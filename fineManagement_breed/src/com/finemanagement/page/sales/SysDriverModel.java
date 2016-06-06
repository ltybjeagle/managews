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
public class SysDriverModel extends BasePage {

	private Integer id; // id主键
	private String name; // 姓名
	private Integer sex; // 性别
	private String age; // 年龄
	private String carAge; // 车龄
	private String phoneNo; // 联系方式
	private String remark; // 备注
	private String driverStatus;
	/**
	 * @return the driverStatus
	 */
	public String getDriverStatus() {
		return driverStatus;
	}
	/**
	 * @param driverStatus the driverStatus to set
	 */
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
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
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
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
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
