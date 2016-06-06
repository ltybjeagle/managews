/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-6-5
 * 修改历史：
 *    1、[2016-6-5]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysVariety extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6943366760867195165L;
	private Integer id; // id主键
	private String varietyName;
	private String sysid;
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
	 * @return the varietyName
	 */
	public String getVarietyName() {
		return varietyName;
	}
	/**
	 * @param varietyName the varietyName to set
	 */
	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
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
	
}
