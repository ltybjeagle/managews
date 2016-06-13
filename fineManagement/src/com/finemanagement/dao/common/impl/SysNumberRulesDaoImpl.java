/**
 * 项目名称：com.finemanagement.dao.common.impl
 * 创建日期：2016-6-12
 * 修改历史：
 *    1、[2016-6-12]创建文件    by liutianyang
 */
package com.finemanagement.dao.common.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.finemanagement.dao.common.SysNumberRulesDao;

/**
 * 
 * @author liutianyang
 */
@Repository("sysNumberRulesDao")
public class SysNumberRulesDaoImpl<T> extends BaseDaoImpl<T> implements SysNumberRulesDao<T> {

}
