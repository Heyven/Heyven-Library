package org.hrms.util;

import java.util.List;

/**
 * 集合工具类
 * 
 * @author VIC
 *
 */
public class ListUtil {

	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(List list) {
		return null != list && list.size() > 0;
	}

}
