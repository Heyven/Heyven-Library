package org.hrms.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hrms.common.request.AuthorityRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.Authority;
import org.hrms.util.ListUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限数据控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path="/authority",produces="application/json;charset=UTF-8")
public class AuthorityController extends BaseController<Authority,Integer,AuthorityRequest> {

	@ResponseBody
	@RequestMapping(path="/all")
	public String all(){
		List<Authority> authoritieLIst = authorityService.allAuths();
		Response response = Response.getInstance();
		if(!ListUtil.isNotEmpty(authoritieLIst)){
			response.setMessage("no.data");
		}else{
			response.setData(authoritieLIst);
			response.setState(true);
		}
		return response.toJson();
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("authority/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("authority/details");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}

	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody AuthorityRequest authorityRequest){
		return baseExists(authorityRequest);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody AuthorityRequest authorityRequest){
		return super.baseDelete(authorityRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody AuthorityRequest authorityRequest){
		return baseSave(authorityRequest);
	}

	@ResponseBody
	@RequestMapping("/insert")
	public Response insert(@RequestBody AuthorityRequest authorityRequest){
		return baseInsert(authorityRequest);
	}
	
}
