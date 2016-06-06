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
import com.finemanagement.dao.user.SysUserDao;
import com.finemanagement.page.user.SysUserModel;

/**
 * 
 * @author liutianyang
 */
@Repository("sysUserDao")
public class SysUserDaoImpl<T> extends BaseDaoImpl<T> implements SysUserDao<T> {

	@Override
	public T queryLogin(String str, SysUserModel model) {
		return sqlSessionTemplate.selectOne(str, model);
	}

	@Override
	public T getUserCountByCode(String str, String code) {
		return sqlSessionTemplate.selectOne(str, code);
	}

	@Override
	public List<T> queryUserListByRole(String str, String rolecode) {
		return sqlSessionTemplate.selectList(str, rolecode);
	}
}
