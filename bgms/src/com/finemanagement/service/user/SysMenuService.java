/**
 * 项目名称：com.finemanagement.service.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.service.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.user.SysMenuDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysMenuService")
public class SysMenuService<T> extends BaseService<T> {

	@Autowired
    private SysMenuDao<T> sysMenuDao;
	
	public SysMenuDao<T> getDao() {
		return sysMenuDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.user.SysMenuDao";
	}
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRootMenu(String sysid) {
		return getDao().getRootMenu(getMapperObj() + ".getRootMenu", sysid);
	}
	
	/**
	 * 获取末级菜单
	 * @return
	 */
	public List<T> getFinalMenu(String sysid) {
		return getDao().getFinalMenu(getMapperObj() + ".getFinalMenu", sysid);
	}
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRoleRootMenu(String sysid) {
		return getDao().getRoleRootMenu(getMapperObj() + ".getRoleRootMenu", sysid);
	}
	
	/**
	 * 获取顶级菜单
	 * @return
	 */
	public List<T> getRoleRootMenuByRel(Map<String, String> map) {
		return getDao().getRoleRootMenuByRel(getMapperObj() + ".getRoleRootMenuByRel", map);
	}
	
	/**
	 * 根据用户id查询父菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getRootMenuByUser(Map<String, String> map) {
		return getDao().getRootMenuByUser(getMapperObj() + ".getRootMenuByUser", map);
	}
	
	/**
	 * 根据用户id查询子菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getChildMenuByUser(Map<String, String> map) {
		return getDao().getChildMenuByUser(getMapperObj() + ".getChildMenuByUser", map);
	}
	
	/**
	 * 根据用户id查询末级菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getFinalMenuByUser(Map<String, String> map) {
		return getDao().getFinalMenuByUser(getMapperObj() + ".getFinalMenuByUser", map);
	}
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getChildMenu(String sysid) {
		return getDao().getChildMenu(getMapperObj() + ".getChildMenu", sysid);
	}
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getRoleChildMenu(String sysid) {
		return getDao().getRoleChildMenu(getMapperObj() + ".getRoleChildMenu", sysid);
	}
	
	/**
	 * 获取子菜单
	 * @return
	 */
	public List<T> getRoleChildMenuByRel(Map<String, String> map) {
		return getDao().getRoleChildMenuByRel(getMapperObj() + ".getRoleChildMenuByRel", map);
	}
	
	/**
	 * 获取末级菜单
	 * @return
	 */
	public List<T> getRoleFinalMenu(String sysid) {
		return getDao().getRoleChildMenu(getMapperObj() + ".getRoleChildMenu", sysid);
	}
	
	/**
	 * 获取末级菜单
	 * @return
	 */
	public List<T> getRoleFinalMenuByRel(Map<String, String> map) {
		return getDao().getRoleChildMenuByRel(getMapperObj() + ".getRoleChildMenuByRel", map);
	}
	
	/**
	 * 根据权限id查询菜单
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(Integer roleId) {
		return getDao().getMenuByRoleId(getMapperObj() + ".getMenuByRoleId", roleId);
	}

}
