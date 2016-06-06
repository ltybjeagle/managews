/**
 * 项目名称：com.finemanagement.service.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.service.slaughter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.slaughter.SysSlaughterDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysSlaughterService")
public class SysSlaughterService<T> extends BaseService<T> {

	@Autowired
	private SysSlaughterDao<T> sysSlaughterDao;
	
	public SysSlaughterDao<T> getDao() {
		return sysSlaughterDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.slaughter.SysSlaughterDao";
	}
	
	public List<T> queryListByProcess() throws Exception {
		return getDao().queryListByProcess(getMapperObj() + ".queryListByProcess");
	}
}
