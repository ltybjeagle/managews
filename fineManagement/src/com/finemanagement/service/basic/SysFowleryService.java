/**
 * 项目名称：com.finemanagement.service.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.basic.SysFowleryDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysFowleryService")
public class SysFowleryService<T> extends BaseService<T> {

	@Autowired
	private SysFowleryDao<T> sysFowleryDao;
	
	public SysFowleryDao<T> getDao() {
		return sysFowleryDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.basic.SysFowleryDao";
	}
}
