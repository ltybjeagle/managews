/**
 * 项目名称：com.finemanagement.dao.common.impl
 * 创建日期：2016-3-24
 * 修改历史：
 *    1、[2016-3-24]创建文件    by liutianyang
 */
package com.finemanagement.dao.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.finemanagement.dao.common.SysIdentifierDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysIdentifierDao")
public class SysIdentifierDaoImpl<T> implements SysIdentifierDao<T> {

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<T> querySysIdentifierList(String str) {
		return sqlSessionTemplate.selectList(str);
	}

}
