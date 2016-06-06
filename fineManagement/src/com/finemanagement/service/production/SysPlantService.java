/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-4-9
 * 修改历史：
 *    1、[2016-4-9]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.production.SysPlantDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysPlantService")
public class SysPlantService<T> extends BaseService<T> {

	@Autowired
	private SysPlantDao<T> sysPlantDao;
	
	public SysPlantDao<T> getDao() {
		return sysPlantDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysPlantDao";
	}
}
