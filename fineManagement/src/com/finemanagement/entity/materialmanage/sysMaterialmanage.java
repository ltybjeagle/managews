package com.finemanagement.entity.materialmanage;

import com.base.entity.BaseEntity;

public class sysMaterialmanage extends BaseEntity {
	private Integer id; // id主键
	private String principal; // 负责人
	private String materialuser;//使用人
	private String backuser;//归还人
	private int warehouseid; // 仓库
	private int brandId; // 品牌
	private int mfid; // 厂家
	private int baseid; // 基地
	private int greehouseid; // 大棚
	private String materialno; // 物资编号
	private String materialname; // 物资名称
	private String specifications; // 规格
	private String unit; // 单位符号
	private String profitloss; // 盈亏
	private String firm; // 实盘数
	private String differences; // 差异
	private String storecount; // 库存
	private String consumcount; // 领用数量
	private String returncount; // 归还数量
	private String unitPrice; // 单价
	private String totalprice; // 总价
	private String consumtime; // 领用时间
	private String returntime; // 归还时间
	private String instoretime; // 入库时间
	private String remark; // 备注
	private String syssign; // 单据标识
	private String sysid; // 系统标识
	private String brandName;
	private String mfName;
	private String whName;
	private String baseName;
	private String greenhousename;
	private String stocktalingno;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public int getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getMfid() {
		return mfid;
	}
	public void setMfid(int mfid) {
		this.mfid = mfid;
	}
	public String getMaterialno() {
		return materialno;
	}
	public void setMaterialno(String materialno) {
		this.materialno = materialno;
	}
	public String getMaterialname() {
		return materialname;
	}
	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStorecount() {
		return storecount;
	}
	public void setStorecount(String storecount) {
		this.storecount = storecount;
	}
	public String getConsumcount() {
		return consumcount;
	}
	public void setConsumcount(String consumcount) {
		this.consumcount = consumcount;
	}
	public String getReturncount() {
		return returncount;
	}
	public void setReturncount(String returncount) {
		this.returncount = returncount;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getConsumtime() {
		return consumtime;
	}
	public void setConsumtime(String consumtime) {
		this.consumtime = consumtime;
	}
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public String getInstoretime() {
		return instoretime;
	}
	public void setInstoretime(String instoretime) {
		this.instoretime = instoretime;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getMfName() {
		return mfName;
	}
	public void setMfName(String mfName) {
		this.mfName = mfName;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getProfitloss() {
		return profitloss;
	}
	public void setProfitloss(String profitloss) {
		this.profitloss = profitloss;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getDifferences() {
		return differences;
	}
	public void setDifferences(String differences) {
		this.differences = differences;
	}
	public String getMaterialuser() {
		return materialuser;
	}
	public void setMaterialuser(String materialuser) {
		this.materialuser = materialuser;
	}
	public int getBaseid() {
		return baseid;
	}
	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}
	public int getGreehouseid() {
		return greehouseid;
	}
	public void setGreehouseid(int greehouseid) {
		this.greehouseid = greehouseid;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getGreenhousename() {
		return greenhousename;
	}
	public void setGreenhousename(String greenhousename) {
		this.greenhousename = greenhousename;
	}
	public String getBackuser() {
		return backuser;
	}
	public void setBackuser(String backuser) {
		this.backuser = backuser;
	}
	public String getStocktalingno() {
		return stocktalingno;
	}
	public void setStocktalingno(String stocktalingno) {
		this.stocktalingno = stocktalingno;
	}
	
}
