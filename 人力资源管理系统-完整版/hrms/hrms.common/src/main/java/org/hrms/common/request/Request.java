package org.hrms.common.request;

public abstract class Request {
	
	/** ID */
	protected Integer id;
	/** 操作人 */
	protected String creator;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
