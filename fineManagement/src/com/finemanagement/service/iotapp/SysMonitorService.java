package com.finemanagement.service.iotapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.BaseDao;
import com.base.page.BasePage;
import com.base.service.BaseService;
import com.finemanagement.dao.iotapp.SysMonitorDao;
import com.finemanagement.entity.iotapp.SysMonitorInfo;

@Service("SysMonitorService")
public class SysMonitorService<T> extends BaseService<T> {

	@Autowired
	private SysMonitorDao<T> sysMonitorDao;

	@Override
	public BaseDao<T> getDao() {
		return sysMonitorDao;
	}

	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.iotapp.SysMonitorDao";
	}

	public List<SysMonitorInfo> queryByMonitorNumList(BasePage page) {
		return sysMonitorDao.queryByMonitorNumList(getMapperObj() + ".queryByMonitorNumList", page);
	}

	public List<T> queryByYearList(BasePage page) {
		return sysMonitorDao.queryByMonitorList(getMapperObj() + ".queryByYearList", page);
	}

	public List<T> queryByMonthList(BasePage page) {
		return sysMonitorDao.queryByMonitorList(getMapperObj() + ".queryByMonthList", page);
	}

	public List<T> queryByDateList(BasePage page) {
		return sysMonitorDao.queryByMonitorList(getMapperObj() + ".queryByDateList", page);
	}

	public List<T> querByAppList(BasePage page) {
		return sysMonitorDao.queryByList(getMapperObj() + ".querByAppList", page);
	}
}
