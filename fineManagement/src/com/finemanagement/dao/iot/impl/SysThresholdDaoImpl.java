/**
 * 项目名称：com.finemanagement.dao.iot.impl
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.dao.iot.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.iot.SysThresholdDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysThresholdDao")
public class SysThresholdDaoImpl<T> extends BaseDaoImpl<T> implements SysThresholdDao<T> {

}
