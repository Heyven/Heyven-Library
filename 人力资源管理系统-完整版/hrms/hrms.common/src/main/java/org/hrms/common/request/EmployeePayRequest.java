package org.hrms.common.request;

/**
 * 员工合同请求对象
 * 
 * @author VIC
 *
 */
public class EmployeePayRequest extends Request {

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

	public Integer getBasePay() {
		return basePay;
	}

	public void setBasePay(Integer basePay) {
		this.basePay = basePay;
	}

	public Integer getMeritPay() {
		return meritPay;
	}

	public void setMeritPay(Integer meritPay) {
		this.meritPay = meritPay;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public Long getGiveTime() {
		return giveTime;
	}

	public void setGiveTime(Long giveTime) {
		this.giveTime = giveTime;
	}
}