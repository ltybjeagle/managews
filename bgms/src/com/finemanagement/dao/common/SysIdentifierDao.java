/**
 * 项目名称：com.finemanagement.dao.common
 * 创建日期：2016-3-24
 * 修改历史：
 *    1、[2016-3-24]创建文件    by liutianyang
 */
package com.finemanagement.dao.common;

import java.util.List;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public interface SysIdentifierDao<T> {

	/**
	 * 获取所有系统标识
	 * @return
	 */
	public List<T> querySysIdentifierList(String str, BasePage page);
	
	/**
	 * 获取所有系统标识
	 * @return
	 */
	public List<T> querySysIdentifierByUser(String str, Integer userid);
}
