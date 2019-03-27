package org.hrms.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import org.hrms.util.StringUtil;

/**
 * 字符编码过滤器
 * 
 * <p>
 * 1. 创建类实现javax.servlet.Filter接口(参考本类)<br/>
 * 2. 在web.xml配置过滤器(参考web.xml)<br/>
 * 
 * @author VIC
 *
 */
public class EncodingFilter implements Filter {

	private Logger log = Logger.getLogger(EncodingFilter.class);
	
	/**
	 * 指定字符集编码,在web.xml配置
	 */
	private String charset;

	public void init(FilterConfig filterConfig) throws ServletException {
		
		// 过滤器启动时执行该方法,在此可以做一些准备资源的工作,比如获取指定字符集编码
		charset = filterConfig.getInitParameter("charset");
		if(StringUtil.isNotEmpty(charset)){
			log.info("加载指定字符集编码: " + charset);
		}else{
			// 如未能正常初始化字符集编码则抛出异常
			throw new ServletException("加载指定字符集编码错误!");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 设置请求字符编码
		request.setCharacterEncoding(charset);
		// 设置响应字符编码
		response.setCharacterEncoding(charset);
		// 设置响应内容类型及内容编码
		response.setContentType("text/html;charset=" + charset);
		// 回调
		chain.doFilter(request, response);
	}

	public void destroy() {
		
		// 过滤器释放时执行该方法,在此可以做一些释放资源的工作
		log.info("destroy...");
	}
}
