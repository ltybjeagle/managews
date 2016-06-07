package com.finemanagement.service.samping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.Attachment;
import com.base.service.BaseService;
import com.finemanagement.dao.samping.SysSampingDao;
import com.finemanagement.entity.samping.SysSampingEntity;
import com.finemanagement.page.samping.SysSampingModel;
import com.finemanagement.service.common.SysAttachmentService;

@Service("sysSampingService")
public class SysSampingService<T> extends BaseService<T> {
	
	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
	@Autowired
	private SysSampingDao<T>sysSampingDao;
	
	public SysSampingDao<T>getDao(){
		return sysSampingDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.samping.SysSampingDao";
	}
	
	public void addSamping(T t) throws Exception {
		SysSampingEntity entity = (SysSampingEntity) t;
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationID(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_testmanage");
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T querSamping(Object id) throws Exception {
		T t = super.queryById(id);
		SysSampingEntity entity = (SysSampingEntity) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysSampingModel model = new SysSampingModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysSampingEntity> newlist = new ArrayList<SysSampingEntity>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysSampingEntity newSam = new SysSampingEntity();
				newSam.setUrl(newEntity.getUrl());
				newSam.setFileName(newEntity.getFileName());
				newlist.add(newSam);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysSampingEntity>());
		}
		return t;
	}
	
	public void deleteSamping(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysSampingEntity entity = (SysSampingEntity) super.queryById(id);
			SysSampingModel model = new SysSampingModel();
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
