package org.hrms.domain;

public class Apply {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 应聘编号
     */
    private String applyId;

    /**
     * 应聘人姓名
     */
    private String applyName;

    /**
     * 应聘人性别
     */
    private String applySex;

    /**
     * 应聘人出生日期
     */
    private Long applyBirthday;

    /**
     * 应聘人联系电话
     */
    private String applyPhone;

    /**
     * 应聘人邮箱地址
     */
    private String applyEmail;

    /**
     * 应聘部门
     */
    private String applyDepartment;

    /**
     * 应聘职位
     */
    private String applyJob;

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
     * 应聘编号
     * @return applyId 应聘编号
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * 应聘编号
     * @param applyId 应聘编号
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    /**
     * 应聘人姓名
     * @return applyName 应聘人姓名
     */
    public String getApplyName() {
        return applyName;
    }

    /**
     * 应聘人姓名
     * @param applyName 应聘人姓名
     */
    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    /**
     * 应聘人性别
     * @return applySex 应聘人性别
     */
    public String getApplySex() {
        return applySex;
    }

    /**
     * 应聘人性别
     * @param applySex 应聘人性别
     */
    public void setApplySex(String applySex) {
        this.applySex = applySex;
    }

    /**
     * 应聘人出生日期
     * @return applyBirthday 应聘人出生日期
     */
    public Long getApplyBirthday() {
        return applyBirthday;
    }

    /**
     * 应聘人出生日期
     * @param applyBirthday 应聘人出生日期
     */
    public void setApplyBirthday(Long applyBirthday) {
        this.applyBirthday = applyBirthday;
    }

    /**
     * 应聘人联系电话
     * @return applyPhone 应聘人联系电话
     */
    public String getApplyPhone() {
        return applyPhone;
    }

    /**
     * 应聘人联系电话
     * @param applyPhone 应聘人联系电话
     */
    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    /**
     * 应聘人邮箱地址
     * @return applyEmail 应聘人邮箱地址
     */
    public String getApplyEmail() {
        return applyEmail;
    }

    /**
     * 应聘人邮箱地址
     * @param applyEmail 应聘人邮箱地址
     */
    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail;
    }

    /**
     * 应聘部门
     * @return applyDepartment 应聘部门
     */
    public String getApplyDepartment() {
        return applyDepartment;
    }

    /**
     * 应聘部门
     * @param applyDepartment 应聘部门
     */
    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment;
    }

    /**
     * 应聘职位
     * @return applyJob 应聘职位
     */
    public String getApplyJob() {
        return applyJob;
    }

    /**
     * 应聘职位
     * @param applyJob 应聘职位
     */
    public void setApplyJob(String applyJob) {
        this.applyJob = applyJob;
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