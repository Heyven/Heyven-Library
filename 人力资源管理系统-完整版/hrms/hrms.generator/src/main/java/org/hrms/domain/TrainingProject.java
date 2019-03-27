package org.hrms.domain;

public class TrainingProject {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 培训项目
     */
    private String projectName;

    /**
     * 培训地址
     */
    private String trainingAddress;

    /**
     * 培训时间
     */
    private Long trainingTime;

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
     * 培训内容
     */
    private String trainingContent;

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
     * 培训项目
     * @return projectName 培训项目
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 培训项目
     * @param projectName 培训项目
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 培训地址
     * @return trainingAddress 培训地址
     */
    public String getTrainingAddress() {
        return trainingAddress;
    }

    /**
     * 培训地址
     * @param trainingAddress 培训地址
     */
    public void setTrainingAddress(String trainingAddress) {
        this.trainingAddress = trainingAddress;
    }

    /**
     * 培训时间
     * @return trainingTime 培训时间
     */
    public Long getTrainingTime() {
        return trainingTime;
    }

    /**
     * 培训时间
     * @param trainingTime 培训时间
     */
    public void setTrainingTime(Long trainingTime) {
        this.trainingTime = trainingTime;
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
     * 培训内容
     * @return trainingContent 培训内容
     */
    public String getTrainingContent() {
        return trainingContent;
    }

    /**
     * 培训内容
     * @param trainingContent 培训内容
     */
    public void setTrainingContent(String trainingContent) {
        this.trainingContent = trainingContent;
    }
}