package com.finemanagement.service.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.process.SysProcessDao;

@Service("proessService")
public class ProessService <T> extends BaseService<T> {

  @Autowired
  private SysProcessDao<T> proessDao;
  
  public SysProcessDao<T> getDao() {
    return proessDao;
  }

  @Override
  public String getMapperObj() {
    // TODO Auto-generated method stub
    return "com.finemanagement.dao.process.SysProcessDao";
  }

}
