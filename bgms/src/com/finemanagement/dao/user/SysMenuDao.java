/**
 * 项目名称：com.finemanagement.dao.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.dao.user;

import java.util.List;
import java.util.Map;

import com.base.dao.BaseDao;

/**
 * SysMenu Mapper
 * @author liutianyang
 */
public interface SysMenuDao<T> extends BaseDao<T> {

	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRootMenu(String str, String sysid);
	
	/**
	 * 获取末级菜单
	 * @return
	 */
	public List<T> getFinalMenu(String str, String sysid);
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRoleRootMenu(String str, String sysid);
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRoleRootMenuByRel(String str, Map<String, String> map);
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getChildMenu(String str, String sysid);
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getRoleChildMenu(String str, String sysid);
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getRoleChildMenuByRel(String str, Map<String, String> map);
	
	/**
	 * 获取末级菜单
	 * @return
	 */
	public List<T> getRoleFinalMenu(String str, String sysid);
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getRoleFinalMenuByRel(String str, Map<String, String> map);

	/**
	 * 根据权限id查询菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(String str, Integer roleId);
	
	/**
	 * 根据用户id查询父菜单菜单
	 * @param userId
	 * @return
	 */
	public List<T> getRootMenuByUser(String str, Map<String, String> map);
	
	/**
	 * 根据用户id查询子菜单菜单
	 * @param userId
	 * @return
	 */
	public List<T> getChildMenuByUser(String str, Map<String, String> map);
	
	/**
	 * 根据用户id查询末级菜单
	 * @param userId
	 * @return
	 */
	public List<T> getFinalMenuByUser(String str, Map<String, String> map);
}
