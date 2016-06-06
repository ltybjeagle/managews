package com.finemanagement.entity.storagemanagement;

import com.base.entity.BaseEntity;

public class SysStoragemanagement extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7497623704129601994L;
	private Integer id; // id主键
	private String batchprocessing; // 加工批次
	private String productname; // 加工产品名称
	private String processingtime; // 加工时间
	private String processingstaff; // 加工人员
	private String instoretime; // 入库时间
	private int warehouseid; // 库房
	private String outstoretime;
	private String principal;//负责人
	private String remark; // 
    private String syssign;//
    private String sysid ;//系统
    private String whName;
    private String batchprocessNo;
	/**
	 * @return the batchprocessNo
	 */
	public String getBatchprocessNo() {
		return batchprocessNo;
	}
	/**
	 * @param batchprocessNo the batchprocessNo to set
	 */
	public void setBatchprocessNo(String batchprocessNo) {
		this.batchprocessNo = batchprocessNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBatchprocessing() {
		return batchprocessing;
	}
	public void setBatchprocessing(String batchprocessing) {
		this.batchprocessing = batchprocessing;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProcessingtime() {
		return processingtime;
	}
	public void setProcessingtime(String processingtime) {
		this.processingtime = processingtime;
	}
	public String getProcessingstaff() {
		return processingstaff;
	}
	public void setProcessingstaff(String processingstaff) {
		this.processingstaff = processingstaff;
	}
	public String getInstoretime() {
		return instoretime;
	}
	public void setInstoretime(String instoretime) {
		this.instoretime = instoretime;
	}
	public int getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSyssign() {
		return syssign;
	}
	public void setSyssign(String syssign) {
		this.syssign = syssign;
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getOutstoretime() {
		return outstoretime;
	}
	public void setOutstoretime(String outstoretime) {
		this.outstoretime = outstoretime;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
    
    
}
