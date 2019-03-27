package org.hrms.common.request;

import org.hrms.common.annotation.UniqueValue;

/**
 * 培训项目请求对象
 * 
 * @author VIC
 *
 */
public class TrainingProjectRequest extends Request {

	private String ids;
	
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

    /**
     * 培训项目
     */
	@UniqueValue
    private String projectName;

    /**
     * 培训地址
     */
    private String trainingAddress;
    
    /**
     * 培训内容
     */
    private String trainingContent;

    /**
     * 培训时间
     */
    private Long trainingTime;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTrainingAddress() {
		return trainingAddress;
	}

	public void setTrainingAddress(String trainingAddress) {
		this.trainingAddress = trainingAddress;
	}

	public String getTrainingContent() {
		return trainingContent;
	}

	public void setTrainingContent(String trainingContent) {
		this.trainingContent = trainingContent;
	}

	public Long getTrainingTime() {
		return trainingTime;
	}

	public void setTrainingTime(Long trainingTime) {
		this.trainingTime = trainingTime;
	}

}