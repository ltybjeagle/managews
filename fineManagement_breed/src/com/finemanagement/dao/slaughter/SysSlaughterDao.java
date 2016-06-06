/**
 * 项目名称：com.finemanagement.dao.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.dao.slaughter;

import java.util.List;

import com.base.dao.BaseDao;

/**
 * 
 * @author liutianyang
 */
public interface SysSlaughterDao<T> extends BaseDao<T> {

	public List<T> queryListByProcess(String str);
}
