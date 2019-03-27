package org.hrms.common.request;

import org.hrms.common.annotation.UniqueValue;

/**
 * 权限请求对象
 * 
 * @author VIC
 *
 */
public class AuthorityRequest extends Request {
	
	@UniqueValue
	private String authorityName;
	@UniqueValue
	private String authorityCode;
	@UniqueValue
	private String authorityUrl;
    private Boolean accessAuthentication;
    private Boolean defaultAuthority;
	
	private String state;
	
	private String ids;

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	public String getAuthorityUrl() {
		return authorityUrl;
	}

	public void setAuthorityUrl(String authorityUrl) {
		this.authorityUrl = authorityUrl;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Boolean getAccessAuthentication() {
		return accessAuthentication;
	}

	public void setAccessAuthentication(Boolean accessAuthentication) {
		this.accessAuthentication = accessAuthentication;
	}

	public Boolean getDefaultAuthority() {
		return defaultAuthority;
	}

	public void setDefaultAuthority(Boolean defaultAuthority) {
		this.defaultAuthority = defaultAuthority;
	}
	
}
