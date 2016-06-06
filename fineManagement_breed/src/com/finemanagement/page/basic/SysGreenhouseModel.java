/**
 * 项目名称：com.finemanagement.page.basic
 * 创建日期：2016-3-28
 * 修改历史：
 *    1、[2016-3-28]创建文件    by liutianyang
 */
package com.finemanagement.page.basic;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysGreenhouseModel extends BasePage {

	private Integer id; // id主键
	private String name; // 大棚名称
	private String ghArea; // 大棚面积
	private Integer baseid; // 基地
	private Integer typeid; // 类型
	private String createTime; // 创建时间
	private String remark; // 备注
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ghArea
	 */
	public String getGhArea() {
		return ghArea;
	}
	/**
	 * @param ghArea the ghArea to set
	 */
	public void setGhArea(String ghArea) {
		this.ghArea = ghArea;
	}
	/**
	 * @return the baseid
	 */
	public Integer getBaseid() {
		return baseid;
	}
	/**
	 * @param baseid the baseid to set
	 */
	public void setBaseid(Integer baseid) {
		this.baseid = baseid;
	}
	/**
	 * @return the typeid
	 */
	public Integer getTypeid() {
		return typeid;
	}
	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
