package com.finemanagement.service.samping;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.samping.SysSampingDao;
import com.finemanagement.entity.samping.SysSampingEntity;

@Service("sysSampingService")
public class SysSampingService<T> extends BaseService<T> {
	
	@Autowired
	private SysSampingDao<T> sysSampingDao;
	
	public SysSampingDao<T> getDao(){
		return sysSampingDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.samping.SysSampingDao";
	}
	
	public void addSamping(T t) throws Exception {
		SysSampingEntity entity = (SysSampingEntity) t;
		if (entity.getFile() != null && entity.getFile().getBytes().length > 0) {
			String fileName = entity.getFile().getOriginalFilename();
			FileUtils.copyInputStreamToFile(entity.getFile().getInputStream(), new File(entity.getFilePath(), fileName));
			entity.setRelationNO(entity.getSampleno());
			entity.setFileName(fileName);
			entity.setUrl("/uploadfile/" + fileName);
			entity.setTableName("sys_cattleSlaughter");
			super.addFile(t);
		}
		super.add(t);
	}
}
