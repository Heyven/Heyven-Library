package org.hrms.common.annotation;

/**
 * 
 * 映射属性名称
 * 
 * @author VIC
 *
 */
public class MapperAttribute {
	
	private String srcAttribute;
	private String destAttribute;
	
	public String getSrcAttribute() {
		return srcAttribute;
	}
	public void setSrcAttribute(String srcAttribute) {
		this.srcAttribute = srcAttribute;
	}
	public String getDestAttribute() {
		return destAttribute;
	}
	public void setDestAttribute(String destAttribute) {
		this.destAttribute = destAttribute;
	}

}
