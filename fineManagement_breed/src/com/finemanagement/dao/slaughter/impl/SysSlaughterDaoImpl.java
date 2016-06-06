/**
 * 项目名称：com.finemanagement.dao.slaughter.impl
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.dao.slaughter.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.slaughter.SysSlaughterDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysSlaughterDao")
public class SysSlaughterDaoImpl<T> extends BaseDaoImpl<T> implements SysSlaughterDao<T> {

	@Override
	public List<T> queryListByProcess(String str) {
		return sqlSessionTemplate.selectList(str);
	}

}
