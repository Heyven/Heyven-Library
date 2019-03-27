package org.hrms.common.request;

import org.hrms.common.annotation.UpdateAttribute;

/**
 * 员工调动请求对象
 * 
 * @author VIC
 *
 */
public class EmployeeTransferRequest extends Request {

    /**
     * 员工ID
     */
	@UpdateAttribute(mapper="EmployeeMapper", 
			srcAttributes={"newDepartment","newJob"},
			destAttributes={"departmentName","employeeJob"})
    private Integer employeeId;

    /**
     * 员工名字
     */
    private String employeeName;

    /**
     * 原部门
     */
    private String originalDepartment;

    /**
     * 原职位
     */
    private String originalJob;

    /**
     * 新部门
     */
    private String newDepartment;

    /**
     * 新职位
     */
    private String newJob;

    /**
     * 调动时间
     */
    private Long transferTime;
    
    /**
     * 生成报表起始时间
     */
    private Long startTime;
    
    /**
     * 生成报表截止时间
     */
    private Long endTime;
    
    /**
     * 调动原因
     */
    private String transferCause;
    
    private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getOriginalDepartment() {
		return originalDepartment;
	}

	public void setOriginalDepartment(String originalDepartment) {
		this.originalDepartment = originalDepartment;
	}

	public String getOriginalJob() {
		return originalJob;
	}

	public void setOriginalJob(String originalJob) {
		this.originalJob = originalJob;
	}

	public String getNewDepartment() {
		return newDepartment;
	}

	public void setNewDepartment(String newDepartment) {
		this.newDepartment = newDepartment;
	}

	public String getNewJob() {
		return newJob;
	}

	public void setNewJob(String newJob) {
		this.newJob = newJob;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}

	public String getTransferCause() {
		return transferCause;
	}

	public void setTransferCause(String transferCause) {
		this.transferCause = transferCause;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}


}