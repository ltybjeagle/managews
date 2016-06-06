/**
 * 项目名称：com.finemanagement.service.common
 * 创建日期：2016-3-24
 * 修改历史：
 *    1、[2016-3-24]创建文件    by liutianyang
 */
package com.finemanagement.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finemanagement.dao.common.SysIdentifierDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysIdentifierService")
public class SysIdentifierService<T> {

	@Autowired
	private SysIdentifierDao<T> sysIdentifierDao;
	
	public SysIdentifierDao<T> getDao() {
		return sysIdentifierDao;
	}
	
	public String getMapperObj() {
		return "com.finemanagement.dao.common.SysIdentifierDao";
	}
	
	/**
	 * 获取所有系统标识
	 * @return
	 */
	public List<T> querySysIdentifierList() {
		return getDao().querySysIdentifierList(getMapperObj() + ".querySysIdentifierList");
	}
}
