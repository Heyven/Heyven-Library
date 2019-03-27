package org.hrms.common.response;

import org.hrms.common.search.Pageing;
import org.hrms.util.JsonUtil;

/**
 * 
 * 输出对象
 * 
 * @author VIC
 *
 */
public class Response {
	
	/** 响应状态: true表示成功,false表示失败,默认false */
	private boolean state;
	/** 响应消息 */
	private String message;
	/** 响应数据 */
	private Object data;
	/** 分页对象*/
	private Pageing pageing;
	
	/** 私有构造 */
	private Response(){}
	
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Pageing getPageing() {
		return pageing;
	}

	public void setPageing(Pageing pageing) {
		this.pageing = pageing;
	}

	/**
	 * 获取响应对象
	 * @return
	 */
	public static Response getInstance(){
		return new Response();
	}

	public String toJson(){
		return JsonUtil.toJsonFormObject(this);
	}
}
