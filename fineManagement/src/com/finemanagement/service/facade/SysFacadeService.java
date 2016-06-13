/**
 * 项目名称：com.finemanagement.service.common
 * 创建日期：2016-3-24
 * 修改历史：
 *    1、[2016-3-24]创建文件    by liutianyang
 */
package com.finemanagement.service.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.page.BasePage;
import com.finemanagement.dao.facade.SysfacadeDao;

/**
 * 
 * @author liutianyang
 */
@Service("SysFacadeService")
public class SysFacadeService<T> {

	@Autowired
	private SysfacadeDao<?> sysfacadeDao;

	public SysfacadeDao<?> getDao() {
		return sysfacadeDao;
	}

	public String getMapperObj() {
		return "com.finemanagement.dao.facade.SysfacadeDao";
	}

	public List<Map<String, Object>> queryGreenhouseList(BasePage page) throws Exception {

		return getDao().queryByFacadeList(getMapperObj() + ".queryGreenhouseList", page);
	}

	public List<Map<String, Object>> querSensorTypeList(Object obj) throws Exception {

		return getDao().queryByFacadeList(getMapperObj() + ".querSensorTypeList", obj);
	}

	public List<Map<String, Object>> querMonitorTypeList(Object obj) throws Exception {

		return getDao().queryByFacadeList(getMapperObj() + ".querMonitorTypeList", obj);
	}

	public List<Map<String, Object>> queryVideoList(Object obj) {
		return getDao().queryByFacadeList(getMapperObj() + ".queryVideoList", obj);
	}

}
