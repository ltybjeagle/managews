/**
 * 项目名称：com.finemanagement.service.common
 * 创建日期：2016-6-12
 * 修改历史：
 *    1、[2016-6-12]创建文件    by liutianyang
 */
package com.finemanagement.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.common.SysNumberRulesDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysNumberRulesService")
public class SysNumberRulesService<T> extends BaseService<T> {

	@Autowired
    private SysNumberRulesDao<T> sysNumberRulesDao;
	
	
	public SysNumberRulesDao<T> getDao() {
		return sysNumberRulesDao ;
	}

	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.common.SysNumberRulesDao";
	}
}
