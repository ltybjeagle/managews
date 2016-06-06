/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.production.SysInputsDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysInputsService")
public class SysInputsService<T> extends BaseService<T> {

	@Autowired
	private SysInputsDao<T> sysInputsDao;
	
	public SysInputsDao<T> getDao() {
		return sysInputsDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysInputsDao";
	}
}
