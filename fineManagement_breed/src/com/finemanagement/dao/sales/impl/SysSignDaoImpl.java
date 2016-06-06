/**
 * 项目名称：com.finemanagement.dao.sales.impl
 * 创建日期：2016-5-5
 * 修改历史：
 *    1、[2016-5-5]创建文件    by liutianyang
 */
package com.finemanagement.dao.sales.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.sales.SysSignDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysSignDao")
public class SysSignDaoImpl<T> extends BaseDaoImpl<T> implements SysSignDao<T> {

}
