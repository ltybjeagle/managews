package com.finemanagement.dao.quarantine.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.quarantine.QuarantineDao;

@Repository("QuarantineDao")
public class QuarantineDaoIml<T> extends BaseDaoImpl<T> implements QuarantineDao<T>{

}
