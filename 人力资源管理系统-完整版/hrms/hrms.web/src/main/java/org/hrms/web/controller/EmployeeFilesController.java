package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.hrms.common.request.EmployeeFilesRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.EmployeeFiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 员工档案控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/employee/files",produces="application/json;charset=UTF-8")
public class EmployeeFilesController extends BaseController<EmployeeFiles,Integer,EmployeeFilesRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody EmployeeFilesRequest employeeFilesRequest) {
		return super.baseInsert(employeeFilesRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody EmployeeFilesRequest employeeFilesRequest){
		return baseSave(employeeFilesRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody EmployeeFilesRequest employeeFilesRequest) {
		return super.baseExists(employeeFilesRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody EmployeeFilesRequest employeeFilesRequest){
		return super.baseDelete(employeeFilesRequest);
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/files/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/files/details");
		return modelAndView;
	}

}
