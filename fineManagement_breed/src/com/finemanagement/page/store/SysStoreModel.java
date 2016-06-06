/**
 * 项目名称：com.finemanagement.page.inputs
 * 创建日期：2016-3-29
 * 创建文件    by zhangyong
 */
package com.finemanagement.page.store;

import com.base.page.BasePage;


/**
 * 
 * @author zhangyong
 */
public class SysStoreModel extends BasePage {
	
	private Integer id; // id主键
	private String productNo; // 商品编号
	private String inputName; // 投入品名称
	private int classifyId; // 分类
	private String unit; // 单位符号
	private String specifications; // 规格
	private int brandId; // 品牌
	private int mfid; // 厂家
    private String purchaseCount;//数量
    private String unitPrice;//单价
    private String totalprice;//总价
    private int warehouseid ;//库房
    private String sysid ;//系统id
    private String technicalstaff ;//技术人员
    private String principal ;//负责人
    private String remark ;//说明
    private String outremark ;//出库说明
    private String instoretime;//入库时间
    private String outstoretime;//出库时间
    private String outuser;//使用人
    private int baseid;//基地
    private int greenhouseid;//大棚
    private String outpurchaseCount;//出库数量
    private String syssign;//
    private String processInstanceId;//操作类型
    private String startInstoretime; // 开始入库时间
    private String endInstoretime; // 结束入库时间
    private String classname; // 分类
    private String startOutstoretime; // 开始出库时间
    private String endOutstoretime; // 结束出库时间
    /**
	 * @return the startOutstoretime
	 */
	public String getStartOutstoretime() {
		return startOutstoretime;
	}
	/**
	 * @param startOutstoretime the startOutstoretime to set
	 */
	public void setStartOutstoretime(String startOutstoretime) {
		this.startOutstoretime = startOutstoretime;
	}
	/**
	 * @return the endOutstoretime
	 */
	public String getEndOutstoretime() {
		return endOutstoretime;
	}
	/**
	 * @param endOutstoretime the endOutstoretime to set
	 */
	public void setEndOutstoretime(String endOutstoretime) {
		this.endOutstoretime = endOutstoretime;
	}
	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}
	/**
	 * @param classname the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}
	/**
	 * @return the startInstoretime
	 */
	public String getStartInstoretime() {
		return startInstoretime;
	}
	/**
	 * @param startInstoretime the startInstoretime to set
	 */
	public void setStartInstoretime(String startInstoretime) {
		this.startInstoretime = startInstoretime;
	}
	/**
	 * @return the endInstoretime
	 */
	public String getEndInstoretime() {
		return endInstoretime;
	}
	/**
	 * @param endInstoretime the endInstoretime to set
	 */
	public void setEndInstoretime(String endInstoretime) {
		this.endInstoretime = endInstoretime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public int getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(int classifyId) {
		this.classifyId = classifyId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
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
	public String getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(String purchaseCount) {
		this.purchaseCount = purchaseCount;
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
	public int getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	public String getTechnicalstaff() {
		return technicalstaff;
	}
	public void setTechnicalstaff(String technicalstaff) {
		this.technicalstaff = technicalstaff;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInstoretime() {
		return instoretime;
	}
	public void setInstoretime(String instoretime) {
		this.instoretime = instoretime;
	}
	public String getOutstoretime() {
		return outstoretime;
	}
	public void setOutstoretime(String outstoretime) {
		this.outstoretime = outstoretime;
	}
	public String getOutuser() {
		return outuser;
	}
	public void setOutuser(String outuser) {
		this.outuser = outuser;
	}
	public int getBaseid() {
		return baseid;
	}
	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}
	public int getGreenhouseid() {
		return greenhouseid;
	}
	public void setGreenhouseid(int greenhouseid) {
		this.greenhouseid = greenhouseid;
	}
	public String getOutpurchaseCount() {
		return outpurchaseCount;
	}
	public void setOutpurchaseCount(String outpurchaseCount) {
		this.outpurchaseCount = outpurchaseCount;
	}
	public String getOutremark() {
		return outremark;
	}
	public void setOutremark(String outremark) {
		this.outremark = outremark;
	}
	public String getSyssign() {
		return syssign;
	}
	public void setSyssign(String syssign) {
		this.syssign = syssign;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
    
    
}
