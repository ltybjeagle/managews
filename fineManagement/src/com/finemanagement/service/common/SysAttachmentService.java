/**
 * 项目名称：com.finemanagement.service.common
 * 创建日期：2016-6-4
 * 修改历史：
 *    1、[2016-6-4]创建文件    by liutianyang
 */
package com.finemanagement.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.common.SysAttachmentDao;

/**
 * 
 * @author liutianyang
 */
@Service("sysAttachmentService")
public class SysAttachmentService<T> extends BaseService<T> {

	@Autowired
    private SysAttachmentDao<T> sysAttachmentDao;
	
	
	public SysAttachmentDao<T> getDao() {
		return sysAttachmentDao ;
	}

	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.common.SysAttachmentDao";
	}
	
	public void deleteFile(String id) {
		getDao().deleteFile(getMapperObj() + ".deleteFile", id);
	}
}
