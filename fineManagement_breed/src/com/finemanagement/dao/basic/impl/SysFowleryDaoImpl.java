/**
 * 项目名称：com.finemanagement.dao.basic.impl
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.dao.basic.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.basic.SysFowleryDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysFowleryDao")
public class SysFowleryDaoImpl<T> extends BaseDaoImpl<T> implements SysFowleryDao<T> {

}
