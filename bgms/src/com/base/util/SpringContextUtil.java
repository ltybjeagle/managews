package com.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 * @author liutianyang
 */
@SuppressWarnings("unchecked")
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	/* (non-Javadoc)
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境   
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 * @return
	 */
	public ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}
	
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * @param name
	 * @return
	 */
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}
	
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}
	
	/**
	 * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
	 * @param name
	 * @return
	 */
	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}
	
	/**
	 * 清除applicationContext静态变量.
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}
	
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在spring-common.xml中定义SpringContextUtil");
		}
	}
}
