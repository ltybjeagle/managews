/**
 * 项目名称：com.finemanagement
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.dao.pick.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.pick.SysPickDao;

/**
 *by zhangyong
 */
@Repository("SysPickDao")
public class SysPickDaoIml<T> extends BaseDaoImpl<T> implements SysPickDao<T> {

}
