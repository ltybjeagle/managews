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
import com.finemanagement.dao.slaughter.SysSlaughterDao;
import com.finemanagement.entity.slaughter.SysSlaughter;
import com.finemanagement.page.slaughter.SysSlaughterModel;
import com.finemanagement.service.common.SysAttachmentService;

/**
 * 
 * @author liutianyang
 */
@Service("sysSlaughterService")
public class SysSlaughterService<T> extends BaseService<T> {

	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
	@Autowired
	private SysSlaughterDao<T> sysSlaughterDao;
	
	public SysSlaughterDao<T> getDao() {
		return sysSlaughterDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.slaughter.SysSlaughterDao";
	}
	
	public List<T> queryListByProcess() throws Exception {
		return getDao().queryListByProcess(getMapperObj() + ".queryListByProcess");
	}
	
	public void addSlaughter(T t) throws Exception {
		SysSlaughter entity = (SysSlaughter) t;
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationID(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_slaughter");
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T querySlaughter(Object id) throws Exception {
		T t = super.queryById(id);
		SysSlaughter entity = (SysSlaughter) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysSlaughterModel model = new SysSlaughterModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysSlaughter> newlist = new ArrayList<SysSlaughter>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysSlaughter newSla = new SysSlaughter();
				newSla.setUrl(newEntity.getUrl());
				newSla.setFileName(newEntity.getFileName());
				newlist.add(newSla);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysSlaughter>());
		}
		return t;
	}
	
	public void deleteSlaughter(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysSlaughter entity = (SysSlaughter) super.queryById(id);
			SysSlaughterModel model = new SysSlaughterModel();
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
