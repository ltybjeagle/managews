/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-4-9
 * 修改历史：
 *    1、[2016-4-9]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysPlant extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 933774112246150323L;
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
	private String purchaseCount;// 总数
	private String unitPrice;// 单价

	public String getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(String purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the plantationMemberName
	 */
	public String getPlantationMemberName() {
		return plantationMemberName;
	}

	/**
	 * @param plantationMemberName
	 *            the plantationMemberName to set
	 */
	public void setPlantationMemberName(String plantationMemberName) {
		this.plantationMemberName = plantationMemberName;
	}

	/**
	 * @return the technicianName
	 */
	public String getTechnicianName() {
		return technicianName;
	}

	/**
	 * @param technicianName
	 *            the technicianName to set
	 */
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	private String remark; // 备注
	private String plantationMemberName;
	private String technicianName;
	private String basePhone; // 基地电话
	private String greenhouseType; // 大棚类型

	/**
	 * @return the basePhone
	 */
	public String getBasePhone() {
		return basePhone;
	}

	/**
	 * @param basePhone
	 *            the basePhone to set
	 */
	public void setBasePhone(String basePhone) {
		this.basePhone = basePhone;
	}

	/**
	 * @return the greenhouseType
	 */
	public String getGreenhouseType() {
		return greenhouseType;
	}

	/**
	 * @param greenhouseType
	 *            the greenhouseType to set
	 */
	public void setGreenhouseType(String greenhouseType) {
		this.greenhouseType = greenhouseType;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param greenhouseid
	 *            the greenhouseid to set
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
	 * @param baseid
	 *            the baseid to set
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
	 * @param variety
	 *            the variety to set
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
	 * @param plantArea
	 *            the plantArea to set
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
	 * @param plantationMember
	 *            the plantationMember to set
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
	 * @param technician
	 *            the technician to set
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
	 * @param wages
	 *            the wages to set
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
	 * @param startTime
	 *            the startTime to set
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
	 * @param endTime
	 *            the endTime to set
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
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
