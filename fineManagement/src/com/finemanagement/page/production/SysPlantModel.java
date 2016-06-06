/**
 * 项目名称：com.finemanagement.page.production
 * 创建日期：2016-4-9
 * 修改历史：
 *    1、[2016-4-9]创建文件    by liutianyang
 */
package com.finemanagement.page.production;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysPlantModel extends BasePage {

	private Integer id; // id主键
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
	private String variety; // 品种
	private String plantArea; // 种植面积
	private int plantationMember; // 种植员
	private int technician; // 技术员
	private String wages; // 人员工资
	private String startTime; // 开始时间
	private String endTime; // 结束时间
	private String remark; // 备注
	private String startStartTime; // 开始种植时间
	private String endStartTime; // 结束种植时间
	/**
	 * @return the startStartTime
	 */
	public String getStartStartTime() {
		return startStartTime;
	}
	/**
	 * @param startStartTime the startStartTime to set
	 */
	public void setStartStartTime(String startStartTime) {
		this.startStartTime = startStartTime;
	}
	/**
	 * @return the endStartTime
	 */
	public String getEndStartTime() {
		return endStartTime;
	}
	/**
	 * @param endStartTime the endStartTime to set
	 */
	public void setEndStartTime(String endStartTime) {
		this.endStartTime = endStartTime;
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
	 * @return the greenhouseid
	 */
	public int getGreenhouseid() {
		return greenhouseid;
	}
	/**
	 * @param greenhouseid the greenhouseid to set
	 */
	public void setGreenhouseid(int greenhouseid) {
		this.greenhouseid = greenhouseid;
	}
	/**
	 * @return the baseid
	 */
	public int getBaseid() {
		return baseid;
	}
	/**
	 * @param baseid the baseid to set
	 */
	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}
	/**
	 * @return the variety
	 */
	public String getVariety() {
		return variety;
	}
	/**
	 * @param variety the variety to set
	 */
	public void setVariety(String variety) {
		this.variety = variety;
	}
	/**
	 * @return the plantArea
	 */
	public String getPlantArea() {
		return plantArea;
	}
	/**
	 * @param plantArea the plantArea to set
	 */
	public void setPlantArea(String plantArea) {
		this.plantArea = plantArea;
	}
	/**
	 * @return the plantationMember
	 */
	public int getPlantationMember() {
		return plantationMember;
	}
	/**
	 * @param plantationMember the plantationMember to set
	 */
	public void setPlantationMember(int plantationMember) {
		this.plantationMember = plantationMember;
	}
	/**
	 * @return the technician
	 */
	public int getTechnician() {
		return technician;
	}
	/**
	 * @param technician the technician to set
	 */
	public void setTechnician(int technician) {
		this.technician = technician;
	}
	/**
	 * @return the wages
	 */
	public String getWages() {
		return wages;
	}
	/**
	 * @param wages the wages to set
	 */
	public void setWages(String wages) {
		this.wages = wages;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
