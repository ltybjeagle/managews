/**
 * 项目名称：com.base.service
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.base.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
	
	protected T setUUID(T t) throws Exception {
		Field field = ClassReflectUtil.getFieldByFieldName(t, "id");
		if (field != null && !field.getGenericType().toString().equals("class java.lang.Integer")) {
			// 设置主键.字符类型采用UUID, 数字类型采用自增
			ClassReflectUtil.setValueByFieldName(t, "id", UUID.randomUUID().toString());
		}
		return t;
	}
	
	public void add(T t) throws Exception {
		getDao().add(getMapperObj() + ".add", t);
	}
	
	public void addFile(T t) throws Exception {
		getDao().add(getMapperObj() + ".addFile", t);
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
	
	public void deleteFileByID(Integer id) {
		getDao().deleteFileByID(getMapperObj() + ".deleteFileByID", id);
	}
	
	public List<T> queryByList(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByList", page);
	}
	
	public List<T> queryDataByList(BasePage page) throws Exception {
		return getDao().queryDataByList(getMapperObj() + ".queryDataByList", page);
	}

	public T queryById(Object id) throws Exception {
		return getDao().queryById(getMapperObj() + ".queryById", id);
	}
	
	public List<T> queryFileByNo(Object RelationNO) {
		return getDao().queryFileByNo(getMapperObj() + ".queryFileByNo", RelationNO);
	}
	
	public List<T> queryByIninventoryList(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByIninventoryList", page);
	}
	
	public List<T> queryByOutinventoryList(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByOutinventoryList", page);
	}
	
	public List<T> queryByInStore(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByInStore", page);
	}
	
	public T queryByToken(Object token) throws Exception {
		return getDao().queryByToken(getMapperObj() + ".queryByToken", token);
	}
	
	public T queryByCode(Object code) throws Exception {
		return getDao().queryByCode(getMapperObj() + ".queryByCode", code);
	}
	
	public T queryByProductNo(Object code) throws Exception {
		return getDao().queryByCode(getMapperObj() + ".queryByProductNo", code);
	}
	
	public List<T> queryByOutStore(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByOutStore", page);
	}
	
	public void outadd(T t) throws Exception {
		Field field = ClassReflectUtil.getFieldByFieldName(t, "id");
		if (field.getGenericType().equals("class java.lang.Integer")) {
			// 设置主键.字符类型采用UUID, 数字类型采用自增
			ClassReflectUtil.setValueByFieldName(t, "id", UUID.randomUUID().toString());
		}
		getDao().add(getMapperObj() + ".outadd", t);
	}
	
	public List<T> queryByUniteList(BasePage page) throws Exception {
		return getDao().queryByList(getMapperObj() + ".queryByUniteList", page);
	}

	public List<T> queryByYearList(BasePage page) {
		return getDao().queryByList(getMapperObj() + ".queryByYearList", page);
	}

	public List<T> queryByMonthList(BasePage page) {
		return getDao().queryByList(getMapperObj() + ".queryByMonthList", page);
	}

	public List<T> queryByDateList(BasePage page) {
		return getDao().queryByList(getMapperObj() + ".queryByDateList", page);
	}
	
	public List<T> queryByStatistics(Map<String, Object> map) throws Exception{
		return getDao().queryByStatistics(getMapperObj()+".queryByStatistics", map);
	}

	//入库来源数据：采购计划
	public T queryByplanId(Object id) throws Exception {
		return getDao().queryById(getMapperObj() + ".queryByplanId", id);
	}
	public void updateplan(T t) throws Exception {
		getDao().update(getMapperObj() + ".updateplan", t);
	}
	//出库来源数据投入品
	public T queryByinput(Object id) throws Exception {
		return getDao().queryById(getMapperObj() + ".queryByinput", id);
	}
	public void updateinput(T t) throws Exception {
		getDao().update(getMapperObj() + ".updateinput", t);
	}
}
