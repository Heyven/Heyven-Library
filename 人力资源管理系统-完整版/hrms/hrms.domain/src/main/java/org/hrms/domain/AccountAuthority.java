package org.hrms.domain;

public class AccountAuthority {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 账号ID
     */
    private Integer accountId;

    /**
     * 权限ID
     */
    private Integer authorityId;
    
    public AccountAuthority(){}

    public AccountAuthority(Integer accountId, Integer authorityId) {
		this.accountId = accountId;
		this.authorityId = authorityId;
	}

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
     * 账号ID
     * @return accountId 账号ID
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 账号ID
     * @param accountId 账号ID
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 权限ID
     * @return authorityId 权限ID
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * 权限ID
     * @param authorityId 权限ID
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }
}