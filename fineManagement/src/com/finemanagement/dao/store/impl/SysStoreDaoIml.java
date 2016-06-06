/**
 * 项目名称：com.finemanagement.controller.SysStoreManager
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.dao.store.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.store.SysStoreDao;

/**
 *by zhangyong
 */
@Repository("sysStoreDao")
public class SysStoreDaoIml<T> extends BaseDaoImpl<T> implements SysStoreDao<T> {

}
