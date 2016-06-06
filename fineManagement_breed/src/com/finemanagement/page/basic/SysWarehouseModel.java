/**
 * 项目名称：com.finemanagement.page.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.page.basic;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysWarehouseModel extends BasePage {

	private Integer id; // id主键
	private String whName; // 仓库名称
	private String responsible; // 责任人
	private String whArea; // 仓库面积
	private String whAddress; // 仓库地址
	private String phoneNo; // 联系方式
	private String createTime; // 创建时间
	private String remark; // 备注
	private String sysid;
	/**
	 * @return the sysid
	 */
	public String getSysid() {
		return sysid;
	}
	/**
	 * @param sysid the sysid to set
	 */
	public void setSysid(String sysid) {
		this.sysid = sysid;
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
	 * @return the whName
	 */
	public String getWhName() {
		return whName;
	}
	/**
	 * @param whName the whName to set
	 */
	public void setWhName(String whName) {
		this.whName = whName;
	}
	/**
	 * @return the responsible
	 */
	public String getResponsible() {
		return responsible;
	}
	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	/**
	 * @return the whArea
	 */
	public String getWhArea() {
		return whArea;
	}
	/**
	 * @param whArea the whArea to set
	 */
	public void setWhArea(String whArea) {
		this.whArea = whArea;
	}
	/**
	 * @return the whAddress
	 */
	public String getWhAddress() {
		return whAddress;
	}
	/**
	 * @param whAddress the whAddress to set
	 */
	public void setWhAddress(String whAddress) {
		this.whAddress = whAddress;
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
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
