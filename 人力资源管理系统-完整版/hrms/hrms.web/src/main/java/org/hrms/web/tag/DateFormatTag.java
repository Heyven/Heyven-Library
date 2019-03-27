package org.hrms.web.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import org.hrms.util.DateUtil;
import org.hrms.util.StringUtil;

/**
 * 日期格式化标签
 * 
 * @author VIC
 *
 */
public class DateFormatTag extends BaseTag {
	
	/**日期格式KEY*/
	private String partternKey;
	
	/**日期*/
	private Object date;

	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter jspWriter = getJspContext().getOut();
		partternKey = StringUtil.isEmpty(partternKey) ? "1" : partternKey;
		SimpleDateFormat simpleDateFormat = DateUtil.partternMap.get(partternKey);
		String value = "NaN";
		try {
			if(date instanceof String){
				value = simpleDateFormat.format(Long.valueOf(date.toString()));
			}else{
				value = simpleDateFormat.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jspWriter.write(value);
	}
	
	public String getPartternKey() {
		return this.partternKey;
	}
	public void setPartternKey(String partternKey) {
		this.partternKey = partternKey;
	}
	public Object getDate() {
		return this.date;
	}
	public void setDate(Object date) {
		this.date = date;
	}
}
