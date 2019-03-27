package org.hrms.service;

import org.hrms.common.request.AccountRequest;
import org.hrms.common.response.Response;
import org.hrms.domain.Account;

/**
 * 账号业务接口
 * 
 * @author VIC
 *
 */
public interface IAccountService extends IBaseService<Account, Integer, AccountRequest> {

	/**
	 * 登录
	 * @param accountRequest
	 * @return
	 */
	Response login(AccountRequest accountRequest);

	/**
	 * 保存密码
	 * 
	 * @param accountRequest
	 * @return
	 */
	Response savePassword(AccountRequest accountRequest);

	/**
	 * 获取账号所有权限
	 * @param accountRequest
	 * @return
	 */
	Response auths(AccountRequest accountRequest);

}
