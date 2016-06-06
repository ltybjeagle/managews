/**
 * 项目名称：com.finemanagement.service.inputs
 * 创建日期：2016-3-28
 * 修改历史：
 *    1、[2016-3-28]创建文件    by liutianyang
 */
package com.finemanagement.service.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.inputs.SysClassifyDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysClassifyService")
public class SysClassifyService<T> extends BaseService<T> {

	@Autowired
	private SysClassifyDao<T> sysClassifyDao;
	
	public SysClassifyDao<T> getDao() {
		return sysClassifyDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.inputs.SysClassifyDao";
	}
}
