package org.hrms.job;

import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 初始化缓存数据任务
 * 
 * @author VIC
 *
 */
@Component
public class InitCacheDataJob extends TimerTask {
	
	@Autowired
	private LoadDefaultAuthorityJob loadDefaultAuthorityJob;

	@Override
	public void run() {
		// 从数据库加载默认权限数据到缓存
		loadDefaultAuthorityJob.work();
	}

}
