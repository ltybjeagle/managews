package com.finemanagement.dao.samping.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.samping.SysSampingDao;

@Repository("sysSampingDao")
public class SysSampingDaoIml<T> extends BaseDaoImpl<T> implements
		SysSampingDao<T> {

}
