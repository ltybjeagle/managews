/**
 * 项目名称：com.finemanagement.page.basic
 * 创建日期：2016-3-23
 * 修改历史：
 *    1、[2016-3-23]创建文件    by liutianyang
 */
package com.finemanagement.page.basic;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysBaseModel extends BasePage {

	private Integer id; // id主键
	private String baseName; // 基地名称
	private String responsible; // 责任人
	private String baseArea; // 基地面积
	private String baseAddress; // 基地地址
	private String phoneNo; // 联系方式
	private String createTime; // 创建时间
	private String coordinate;// 地图坐标
	private String remark; // 备注

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}

	/**
	 * @param baseName
	 *            the baseName to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * @return the responsible
	 */

	/**
	 * @return the baseArea
	 */
	public String getBaseArea() {
		return baseArea;
	}

	/**
	 * @return the responsible
	 */
	public String getResponsible() {
		return responsible;
	}

	/**
	 * @param responsible
	 *            the responsible to set
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	/**
	 * @param baseArea
	 *            the baseArea to set
	 */
	public void setBaseArea(String baseArea) {
		this.baseArea = baseArea;
	}

	/**
	 * @return the baseAddress
	 */
	public String getBaseAddress() {
		return baseAddress;
	}

	/**
	 * @param baseAddress
	 *            the baseAddress to set
	 */
	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
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
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
