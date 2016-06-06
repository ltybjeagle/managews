/**
 * 项目名称：com.finemanagement.dao.sales.impl
 * 创建日期：2016-5-6
 * 修改历史：
 *    1、[2016-5-6]创建文件    by liutianyang
 */
package com.finemanagement.dao.sales.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.sales.SysDistributionDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysDistributionDao")
public class SysDistributionDaoImpl<T> extends BaseDaoImpl<T> implements SysDistributionDao<T> {

	@Override
	public void deleteDistributionList(String str, String distributionNo) {
		sqlSessionTemplate.delete(str, distributionNo);
	}

}
