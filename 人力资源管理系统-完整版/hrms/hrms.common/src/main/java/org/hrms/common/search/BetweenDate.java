package org.hrms.common.search;

/**
 * 日期范围查询
 * 
 * @author VIC
 *
 */
public class BetweenDate {
	
	private Long startTime;
	private Long endTime;
	public BetweenDate(Long startTime, Long endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
}
