/**
 * 项目名称：com.finemanagement.service.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.BaseEntity.STATE;
import com.base.service.BaseService;
import com.finemanagement.dao.user.SysRoleDao;
import com.finemanagement.entity.user.SysRole;
import com.finemanagement.entity.user.SysRoleRel;
import com.finemanagement.entity.user.SysRoleRel.RelType;

/**
 * 
 * @author liutianyang
 */
@Service("sysRoleService")
public class SysRoleService<T> extends BaseService<T> {

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@Autowired
    private SysRoleDao<T> sysRoleDao;
		
	public SysRoleDao<T> getDao() {
		return sysRoleDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.user.SysRoleDao";
	}
	
	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleMenuRel(Integer roleId, Integer[] menuIds) throws Exception {
		if (roleId == null || menuIds == null || menuIds.length < 1) { 
			return;
		}
		for (Integer menuid : menuIds ) { 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(menuid);
			rel.setRelType(RelType.MENU.key);
			sysRoleRelService.add(rel);
		}
	}
		
	/**
	 * 添加角色&菜单关系
	 */
	public void addRoleBtnRel(Integer roleId, Integer[] btnIds) throws Exception {
		if (roleId == null || btnIds == null || btnIds.length < 1) { 
			return;
		}
		for (Integer btnid : btnIds ) { 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(btnid);
			rel.setRelType(RelType.BTN.key);
			sysRoleRelService.add(rel);
		}
	}
	
	/**
	 * 添加
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	public void roleAdd(SysRole role, Integer[] menuIds, Integer[] btnIds) throws Exception {
		addRoleMenuRel(role.getId(), menuIds);
		addRoleBtnRel(role.getId(), btnIds);
	}
	
	/**
	 * 修改
	 * @param role
	 * @param menuIds
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void update(SysRole role, Integer[] menuIds, Integer[] btnIds) throws Exception {
		super.update((T) role);
		// 如果角色被禁用则删除关联的用户关系
		if (STATE.DISABLE.key == role.getState()){
			sysRoleRelService.deleteByRoleId(role.getId(), RelType.USER.key);
		}
		// 清除关联关系
		sysRoleRelService.deleteByRoleId(role.getId(), RelType.MENU.key);
		sysRoleRelService.deleteByRoleId(role.getId(), RelType.BTN.key);
		addRoleMenuRel(role.getId(), menuIds);
		addRoleBtnRel(role.getId(), btnIds);
	}
	
	/**
	 * 查询全部有效的权限
	 * @return
	 */
	public List<T> queryAllList() {
		return getDao().queryAllList(getMapperObj() + ".queryAllList");
	}
	
	/**
	 * 查询全部有效的权限
	 * @return
	 */
	public List<T> queryRoleByList(T t) {
		return getDao().queryRoleByList(getMapperObj() + ".queryRoleByList", t);
	}
	
	/**
	 * 查询全部有效的权限
	 * @return
	 */
	public List<T> queryByUserid(Integer userid) {
		return getDao().queryByUserid(getMapperObj() + ".queryByUserid", userid);
	}
}
