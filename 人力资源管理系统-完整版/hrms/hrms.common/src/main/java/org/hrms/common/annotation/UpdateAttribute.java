package org.hrms.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 更新注解,使用该注解标注的属性将自动更新指定对象的指定属性值
 * 
 * @author VIC
 *
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateAttribute {
	
	/**
	 * mapper接口
	 * @return
	 */
	String mapper() default "";
	
	String[] srcAttributes() default {};
	
	String[] destAttributes() default {};
	
}
