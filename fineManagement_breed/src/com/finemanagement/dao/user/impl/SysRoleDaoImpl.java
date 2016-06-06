/**
 * 项目名称：com.finemanagement.dao.user.impl
 * 创建日期：2016-3-22
 * 修改历史：
 *    1、[2016-3-22]创建文件    by liutianyang
 */
package com.finemanagement.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.user.SysRoleDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysRoleDao")
public class SysRoleDaoImpl<T> extends BaseDaoImpl<T> implements SysRoleDao<T> {

	@Override
	public List<T> queryAllList(String str) {
		return sqlSessionTemplate.selectList(str);
	}
	
	@Override
	public List<T> queryRoleByList(String str, T t) {
		return sqlSessionTemplate.selectList(str, t);
	}

	@Override
	public List<T> queryByUserid(String str, Integer userid) {
		return sqlSessionTemplate.selectList(str, userid);
	}

}
