/**
 * 项目名称：com.finemanagement.dao.purchase.impl
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.dao.purchase.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.purchase.SysPurchaseDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysPurchaseDao")
public class SysPurchaseDaoImpl<T> extends BaseDaoImpl<T> implements SysPurchaseDao<T> {

	public List<T> queryTaskList(String str, Object id) {
		return sqlSessionTemplate.selectList(str, id);
	}
	
	public void deleteSysPurchase(String str, String id) {
		sqlSessionTemplate.delete(str, id);
	}
}
