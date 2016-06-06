/**
 * 项目名称：com.finemanagement.service.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.service.slaughter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.slaughter.SysPreSlaughterQuarantineDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysPreSlaughterQuarantineService")
public class SysPreSlaughterQuarantineService<T> extends BaseService<T> {

	@Autowired
	private SysPreSlaughterQuarantineDao<T> sysPreSlaughterQuarantineDao;
	
	public SysPreSlaughterQuarantineDao<T> getDao() {
		return sysPreSlaughterQuarantineDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.slaughter.SysPreSlaughterQuarantineDao";
	}
}
