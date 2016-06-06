/**
 * 项目名称：com.finemanagement.service.slaughter
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
 */
package com.finemanagement.service.slaughter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.slaughter.SysWeighingDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysWeighingService")
public class SysWeighingService<T> extends BaseService<T> {

	@Autowired
	private SysWeighingDao<T> sysWeighingDao;
	
	public SysWeighingDao<T> getDao() {
		return sysWeighingDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.slaughter.SysWeighingDao";
	}
}
