/**
 * 项目名称：com.finemanagement.dao.production.impl
 * 创建日期：2016-4-11
 * 修改历史：
 *    1、[2016-4-11]创建文件    by liutianyang
 */
package com.finemanagement.dao.production.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.production.SysBreedDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysBreedDao")
public class SysBreedDaoImpl<T> extends BaseDaoImpl<T> implements SysBreedDao<T> {

}
