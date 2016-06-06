package com.finemanagement.service.storagemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finemanagement.dao.storagemanagement.SysStoremanageDao;
import com.base.service.BaseService;


@Service("sysStoremanageService")
public class sysStoremanageService<T> extends BaseService<T> {
	
	@Autowired
	private SysStoremanageDao<T> sysStoremanageDao;
	
	public SysStoremanageDao<T> getDao() {
		return sysStoremanageDao;
	}
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.storagemanagement.SysStoremanageDao";
	}
}
