package org.hrms.domain;

public class EmployeeContract {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 合同内容
     */
    private String contractContent;

    /**
     * 合同编号
     */
    private String contractNumber;

    /**
     * 员工ID
     */
    private Integer employeeId;

    /**
     * 
     */
    private String employeeName;

    /**
     * 合同开始日期
     */
    private Long contractStartTime;

    /**
     * 合同结束日期
     */
    private Long contractEndTime;

    /**
     * 合同备注
     */
    private String contractRemarks;

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
     * 合同内容
     * @return contractContent 合同内容
     */
    public String getContractContent() {
        return contractContent;
    }

    /**
     * 合同内容
     * @param contractContent 合同内容
     */
    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    /**
     * 合同编号
     * @return contractNumber 合同编号
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * 合同编号
     * @param contractNumber 合同编号
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
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
     * 
     * @return employeeName 
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 
     * @param employeeName 
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 合同开始日期
     * @return contractStartTime 合同开始日期
     */
    public Long getContractStartTime() {
        return contractStartTime;
    }

    /**
     * 合同开始日期
     * @param contractStartTime 合同开始日期
     */
    public void setContractStartTime(Long contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    /**
     * 合同结束日期
     * @return contractEndTime 合同结束日期
     */
    public Long getContractEndTime() {
        return contractEndTime;
    }

    /**
     * 合同结束日期
     * @param contractEndTime 合同结束日期
     */
    public void setContractEndTime(Long contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    /**
     * 合同备注
     * @return contractRemarks 合同备注
     */
    public String getContractRemarks() {
        return contractRemarks;
    }

    /**
     * 合同备注
     * @param contractRemarks 合同备注
     */
    public void setContractRemarks(String contractRemarks) {
        this.contractRemarks = contractRemarks;
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
}