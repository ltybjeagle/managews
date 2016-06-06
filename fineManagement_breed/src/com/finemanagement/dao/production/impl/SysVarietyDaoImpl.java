/**
 * 项目名称：com.finemanagement.dao.production.impl
 * 创建日期：2016-6-5
 * 修改历史：
 *    1、[2016-6-5]创建文件    by liutianyang
 */
package com.finemanagement.dao.production.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.production.SysVarietyDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysVarietyDao")
public class SysVarietyDaoImpl<T> extends BaseDaoImpl<T> implements SysVarietyDao<T> {

}
