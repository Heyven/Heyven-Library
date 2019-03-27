package org.hrms.service;

import java.util.List;
import org.hrms.common.request.AuthorityRequest;
import org.hrms.domain.Authority;

/**
 * 权限业务接口
 * 
 * @author VIC
 *
 */
public interface IAuthorityService extends IBaseService<Authority, Integer, AuthorityRequest> {

	/**
	 * 获取所有权限(启用或禁用)
	 * @return
	 */
	List<Authority> allAuths();

	List<Authority> selectAccountAuthorityByAccountId(Integer id);
	
}
