package org.hrms.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一对多属性注解
 * 被该注解标注的属性标识需要添加一对多映射数据
 * 
 * @author VIC
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface OneToMany {

	/**
	 * mapper接口
	 * @return
	 */
	String mapper() default "";
	/**
	 * 映射类
	 * @return
	 */
	String domain() default "";
	/**
	 * 一方的关联键
	 * @return
	 */
	String oneKey() default "id";
	
	/**
	 * 多方的关联键
	 * @return
	 */
	String manyKey() default "id";
	
}
