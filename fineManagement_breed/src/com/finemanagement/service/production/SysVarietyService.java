/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-6-5
 * 修改历史：
 *    1、[2016-6-5]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.production.SysVarietyDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysVarietyService")
public class SysVarietyService<T> extends BaseService<T> {

	@Autowired
	private SysVarietyDao<T> sysVarietyDao;
	
	public SysVarietyDao<T> getDao() {
		return sysVarietyDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysVarietyDao";
	}
}
