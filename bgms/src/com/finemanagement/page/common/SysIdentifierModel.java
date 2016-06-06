/**
 * 项目名称：com.finemanagement.page.common
 * 创建日期：2016-5-23
 * 修改历史：
 *    1、[2016-5-23]创建文件    by liutianyang
 */
package com.finemanagement.page.common;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysIdentifierModel extends BasePage {

	private Integer id; // id主键
	private String sysid; // 系统标识符
	private String sysname; // 系统名称
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
