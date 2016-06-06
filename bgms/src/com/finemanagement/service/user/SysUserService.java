/**
 * 项目名称：com.finemanagement.service.user
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.finemanagement.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.user.SysUserDao;
import com.finemanagement.entity.user.SysRoleRel;
import com.finemanagement.entity.user.SysRoleRel.RelType;
import com.finemanagement.page.user.SysUserModel;

/**
 * 
 * @author liutianyang
 */
@Service("sysUserService")
public class SysUserService<T> extends BaseService<T> {

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	@Autowired
    private SysUserDao<T> sysUserDao;
		
	public SysUserDao<T> getDao() {
		return sysUserDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.user.SysUserDao";
	}
	
	/**
	 * 检查登录
	 * @param code
	 * @param pwd
	 * @return
	 */
	public T queryLogin(String code, String pwd) {
		SysUserModel model = new SysUserModel();
		model.setCode(code);
		model.setPwd(pwd);
		return getDao().queryLogin(getMapperObj() + ".queryLogin", model);
	}
	
	/**
	 * 检查是否存在
	 * @param code
	 * @return
	 */
	public T getUserCountByCode(String code) {
		return getDao().getUserCountByCode(getMapperObj() + ".getUserCountByCode", code);
	}
	
	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 */
	public List<SysRoleRel> getUserRole(Integer userId) {
		return sysRoleRelService.queryByObjId(userId, RelType.USER.key);
	}
	
	/**
	 * 添加用户权限
	 * @param userId
	 * @param roleIds
	 * @throws Exception
	 */
	public void addUserRole(Integer userId, Integer[] roleIds) throws Exception {
		if (userId == null || roleIds == null || roleIds.length < 1) { 
			return;
		}
		// 清除关联关系
		sysRoleRelService.deleteByObjId(userId, RelType.USER.key);
		for (Integer roleId : roleIds) { 
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(userId);
			rel.setRelType(RelType.USER.key);
			sysRoleRelService.add(rel);
		}
	}
}
