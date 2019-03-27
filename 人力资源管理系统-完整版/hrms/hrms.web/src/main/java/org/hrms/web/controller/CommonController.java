package org.hrms.web.controller;

import java.util.Locale;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hrms.common.context.SystemConfiguraction;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 
 * @author VIC
 *
 */
public class CommonController {
	
	protected Logger log = Logger.getLogger(getClass());
	
	@Resource
	SystemConfiguraction systemConfiguraction;
	
	/** 
	 * 读取国际化文件里面的变量值 
	 *  
	 * @param msgCode 变量名称 
	 * @param args 参数 
	 * @return 
	 */  
	protected String getMessage(String msgCode, Object... args) {  
	  ReloadableResourceBundleMessageSource messageSource;  
	  messageSource = new ReloadableResourceBundleMessageSource();  
	  messageSource.setBasename("classpath:/message");  
	  messageSource.setUseCodeAsDefaultMessage(true);  
	  return messageSource.getMessage(msgCode, args, Locale.getDefault());  
	}

}
