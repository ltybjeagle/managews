/**
 * 项目名称：com.finemanagement.service.sales
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
 */
package com.finemanagement.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.sales.SysVehiclesDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysVehiclesService")
public class SysVehiclesService<T> extends BaseService<T> {

	@Autowired
	private SysVehiclesDao<T> sysVehiclesDao;
	
	public SysVehiclesDao<T> getDao() {
		return sysVehiclesDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.sales.SysVehiclesDao";
	}
}
