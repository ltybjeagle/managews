package com.finemanagement.service.puarantine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.Attachment;
import com.base.service.BaseService;
import com.finemanagement.dao.quarantine.QuarantineDao;
import com.finemanagement.entity.quarantine.SysQuarantine;
import com.finemanagement.page.puarantine.SysQuarantineModel;
import com.finemanagement.service.common.SysAttachmentService;

@Service("quarantineService")
public class QuarantineService<T> extends BaseService<T> {
	
	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
	@Autowired
	private QuarantineDao<T> quarantineDao;
	  
	public QuarantineDao<T> getDao() {
		return quarantineDao;
	}

	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.quarantine.QuarantineDao";
	}
	  
	public void addQuarantine(T t) throws Exception {
		SysQuarantine entity = (SysQuarantine) t;
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationID(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_quarantine");
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T queryQuarantine(Object id) throws Exception {
		T t = super.queryById(id);
		SysQuarantine entity = (SysQuarantine) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysQuarantineModel model = new SysQuarantineModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysQuarantine> newlist = new ArrayList<SysQuarantine>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysQuarantine newQua = new SysQuarantine();
				newQua.setUrl(newEntity.getUrl());
				newQua.setFileName(newEntity.getFileName());
				newlist.add(newQua);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysQuarantine>());
		}
		return t;
	}
	
	public void deletePreSlaughterQuarantine(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysQuarantine entity = (SysQuarantine) super.queryById(id);
			SysQuarantineModel model = new SysQuarantineModel();
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
