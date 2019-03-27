package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.hrms.common.request.AccountRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.Account;
import org.hrms.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 账号控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/account",produces="application/json;charset=UTF-8")
public class AccountController extends BaseController<Account,Integer,AccountRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody AccountRequest accountRequest) {
		return super.baseInsert(accountRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody AccountRequest accountRequest){
		return baseSave(accountRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody AccountRequest accountRequest) {
		return super.baseExists(accountRequest);
	}
	
	@ResponseBody
	@RequestMapping("/authoritys")
	public Response authoritys(@RequestBody AccountRequest accountRequest) {
		return accountService.auths(accountRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public Response login(@RequestBody AccountRequest accountRequest, HttpServletRequest request){
		
		Response response = accountService.login(accountRequest);
		if(response.getState()){
			request.getSession().setAttribute("accountRequest", accountRequest);
			request.getSession().setAttribute("currentAccount", accountRequest.getAccount());
		}
		getMessage(response);
		return response;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody AccountRequest accountRequest){
		return super.baseDelete(accountRequest);
	}
	
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		
		request.getSession().removeAttribute("accountRequest");
		request.getSession().invalidate();
		return "redirect:../login";
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("account/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("account/details");
		return modelAndView;
	}
	
	@RequestMapping("/save_password")
	@ResponseBody
	public Response savePassword(@RequestBody AccountRequest accountRequest) {
		Response response = accountService.savePassword(accountRequest);
		if(StringUtil.isNotEmpty(response.getMessage())){
			response.setMessage(getMessage(response.getMessage()));
		}
		return response;
	}

}
