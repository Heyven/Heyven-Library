package org.hrms.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.hrms.common.request.EmployeePayRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Pageing;
import org.hrms.domain.EmployeePay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 员工薪酬控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping(path = "/employee/pay",produces="application/json;charset=UTF-8")
public class EmployeePayController extends BaseController<EmployeePay,Integer,EmployeePayRequest> {
	
	@ResponseBody
	@RequestMapping(path="/search")
	public Response search(@RequestBody Pageing pageing,HttpServletRequest request) throws Exception{
		return baseSearch(pageing, request);
	}

}
