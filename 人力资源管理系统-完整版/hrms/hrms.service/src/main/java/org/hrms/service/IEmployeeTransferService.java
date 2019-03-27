package org.hrms.service;

import org.hrms.common.request.EmployeeTransferRequest;
import org.hrms.common.response.Response;
import org.hrms.domain.EmployeeTransfer;

/**
 * 员工调动业务接口
 * 
 * @author VIC
 *
 */
public interface IEmployeeTransferService extends IBaseService<EmployeeTransfer, Integer, EmployeeTransferRequest> {
	
	Response generate(EmployeeTransferRequest employeeTransferRequest);

}
