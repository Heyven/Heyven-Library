package org.hrms.service.impl;

import org.hrms.common.request.EmployeeRequest;
import org.hrms.domain.Employee;
import org.hrms.service.IEmployeeService;
import org.springframework.stereotype.Service;

/**
 * 员工业务实现类
 * 
 * @author VIC
 *
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Integer, EmployeeRequest> implements IEmployeeService {

}
