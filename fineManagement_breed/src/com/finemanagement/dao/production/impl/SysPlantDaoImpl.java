/**
 * 项目名称：com.finemanagement.dao.production.impl
 * 创建日期：2016-4-9
 * 修改历史：
 *    1、[2016-4-9]创建文件    by liutianyang
 */
package com.finemanagement.dao.production.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.production.SysPlantDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysPlantDao")
public class SysPlantDaoImpl<T> extends BaseDaoImpl<T> implements SysPlantDao<T> {

}
