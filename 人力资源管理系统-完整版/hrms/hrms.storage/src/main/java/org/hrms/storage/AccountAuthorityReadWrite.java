package org.hrms.storage;

import java.util.List;
import org.hrms.domain.AccountAuthority;

public interface AccountAuthorityReadWrite extends IDatabaseReadWrite<AccountAuthority,Integer> {

	int deleteInByAuthorityIds(List<Integer> authorityIds);
	
	List<AccountAuthority> selectByAccountId(Integer id);
	
}