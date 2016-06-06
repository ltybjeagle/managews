/**
 * 项目名称：com.finemanagement.page.inputs
 * 创建日期：2016-3-29
 * 修改历史：
 *    1、[2016-3-29]创建文件    by liutianyang
 */
package com.finemanagement.page.inputs;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysManufacturerModel extends BasePage {

	private Integer id; // id主键
	private String mfName; // 厂家名称
	private String mfArea; // 厂家地址
	private String mfPhoneNo; // 联系方式
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
	 * @return the mfName
	 */
	public String getMfName() {
		return mfName;
	}
	/**
	 * @param mfName the mfName to set
	 */
	public void setMfName(String mfName) {
		this.mfName = mfName;
	}
	/**
	 * @return the mfArea
	 */
	public String getMfArea() {
		return mfArea;
	}
	/**
	 * @param mfArea the mfArea to set
	 */
	public void setMfArea(String mfArea) {
		this.mfArea = mfArea;
	}
	/**
	 * @return the mfPhoneNo
	 */
	public String getMfPhoneNo() {
		return mfPhoneNo;
	}
	/**
	 * @param mfPhoneNo the mfPhoneNo to set
	 */
	public void setMfPhoneNo(String mfPhoneNo) {
		this.mfPhoneNo = mfPhoneNo;
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
