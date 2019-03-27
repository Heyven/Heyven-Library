package org.hrms.service.impl;

import java.util.List;

import org.hrms.common.request.AuthorityRequest;
import org.hrms.common.search.Attribute;
import org.hrms.domain.Authority;
import org.hrms.service.IAuthorityService;
import org.springframework.stereotype.Service;

/**
 * 权限业务接口实现
 * 
 * @author VIC
 *
 */
@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, Integer, AuthorityRequest> implements IAuthorityService {
	
	public List<Authority> allAuths() {
		return authorityReadWrite.selectByAttributes(Attribute.getInstance("defaultAuthority", false));
	}

	public List<Authority> selectAccountAuthorityByAccountId(Integer id) {
		return authorityReadWrite.selectAccountAuthorityByAccountId(id);
	}
	
}
