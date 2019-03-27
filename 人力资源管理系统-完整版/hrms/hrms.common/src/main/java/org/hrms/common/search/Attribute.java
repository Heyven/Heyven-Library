package org.hrms.common.search;

/**
 * 属性类
 * 存放属性名称和属性值
 * 
 * @author VIC
 *
 */
public class Attribute {

	private String name;
	private Object value;
	/** 模糊查询模式：true:开启,false默认关闭*/
	private boolean likePattern;

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
	public Attribute(){}
	
	public Attribute(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public static Attribute getInstance() {
		return new Attribute();
	}
	
	public static Attribute getInstance(String name, Object value) {
		return new Attribute(name, value);
	}
	public boolean isLikePattern() {
		return likePattern;
	}
	public void setLikePattern(boolean likePattern) {
		this.likePattern = likePattern;
	}
	
}
