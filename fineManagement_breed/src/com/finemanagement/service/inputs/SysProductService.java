/**
 * 项目名称：com.finemanagement.service.inputs
 * 创建日期：2016-3-29
 * 修改历史：
 *    1、[2016-3-29]创建文件    by liutianyang
 */
package com.finemanagement.service.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.inputs.SysProductDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysProductService")
public class SysProductService<T> extends BaseService<T> {

	@Autowired
	private SysProductDao<T> sysProductDao;
	
	public SysProductDao<T> getDao() {
		return sysProductDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.inputs.SysProductDao";
	}
}
