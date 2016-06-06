/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.page.BasePage;
import com.base.service.BaseService;
import com.finemanagement.dao.production.SysTaskDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysTaskService")
public class SysTaskService<T> extends BaseService<T> {

	@Autowired
	private SysTaskDao<T> sysTaskDao;
	
	public SysTaskDao<T> getDao() {
		return sysTaskDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysTaskDao";
	}
	
	public List<T> queryTaskTypeList(BasePage page) {
		return getDao().queryTaskTypeList(getMapperObj() + ".queryTaskTypeList", page);
	}
	
}
