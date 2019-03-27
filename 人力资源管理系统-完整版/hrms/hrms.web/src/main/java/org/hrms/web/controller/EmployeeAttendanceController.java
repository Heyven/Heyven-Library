package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.hrms.common.request.EmployeeAttendanceRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.EmployeeAttendance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 员工考勤控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/employee/attendance",produces="application/json;charset=UTF-8")
public class EmployeeAttendanceController extends BaseController<EmployeeAttendance,Integer,EmployeeAttendanceRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody EmployeeAttendanceRequest employeeAttendanceRequest) {
		return super.baseInsert(employeeAttendanceRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/save")
	public Response save(@RequestBody EmployeeAttendanceRequest employeeAttendanceRequest){
		return baseSave(employeeAttendanceRequest);
	}
	
	@ResponseBody
	@RequestMapping("/exists")
	public Response exists(@RequestBody EmployeeAttendanceRequest employeeAttendanceRequest) {
		return super.baseExists(employeeAttendanceRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Response remove(@RequestBody EmployeeAttendanceRequest employeeAttendanceRequest){
		return super.baseDelete(employeeAttendanceRequest);
	}
	
	@RequestMapping("/find")
	public ModelAndView find(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/attendance/update");
		return modelAndView;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(@RequestParam Integer id) throws Exception{
		ModelAndView modelAndView = super.baseFind(id);
		modelAndView.setViewName("employee/attendance/details");
		return modelAndView;
	}

}
