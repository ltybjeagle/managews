package com.finemanagement.dao.iot.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.iot.SysVideoConfigDao;

@Repository("SysVideoConfigDao")
public class SysVideoConfigImplDao<T> extends BaseDaoImpl<T> implements SysVideoConfigDao<T> {

}
