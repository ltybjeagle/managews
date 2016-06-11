package com.finemanagement.page.storagemanagement;

import com.base.page.BasePage;

public class sysStoremanageModel extends BasePage {
	
	private Integer id; // id主键
	private String warehouseid; // 仓库
	private String principal; // 负责人
	private String registertime; // 登记时间
	private String description; // 描述
	private String remark; // 
	private String sysid; // 系统标志
	private String syssign;
	private String startregistertime;
	private String endregistertime;
	/**
	 * @return the startregistertime
	 */
	public String getStartregistertime() {
		return startregistertime;
	}
	/**
	 * @param startregistertime the startregistertime to set
	 */
	public void setStartregistertime(String startregistertime) {
		this.startregistertime = startregistertime;
	}
	/**
	 * @return the endregistertime
	 */
	public String getEndregistertime() {
		return endregistertime;
	}
	/**
	 * @param endregistertime the endregistertime to set
	 */
	public void setEndregistertime(String endregistertime) {
		this.endregistertime = endregistertime;
	}
	/**
	 * @return the syssign
	 */
	public String getSyssign() {
		return syssign;
	}
	/**
	 * @param syssign the syssign to set
	 */
	public void setSyssign(String syssign) {
		this.syssign = syssign;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	
}
