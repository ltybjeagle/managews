package com.finemanagement.entity.materialmanage;

import com.base.entity.BaseEntity;

public class sysStocktakingEntity extends BaseEntity {
	private Integer id; // id主键
	private String principal; // 负责人
	private String stocktalingno; // 盘点单号
	private String warehouseid; // 仓库
	private String remark;//
	private String sysid;
	private String whName;
	private String stocktime;//盘库时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getStocktalingno() {
		return stocktalingno;
	}
	public void setStocktalingno(String stocktalingno) {
		this.stocktalingno = stocktalingno;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
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
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getStocktime() {
		return stocktime;
	}
	public void setStocktime(String stocktime) {
		this.stocktime = stocktime;
	}
	
}
