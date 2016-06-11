/**
 * 项目名称：com.finemanagement.service.sales
 * 创建日期：2016-5-5
 * 修改历史：
 *    1、[2016-5-5]创建文件    by liutianyang
 */
package com.finemanagement.service.sales;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.Attachment;
import com.base.service.BaseService;
import com.finemanagement.dao.sales.SysSignDao;
import com.finemanagement.entity.sales.SysSign;
import com.finemanagement.page.sales.SysSignModel;
import com.finemanagement.service.common.SysAttachmentService;

/**
 * 
 * @author liutianyang
 */
@Service("sysSignService")
public class SysSignService<T> extends BaseService<T> {

	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
	@Autowired
	private SysSignDao<T> sysSignDao;
	
	public SysSignDao<T> getDao() {
		return sysSignDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.sales.SysSignDao";
	}
	
	public void addSign(T t) throws Exception {
		SysSign entity = (SysSign) t;
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationID(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_sign");
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T querSign(T t) throws Exception {
		SysSign entity = (SysSign) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysSignModel model = new SysSignModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysSign> newlist = new ArrayList<SysSign>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysSign newSign = new SysSign();
				newSign.setUrl(newEntity.getUrl());
				newSign.setFileName(newEntity.getFileName());
				newlist.add(newSign);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysSign>());
		}
		return t;
	}
	
	public void deleteSign(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysSign entity = (SysSign) super.queryById(id);
			SysSignModel model = new SysSignModel();
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
