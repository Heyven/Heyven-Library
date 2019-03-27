package org.hrms.common.request;

import org.hrms.common.annotation.AutoGeneration;
import org.hrms.common.annotation.UniqueValue;

/**
 * 应聘请求对象
 * 
 * @author VIC
 *
 */
public class ApplyRequest extends Request {

	private String ids;
	
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

    /**
     * 应聘编号
     */
	@AutoGeneration
    private String applyId;

    /**
     * 应聘人姓名
     */
	@UniqueValue
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

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApplySex() {
		return applySex;
	}

	public void setApplySex(String applySex) {
		this.applySex = applySex;
	}

	public Long getApplyBirthday() {
		return applyBirthday;
	}

	public void setApplyBirthday(Long applyBirthday) {
		this.applyBirthday = applyBirthday;
	}

	public String getApplyPhone() {
		return applyPhone;
	}

	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}

	public String getApplyEmail() {
		return applyEmail;
	}

	public void setApplyEmail(String applyEmail) {
		this.applyEmail = applyEmail;
	}

	public String getApplyDepartment() {
		return applyDepartment;
	}

	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}

	public String getApplyJob() {
		return applyJob;
	}

	public void setApplyJob(String applyJob) {
		this.applyJob = applyJob;
	}
}