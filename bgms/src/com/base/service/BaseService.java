/**
 * 项目名称：com.base.service
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.base.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import com.base.dao.BaseDao;
import com.base.page.BasePage;
import com.base.util.ClassReflectUtil;

/**
 * 
 * @author liutianyang
 */
public abstract class BaseService<T> {

	public abstract BaseDao<T> getDao();
	
	public abstract String getMapperObj();
	
	public void add(T t) throws Exception {
		Field field = ClassReflectUtil.getFieldByFieldName(t, "id");
		if (field != null && !field.getGenericType().toString().equals("class java.lang.Integer")) {
			// 设置主键.字符类型采用UUID, 数字类型采用自增
			ClassReflectUtil.setValueByFieldName(t, "id", UUID.randomUUID().toString());
		}
		getDao().add(getMapperObj() + ".add", t);
	}
	
	public void update(T t) throws Exception {
		getDao().update(getMapperObj() + ".update", t);
	}
	
	public void updateBySelective(T t) {
		getDao().updateBySelective(getMapperObj() + ".updateBySelective", t);
	}
	
	public void delete(Integer... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Integer id : ids) {
			getDao().delete(getMapperObj() + ".delete", id);
		}
	}
	
	public List<T> queryByList(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByList", page);
	}

	public T queryById(Object id) throws Exception {
		return getDao().queryById(getMapperObj() + ".queryById", id);
	}
	
	public T queryByCode(Object code) throws Exception {
		return getDao().queryByCode(getMapperObj() + ".queryByCode", code);
	}
	
	public T queryByToken(Object token) throws Exception {
		return getDao().queryByToken(getMapperObj() + ".queryByToken", token);
	}
	
	public List<T> queryDataByList(BasePage page) throws Exception {
		return getDao().queryDataByList(getMapperObj() + ".queryDataByList", page);
	}
}
