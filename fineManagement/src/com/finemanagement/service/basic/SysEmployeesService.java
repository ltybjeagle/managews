/**
 * 项目名称：com.finemanagement.service.basic
 * 创建日期：2016-5-30
 * 修改历史：
 *    1、[2016-5-30]创建文件    by liutianyang
 */
package com.finemanagement.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.basic.SysEmployeesDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysEmployeesService")
public class SysEmployeesService<T> extends BaseService<T> {

	@Autowired
	private SysEmployeesDao<T> sysEmployeesDao;
	
	public SysEmployeesDao<T> getDao() {
		return sysEmployeesDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.basic.SysEmployeesDao";
	}
}
