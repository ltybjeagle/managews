/**
 * 项目名称：com.finemanagement.service.basic
 * 创建日期：2016-3-28
 * 修改历史：
 *    1、[2016-3-28]创建文件    by liutianyang
 */
package com.finemanagement.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.basic.SysGreenhouseDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysGreenhouseService")
public class SysGreenhouseService<T> extends BaseService<T> {

	@Autowired
	private SysGreenhouseDao<T> sysGreenhouseDao;
	
	public SysGreenhouseDao<T> getDao() {
		return sysGreenhouseDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.basic.SysGreenhouseDao";
	}
}
