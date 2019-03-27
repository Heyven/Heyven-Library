package org.hrms.domain;

public class EmployeeTransfer {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工ID
     */
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
     * 调动原因
     */
    private String transferCause;

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
     * 员工ID
     * @return employeeId 员工ID
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 员工ID
     * @param employeeId 员工ID
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 员工名字
     * @return employeeName 员工名字
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 员工名字
     * @param employeeName 员工名字
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 原部门
     * @return originalDepartment 原部门
     */
    public String getOriginalDepartment() {
        return originalDepartment;
    }

    /**
     * 原部门
     * @param originalDepartment 原部门
     */
    public void setOriginalDepartment(String originalDepartment) {
        this.originalDepartment = originalDepartment;
    }

    /**
     * 原职位
     * @return originalJob 原职位
     */
    public String getOriginalJob() {
        return originalJob;
    }

    /**
     * 原职位
     * @param originalJob 原职位
     */
    public void setOriginalJob(String originalJob) {
        this.originalJob = originalJob;
    }

    /**
     * 新部门
     * @return newDepartment 新部门
     */
    public String getNewDepartment() {
        return newDepartment;
    }

    /**
     * 新部门
     * @param newDepartment 新部门
     */
    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment;
    }

    /**
     * 新职位
     * @return newJob 新职位
     */
    public String getNewJob() {
        return newJob;
    }

    /**
     * 新职位
     * @param newJob 新职位
     */
    public void setNewJob(String newJob) {
        this.newJob = newJob;
    }

    /**
     * 调动时间
     * @return transferTime 调动时间
     */
    public Long getTransferTime() {
        return transferTime;
    }

    /**
     * 调动时间
     * @param transferTime 调动时间
     */
    public void setTransferTime(Long transferTime) {
        this.transferTime = transferTime;
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
     * 调动原因
     * @return transferCause 调动原因
     */
    public String getTransferCause() {
        return transferCause;
    }

    /**
     * 调动原因
     * @param transferCause 调动原因
     */
    public void setTransferCause(String transferCause) {
        this.transferCause = transferCause;
    }
}