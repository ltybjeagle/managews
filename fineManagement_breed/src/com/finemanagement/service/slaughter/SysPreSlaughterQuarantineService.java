/**
 * 项目名称：com.finemanagement.service.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.service.slaughter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.Attachment;
import com.base.service.BaseService;
import com.finemanagement.dao.slaughter.SysPreSlaughterQuarantineDao;
import com.finemanagement.entity.slaughter.SysPreSlaughterQuarantine;
import com.finemanagement.page.slaughter.SysPreSlaughterQuarantineModel;
import com.finemanagement.service.common.SysAttachmentService;

/**
 * 
 * @author liutianyang
 */
@Service("sysPreSlaughterQuarantineService")
public class SysPreSlaughterQuarantineService<T> extends BaseService<T> {

	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
	@Autowired
	private SysPreSlaughterQuarantineDao<T> sysPreSlaughterQuarantineDao;
	
	public SysPreSlaughterQuarantineDao<T> getDao() {
		return sysPreSlaughterQuarantineDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.slaughter.SysPreSlaughterQuarantineDao";
	}
	
	public void addPreSlaughterQuarantine(T t) throws Exception {
		SysPreSlaughterQuarantine entity = (SysPreSlaughterQuarantine) t;
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationID(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_preSlaughterQuarantine");
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T queryPreSlaughterQuarantine(Object id) throws Exception {
		T t = super.queryById(id);
		SysPreSlaughterQuarantine entity = (SysPreSlaughterQuarantine) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysPreSlaughterQuarantineModel model = new SysPreSlaughterQuarantineModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysPreSlaughterQuarantine> newlist = new ArrayList<SysPreSlaughterQuarantine>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysPreSlaughterQuarantine newPre = new SysPreSlaughterQuarantine();
				newPre.setUrl(newEntity.getUrl());
				newPre.setFileName(newEntity.getFileName());
				newlist.add(newPre);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysPreSlaughterQuarantine>());
		}
		return t;
	}
	
	public void deletePreSlaughterQuarantine(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysPreSlaughterQuarantine entity = (SysPreSlaughterQuarantine) super.queryById(id);
			SysPreSlaughterQuarantineModel model = new SysPreSlaughterQuarantineModel();
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
