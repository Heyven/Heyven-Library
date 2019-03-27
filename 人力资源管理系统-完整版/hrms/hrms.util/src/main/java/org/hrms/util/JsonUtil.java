package org.hrms.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;

/**
 * Json工具类
 * 
 * @author VIC
 *
 */
public class JsonUtil {
	
	static Gson gson = new Gson();
	
	/**
	 * 对象转JSON字符串
	 * @param object
	 * @return
	 */
	public static String toJsonFormObject(Object object){
		return gson.toJson(object);
	}

    public static <T> T fromJson(String json,Class<T> tClass){
        return gson.fromJson(json,tClass);
    }

    public static <T> T fromJson(String json, Type t){
        return gson.fromJson(json,t);
    }
}
