package org.hrms.common.request;

import org.hrms.common.annotation.AutoGeneration;

/**
 * 员工考勤请求对象
 * 
 * @author VIC
 *
 */
public class EmployeeAttendanceRequest extends Request {
	
	private String ids;
	

    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
     * 考勤编号
     */
	@AutoGeneration
    private String attendanceNumber;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 考勤类型
     */
    private String attendanceType;

    /**
     * 考勤开始时间
     */
    private Long attendanceStartTime;

    /**
     * 考勤结束时间
     */
    private Long attendanceEndTime;

    /**
     * 奖罚金额
     */
    private Integer sanctionMoney;
    
    /**
     * 考勤原因
     */
    private String attendanceCause;

	public String getAttendanceNumber() {
		return attendanceNumber;
	}

	public void setAttendanceNumber(String attendanceNumber) {
		this.attendanceNumber = attendanceNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public Long getAttendanceStartTime() {
		return attendanceStartTime;
	}

	public void setAttendanceStartTime(Long attendanceStartTime) {
		this.attendanceStartTime = attendanceStartTime;
	}

	public Long getAttendanceEndTime() {
		return attendanceEndTime;
	}

	public void setAttendanceEndTime(Long attendanceEndTime) {
		this.attendanceEndTime = attendanceEndTime;
	}

	public Integer getSanctionMoney() {
		return sanctionMoney;
	}

	public void setSanctionMoney(Integer sanctionMoney) {
		this.sanctionMoney = sanctionMoney;
	}

	public String getAttendanceCause() {
		return attendanceCause;
	}

	public void setAttendanceCause(String attendanceCause) {
		this.attendanceCause = attendanceCause;
	}
}