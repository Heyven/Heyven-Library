package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 页面跳转控制器
 * 
 * @author VIC
 *
 */

@Controller
//@RequestMapping("/jsp")
public class PageForwordController extends CommonController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/{model1}/{model2}/{view}")
	public ModelAndView modelView(@PathVariable("model1") String model1, 
			@PathVariable("model2") String model2, 
			@PathVariable("view") String view,
			HttpServletRequest request){
		
		String viewPath = model1 + "/" + model2 + "/" + view;
		log.debug("viewPath: " + viewPath);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewPath);
		modelAndView.addAllObjects(request.getParameterMap());
		return modelAndView;
	}

	@RequestMapping("/{model}/{view}")
	public String modelView(@PathVariable("model") String model, @PathVariable("view") String view){
		String viewPath = model + "/" + view;
		log.debug("viewPath: " + viewPath);
		return viewPath;
	}
	
	@RequestMapping("/{view}")
	public String view(@PathVariable("view") String view, HttpServletRequest request){
		log.debug("view: " + view);
		return view;
	}
	
}
