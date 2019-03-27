package org.hrms.domain;

public class EmployeeAttendance {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 考勤编号
     */
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
     * 状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 操作人
     */
    private String creator;

    /**
     * 考勤原因
     */
    private String attendanceCause;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 考勤编号
     * @return attendanceNumber 考勤编号
     */
    public String getAttendanceNumber() {
        return attendanceNumber;
    }

    /**
     * 考勤编号
     * @param attendanceNumber 考勤编号
     */
    public void setAttendanceNumber(String attendanceNumber) {
        this.attendanceNumber = attendanceNumber;
    }

    /**
     * 部门名称
     * @return departmentName 部门名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 部门名称
     * @param departmentName 部门名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 员工姓名
     * @return employeeName 员工姓名
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 员工姓名
     * @param employeeName 员工姓名
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 考勤类型
     * @return attendanceType 考勤类型
     */
    public String getAttendanceType() {
        return attendanceType;
    }

    /**
     * 考勤类型
     * @param attendanceType 考勤类型
     */
    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType;
    }

    /**
     * 考勤开始时间
     * @return attendanceStartTime 考勤开始时间
     */
    public Long getAttendanceStartTime() {
        return attendanceStartTime;
    }

    /**
     * 考勤开始时间
     * @param attendanceStartTime 考勤开始时间
     */
    public void setAttendanceStartTime(Long attendanceStartTime) {
        this.attendanceStartTime = attendanceStartTime;
    }

    /**
     * 考勤结束时间
     * @return attendanceEndTime 考勤结束时间
     */
    public Long getAttendanceEndTime() {
        return attendanceEndTime;
    }

    /**
     * 考勤结束时间
     * @param attendanceEndTime 考勤结束时间
     */
    public void setAttendanceEndTime(Long attendanceEndTime) {
        this.attendanceEndTime = attendanceEndTime;
    }

    /**
     * 奖罚金额
     * @return sanctionMoney 奖罚金额
     */
    public Integer getSanctionMoney() {
        return sanctionMoney;
    }

    /**
     * 奖罚金额
     * @param sanctionMoney 奖罚金额
     */
    public void setSanctionMoney(Integer sanctionMoney) {
        this.sanctionMoney = sanctionMoney;
    }

    /**
     * 状态
     * @return state 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return updateTime 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 操作人
     * @return creator 操作人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 操作人
     * @param creator 操作人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 考勤原因
     * @return attendanceCause 考勤原因
     */
    public String getAttendanceCause() {
        return attendanceCause;
    }

    /**
     * 考勤原因
     * @param attendanceCause 考勤原因
     */
    public void setAttendanceCause(String attendanceCause) {
        this.attendanceCause = attendanceCause;
    }
}