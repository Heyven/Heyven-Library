package org.hrms.domain;

public class EmployeeFiles {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 档案编号
     */
    private String archivesNumber;

    /**
     * 档案名称
     */
    private String archivesName;

    /**
     * 档案内容
     */
    private String archivesContent;

    /**
     * 档案备注
     */
    private String archivesRemarks;

    /**
     * 档案摘要
     */
    private String archivesSummary;

    /**
     * 员工ID
     */
    private Integer employeeId;

    /**
     * 
     */
    private String employeeName;

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
     * 档案编号
     * @return archivesNumber 档案编号
     */
    public String getArchivesNumber() {
        return archivesNumber;
    }

    /**
     * 档案编号
     * @param archivesNumber 档案编号
     */
    public void setArchivesNumber(String archivesNumber) {
        this.archivesNumber = archivesNumber;
    }

    /**
     * 档案名称
     * @return archivesName 档案名称
     */
    public String getArchivesName() {
        return archivesName;
    }

    /**
     * 档案名称
     * @param archivesName 档案名称
     */
    public void setArchivesName(String archivesName) {
        this.archivesName = archivesName;
    }

    /**
     * 档案内容
     * @return archivesContent 档案内容
     */
    public String getArchivesContent() {
        return archivesContent;
    }

    /**
     * 档案内容
     * @param archivesContent 档案内容
     */
    public void setArchivesContent(String archivesContent) {
        this.archivesContent = archivesContent;
    }

    /**
     * 档案备注
     * @return archivesRemarks 档案备注
     */
    public String getArchivesRemarks() {
        return archivesRemarks;
    }

    /**
     * 档案备注
     * @param archivesRemarks 档案备注
     */
    public void setArchivesRemarks(String archivesRemarks) {
        this.archivesRemarks = archivesRemarks;
    }

    /**
     * 档案摘要
     * @return archivesSummary 档案摘要
     */
    public String getArchivesSummary() {
        return archivesSummary;
    }

    /**
     * 档案摘要
     * @param archivesSummary 档案摘要
     */
    public void setArchivesSummary(String archivesSummary) {
        this.archivesSummary = archivesSummary;
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