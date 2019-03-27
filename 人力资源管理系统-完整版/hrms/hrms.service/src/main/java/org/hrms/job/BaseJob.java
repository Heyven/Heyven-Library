package org.hrms.job;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hrms.common.context.State;
import org.hrms.domain.Authority;
import org.hrms.storage.AccountAuthorityReadWrite;
import org.hrms.storage.AccountReadWrite;
import org.hrms.storage.AuthorityReadWrite;
import org.hrms.storage.EmployeeAttendanceReadWrite;
import org.hrms.storage.EmployeeReadReadWrite;
import org.hrms.storage.EmployeePayReadWrite;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.collect.Lists;

public class BaseJob {
	
	@Autowired
	protected AuthorityReadWrite authorityReadWrite;
	@Autowired
	protected AccountAuthorityReadWrite accountAuthorityReadWrite;
	@Autowired
	protected AccountReadWrite accountReadWrite;
	@Autowired
	protected EmployeeReadReadWrite employeeReadReadWrite;
	@Autowired
	protected EmployeeAttendanceReadWrite employeeAttendanceReadWrite;
	@Autowired
	protected EmployeePayReadWrite employeePayReadWrite;
	
	protected Logger log = Logger.getLogger(getClass());
	
	/**
	 * 读取初始化数据
	 * 
	 * @param path
	 * @return
	 */
	protected static String readerFileToString(String path) {
		
		String result = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			InputStream inputStream = InitDatabaseDataJob.class.getClassLoader().getResourceAsStream(path);
			bufferedInputStream = new BufferedInputStream(inputStream);
			byte[] bs = new byte[bufferedInputStream.available()];
			bufferedInputStream.read(bs);
			result = new String(bs, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null != bufferedInputStream){
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/**
	 * 求权限表中的权限集合与权限文件中的权限集合的差集
	 * @param sourceAuthoritys 权限文件数据
	 * @param oldAuthoritys 权限表数据
	 * @return 差集
	 */
	protected List<Authority> processNewAuths(List<Authority> sourceAuthoritys, List<Authority> oldAuthoritys) {
		List<Authority> newAuthoritys = new ArrayList<Authority>();
		for(Authority sourceAuthority : sourceAuthoritys){
			boolean state = false;
			for(Authority oldAuthority : oldAuthoritys){
				if(sourceAuthority.getAuthorityName().equals(oldAuthority.getAuthorityName()) || 
				   sourceAuthority.getAuthorityUrl().equals(oldAuthority.getAuthorityUrl())){
					state = true;
				}
			}
			if(!state){
				sourceAuthority.setState(State.ENABLED.toString());
				sourceAuthority.setCreateTime(System.currentTimeMillis());
				sourceAuthority.setUpdateTime(sourceAuthority.getCreateTime());
				sourceAuthority.setCreator("system");
				newAuthoritys.add(sourceAuthority);
			}
		}
		return newAuthoritys;
	}
	
	/**
	 * 获取权限集ID集
	 * @param authoritys
	 * @return
	 */
	protected List<Integer> buildAuthIds(List<Authority> authoritys) {
		List<Integer> ids = Lists.newArrayList();
		for(Authority auth : authoritys){
			ids.add(auth.getId());
		}
		return ids;
	}
}
