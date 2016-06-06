/**
 * 项目名称：com.finemanagement.dao.purchase
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.dao.purchase;

import java.util.List;

import com.base.dao.BaseDao;

/**
 * 
 * @author liutianyang
 */
public interface SysPurchaseDao<T> extends BaseDao<T> {

	public List<T> queryTaskList(String str, Object id);
	
	public void deleteSysPurchase(String str, String id);
}
