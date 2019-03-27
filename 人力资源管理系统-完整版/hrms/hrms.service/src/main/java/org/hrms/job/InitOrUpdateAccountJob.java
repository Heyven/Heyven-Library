package org.hrms.job;

import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.hrms.common.context.State;
import org.hrms.common.request.AccountRequest;
import org.hrms.common.search.Attribute;
import org.hrms.domain.Account;
import org.hrms.domain.AccountAuthority;
import org.hrms.domain.Authority;
import org.hrms.util.JsonUtil;
import org.hrms.util.MD5Util;
import org.hrms.util.ObjectUtil;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;

/**
 * 初始化或更新系统默认账号及账号权限任务
 * 
 * @author VIC
 *
 */
@Component
public class InitOrUpdateAccountJob extends BaseJob {

	public void work(){

		log.debug("===================开始初始化或更新系统默认账号及账号权限=========================");
		// 反序列化账号对象
		String rootJsonData = readerFileToString("data/account.json");
		AccountRequest accountRequest = JsonUtil.fromJson(rootJsonData, new TypeToken<AccountRequest>(){}.getType());
		// 获取系统当前最新所有权限
		List<Authority> sourceAuthoritys = authorityReadWrite.selectByAttributes(new Attribute());
		
		// 查询账号
		Account account = accountReadWrite.selectByAttribute(new Attribute("account", accountRequest.getAccount()));
		if(ObjectUtil.isNotEmpty(account)){
			// 获取当前账号的所有权限
			List<Authority> oldAuthoritys = authorityReadWrite.selectAccountAuthorityByAccountId(account.getId());
			// 求新加账号权限差集，批量添加新的账号权限
			initAccountAuthority(sourceAuthoritys,oldAuthoritys, account);
			// 求删除账号权限差集，批量删除账号权限
			deleteAccountAuthority(oldAuthoritys, sourceAuthoritys);
		}else{
			initAccountAndAuthority(sourceAuthoritys, accountRequest);
		}
		log.debug("===================结束初始化或更新系统默认账号及账号权限=========================");
	}
	
	
	/**
	 * 删除账号权限映射数据
	 * 
	 * @param oldAuthoritys
	 * @param sourceAuthoritys
	 */
	private void deleteAccountAuthority(List<Authority> oldAuthoritys,List<Authority> sourceAuthoritys){
		// 求删除账号权限差集
		List<Authority> delAuthoritys = processNewAuths(oldAuthoritys, sourceAuthoritys);
		if(delAuthoritys.size() > 0){
			// 批量删除账号权限
			List<Integer> ids = buildAuthIds(delAuthoritys);
			int batchDelete = accountAuthorityReadWrite.deleteInByAuthorityIds(ids);
			log.debug("删除系统默认账号权限数量: " + batchDelete);
		}
	}
	
	/**
	 * 
	 * 初始化账号及账号权限数据
	 * 
	 * @param authoritys
	 * @param accountRequest
	 */
	private void initAccountAndAuthority(List<Authority> authoritys, AccountRequest accountRequest){
		
		Account account = new Account();
		try {
			BeanUtils.copyProperties(account, accountRequest);
			account.setPassword(MD5Util.encryptMD5(account.getPassword()));
			account.setState(State.ENABLED.toString());
			account.setCreateTime(System.currentTimeMillis());
			account.setUpdateTime(account.getCreateTime());
			account.setCreator("system");
			accountReadWrite.insert(account);
			if(ObjectUtil.isNotEmpty(account.getId())){
				log.debug("初始化系统默认账号成功.");
				initAuthority(authoritys, account);
			}else{
				log.debug("系统默认账号已经存在.");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			log.error("初始化系统默认账号错误.");
		}
	}
	
	/**
	 * 
	 * 初始化账号权限映射数据
	 * 
	 * @param authoritys
	 * @param account
	 */
	private void initAccountAuthority(List<Authority> sourceAuthoritys, List<Authority> oldAuthoritys, Account account){
		List<Authority> newAuthoritys = processNewAuths(sourceAuthoritys,oldAuthoritys);
		if(newAuthoritys.size() > 0){
			// 批量添加账号权限
			initAuthority(newAuthoritys, account);
		}
	}
	
	/**
	 * 批量添加账号权限
	 * 
	 * @param authoritys
	 * @param account
	 */
	private void initAuthority(List<Authority> authoritys, Account account){
		List<AccountAuthority> accountAuthorityList = buildAccountAuthoritys(authoritys, account);
		int batchInsert = accountAuthorityReadWrite.batchInsert(accountAuthorityList);
		log.debug("初始化系统默认账号权限数量: " + batchInsert);
	}
	
	/**
	 * 构建账号权限映射数据
	 * 
	 * @param authoritys
	 * @param account
	 * @return
	 */
	private List<AccountAuthority> buildAccountAuthoritys(List<Authority> authoritys, Account account) {
		List<AccountAuthority> accountAuthorityList = Lists.newArrayList();
		for(Authority authority : authoritys){
			accountAuthorityList.add(new AccountAuthority(account.getId(), authority.getId()));
		}
		return accountAuthorityList;
	}
}
