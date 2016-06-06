/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-4-11
 * 修改历史：
 *    1、[2016-4-11]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.production.SysTaskBreedDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysTaskBreedService")
public class SysTaskBreedService<T> extends BaseService<T> {

	@Autowired
	private SysTaskBreedDao<T> sysTaskBreedDao;
	
	public SysTaskBreedDao<T> getDao() {
		return sysTaskBreedDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysTaskBreedDao";
	}
}
