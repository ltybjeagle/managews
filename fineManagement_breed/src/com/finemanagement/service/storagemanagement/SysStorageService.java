package com.finemanagement.service.storagemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.storagemanagement.SysStorageDao;



@Service("sysStorageService")
public class SysStorageService<T> extends BaseService<T> {
	
	@Autowired
	private SysStorageDao<T> sysStorageDao;
	
	public SysStorageDao<T> getDao() {
		return sysStorageDao;
	}
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.storagemanagement.SysStorageDao";
	}
}
