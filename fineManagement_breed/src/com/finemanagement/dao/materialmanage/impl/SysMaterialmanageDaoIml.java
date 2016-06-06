package com.finemanagement.dao.materialmanage.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;

import com.finemanagement.dao.materialmanage.SysMaterialmanageDao;

@Repository("sysMaterialmanageDao")
public class SysMaterialmanageDaoIml<T> extends BaseDaoImpl<T> implements
	SysMaterialmanageDao<T> {

}
