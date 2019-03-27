package org.hrms.service;

import java.util.List;

import org.hrms.domain.AccountAuthority;

public interface IAccountAuthorityService extends IBaseService<AccountAuthority, Integer, AccountAuthority> {

	int deleteInByAuthorityIds(List<Integer> ids);
	
	List<AccountAuthority> selectByAccountId(Integer id);

}
