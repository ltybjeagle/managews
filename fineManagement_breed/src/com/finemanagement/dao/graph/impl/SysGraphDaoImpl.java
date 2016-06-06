package com.finemanagement.dao.graph.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.graph.SysGraphDao;


@Repository("SysGraphDao")
public class SysGraphDaoImpl<T> extends BaseDaoImpl<T> implements SysGraphDao<T>{

}
