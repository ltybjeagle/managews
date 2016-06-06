/**
 * 项目名称：com.finemanagement.entity.common
 * 创建日期：2016-3-24
 * 修改历史：
 *    1、[2016-3-24]创建文件    by liutianyang
 */
package com.finemanagement.entity.common;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysIdentifier extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1165364843651601200L;
	private Integer id; // id主键
	private String sysid; // 系统标识符
	private String sysname; // 系统名称
	private String isApp;
	/**
	 * @return the isApp
	 */
	public String getIsApp() {
		return isApp;
	}
	/**
	 * @param isApp the isApp to set
	 */
	public void setIsApp(String isApp) {
		this.isApp = isApp;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the sysid
	 */
	public String getSysid() {
		return sysid;
	}
	/**
	 * @param sysid the sysid to set
	 */
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	/**
	 * @return the sysname
	 */
	public String getSysname() {
		return sysname;
	}
	/**
	 * @param sysname the sysname to set
	 */
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	
}
