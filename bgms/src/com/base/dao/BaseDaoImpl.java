/**
 * 项目名称：com.base.dao
 * 创建日期：2016-3-21
 * 修改历史：
 *    1、[2016-3-21]创建文件    by liutianyang
 */
package com.base.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void add(String str, T t) {
		sqlSessionTemplate.insert(str, t);
	}

	@Override
	public void update(String str, T t) {
		sqlSessionTemplate.update(str, t);
	}

	@Override
	public void updateBySelective(String str, T t) {
		sqlSessionTemplate.update(str, t);
	}

	@Override
	public void delete(String str, Integer id) {
		sqlSessionTemplate.delete(str, id);
	}

	@Override
	public List<T> queryByList(String str, BasePage page) {
		return sqlSessionTemplate.selectList(str, page);
	}

	@Override
	public T queryById(String str, Object id) {
		return sqlSessionTemplate.selectOne(str, id);
	}
	
	@Override
	public T queryByCode(String str, Object code) {
		return sqlSessionTemplate.selectOne(str, code);
	}
	
	@Override
	public T queryByToken(String str, Object token) {
		return sqlSessionTemplate.selectOne(str, token);
	}
	
	@Override
	public List<T> queryDataByList(String str, BasePage page) {
		return sqlSessionTemplate.selectList(str, page);
	}
}
