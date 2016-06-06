/**
 * 项目名称：com.finemanagement.dao.user.impl
 * 创建日期：2016-3-22
 * 修改历史：
 *    1、[2016-3-22]创建文件    by liutianyang
 */
package com.finemanagement.dao.user.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.user.SysMenuDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysMenuDao")
public class SysMenuDaoImpl<T> extends BaseDaoImpl<T> implements SysMenuDao<T> {

	@Override
	public List<T> getRootMenu(String str, String sysid) {
		return sqlSessionTemplate.selectList(str, sysid);
	}
	
	/**
	 * 获取末级菜单
	 * @return
	 */
	public List<T> getFinalMenu(String str, String sysid) {
		return sqlSessionTemplate.selectList(str, sysid);
	}
	
	@Override
	public List<T> getRoleRootMenu(String str, String sysid) {
		return sqlSessionTemplate.selectList(str, sysid);
	}
	
	@Override
	public List<T> getRoleRootMenuByRel(String str, Map<String, String> map) {
		return sqlSessionTemplate.selectList(str, map);
	}

	@Override
	public List<T> getChildMenu(String str, String sysid) {
		return sqlSessionTemplate.selectList(str, sysid);
	}
	
	@Override
	public List<T> getRoleChildMenu(String str, String sysid) {
		return sqlSessionTemplate.selectList(str, sysid);
	}
	
	@Override
	public List<T> getRoleChildMenuByRel(String str, Map<String, String> map) {
		return sqlSessionTemplate.selectList(str, map);
	}
	
	@Override
	public List<T> getRoleFinalMenu(String str, String sysid) {
		return sqlSessionTemplate.selectList(str, sysid);
	}
	
	@Override
	public List<T> getRoleFinalMenuByRel(String str, Map<String, String> map) {
		return sqlSessionTemplate.selectList(str, map);
	}

	@Override
	public List<T> getMenuByRoleId(String str, Integer roleId) {
		return sqlSessionTemplate.selectList(str, roleId);
	}

	@Override
	public List<T> getRootMenuByUser(String str, Map<String, String> map) {
		return sqlSessionTemplate.selectList(str, map);
	}

	@Override
	public List<T> getChildMenuByUser(String str, Map<String, String> map) {
		return sqlSessionTemplate.selectList(str, map);
	}

	@Override
	public List<T> getFinalMenuByUser(String str, Map<String, String> map) {
		return sqlSessionTemplate.selectList(str, map);
	}
}
