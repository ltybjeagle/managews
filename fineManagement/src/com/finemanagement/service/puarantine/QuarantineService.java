package com.finemanagement.service.puarantine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.quarantine.QuarantineDao;

@Service("quarantineService")
public class QuarantineService<T> extends BaseService<T>{
	
	 @Autowired
	  private QuarantineDao<T> quarantineDao;
	  
	  public QuarantineDao<T> getDao() {
	    return quarantineDao;
	  }

	  @Override
	  public String getMapperObj() {
	    // TODO Auto-generated method stub
	    return "com.finemanagement.dao.quarantine.QuarantineDao";
	  }
}
