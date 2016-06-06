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
import com.finemanagement.dao.sales.SysDriverDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysDriverService")
public class SysDriverService<T> extends BaseService<T> {

	@Autowired
	private SysDriverDao<T> sysDriverDao;
	
	public SysDriverDao<T> getDao() {
		return sysDriverDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.sales.SysDriverDao";
	}
}
