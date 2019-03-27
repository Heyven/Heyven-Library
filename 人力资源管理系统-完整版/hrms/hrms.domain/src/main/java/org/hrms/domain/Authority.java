package org.hrms.domain;

public class Authority {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String authorityName;

    /**
     * 权限代码
     */
    private String authorityCode;

    /**
     * 权限URL
     */
    private String authorityUrl;
    /**
     * 标识访问该能耐是否需要权限认证
     */
    private Boolean accessAuthentication;
    
    /**
     * 标识该权限是否是所有账号默认权限
     */
    private Boolean defaultAuthority;
    /**
     * 状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 权限名称
     * @return authorityName 权限名称
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 权限名称
     * @param authorityName 权限名称
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * 权限代码
     * @return authorityCode 权限代码
     */
    public String getAuthorityCode() {
        return authorityCode;
    }

    /**
     * 权限代码
     * @param authorityCode 权限代码
     */
    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    /**
     * 权限URL
     * @return authorityUrl 权限URL
     */
    public String getAuthorityUrl() {
        return authorityUrl;
    }

    /**
     * 权限URL
     * @param authorityUrl 权限URL
     */
    public void setAuthorityUrl(String authorityUrl) {
        this.authorityUrl = authorityUrl;
    }

    /**
     * 状态
     * @return state 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return updateTime 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人
     * @return creator 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
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

	@Override
	public String toString() {
		return "Authority [id=" + id + ", authorityName=" + authorityName + ", authorityCode=" + authorityCode
				+ ", authorityUrl=" + authorityUrl + ", accessAuthentication=" + accessAuthentication
				+ ", defaultAuthority=" + defaultAuthority + ", state=" + state + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", creator=" + creator + "]";
	}
    
}