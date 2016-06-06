package com.finemanagement.dao.storagemanagement.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.storagemanagement.SysStorageDao;

@Repository("sysStorageDao")
public class SysStorageDaoImp<T> extends BaseDaoImpl<T> implements SysStorageDao<T> {

}
