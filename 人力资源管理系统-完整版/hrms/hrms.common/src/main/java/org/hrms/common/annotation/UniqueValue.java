package org.hrms.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一唯一值注解
 * 被该注解标注的属性标识需要验证该属性的唯一性
 * 
 * @author VIC
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface UniqueValue {
	
	String field() default "";

}
