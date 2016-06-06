/**
 * 项目名称：com.finemanagement.dao.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.dao.production;

import java.util.List;

import com.base.dao.BaseDao;
import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public interface SysTaskDao<T> extends BaseDao<T> {

	public List<T> queryTaskTypeList(String str, BasePage page);
}
