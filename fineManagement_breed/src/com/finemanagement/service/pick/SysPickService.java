/**
 * 项目名称：com.finemanagement
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.service.pick;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.base.util.DateUtil;
import com.finemanagement.dao.pick.SysPickDao;
import com.finemanagement.entity.pick.SysPick;


/**
 *by zhangyong
 */
@Service("sysPickService")
public class SysPickService<T> extends BaseService<T> {
	
	@Autowired
	private SysPickDao<T> sysPickDao;
	
	public SysPickDao<T> getDao() {
		return sysPickDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.pick.SysPickDao";
	}
	
	public void addPickPlants(T t) throws Exception {
		SysPick entity = (SysPick) t;
		entity.setSysNo(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationNO(entity.getSysNo());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_picking");
			entity.setCreateTime(DateUtil.getNowFormateDate());
			super.addFile(t);
		}
		super.add(t);
	}
}
