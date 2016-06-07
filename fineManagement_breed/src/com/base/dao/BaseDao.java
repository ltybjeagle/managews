/**
 * 项目名称：com.base.dao
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.base.dao;

import java.util.List;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public interface BaseDao<T> {

	public void add(String str, T t);
	
	public void addFile(String str, T t);
	
	public void update(String str, T t);
	
	public void updateBySelective(String str, T t); 	
	
	public void delete(String str, Integer id);
	
	public void deleteFileByID(String str, Integer id);

	public List<T> queryByList(String str, BasePage page);
	
	public List<T> sumqueryByList(String str, BasePage page);
	
	public List<T> queryDataByList(String str, BasePage page);
	
	public T queryById(String str, Object id);
	
	public List<T> queryFileByNo(String str, Object RelationNO);
	
	public T queryByCode(String str, Object code);
	
	public List<T> queryByStatistics(String str,Object obj);
	
	public T queryByToken(String str, Object token);
}
