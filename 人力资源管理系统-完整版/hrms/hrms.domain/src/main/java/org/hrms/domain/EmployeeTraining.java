package org.hrms.domain;

public class EmployeeTraining {
    /**
     * 
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
     * 培训项目ID
     */
    private Integer trainId;

    /**
     * 培训项目名称
     */
    private String projectName;

    /**
     * 培训类型:岗前培训,定期培训
     */
    private String trainingType;

    /**
     * 培训开始时间
     */
    private Long trainingStartTime;

    /**
     * 培训结束时间
     */
    private Long trainingEndTime;

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
     * 培训结果
     */
    private String trainingResult;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
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
     * 培训项目ID
     * @return trainId 培训项目ID
     */
    public Integer getTrainId() {
        return trainId;
    }

    /**
     * 培训项目ID
     * @param trainId 培训项目ID
     */
    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    /**
     * 培训项目名称
     * @return projectName 培训项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 培训项目名称
     * @param projectName 培训项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 培训类型:岗前培训,定期培训
     * @return trainingType 培训类型:岗前培训,定期培训
     */
    public String getTrainingType() {
        return trainingType;
    }

    /**
     * 培训类型:岗前培训,定期培训
     * @param trainingType 培训类型:岗前培训,定期培训
     */
    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    /**
     * 培训开始时间
     * @return trainingStartTime 培训开始时间
     */
    public Long getTrainingStartTime() {
        return trainingStartTime;
    }

    /**
     * 培训开始时间
     * @param trainingStartTime 培训开始时间
     */
    public void setTrainingStartTime(Long trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    /**
     * 培训结束时间
     * @return trainingEndTime 培训结束时间
     */
    public Long getTrainingEndTime() {
        return trainingEndTime;
    }

    /**
     * 培训结束时间
     * @param trainingEndTime 培训结束时间
     */
    public void setTrainingEndTime(Long trainingEndTime) {
        this.trainingEndTime = trainingEndTime;
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
     * 培训结果
     * @return trainingResult 培训结果
     */
    public String getTrainingResult() {
        return trainingResult;
    }

    /**
     * 培训结果
     * @param trainingResult 培训结果
     */
    public void setTrainingResult(String trainingResult) {
        this.trainingResult = trainingResult;
    }
}