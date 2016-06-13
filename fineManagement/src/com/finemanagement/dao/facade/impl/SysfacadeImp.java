package com.finemanagement.dao.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.base.page.BasePage;
import com.finemanagement.dao.facade.SysfacadeDao;

@Repository("SysfacadeDao")
public class SysfacadeImp<T> extends BaseDaoImpl<T> implements SysfacadeDao<T> {

	public List<Map<String, Object>> queryByFacadeList(String str, BasePage page) {
		return sqlSessionTemplate.selectList(str, page);
	}

	@Override
	public List<Map<String, Object>> queryByFacadeList(String str, Object page) {
		return sqlSessionTemplate.selectList(str, page);
	}
}
