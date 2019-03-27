package org.hrms.job;

import org.hrms.common.context.State;
import org.hrms.common.search.Attribute;
import org.hrms.domain.Employee;
import org.hrms.domain.EmployeeAttendance;
import org.hrms.domain.EmployeePay;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 定时计算员工薪资任务
 * 
 * @author VIC
 *
 */
@Component
public class CalculationBasicPayJob extends BaseJob {

	public void work() throws InterruptedException {
		log.debug("=================开始计算薪资=======================");
		// 查询所有员工(获取基本工资)
		Attribute attribute = new Attribute("state", State.DISABLED.toString());
		List<Employee> employeeList = employeeReadReadWrite.selectByAttributes(attribute);
		//查询所有员工考勤(获取出勤天数)
		List<EmployeeAttendance> employeeAttendanceList = employeeAttendanceReadWrite.selectByAttributes(attribute);
		// 运算薪资
		// 1. 计算出每天的基本工资
		// 2. 总工资=每天基本工资*出勤天数
		BigDecimal monthDay = new BigDecimal(30);
			for(Employee employee : employeeList){
				try{
					BigDecimal basicPay = new BigDecimal(employee.getBasicPay());
					BigDecimal dayPay = basicPay.divide(monthDay);
					BigDecimal workDay = new BigDecimal(filterWrkAttendance(employeeAttendanceList, employee));
					BigDecimal sumPay = dayPay.multiply(workDay);
					EmployeePay employeePay = new EmployeePay();
					employeePay.setBasePay(basicPay.intValue());
					employeePay.setBonus(0);
					employeePay.setCreator("system");
					employeePay.setEmployeeId(employee.getId());
					employeePay.setEmployeeName(employee.getEmployeeName());
					employeePay.setFine(0);
					employeePay.setGiveTime(System.currentTimeMillis());
					employeePay.setMeritPay(0);
					employeePay.setPay(sumPay.intValue());
					employeePay.setCreateTime(System.currentTimeMillis());
					employeePay.setUpdateTime(System.currentTimeMillis());
					employeePayReadWrite.insert(employeePay);
					log.debug("姓名: " + employee.getEmployeeName() + "工资: " + sumPay);
				}catch (Exception e) {
					log.error("计算错误: " +  employee);
				}
			}
		
			log.debug("=================结束计算薪资=======================");
	}

	private int filterWrkAttendance(List<EmployeeAttendance> employeeAttendanceList, Employee employee) {
		int workDay = 0;
		for(EmployeeAttendance employeeAttendance : employeeAttendanceList){
			if(employeeAttendance.getEmployeeName().equals(employee.getEmployeeName()) && 
					employeeAttendance.getAttendanceType().equals("上班")){
				workDay++;
			}
		}
		return workDay;
	}
}
