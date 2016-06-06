/**
 * 项目名称：com.finemanagement
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.service.pick;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.Attachment;
import com.base.service.BaseService;
import com.finemanagement.dao.pick.SysPickDao;
import com.finemanagement.entity.pick.SysPick;
import com.finemanagement.page.pick.SysPickModel;
import com.finemanagement.service.common.SysAttachmentService;


/**
 *by zhangyong
 */
@Service("sysPickService")
public class SysPickService<T> extends BaseService<T> {
	
	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
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
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationNO(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_picking");
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T querPickPlants(Object id) throws Exception {
		T t = super.queryById(id);
		SysPick entity = (SysPick) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysPickModel model = new SysPickModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysPick> newlist = new ArrayList<SysPick>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysPick newPick = new SysPick();
				newPick.setUrl(newEntity.getUrl());
				newPick.setFileName(newEntity.getFileName());
				newlist.add(newPick);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysPick>());
		}
		return t;
	}
	
	public void deletePickPlants(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysPick entity = (SysPick) super.queryById(id);
			SysPickModel model = new SysPickModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				File samFile = new File(realPath + "/" + newEntity.getFileName());
				if (samFile.isFile() && samFile.exists()) {
					samFile.delete();
				}
				sysAttachmentService.deleteFile(newEntity.getID());
			}
		}
		super.delete(ids);
	}
}
