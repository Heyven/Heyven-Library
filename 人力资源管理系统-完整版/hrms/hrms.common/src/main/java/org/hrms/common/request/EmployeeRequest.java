package org.hrms.common.request;

import org.hrms.common.annotation.AutoGeneration;
import org.hrms.common.annotation.UniqueValue;

/**
 * 员工请求对象
 * 
 * @author VIC
 *
 */
public class EmployeeRequest extends Request {

	private String ids;
	
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
     * 员工姓名
     */
	@UniqueValue
    private String employeeName;
	
	/**
	 * 员工编号
	 */
	@AutoGeneration
	private String employeeNumber;

    /**
     * 员工照片
     */
    private String employeePhoto;

    /**
     * 员工性别(男或女)
     */
    private String employeeSex;

    /**
     * 员工生日
     */
    private Long employeeBirthday;

    /**
     * 员工手机
     */
    private String employeePhone;

    /**
     * 员工邮箱
     */
    private String employeeEmail;

    /**
     * 员工学历
     */
    private String employeeEducation;

    /**
     * 员工部门
     */
    private String departmentName;

    /**
     * 员工职务
     */
    private String employeeJob;

    /**
     * 职称等级
     */
    private String gradeGrade;
    /**
     * 基本工资
     */
    private Integer basicPay;
    /**
     * 入职时间
     */
    private Long inductionTime;

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
     * 员工照片(存放的是员工照片的相对路径)
     * @return employeePhoto 员工照片(存放的是员工照片的相对路径)
     */
    public String getEmployeePhoto() {
        return employeePhoto;
    }

    /**
     * 员工照片
     * @param employeePhoto 员工照片
     */
    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    /**
     * 员工性别(男或女)
     * @return employeeSex 员工性别(男或女)
     */
    public String getEmployeeSex() {
        return employeeSex;
    }

    public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
     * 员工性别(男或女)
     * @param employeeSex 员工性别(男或女)
     */
    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    /**
     * 员工生日
     * @return employeeBirthday 员工生日
     */
    public Long getEmployeeBirthday() {
        return employeeBirthday;
    }

    /**
     * 员工生日
     * @param employeeBirthday 员工生日
     */
    public void setEmployeeBirthday(Long employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    /**
     * 员工手机
     * @return employeePhone 员工手机
     */
    public String getEmployeePhone() {
        return employeePhone;
    }

    /**
     * 员工手机
     * @param employeePhone 员工手机
     */
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    /**
     * 员工邮箱
     * @return employeeEmail 员工邮箱
     */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * 员工邮箱
     * @param employeeEmail 员工邮箱
     */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    /**
     * 员工学历
     * @return employeeEducation 员工学历
     */
    public String getEmployeeEducation() {
        return employeeEducation;
    }

    /**
     * 员工学历
     * @param employeeEducation 员工学历
     */
    public void setEmployeeEducation(String employeeEducation) {
        this.employeeEducation = employeeEducation;
    }

    /**
     * 员工部门
     * @return departmentName 员工部门
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 员工部门
     * @param departmentName 员工部门
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 员工职务
     * @return employeeJob 员工职务
     */
    public String getEmployeeJob() {
        return employeeJob;
    }

    /**
     * 员工职务
     * @param employeeJob 员工职务
     */
    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    /**
     * 职称等级
     * @return gradeGrade 职称等级
     */
    public String getGradeGrade() {
        return gradeGrade;
    }

    /**
     * 职称等级
     * @param gradeGrade 职称等级
     */
    public void setGradeGrade(String gradeGrade) {
        this.gradeGrade = gradeGrade;
    }

    /**
     * 入职时间
     * @return inductionTime 入职时间
     */
    public Long getInductionTime() {
        return inductionTime;
    }

    /**
     * 入职时间
     * @param inductionTime 入职时间
     */
    public void setInductionTime(Long inductionTime) {
        this.inductionTime = inductionTime;
    }

	public Integer getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Integer basicPay) {
		this.basicPay = basicPay;
	}


}