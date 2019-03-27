package org.hrms.web.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.hrms.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 国际化语言切换控制器
 * 
 * @author VIC
 *
 */
@Controller
public class I18NController extends CommonController {

	@SuppressWarnings("deprecation")
	@RequestMapping("switch")
	public String switchLang(String lang, HttpServletRequest request){
		
		// 获取默认国家语言代码
		Locale locale = Locale.getDefault();
		if(!lang.startsWith(locale.getLanguage())){
			if(lang.startsWith("zh")){
				locale = new Locale("zh", "CN");
			}else if(lang.startsWith("en")){
				locale = new Locale("en", "US");
			}
			Locale.setDefault(locale);
			request.getSession().putValue("WW_TRANS_I18N_LOCALE",locale);
			request.getSession().setAttribute("current.language", locale.getLanguage());
		}
		// 获取来源路径在重新设置语言后重定向到原路径
		String referer = request.getHeader("Referer");
		String sourceUrl = getSourceUrl(referer);
		return "redirect:"+sourceUrl;
	}
	
	private String getSourceUrl(String referer) {
		if(StringUtil.isNotEmpty(referer)){
			return referer.substring(referer.indexOf(systemConfiguraction.webname) + systemConfiguraction.webname.length()); 
		}else{
			return "index";
		}
	}
	
}
