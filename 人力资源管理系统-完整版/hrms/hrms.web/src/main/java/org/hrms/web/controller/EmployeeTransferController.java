package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.hrms.common.request.EmployeeTransferRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.EmployeeTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 人事调动控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/employee/transfer",produces="application/json;charset=UTF-8")
public class EmployeeTransferController extends BaseController<EmployeeTransfer,Integer,EmployeeTransferRequest> {
	
	@ResponseBody
	@RequestMapping(path="/insert")
	public Response insert(@RequestBody EmployeeTransferRequest employeeTransferRequest) {
		return super.baseInsert(employeeTransferRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/generate")
	public Response generate(@RequestBody EmployeeTransferRequest employeeTransferRequest, HttpServletRequest request) {
		employeeTransferRequest.setFilePath(request.getSession().getServletContext().getRealPath("/"));
    	return employeeTransferService.generate(employeeTransferRequest);
	}
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}
}
