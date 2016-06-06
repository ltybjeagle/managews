/**
 * 项目名称：com.finemanagement.dao.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.dao.user;

import java.util.List;
import java.util.Map;

import com.base.dao.BaseDao;
import com.finemanagement.entity.user.SysRoleRel;

/**
 * 
 * @author liutianyang
 */
public interface SysRoleRelDao<T> extends BaseDao<T> {

	public void deleteByRoleId(String str, Map<String, Object> param);
	
	public void deleteByObjId(String str, Map<String, Object> param);
	
	public List<SysRoleRel> queryByRoleId(String str, Map<String, Object> param);
	
	public List<SysRoleRel> queryByObjId(String str, Map<String, Object> param);
}
