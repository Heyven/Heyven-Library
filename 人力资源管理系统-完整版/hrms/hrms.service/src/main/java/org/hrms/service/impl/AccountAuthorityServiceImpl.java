package org.hrms.service.impl;

import java.util.List;

import org.hrms.domain.AccountAuthority;
import org.hrms.service.IAccountAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AccountAuthorityServiceImpl extends BaseServiceImpl<AccountAuthority, Integer, AccountAuthority> implements IAccountAuthorityService {

	public int deleteInByAuthorityIds(List<Integer> ids) {
		return accountAuthorityReadWrite.deleteInByAuthorityIds(ids);
	}

	public List<AccountAuthority> selectByAccountId(Integer id) {
		return accountAuthorityReadWrite.selectByAccountId(id);
	}
	
}
