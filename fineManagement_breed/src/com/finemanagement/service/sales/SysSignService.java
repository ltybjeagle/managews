/**
 * 项目名称：com.finemanagement.service.sales
 * 创建日期：2016-5-5
 * 修改历史：
 *    1、[2016-5-5]创建文件    by liutianyang
 */
package com.finemanagement.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.sales.SysSignDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysSignService")
public class SysSignService<T> extends BaseService<T> {

	@Autowired
	private SysSignDao<T> sysSignDao;
	
	public SysSignDao<T> getDao() {
		return sysSignDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.sales.SysSignDao";
	}
}
