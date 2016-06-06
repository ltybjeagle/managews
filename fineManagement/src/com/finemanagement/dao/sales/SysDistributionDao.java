/**
 * 项目名称：com.finemanagement.dao.sales
 * 创建日期：2016-5-6
 * 修改历史：
 *    1、[2016-5-6]创建文件    by liutianyang
 */
package com.finemanagement.dao.sales;

import com.base.dao.BaseDao;

/**
 * 
 * @author liutianyang
 */
public interface SysDistributionDao<T> extends BaseDao<T> {

	public void deleteDistributionList(String str, String distributionNo);
}
