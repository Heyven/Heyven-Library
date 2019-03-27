package org.hrms.domain;

public class Department {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门固定人数，预定需要多少人
     */
    private Integer fixedNumber;

    /**
     * 部门实际有多少人
     */
    private Integer actualNumber;

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
     * 部门固定人数，预定需要多少人
     * @return fixedNumber 部门固定人数，预定需要多少人
     */
    public Integer getFixedNumber() {
        return fixedNumber;
    }

    /**
     * 部门固定人数，预定需要多少人
     * @param fixedNumber 部门固定人数，预定需要多少人
     */
    public void setFixedNumber(Integer fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    /**
     * 部门实际有多少人
     * @return actualNumber 部门实际有多少人
     */
    public Integer getActualNumber() {
        return actualNumber;
    }

    /**
     * 部门实际有多少人
     * @param actualNumber 部门实际有多少人
     */
    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
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