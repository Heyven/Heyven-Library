package org.hrms.common.request;

/**
 * 招聘请求对象
 * 
 * @author VIC
 *
 */
public class RecruitmentRequest extends Request {

	private String ids;
	
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

    /**
     * 招聘部门
     */
    private String recruitmentDeparment;

    /**
     * 招聘职位
     */
    private String recruitmentJob;

    /**
     * 任职要求
     */
    private String jobRequirements;

    /**
     * 工作内容
     */
    private String jobContent;

    /**
     * 招聘人数
     */
    private Integer recruitmentNumber;

    /**
     * 学历要求
     */
    private String minimumEducation;

    /**
     * 招聘公司
     */
    private String recruitmentAgency;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 工作性质
     */
    private String workingProperty;

    /**
     * 招聘状态
     */
    private String recruitmentState;

	public String getRecruitmentDeparment() {
		return recruitmentDeparment;
	}

	public void setRecruitmentDeparment(String recruitmentDeparment) {
		this.recruitmentDeparment = recruitmentDeparment;
	}

	public String getRecruitmentJob() {
		return recruitmentJob;
	}

	public void setRecruitmentJob(String recruitmentJob) {
		this.recruitmentJob = recruitmentJob;
	}

	public String getJobRequirements() {
		return jobRequirements;
	}

	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}

	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	public Integer getRecruitmentNumber() {
		return recruitmentNumber;
	}

	public void setRecruitmentNumber(Integer recruitmentNumber) {
		this.recruitmentNumber = recruitmentNumber;
	}

	public String getMinimumEducation() {
		return minimumEducation;
	}

	public void setMinimumEducation(String minimumEducation) {
		this.minimumEducation = minimumEducation;
	}

	public String getRecruitmentAgency() {
		return recruitmentAgency;
	}

	public void setRecruitmentAgency(String recruitmentAgency) {
		this.recruitmentAgency = recruitmentAgency;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getWorkingProperty() {
		return workingProperty;
	}

	public void setWorkingProperty(String workingProperty) {
		this.workingProperty = workingProperty;
	}

	public String getRecruitmentState() {
		return recruitmentState;
	}

	public void setRecruitmentState(String recruitmentState) {
		this.recruitmentState = recruitmentState;
	}

}