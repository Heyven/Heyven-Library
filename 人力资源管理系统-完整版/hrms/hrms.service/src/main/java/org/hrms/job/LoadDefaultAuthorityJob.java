package org.hrms.job;

import java.util.List;

import org.hrms.common.context.CacheContext;
import org.hrms.common.search.Attribute;
import org.hrms.domain.Authority;
import org.springframework.stereotype.Component;

/**
 * 
 * 从数据库加载默认权限数据到缓存
 * 
 * @author VIC
 *
 */
@Component
public class LoadDefaultAuthorityJob extends BaseJob {

	public void work(){
		log.debug("===================开始加载默认权限数据到缓存=========================");
		List<Authority> defaultAuthorityList = authorityReadWrite.selectByAttributes(new Attribute("defaultAuthority", true));
		log.debug("查询到无需认证的默认权限数据数量: " + defaultAuthorityList.size());
		CacheContext.setCache(CacheContext.Keys.DEFAULT_AUTHORITY_KEY.toString(), defaultAuthorityList);
		log.debug("===================结束加载默认权限数据到缓存=========================");
	}
	
}
