/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-4-16
 * 修改历史：
 *    1、[2016-4-16]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.production.SysCattleSlaughterDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysCattleSlaughterService")
public class SysCattleSlaughterService<T> extends BaseService<T> {

	@Autowired
	private SysCattleSlaughterDao<T> sysCattleSlaughterDao;
	
	public SysCattleSlaughterDao<T> getDao() {
		return sysCattleSlaughterDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysCattleSlaughterDao";
	}
}
