package com.finemanagement.dao.facade;

import java.util.List;
import java.util.Map;

import com.base.dao.BaseDao;
import com.base.page.BasePage;

public interface SysfacadeDao<T> extends BaseDao<T> {

	public List<Map<String, Object>> queryByFacadeList(String str, BasePage page);

	public List<Map<String, Object>> queryByFacadeList(String str, Object page);
}
