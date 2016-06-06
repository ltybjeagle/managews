/**
 * 项目名称：com.finemanagement.service.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.user.SysRoleRelDao;
import com.finemanagement.entity.user.SysRoleRel;

/**
 * 
 * @author liutianyang
 */
@Service("sysRoleRelService")
public class SysRoleRelService<T> extends BaseService<T> {

	@Autowired
    private SysRoleRelDao<T> sysRoleRelDao;
		
	public SysRoleRelDao<T> getDao() {
		return sysRoleRelDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.user.SysRoleRelDao";
	}
	
	public List<SysRoleRel> queryByRoleId(Integer roleId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		return getDao().queryByRoleId(getMapperObj() + ".queryByRoleId", param);
	}
	
	/**
	 * 根据角色id删除 
	 * @param roleId
	 */
	public void deleteByRoleId(Integer roleId) {
		deleteByRoleId(roleId, null);
	}
	
	/**
	 *  根据角色id,关联类型删除 
	 * @param roleId
	 * @param relType
	 */
	public void deleteByRoleId(Integer roleId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		getDao().deleteByRoleId(getMapperObj() + ".deleteByRoleId", param);
	}
	
	public List<SysRoleRel> queryByObjId(Integer objId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		return getDao().queryByObjId(getMapperObj() + ".queryByObjId", param);
	}
	
	/**
	 * 根据关联对象id,关联类型删除 
	 * @param objId
	 * @param relType
	 */
	public void deleteByObjId(Integer objId, Integer relType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		getDao().deleteByObjId(getMapperObj() + ".deleteByObjId", param);
	}

}
