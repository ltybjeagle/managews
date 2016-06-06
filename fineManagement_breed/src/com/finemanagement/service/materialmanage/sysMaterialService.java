package com.finemanagement.service.materialmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.materialmanage.SysMaterialmanageDao;

@Service("sysMaterialService")
public class sysMaterialService<T> extends BaseService<T> {
	
	@Autowired
	private SysMaterialmanageDao<T> sysMaterialmanageDao;
	
	public SysMaterialmanageDao<T>getDao(){
		return sysMaterialmanageDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.materialmanage.SysMaterialmanageDao";
	}
}
