/**
 * 项目名称：com.finemanagement.page.sales
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
 */
package com.finemanagement.page.sales;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysVehiclesModel extends BasePage {

	private Integer id; // id主键
	private String vehiclesNo; // 汽车编号
	private String plateNum; // 车牌照
	private String brand; // 品牌
	private String carAge; // 车龄
	private String carType; // 汽车类型
	private String saleDate; // 购车日期
	private String saleSum; // 购买金额
	private String belong; // 所属类型
	private String remark; // 备注
	/**
	 * @return the belong
	 */
	public String getBelong() {
		return belong;
	}
	/**
	 * @param belong the belong to set
	 */
	public void setBelong(String belong) {
		this.belong = belong;
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
	 * @return the carAge
	 */
	public String getCarAge() {
		return carAge;
	}
	/**
	 * @param carAge the carAge to set
	 */
	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}
	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * @return the saleDate
	 */
	public String getSaleDate() {
		return saleDate;
	}
	/**
	 * @param saleDate the saleDate to set
	 */
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	/**
	 * @return the saleSum
	 */
	public String getSaleSum() {
		return saleSum;
	}
	/**
	 * @param saleSum the saleSum to set
	 */
	public void setSaleSum(String saleSum) {
		this.saleSum = saleSum;
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
