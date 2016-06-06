/**
 * 项目名称：com.finemanagement.dao.slaughter.impl
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
 */
package com.finemanagement.dao.slaughter.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.slaughter.SysWeighingDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysWeighingDao")
public class SysWeighingDaoImpl<T> extends BaseDaoImpl<T> implements SysWeighingDao<T> {

}
