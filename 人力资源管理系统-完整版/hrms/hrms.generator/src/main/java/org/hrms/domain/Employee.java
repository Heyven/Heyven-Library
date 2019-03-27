package org.hrms.domain;

public class Employee {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 员工编号(最大32位字符串组成),唯一性
     */
    private String employeeNumber;

    /**
     * 员工照片(存放的是员工照片的相对路径)
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
     * 入职时间
     */
    private Long inductionTime;

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
     * 创建人
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
     * 员工编号(最大32位字符串组成),唯一性
     * @return employeeNumber 员工编号(最大32位字符串组成),唯一性
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 员工编号(最大32位字符串组成),唯一性
     * @param employeeNumber 员工编号(最大32位字符串组成),唯一性
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 员工照片(存放的是员工照片的相对路径)
     * @return employeePhoto 员工照片(存放的是员工照片的相对路径)
     */
    public String getEmployeePhoto() {
        return employeePhoto;
    }

    /**
     * 员工照片(存放的是员工照片的相对路径)
     * @param employeePhoto 员工照片(存放的是员工照片的相对路径)
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
     * 创建人
     * @return creator 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }
}