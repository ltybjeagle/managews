/**
 * 项目名称：com.finemanagement.dao.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.dao.user;

import java.util.List;

import com.base.dao.BaseDao;

/**
 * 
 * @author liutianyang
 */
public interface SysRoleDao<T> extends BaseDao<T> {

	/**
	 * 查询全部有效的权限
	 * @return
	 */
	public List<T> queryAllList(String str);
	
	/**
	 * 查询全部有效的权限
	 * @return
	 */
	public List<T> queryRoleByList(String str, T t);
	
	/**
	 * 根据用户Id查询权限
	 * @return
	 */
	public List<T> queryByUserid(String str, Integer userid);
}
