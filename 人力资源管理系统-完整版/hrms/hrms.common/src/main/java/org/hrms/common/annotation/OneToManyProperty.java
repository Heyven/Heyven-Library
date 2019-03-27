package org.hrms.common.annotation;

/**
 * 一对多注解属性
 * 
 * @author VIC
 *
 */
public class OneToManyProperty {

	/**
	 * 一方的关联键
	 */
	private String oneKey;
	/**
	 * 多方的关联键
	 */
	private String manyKey;
	/**
	 * mapper接口
	 */
	private String mapper;
	/**
	 * 映射类
	 */
	private String domain;
	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 字段值
	 */
	private Object value;
	
	public OneToManyProperty() {
	}

	public OneToManyProperty(String oneKey, String manyKey, String domain, String mapper) {
		this.oneKey = oneKey;
		this.manyKey = manyKey;
		this.domain = domain;
		this.mapper = mapper;
	}

	public String getOneKey() {
		return oneKey;
	}

	public void setOneKey(String oneKey) {
		this.oneKey = oneKey;
	}

	public String getManyKey() {
		return manyKey;
	}

	public void setManyKey(String manyKey) {
		this.manyKey = manyKey;
	}



	public String getMapper() {
		return mapper;
	}

	public void setMapper(String mapper) {
		this.mapper = mapper;
	}

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}
