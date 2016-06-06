/**
 * 项目名称：com.finemanagement.dao.user
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.finemanagement.dao.user;

import com.base.dao.BaseDao;
import com.finemanagement.page.user.SysUserModel;

/**
 * SysUser Mapper
 * @author liutianyang
 */
public interface SysUserDao<T> extends BaseDao<T> {

	/**
	 * 检查登录
	 * @param code
	 * @param pwd
	 * @return
	 */
	public T queryLogin(String str, SysUserModel model);
	
	
	/**
	 * 检查是否存在
	 * @param code
	 * @return
	 */
	public T getUserCountByCode(String str, String code);
}
