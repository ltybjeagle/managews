/**
 * 项目名称：com.finemanagement.page.sales
 * 创建日期：2016-5-6
 * 修改历史：
 *    1、[2016-5-6]创建文件    by liutianyang
 */
package com.finemanagement.page.sales;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysDistributionModel extends BasePage {

	private Integer id; // id主键
	private String distributionNo; // 配送编号
	private String nameOfDishes;
	private String typeOfDishes;
	private String number;
	private String unit;
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
	 * @return the nameOfDishes
	 */
	public String getNameOfDishes() {
		return nameOfDishes;
	}
	/**
	 * @param nameOfDishes the nameOfDishes to set
	 */
	public void setNameOfDishes(String nameOfDishes) {
		this.nameOfDishes = nameOfDishes;
	}
	/**
	 * @return the typeOfDishes
	 */
	public String getTypeOfDishes() {
		return typeOfDishes;
	}
	/**
	 * @param typeOfDishes the typeOfDishes to set
	 */
	public void setTypeOfDishes(String typeOfDishes) {
		this.typeOfDishes = typeOfDishes;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
