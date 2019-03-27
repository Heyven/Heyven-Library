package org.hrms.service.impl;

import org.hrms.common.context.CacheContext;
import org.hrms.common.context.State;
import org.hrms.common.context.VerificationCodeContext;
import org.hrms.common.request.AccountRequest;
import org.hrms.common.response.Response;
import org.hrms.common.search.Attribute;
import org.hrms.domain.Account;
import org.hrms.domain.Authority;
import org.hrms.service.IAccountService;
import org.hrms.util.ListUtil;
import org.hrms.util.MD5Util;
import org.hrms.util.ObjectUtil;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 账号业务实现
 * 
 * @author VIC
 *
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Integer, AccountRequest> implements IAccountService {

	public Response login(AccountRequest accountRequest) {
		
		Response response = Response.getInstance();
		response.setMessage("login.fail");
		Attribute attribute = Attribute.getInstance("account", accountRequest.getAccount());
		Account account = databaseReadWrite.selectByAttribute(attribute);
		
		// 检查验证码正确则删除,否则返回
		boolean codeExists = VerificationCodeContext.existsCode(accountRequest.getCode());
		if(codeExists){
			VerificationCodeContext.removeCode(accountRequest.getCode());
		}else{
			response.setMessage("verification.code.error");
			return response;
		}
		
		// 账号不存在无法登录
		if(!ObjectUtil.isNotEmpty(account)){
			response.setMessage("account.not.exists");
			return response;
		}
		
		// 账号被禁用无法登录
		if(!account.getState().equals(State.ENABLED.toString())){
			response.setMessage("account.disable");	
			return response;
		}
		
		// 其他逻辑..
			
		// 登录验证密码是否一致
		if(MD5Util.encryptMD5(accountRequest.getPassword()).equals(account.getPassword())){
			response.setState(true);
			accountRequest.setHead(account.getHead());
			accountRequest.setId(account.getId());
			// 获取账号权限数据放入缓存
			List<Authority> authoritys = authorityReadWrite.selectAccountAuthorityByAccountId(account.getId());
			// 缓存账号权限
			CacheContext.setCache(accountRequest.getAccount() + CacheContext.Keys._AUTH_CACHE_KEY, authoritys);
			// 缓存账号
			CacheContext.setCache(accountRequest.getAccount() + CacheContext.Keys._CACHE_KEY, accountRequest);
			// 发送登录邮件通知或短信?
			//EmailUtil.sendEmail(title, content, email);
		}
		
		// 登录成功
		if(response.getState()){
			response.setMessage("login.success");
			response.setData("index");
		}
		return response;
	}

	public Response savePassword(AccountRequest accountRequest) {
		
		Response response = Response.getInstance();
		// 首先获取需要修改密码的账号是否存在
		Attribute attribute = Attribute.getInstance("id", accountRequest.getId());
		Account account = accountReadWrite.selectByAttribute(attribute);
		if(ObjectUtil.isNotEmpty(account)){
			// 验证输入的旧密码是否和数据库中的密码一致
			if(account.getPassword().equals(MD5Util.encryptMD5(accountRequest.getPassword()))){
				// 如果一致则执行修改密码
				account.setPassword(MD5Util.encryptMD5(accountRequest.getNewPassword()));
				int update = databaseReadWrite.updateByPrimaryKey(account);
				response.setState(update > 0);
				response.setMessage(response.getState() ? "update.success" : "update.fail");
			}else{
				response.setMessage("old.password.error");	
			}
		}else{
			// 不存在不执行修改并输出提示
			response.setMessage("account.not.exists");
		}
		return response;
	}

	public Response auths(AccountRequest accountRequest) {
		Response response = Response.getInstance();
		List<Authority> auths = authorityReadWrite.selectAccountAuthorityByAccountId(accountRequest.getId());
		if(ListUtil.isNotEmpty(auths)){
			response.setState(true);
			response.setData(auths);
		}
		return response;
	}
	
}
