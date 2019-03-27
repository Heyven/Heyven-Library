package org.hrms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Lists;

/**
 * 日期工具类
 * 
 * @author VIC
 *
 */
public class DateUtil {
	
	public static Map<String, SimpleDateFormat> partternMap = new HashMap<String, SimpleDateFormat>();
	static{
		partternMap.put("1", new SimpleDateFormat("yyyy-MM-dd"));
		partternMap.put("2", new SimpleDateFormat("yyyy-MM-dd hh:mm"));
		partternMap.put("3", new SimpleDateFormat("yyyy年MM月dd日"));
		partternMap.put("4", new SimpleDateFormat("yyyy年MM月dd日 hh时mm分"));
		partternMap.put("5", new SimpleDateFormat("yyyy年MM月"));
	}
	
	/**
	 * 转换月份
	 * @param date
	 * @return
	 */
	public static String converterMonthName(Date date) {
		return partternMap.get("5").format(date);
	}
	
	/**
	 * 获取两个日期之间的相隔的月数
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 日期集合
	 */
	public static List<Date> getBetweenDateMonth(Date start, Date end) {
	    List<Date> result = Lists.newArrayList();
	    Calendar tempStart = Calendar.getInstance();
	    tempStart.setTime(start);
	    tempStart.add(Calendar.MONTH, 1);
	    
	    Calendar tempEnd = Calendar.getInstance();
	    tempEnd.setTime(end);
	    while (tempStart.before(tempEnd)) {
	        result.add(tempStart.getTime());
	        tempStart.add(Calendar.MONTH, 1);
	    }
	    return result;
	}
	
	/**
	 * 获取两个日期之间的相隔的天数
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 日期集合
	 */
	public static List<Date> getBetweenDateDay(Date start, Date end) {
	    List<Date> result = Lists.newArrayList();
	    Calendar tempStart = Calendar.getInstance();
	    tempStart.setTime(start);
	    tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    
	    Calendar tempEnd = Calendar.getInstance();
	    tempEnd.setTime(end);
	    while (tempStart.before(tempEnd)) {
	        result.add(tempStart.getTime());
	        tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    }
	    return result;
	}

	public static Date parse(Long time) {
		return new Date(time);
	}

}
