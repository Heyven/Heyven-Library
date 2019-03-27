package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.hrms.common.request.ApplyRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.Apply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 应聘控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/apply",produces="application/json;charset=UTF-8")
public class ApplyController extends BaseController<Apply,Integer,ApplyRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody ApplyRequest applyRequest) {
		return super.baseInsert(applyRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody ApplyRequest applyRequest){
		return baseSave(applyRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody ApplyRequest applyRequest) {
		return super.baseExists(applyRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody ApplyRequest applyRequest){
		return super.baseDelete(applyRequest);
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("apply/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("apply/details");
		return modelAndView;
	}

}
