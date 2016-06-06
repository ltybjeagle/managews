/**
 * 项目名称：com.finemanagement.dao.common
 * 创建日期：2016-6-4
 * 修改历史：
 *    1、[2016-6-4]创建文件    by liutianyang
 */
package com.finemanagement.dao.common;

import com.base.dao.BaseDao;

/**
 * 
 * @author liutianyang
 */
public interface SysAttachmentDao<T> extends BaseDao<T> {

	public void deleteFile(String str, String id);
}
