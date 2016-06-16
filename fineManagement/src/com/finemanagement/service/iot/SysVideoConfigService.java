package com.finemanagement.service.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.BaseDao;
import com.base.service.BaseService;
import com.finemanagement.dao.iot.SysVideoConfigDao;

@Service("SysVideoConfigService")
public class SysVideoConfigService<T> extends BaseService<T> {

	@Autowired
	private SysVideoConfigDao<T> sysVideoConfigDao;

	@Override
	public BaseDao<T> getDao() {
		return sysVideoConfigDao;
	}

	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.iot.SysVideoConfigDao";
	}

}
