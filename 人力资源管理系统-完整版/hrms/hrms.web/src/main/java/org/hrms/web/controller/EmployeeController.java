package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.hrms.common.request.EmployeeRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 员工控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/employee",produces="application/json;charset=UTF-8")
public class EmployeeController extends BaseController<Employee,Integer,EmployeeRequest> {
	
	@RequestMapping("/upload")
	@ResponseBody 
	public Response upload(@RequestParam("img") CommonsMultipartFile img, HttpServletRequest request){
		return super.upload(img, request, "employee");
	}
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody EmployeeRequest employeeRequest) {
		return super.baseInsert(employeeRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody EmployeeRequest employeeRequest){
		return baseSave(employeeRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody EmployeeRequest employeeRequest) {
		return super.baseExists(employeeRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody EmployeeRequest employeeRequest){
		return super.baseDelete(employeeRequest);
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/details");
		return modelAndView;
	}
	
	@RequestMapping("/transfer")
	public ModelAndView transfer(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/transfer/add");
		return modelAndView;
	}

}
