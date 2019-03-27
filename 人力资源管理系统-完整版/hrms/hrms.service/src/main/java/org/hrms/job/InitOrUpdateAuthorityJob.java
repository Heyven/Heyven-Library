package org.hrms.job;

import java.util.List;
import org.hrms.common.search.Attribute;
import org.hrms.domain.Authority;
import org.hrms.util.JsonUtil;
import org.springframework.stereotype.Component;
import com.google.gson.reflect.TypeToken;

/**
 * 初始化或更新权限任务
 * 
 * @author VIC
 *
 */
@Component
public class InitOrUpdateAuthorityJob extends BaseJob {
	
	public void work() {
		
		log.debug("===================开始初始化或更新权限数据=========================");
		// 查询数据库原有所有权限
		List<Authority> oldAuthoritys = authorityReadWrite.selectByAttributes(new Attribute());
		// 读取权限源数据,将权限源数据转换成权限集合
		String authoritysJsonData = readerFileToString("data/authoritys.json");
		List<Authority> sourceAuthoritys = JsonUtil.fromJson(authoritysJsonData, new TypeToken<List<Authority>>(){}.getType());
		
		// 求新加权限差集
		List<Authority> newAuthoritys = processNewAuths(sourceAuthoritys,oldAuthoritys);
		if(newAuthoritys.size() > 0){
			// 批量添加新权限
			int batchInsert = authorityReadWrite.batchInsert(newAuthoritys);
			log.debug("新增权限数据: " + batchInsert);
		}
		
		// 求删除权限差集，批量删除权限
		List<Authority> delAuthoritys = processNewAuths(oldAuthoritys, sourceAuthoritys);
		if(delAuthoritys.size() > 0){
			List<Integer> ids = buildAuthIds(delAuthoritys);
			int batchDelete = authorityReadWrite.deleteInByPrimaryKey(ids);
			log.debug("删除权限数据: " + batchDelete);
			batchDelete = accountAuthorityReadWrite.deleteInByAuthorityIds(ids);
			log.debug("删除权限映射数据: " + batchDelete);
		}
		log.debug("===================结束初始化或更新权限数据=========================");
	}
}
