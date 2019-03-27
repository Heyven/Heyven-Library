package org.hrms.common.annotation;

public class UpdateAttributeProperty {
	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 字段值
	 */
	private Object value;
	
	/**
	 * mapper接口
	 */
	private String mapper;
	
	/**
	 * 原属性组
	 */
	private String[] srcAttributes;
	
	/**
	 * 目标属性组
	 */
	private String[] destAttributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getMapper() {
		return mapper;
	}

	public void setMapper(String mapper) {
		this.mapper = mapper;
	}

	public String[] getSrcAttributes() {
		return srcAttributes;
	}

	public void setSrcAttributes(String[] srcAttributes) {
		this.srcAttributes = srcAttributes;
	}

	public String[] getDestAttributes() {
		return destAttributes;
	}

	public void setDestAttributes(String[] destAttributes) {
		this.destAttributes = destAttributes;
	}
	
}
