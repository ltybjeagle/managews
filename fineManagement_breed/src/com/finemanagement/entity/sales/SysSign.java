/**
 * 项目名称：com.finemanagement.entity.sales
 * 创建日期：2016-5-5
 * 修改历史：
 *    1、[2016-5-5]创建文件    by liutianyang
 */
package com.finemanagement.entity.sales;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.base.entity.Attachment;

/**
 * 
 * @author liutianyang
 */
public class SysSign extends Attachment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4113137873784090684L;
	private Integer id; // id主键
	private String uuid;
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
	private String vehiclesNo; // 汽车编号
	private String distributionPerson; // 配送人
	private MultipartFile file;
    private String filePath;
    List<SysSign> list;
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the list
	 */
	public List<SysSign> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<SysSign> list) {
		this.list = list;
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
	 * @return the distributionPerson
	 */
	public String getDistributionPerson() {
		return distributionPerson;
	}
	/**
	 * @param distributionPerson the distributionPerson to set
	 */
	public void setDistributionPerson(String distributionPerson) {
		this.distributionPerson = distributionPerson;
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
	 * @return the vehiclesNo
	 */
	public String getVehiclesNo() {
		return vehiclesNo;
	}
	/**
	 * @param vehiclesNo the vehiclesNo to set
	 */
	public void setVehiclesNo(String vehiclesNo) {
		this.vehiclesNo = vehiclesNo;
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
}
