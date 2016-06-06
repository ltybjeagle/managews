/**
 * 项目名称：com.finemanagement.dao.purchase.impl
 * 创建日期：2016-4-6
 * 修改历史：
 *    1、[2016-4-6]创建文件    by liutianyang
 */
package com.finemanagement.dao.purchase.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.purchase.SysAuditPurchaseDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysAuditPurchaseDao")
public class SysAuditPurchaseDaoImpl<T> extends BaseDaoImpl<T> implements SysAuditPurchaseDao<T> {

	public List<T> queryTaskList(String str, Object id) {
		return sqlSessionTemplate.selectList(str, id);
	}

}
