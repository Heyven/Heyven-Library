package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.hrms.common.request.RecruitmentRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.Recruitment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 招聘控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/recruitment",produces="application/json;charset=UTF-8")
public class RecruitmentController extends BaseController<Recruitment,Integer,RecruitmentRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody RecruitmentRequest recruitmentRequest) {
		return super.baseInsert(recruitmentRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody RecruitmentRequest recruitmentRequest){
		return baseSave(recruitmentRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody RecruitmentRequest recruitmentRequest) {
		return super.baseExists(recruitmentRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody RecruitmentRequest recruitmentRequest){
		return super.baseDelete(recruitmentRequest);
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("recruitment/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("recruitment/details");
		return modelAndView;
	}

}
