/**
 * 项目名称：com.finemanagement.page.purchase
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.page.purchase;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysPurchaseModel extends BasePage {

	private String id; // id主键
	private int productid; // 商品编号
	private String inputName; // 投入品名称
	private String classname; // 分类
	private String unit; // 单位符号
	private String specifications; // 规格
	private String brandName; // 品牌
	private String mfName; // 厂家
	private String purchaseCount; // 采购数量
	private String unitPrice; // 单价
	private String remark; // 备注
	private String productNo;
	private int userid;
	private int waittaskid;
	private String taskkey;
	private String isinstore;
	private String createTime; // 发布时间
	private String totalAmt; // 总价
	private int auditId; // 审核人
	private String startCreatetTime;
	private String endCreatetTime;
	/**
	 * @return the startCreatetTime
	 */
	public String getStartCreatetTime() {
		return startCreatetTime;
	}
	/**
	 * @param startCreatetTime the startCreatetTime to set
	 */
	public void setStartCreatetTime(String startCreatetTime) {
		this.startCreatetTime = startCreatetTime;
	}
	/**
	 * @return the endCreatetTime
	 */
	public String getEndCreatetTime() {
		return endCreatetTime;
	}
	/**
	 * @param endCreatetTime the endCreatetTime to set
	 */
	public void setEndCreatetTime(String endCreatetTime) {
		this.endCreatetTime = endCreatetTime;
	}
	/**
	 * @return the auditId
	 */
	public int getAuditId() {
		return auditId;
	}
	/**
	 * @param auditId the auditId to set
	 */
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	/**
	 * @return the totalAmt
	 */
	public String getTotalAmt() {
		return totalAmt;
	}
	/**
	 * @param totalAmt the totalAmt to set
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @return the isinstore
	 */
	public String getIsinstore() {
		return isinstore;
	}
	/**
	 * @param isinstore the isinstore to set
	 */
	public void setIsinstore(String isinstore) {
		this.isinstore = isinstore;
	}
	/**
	 * @return the taskkey
	 */
	public String getTaskkey() {
		return taskkey;
	}
	/**
	 * @param taskkey the taskkey to set
	 */
	public void setTaskkey(String taskkey) {
		this.taskkey = taskkey;
	}
	/**
	 * @return the waittaskid
	 */
	public int getWaittaskid() {
		return waittaskid;
	}
	/**
	 * @param waittaskid the waittaskid to set
	 */
	public void setWaittaskid(int waittaskid) {
		this.waittaskid = waittaskid;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the productNo
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * @param productNo the productNo to set
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the productid
	 */
	public int getProductid() {
		return productid;
	}
	/**
	 * @param productid the productid to set
	 */
	public void setProductid(int productid) {
		this.productid = productid;
	}
	/**
	 * @return the inputName
	 */
	public String getInputName() {
		return inputName;
	}
	/**
	 * @param inputName the inputName to set
	 */
	public void setInputName(String inputName) {
		this.inputName = inputName;
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
	/**
	 * @return the specifications
	 */
	public String getSpecifications() {
		return specifications;
	}
	/**
	 * @param specifications the specifications to set
	 */
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
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
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	 * @return the purchaseCount
	 */
	public String getPurchaseCount() {
		return purchaseCount;
	}
	/**
	 * @param purchaseCount the purchaseCount to set
	 */
	public void setPurchaseCount(String purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	/**
	 * @return the unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
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
