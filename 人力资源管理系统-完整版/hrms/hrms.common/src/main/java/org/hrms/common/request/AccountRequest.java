package org.hrms.common.request;

import org.hrms.common.annotation.MD5;
import org.hrms.common.annotation.OneToMany;
import org.hrms.common.annotation.UniqueValue;

/**
 * 账号请求对象
 * 
 * @author VIC
 *
 */
public class AccountRequest extends Request {
	
	@UniqueValue
	private String account;
	@MD5
	private String password;
	/** 新密码 */
	private String newPassword;
	private String head;
	private String code;
	
	/** 
	 * ids: 多的一方id集合
	 * 一对多关系映射的ID集合,多个ID使用逗号分隔 
	 */
	@OneToMany(domain="org.hrms.domain.AccountAuthority",mapper="AccountAuthorityMapper",oneKey="accountId",manyKey="authorityId")
	private String ids;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "AccountRequest [account=" + account + ", password=" + password + ", head=" + head + ", ids=" + ids
				+ "]";
	}
	
}
