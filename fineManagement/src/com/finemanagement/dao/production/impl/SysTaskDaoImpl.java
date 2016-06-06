/**
 * 项目名称：com.finemanagement.dao.production.impl
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.dao.production.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.base.page.BasePage;
import com.finemanagement.dao.production.SysTaskDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysTaskDao")
public class SysTaskDaoImpl<T> extends BaseDaoImpl<T> implements SysTaskDao<T> {

	@Override
	public List<T> queryTaskTypeList(String str, BasePage page) {
		return sqlSessionTemplate.selectList(str, page);
	}

}
