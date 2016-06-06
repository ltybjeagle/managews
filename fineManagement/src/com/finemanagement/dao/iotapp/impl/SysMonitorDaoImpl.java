package com.finemanagement.dao.iotapp.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.base.page.BasePage;
import com.finemanagement.dao.iotapp.SysMonitorDao;
import com.finemanagement.entity.iotapp.SysMonitorInfo;

@Repository("SysMonitorDao")
public class SysMonitorDaoImpl<T> extends BaseDaoImpl<T> implements SysMonitorDao<T> {

	@Override
	public List<SysMonitorInfo> queryByMonitorNumList(String str, BasePage page) {
		return sqlSessionTemplate.selectList(str, page);

	}

	@Override
	public List<T> queryByMonitorList(String str, BasePage page) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, page);

	}

}
