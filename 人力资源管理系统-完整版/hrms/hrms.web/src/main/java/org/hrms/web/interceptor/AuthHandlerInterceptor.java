package org.hrms.web.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.hrms.common.context.CacheContext;
import org.hrms.domain.Authority;
import org.hrms.util.ListUtil;
import org.hrms.util.ObjectUtil;
import org.hrms.util.StringUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.reflect.TypeToken;

/**
 * 登录认证及权限认证拦截器
 * 
 * @author VIC
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AuthHandlerInterceptor implements HandlerInterceptor {

	private static Logger log = Logger.getLogger(AuthHandlerInterceptor.class);
	
	@SuppressWarnings("serial")
	private static Class clz = new TypeToken<List<Authority>>(){}.getClass();
	private static List<Authority> defaultAuthority;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 获取访问地址
		String requestURI = request.getRequestURI();
		requestURI = requestURI.substring(10);
		log.debug("requestURI: " + requestURI);
		
		// 默认权限认证,如果访问的是默认权限则直接通过
		if(authentication(null, requestURI, true)){
			return true;
		}
		
		// 登录认证,如果未登录则重定向到登录页
		Object objectAccount = request.getSession().getAttribute("currentAccount");
		if(!ObjectUtil.isNotEmpty(objectAccount)){
			response.sendRedirect(handlerRootPath(requestURI) + "login");
			return false;
		}
		
		// 账号权限认证
		if(authentication(objectAccount.toString(), requestURI, false)){
			return true;
		}else{
			response.sendRedirect(handlerRootPath(requestURI) + "noauth");
			return false;
		}
	}
	
	/**
	 * 权限认证
	 * 
	 * @param account 登录账号名
	 * @param authorityUrl 请求地址(权限路径)
	 * @param authenticationDefault 是否认证默认权限
	 * @return
	 */
	private boolean authentication(String account, String authorityUrl, boolean authenticationDefault) {
		
		boolean state = false;
		// 认证默认权限(默认权限与账号无关,未登录即可访问)
		if(authenticationDefault){
			state = authenticationDefaultAuthority(authorityUrl);
		}
		// 认证账号权限(与账号绑定,每个账号权限不同)
		if(!state && StringUtil.isNotEmpty(account)){
			state = authenticationAccountAuthority(account, authorityUrl);
		}
		return state;
	}

	/**
	 * 认证账号权限
	 * 
	 * @param account 登录账号名
	 * @param authorityUrl 请求地址(权限路径)
	 * @return
	 */
	private boolean authenticationAccountAuthority(String account, String authorityUrl) {
		List<Authority> accountAuthoritys = (List<Authority>) CacheContext.getCache(account + CacheContext.Keys._AUTH_CACHE_KEY, clz);
		return authenticationAuthority(accountAuthoritys, authorityUrl);
	}

	/**
	 * 认证默认权限
	 * 
	 * @param authorityUrl
	 * @return
	 */
	private boolean authenticationDefaultAuthority(String authorityUrl) {
		if(!ListUtil.isNotEmpty(defaultAuthority)){
			defaultAuthority = (List<Authority>) CacheContext.getCache(CacheContext.Keys.DEFAULT_AUTHORITY_KEY.toString(), clz);
			log.debug("获取默认权限数量: " +  defaultAuthority.size());
		}
		return authenticationAuthority(defaultAuthority, authorityUrl);
	}
	
	private boolean authenticationAuthority(List<Authority> authoritys, String authorityUrl){
		if(ListUtil.isNotEmpty(authoritys)){
			for(Authority authority : authoritys){
				if(authority.getAuthorityUrl().equals(authorityUrl)){
					return true;
				}
			}
		}
		return false;
	}

	private String handlerRootPath(String requestURI){
		return requestURI.indexOf("/") > 0 ? "../" : "";
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
