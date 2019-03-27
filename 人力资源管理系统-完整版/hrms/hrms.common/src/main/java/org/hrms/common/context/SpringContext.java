package org.hrms.common.context;

import org.springframework.beans.BeansException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringContext {

	// 获取当前Spring上下文
	private static WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

	/**
	 * 根据ID名称获取Bean对象
	 * @param bean name
	 * @return T
	 * @throws BeansException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name, Class<T> tClass) throws BeansException {
		return (T)wac.getBean(name);
	}
	
	/**
	 * 根据类类型获取Bean对象
	 * @param clz
	 * @return
	 * @throws BeansException
	 */
	public static <T> T getBean(Class<T> clz) throws BeansException {
		return wac.getBean(clz);
	}
	
}
