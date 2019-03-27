package org.hrms.common.request;

import org.hrms.common.annotation.AutoGeneration;

/**
 * 员工合同请求对象
 * 
 * @author VIC
 *
 */
public class EmployeeContractRequest extends Request {

    /**
     * 合同内容
     */
    private String contractContent;

    /**
     * 合同编号
     */
    @AutoGeneration
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

}