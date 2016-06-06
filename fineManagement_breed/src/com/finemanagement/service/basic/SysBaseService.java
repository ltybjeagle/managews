/**
 * 项目名称：com.finemanagement.service.basic
 * 创建日期：2016-3-23
 * 修改历史：
 *    1、[2016-3-23]创建文件    by liutianyang
 */
package com.finemanagement.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.basic.SysBaseDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysBaseService")
public class SysBaseService<T> extends BaseService<T> {

	@Autowired
	private SysBaseDao<T> sysBaseDao;
	
	public SysBaseDao<T> getDao() {
		return sysBaseDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.basic.SysBaseDao";
	}
}
