package org.hrms.job;

import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 初始化数据库数据任务
 * 
 * @author VIC
 *
 */
@Component
public class InitDatabaseDataJob extends TimerTask {

	@Autowired
	private InitOrUpdateAuthorityJob initOrUpdateAuthorityJob;
	@Autowired
	private InitOrUpdateAccountJob initOrUpdateAccountJob;
	
	@Override
	public void run() {
		// 初始化或更新系统所有的权限数据
		initOrUpdateAuthorityJob.work();
		// 初始化或更新系统默认账号及账号权限
		initOrUpdateAccountJob.work();
	}
	
}
