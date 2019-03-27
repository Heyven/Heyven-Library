package org.hrms.web.listener;

import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import org.hrms.common.context.SpringContext;
import org.hrms.job.InitCacheDataJob;
import org.hrms.job.InitDatabaseDataJob;

/**
 * 系统启动监听器
 * 
 * @author VIC
 *
 */
public class SystemStartListener implements ServletContextListener {

	private Logger log = Logger.getLogger(getClass());
	
	public void contextDestroyed(ServletContextEvent arg0) {
		log.debug("contextDestroyed...");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		log.debug("contextInitialized...");
		// 创建一个定时器(Timer)对象执行定时任务,每个Timer对象相对应的是单个后台线程
		// schedule(任务对象,延时多久(毫秒));
		// 下列即: 系统启动后延迟10秒执行任务
		new Timer().schedule(SpringContext.getBean(InitDatabaseDataJob.class), 10000);
		new Timer().schedule(SpringContext.getBean(InitCacheDataJob.class), 20000);
	}
	
}
