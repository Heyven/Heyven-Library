package org.hrms.web.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 自定义国际化拦截器
 * 
 * @author VIC
 *
 */
public class LocaleChangeInterceptor extends HandlerInterceptorAdapter {

	public static final String DEFAULT_PARAM_NAME = "locale";


	protected final Log logger = LogFactory.getLog(getClass());

	private String paramName = DEFAULT_PARAM_NAME;

	private String[] httpMethods;

	private boolean ignoreInvalidLocale = false;

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setHttpMethods(String... httpMethods) {
		this.httpMethods = httpMethods;
	}

	public String[] getHttpMethods() {
		return this.httpMethods;
	}

	public void setIgnoreInvalidLocale(boolean ignoreInvalidLocale) {
		this.ignoreInvalidLocale = ignoreInvalidLocale;
	}

	public boolean isIgnoreInvalidLocale() {
		return this.ignoreInvalidLocale;
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletException {
		String newLocale = request.getParameter(getParamName());
		if (newLocale != null) {
			if (checkHttpMethod(request.getMethod())) {
				LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
				if (localeResolver == null) {
					throw new IllegalStateException(
							"No LocaleResolver found: not in a DispatcherServlet request?");
				}
				try {
					localeResolver.setLocale(request, response, StringUtils.parseLocaleString(newLocale));
				}
				catch (IllegalArgumentException ex) {
					if (isIgnoreInvalidLocale()) {
						logger.debug("Ignoring invalid locale value [" + newLocale + "]: " + ex.getMessage());
					}
					else {
						throw ex;
					}
				}
			}
			setCurrentLanguage(request, newLocale);
		}else{

			Object object = request.getSession().getAttribute("current.language");
			String localeLangage = null != object ? object.toString() : request.getLocale().getLanguage();
			setCurrentLanguage(request, localeLangage);
		}
		// Proceed in any case.
		return true;
	}
	
	/**
	 * 设置当前系统使用的语言
	 * 
	 * @param request
	 * @param language
	 */
	private void setCurrentLanguage(HttpServletRequest request,String language){
		if(language.startsWith("zh")){
			request.setAttribute("current.language", "中文");
		}else if(language.startsWith("en")){
			request.setAttribute("current.language", "English");
		}
	}
	

	private boolean checkHttpMethod(String currentMethod) {
		String[] configuredMethods = getHttpMethods();
		if (ObjectUtils.isEmpty(configuredMethods)) {
			return true;
		}
		for (String configuredMethod : configuredMethods) {
			if (configuredMethod.equalsIgnoreCase(currentMethod)) {
				return true;
			}
		}
		return false;
	}

}
