package com.finemanagement.dao.storagemanagement.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.storagemanagement.SysStoremanageDao;

@Repository("sysStoremanageDao")
public class SysStoremanageDaoImp<T> extends BaseDaoImpl<T> implements
		SysStoremanageDao<T> {

}
