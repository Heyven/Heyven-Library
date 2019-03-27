package org.hrms.common.request;

import org.hrms.common.annotation.AutoGeneration;
import org.hrms.common.annotation.UniqueValue;

/**
 * 员工档案请求对象
 * 
 * @author VIC
 *
 */
public class EmployeeFilesRequest extends Request {

	private String ids;
	
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
     * 档案编号
     */
	@AutoGeneration
    private String archivesNumber;

    /**
     * 档案名称
     */
	@UniqueValue
    private String archivesName;

    /**
     * 档案内容
     */
    private String archivesContent;

    /**
     * 档案备注
     */
    private String archivesRemarks;

    /**
     * 档案摘要
     */
    private String archivesSummary;

    /**
     * 员工ID
     */
    private Integer employeeId;

    /**
     * 
     */
    private String employeeName;

    /**
     * 档案编号
     * @return archivesNumber 档案编号
     */
    public String getArchivesNumber() {
        return archivesNumber;
    }

    /**
     * 档案编号
     * @param archivesNumber 档案编号
     */
    public void setArchivesNumber(String archivesNumber) {
        this.archivesNumber = archivesNumber;
    }

    /**
     * 档案名称
     * @return archivesName 档案名称
     */
    public String getArchivesName() {
        return archivesName;
    }

    /**
     * 档案名称
     * @param archivesName 档案名称
     */
    public void setArchivesName(String archivesName) {
        this.archivesName = archivesName;
    }

    /**
     * 档案内容
     * @return archivesContent 档案内容
     */
    public String getArchivesContent() {
        return archivesContent;
    }

    /**
     * 档案内容
     * @param archivesContent 档案内容
     */
    public void setArchivesContent(String archivesContent) {
        this.archivesContent = archivesContent;
    }

    /**
     * 档案备注
     * @return archivesRemarks 档案备注
     */
    public String getArchivesRemarks() {
        return archivesRemarks;
    }

    /**
     * 档案备注
     * @param archivesRemarks 档案备注
     */
    public void setArchivesRemarks(String archivesRemarks) {
        this.archivesRemarks = archivesRemarks;
    }

    /**
     * 档案摘要
     * @return archivesSummary 档案摘要
     */
    public String getArchivesSummary() {
        return archivesSummary;
    }

    /**
     * 档案摘要
     * @param archivesSummary 档案摘要
     */
    public void setArchivesSummary(String archivesSummary) {
        this.archivesSummary = archivesSummary;
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
     * 
     * @return employeeName 
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 
     * @param employeeName 
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}