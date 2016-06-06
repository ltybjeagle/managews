/**
 * 项目名称：com.finemanagement.service.production
 * 创建日期：2016-4-16
 * 修改历史：
 *    1、[2016-4-16]创建文件    by liutianyang
 */
package com.finemanagement.service.production;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.entity.Attachment;
import com.base.service.BaseService;
import com.base.util.DateUtil;
import com.finemanagement.dao.production.SysCattleSlaughterDao;
import com.finemanagement.entity.production.SysCattleSlaughter;
import com.finemanagement.page.production.SysCattleSlaughterModel;
import com.finemanagement.service.common.SysAttachmentService;

/**
 * 
 * @author liutianyang
 */
@Service("sysCattleSlaughterService")
public class SysCattleSlaughterService<T> extends BaseService<T> {

	@Autowired
	private SysAttachmentService<T> sysAttachmentService;
	
	@Autowired
	private SysCattleSlaughterDao<T> sysCattleSlaughterDao;
	
	public SysCattleSlaughterDao<T> getDao() {
		return sysCattleSlaughterDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.production.SysCattleSlaughterDao";
	}
	
	public void addCattleSlaughter(T t) throws Exception {
		SysCattleSlaughter entity = (SysCattleSlaughter) t;
		entity.setUuid(UUID.randomUUID().toString());
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationID(entity.getUuid());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_cattleSlaughter");
			entity.setCreateTime(DateUtil.getNowFormateDate());
			sysAttachmentService.addFile(t);
		}
		super.add(t);
	}
	
	public T querCattleSlaughterById(Object id) throws Exception {
		T t = super.queryById(id);
		SysCattleSlaughter entity = (SysCattleSlaughter) t;
		if (entity.getUuid() != null && !"".equals(entity.getUuid())) {
			SysCattleSlaughterModel model = new SysCattleSlaughterModel();
			model.setRelationID(entity.getUuid());
			List<T> list = sysAttachmentService.queryDataByList(model);
			List<SysCattleSlaughter> newlist = new ArrayList<SysCattleSlaughter>();
			for (T nt : list) {
				Attachment newEntity = (Attachment) nt;
				SysCattleSlaughter newCat = new SysCattleSlaughter();
				newCat.setUrl(newEntity.getUrl());
				newCat.setFileName(newEntity.getFileName());
				newlist.add(newCat);
			}
			entity.setList(newlist);
		} else {
			entity.setList(new ArrayList<SysCattleSlaughter>());
		}
		return t;
	}
	
	public void deleteCattleSlaughter(String realPath, Integer... ids) throws Exception {
		for (Integer id : ids) {
			SysCattleSlaughter entity = (SysCattleSlaughter) super.queryById(id);
			SysCattleSlaughterModel model = new SysCattleSlaughterModel();
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
