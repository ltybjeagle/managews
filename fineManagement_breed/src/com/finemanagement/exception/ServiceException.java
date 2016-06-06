/**
 * 项目名称：com.finemanagement.exception
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.exception;

/**
 * 
 * @author liutianyang
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String err) {
		super(err);
	}
}
