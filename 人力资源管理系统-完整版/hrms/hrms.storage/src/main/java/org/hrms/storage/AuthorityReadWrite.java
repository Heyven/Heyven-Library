package org.hrms.storage;

import java.util.List;

import org.hrms.domain.Authority;

public interface AuthorityReadWrite extends IDatabaseReadWrite<Authority,Integer> {

	List<Authority> selectAccountAuthorityByAccountId(Integer id);

}