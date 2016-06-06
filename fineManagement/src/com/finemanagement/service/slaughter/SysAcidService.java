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
import com.finemanagement.dao.slaughter.SysAcidDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysAcidService")
public class SysAcidService<T> extends BaseService<T> {

	@Autowired
	private SysAcidDao<T> sysAcidDao;
	
	public SysAcidDao<T> getDao() {
		return sysAcidDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.slaughter.SysAcidDao";
	}
}
