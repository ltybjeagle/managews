/**
 * 项目名称：com.finemanagement.page.sales
 * 创建日期：2016-5-5
 * 修改历史：
 *    1、[2016-5-5]创建文件    by liutianyang
 */
package com.finemanagement.page.sales;

import com.base.page.AttachmentModel;

/**
 * 
 * @author liutianyang
 */
public class SysSignModel extends AttachmentModel {

	private Integer id; // id主键
	private String distributionNo; // 配送编号
	private String releaseTime; // 发布时间
	private Integer distributionPId; // 配送人ID
	private String receivingUnit; // 收货单位
	private Integer distributionStatus; // 配送状态
	private Integer vehiclesId; // 汽车编号ID
	private String brand; // 品牌
	private String plateNum; // 车牌照
	private String distributionAddress; // 配送地址
	private String signTime; // 签收时间
	private String signPerson; // 签收人
	private String startReleaseTime; // 发布时间
	private String endReleaseTime; // 发布时间
	/**
	 * @return the startReleaseTime
	 */
	public String getStartReleaseTime() {
		return startReleaseTime;
	}
	/**
	 * @param startReleaseTime the startReleaseTime to set
	 */
	public void setStartReleaseTime(String startReleaseTime) {
		this.startReleaseTime = startReleaseTime;
	}
	/**
	 * @return the endReleaseTime
	 */
	public String getEndReleaseTime() {
		return endReleaseTime;
	}
	/**
	 * @param endReleaseTime the endReleaseTime to set
	 */
	public void setEndReleaseTime(String endReleaseTime) {
		this.endReleaseTime = endReleaseTime;
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
	 * @return the distributionNo
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * @param distributionNo the distributionNo to set
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * @return the releaseTime
	 */
	public String getReleaseTime() {
		return releaseTime;
	}
	/**
	 * @param releaseTime the releaseTime to set
	 */
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * @return the receivingUnit
	 */
	public String getReceivingUnit() {
		return receivingUnit;
	}
	/**
	 * @param receivingUnit the receivingUnit to set
	 */
	public void setReceivingUnit(String receivingUnit) {
		this.receivingUnit = receivingUnit;
	}
	/**
	 * @return the distributionStatus
	 */
	public Integer getDistributionStatus() {
		return distributionStatus;
	}
	/**
	 * @param distributionStatus the distributionStatus to set
	 */
	public void setDistributionStatus(Integer distributionStatus) {
		this.distributionStatus = distributionStatus;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the plateNum
	 */
	public String getPlateNum() {
		return plateNum;
	}
	/**
	 * @param plateNum the plateNum to set
	 */
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	/**
	 * @return the distributionAddress
	 */
	public String getDistributionAddress() {
		return distributionAddress;
	}
	/**
	 * @param distributionAddress the distributionAddress to set
	 */
	public void setDistributionAddress(String distributionAddress) {
		this.distributionAddress = distributionAddress;
	}
	/**
	 * @return the signTime
	 */
	public String getSignTime() {
		return signTime;
	}
	/**
	 * @param signTime the signTime to set
	 */
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}
	/**
	 * @return the signPerson
	 */
	public String getSignPerson() {
		return signPerson;
	}
	/**
	 * @param signPerson the signPerson to set
	 */
	public void setSignPerson(String signPerson) {
		this.signPerson = signPerson;
	}
	/**
	 * @return the distributionPId
	 */
	public Integer getDistributionPId() {
		return distributionPId;
	}
	/**
	 * @param distributionPId the distributionPId to set
	 */
	public void setDistributionPId(Integer distributionPId) {
		this.distributionPId = distributionPId;
	}
	/**
	 * @return the vehiclesId
	 */
	public Integer getVehiclesId() {
		return vehiclesId;
	}
	/**
	 * @param vehiclesId the vehiclesId to set
	 */
	public void setVehiclesId(Integer vehiclesId) {
		this.vehiclesId = vehiclesId;
	}
}
