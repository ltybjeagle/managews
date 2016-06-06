/**
 * 项目名称：com.base.annotation
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author liutianyang
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
@Documented 
@Inherited
public @interface Auth {

	/**
	 * 是否验证登陆 true=验证 ,false = 不验证
	 * @return
	 */
	 public boolean verifyLogin() default true;
	 
	 /**
	 * 是否验证URL true=验证 ,false = 不验证
	 * @return
	 */
	 public boolean verifyURL() default true;
}
