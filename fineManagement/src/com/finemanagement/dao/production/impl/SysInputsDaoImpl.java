/**
 * 项目名称：com.finemanagement.dao.production.impl
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.dao.production.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.production.SysInputsDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysInputsDao")
public class SysInputsDaoImpl<T> extends BaseDaoImpl<T> implements SysInputsDao<T> {

}
