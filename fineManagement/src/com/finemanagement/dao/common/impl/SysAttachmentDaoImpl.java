/**
 * 项目名称：com.finemanagement.dao.common.impl
 * 创建日期：2016-6-4
 * 修改历史：
 *    1、[2016-6-4]创建文件    by liutianyang
 */
package com.finemanagement.dao.common.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.common.SysAttachmentDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysAttachmentDao")
public class SysAttachmentDaoImpl<T> extends BaseDaoImpl<T> implements SysAttachmentDao<T> {

	@Override
	public void deleteFile(String str, String id) {
		sqlSessionTemplate.delete(str, id);
	}
}
