package org.hrms.domain;

public class EmployeePay {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工ID
     */
    private Integer employeeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 基本工资
     */
    private Integer basePay;

    /**
     * 绩效工资
     */
    private Integer meritPay;

    /**
     * 奖金
     */
    private Integer bonus;

    /**
     * 罚款
     */
    private Integer fine;

    /**
     * 薪酬
     */
    private Integer pay;

    /**
     * 获取时间
     */
    private Long giveTime;

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
     * 基本工资
     * @return basePay 基本工资
     */
    public Integer getBasePay() {
        return basePay;
    }

    /**
     * 基本工资
     * @param basePay 基本工资
     */
    public void setBasePay(Integer basePay) {
        this.basePay = basePay;
    }

    /**
     * 绩效工资
     * @return meritPay 绩效工资
     */
    public Integer getMeritPay() {
        return meritPay;
    }

    /**
     * 绩效工资
     * @param meritPay 绩效工资
     */
    public void setMeritPay(Integer meritPay) {
        this.meritPay = meritPay;
    }

    /**
     * 奖金
     * @return bonus 奖金
     */
    public Integer getBonus() {
        return bonus;
    }

    /**
     * 奖金
     * @param bonus 奖金
     */
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    /**
     * 罚款
     * @return fine 罚款
     */
    public Integer getFine() {
        return fine;
    }

    /**
     * 罚款
     * @param fine 罚款
     */
    public void setFine(Integer fine) {
        this.fine = fine;
    }

    /**
     * 薪酬
     * @return pay 薪酬
     */
    public Integer getPay() {
        return pay;
    }

    /**
     * 薪酬
     * @param pay 薪酬
     */
    public void setPay(Integer pay) {
        this.pay = pay;
    }

    /**
     * 获取时间
     * @return giveTime 获取时间
     */
    public Long getGiveTime() {
        return giveTime;
    }

    /**
     * 获取时间
     * @param giveTime 获取时间
     */
    public void setGiveTime(Long giveTime) {
        this.giveTime = giveTime;
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