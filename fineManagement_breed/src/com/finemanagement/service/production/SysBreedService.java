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
import com.finemanagement.dao.production.SysBreedDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysBreedService")
public class SysBreedService<T> extends BaseService<T> {

	@Autowired
	private SysBreedDao<T> sysBreedDao;
	
	public SysBreedDao<T> getDao() {
		return sysBreedDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysBreedDao";
	}
}
