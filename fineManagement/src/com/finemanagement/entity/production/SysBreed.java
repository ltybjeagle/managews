/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-4-11
 * 修改历史：
 *    1、[2016-4-11]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysBreed extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4251161270062574957L;
	private Integer id; // id主键
	private int fowleryid; // 归属禽舍
	private int baseid; // 归属基地
	private String variety; // 品种
	private String breedArea; // 养殖面积
	private int breeder; // 养殖员
	private int breedTechnician; // 技术员
	private String wages; // 人员工资
	private String startTime; // 开始时间
	private String endTime; // 结束时间
	private String remark; // 备注
	private String breederName;
	private String breedTechnicianName;
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
	 * @return the fowleryid
	 */
	public int getFowleryid() {
		return fowleryid;
	}
	/**
	 * @param fowleryid the fowleryid to set
	 */
	public void setFowleryid(int fowleryid) {
		this.fowleryid = fowleryid;
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
	 * @return the breedArea
	 */
	public String getBreedArea() {
		return breedArea;
	}
	/**
	 * @param breedArea the breedArea to set
	 */
	public void setBreedArea(String breedArea) {
		this.breedArea = breedArea;
	}
	/**
	 * @return the breeder
	 */
	public int getBreeder() {
		return breeder;
	}
	/**
	 * @param breeder the breeder to set
	 */
	public void setBreeder(int breeder) {
		this.breeder = breeder;
	}
	/**
	 * @return the breedTechnician
	 */
	public int getBreedTechnician() {
		return breedTechnician;
	}
	/**
	 * @param breedTechnician the breedTechnician to set
	 */
	public void setBreedTechnician(int breedTechnician) {
		this.breedTechnician = breedTechnician;
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
	/**
	 * @return the breederName
	 */
	public String getBreederName() {
		return breederName;
	}
	/**
	 * @param breederName the breederName to set
	 */
	public void setBreederName(String breederName) {
		this.breederName = breederName;
	}
	/**
	 * @return the breedTechnicianName
	 */
	public String getBreedTechnicianName() {
		return breedTechnicianName;
	}
	/**
	 * @param breedTechnicianName the breedTechnicianName to set
	 */
	public void setBreedTechnicianName(String breedTechnicianName) {
		this.breedTechnicianName = breedTechnicianName;
	}
}
