package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.hrms.common.request.EmployeeContractRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.EmployeeContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 员工合同控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/employee/contract",produces="application/json;charset=UTF-8")
public class EmployeeContractController extends BaseController<EmployeeContract,Integer,EmployeeContractRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody EmployeeContractRequest employeeContractRequest) {
		return super.baseInsert(employeeContractRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody EmployeeContractRequest employeeContractRequest){
		return baseSave(employeeContractRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody EmployeeContractRequest employeeContractRequest) {
		return super.baseExists(employeeContractRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody EmployeeContractRequest employeeContractRequest){
		return super.baseDelete(employeeContractRequest);
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/contract/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/contract/details");
		return modelAndView;
	}

}
