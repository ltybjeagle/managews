/**
 * 项目名称：com.finemanagement.dao.inputs.impl
 * 创建日期：2016-3-29
 * 修改历史：
 *    1、[2016-3-29]创建文件    by liutianyang
 */
package com.finemanagement.dao.inputs.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.inputs.SysProductDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysProductDao")
public class SysProductDaoImpl<T> extends BaseDaoImpl<T> implements SysProductDao<T> {

}
