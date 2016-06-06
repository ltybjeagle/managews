/**
 * 项目名称：com.finemanagement.service.iot
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.service.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.iot.SysSensorDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysSensorService")
public class SysSensorService<T> extends BaseService<T> {

	@Autowired
	private SysSensorDao<T> sysSensorDao;
	
	public SysSensorDao<T> getDao() {
		return sysSensorDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.iot.SysSensorDao";
	}
}
