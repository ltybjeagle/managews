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
import com.finemanagement.dao.user.SysRoleRelDao;
import com.finemanagement.entity.user.SysRoleRel;

/**
 * 
 * @author liutianyang
 */
@Repository("sysRoleRelDao")
public class SysRoleRelDaoImpl<T> extends BaseDaoImpl<T> implements SysRoleRelDao<T> {

	@Override
	public void deleteByRoleId(String str, Map<String, Object> param) {
		sqlSessionTemplate.delete(str, param);
	}

	@Override
	public void deleteByObjId(String str, Map<String, Object> param) {
		sqlSessionTemplate.delete(str, param);
	}

	@Override
	public List<SysRoleRel> queryByRoleId(String str, Map<String, Object> param) {
		return sqlSessionTemplate.selectList(str, param);
	}

	@Override
	public List<SysRoleRel> queryByObjId(String str, Map<String, Object> param) {
		return sqlSessionTemplate.selectList(str, param);
	}

}
