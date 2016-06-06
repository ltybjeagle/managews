package com.finemanagement.dao.iotapp;

import java.util.List;

import com.base.dao.BaseDao;
import com.base.page.BasePage;
import com.finemanagement.entity.iotapp.SysMonitorInfo;

public interface SysMonitorDao<T> extends BaseDao<T> {

	public List<SysMonitorInfo> queryByMonitorNumList(String str, BasePage page);

	public List<T> queryByMonitorList(String str, BasePage page);

}
