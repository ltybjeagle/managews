package com.finemanagement.service.materialmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.materialmanage.sysStocktakingDao;
@Service("sysStocktakingService")
public class sysStocktakingService<T> extends BaseService<T> {
	
	@Autowired
	private sysStocktakingDao<T> sysStocktakingDao;
	public sysStocktakingDao<T>getDao(){
		return sysStocktakingDao;
	}
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.materialmanage.sysStocktakingDao";
	}
}
