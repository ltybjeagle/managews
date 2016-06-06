/**
 * 项目名称：com.finemanagement.controller.SysStoreManager
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.page.BasePage;
import com.base.service.BaseService;
import com.finemanagement.dao.store.SysStoreDao;

/**
 *by zhangyong
 */
@Service("sysStoreService")
public class SysStoreService<T> extends BaseService<T> {
	
	@Autowired
	private SysStoreDao<T> sysStoreDao;
	
	public SysStoreDao<T> getDao() {
		return sysStoreDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.store.SysStoreDao";
	}
	
	
	public List<T> queryByInStore(BasePage page) throws Exception {
		return super.queryByInStore(page);
	}
	
	public List<T> queryByOutStore(BasePage page) throws Exception {
		return super.queryByOutStore(page);
	}
	
	public T queryByProductNo(Object code) throws Exception {
		return super.queryByProductNo(code);
	}
}
