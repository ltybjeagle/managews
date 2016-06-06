/**
 * 项目名称：com.finemanagement.service.sales
 * 创建日期：2016-5-6
 * 修改历史：
 *    1、[2016-5-6]创建文件    by liutianyang
 */
package com.finemanagement.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.sales.SysDistributionDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysDistributionService")
public class SysDistributionService<T> extends BaseService<T> {

	@Autowired
	private SysDistributionDao<T> sysDistributionDao;
	
	public SysDistributionDao<T> getDao() {
		return sysDistributionDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.sales.SysDistributionDao";
	}
	
	public void deleteDistributionList(String distributionNo) throws Exception {
		getDao().deleteDistributionList(getMapperObj() + ".deleteDistributionList", distributionNo);
	}
}
