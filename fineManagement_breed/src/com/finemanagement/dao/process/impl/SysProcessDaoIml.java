package com.finemanagement.dao.process.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.process.SysProcessDao;

@Repository("SysProessDao")
public class SysProcessDaoIml<T> extends BaseDaoImpl<T> implements SysProcessDao<T> {

}
