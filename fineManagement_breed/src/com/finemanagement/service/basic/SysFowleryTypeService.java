/**
 * 项目名称：com.finemanagement.service.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.basic.SysFowleryTypeDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysFowleryTypeService")
public class SysFowleryTypeService<T>  extends BaseService<T> {

	@Autowired
	private SysFowleryTypeDao<T> sysFowleryTypeDao;
	
	public SysFowleryTypeDao<T> getDao() {
		return sysFowleryTypeDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.basic.SysFowleryTypeDao";
	}
}
