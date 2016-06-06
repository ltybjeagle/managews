package com.finemanagement.service.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.graph.SysGraphDao;

@Service("SysGraphService")
public class SysGraphService<T> extends BaseService<T>{

	@Autowired
    private SysGraphDao<T> sysGraphDao;
	
	
	public SysGraphDao<T> getDao() {
		return sysGraphDao ;
	}

	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.graph.SysGraphDao";
	}

}
