package com.finemanagement.page.production;

import com.base.page.BasePage;

public class SysVarietyModel extends BasePage {

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
