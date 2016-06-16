/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysInputs extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 965743594427667078L;
	private Integer id; // 投入品ID
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
	private int productid; // 商品编号
	private String inputName; // 投入品名称
	private String classname; // 分类
	private String unit; // 单位符号
	private String specifications; // 规格
	private String brandName; // 品牌
	private String mfName; // 厂家
	private String purchaseCount; // 使用数量
	private String unitPrice; // 单价
	private String remark; // 备注
	private int plantationMember; // 种植员
	private int technician; // 技术员
	private String plantationMemberName;
	private String technicianName;
	private String productNo;
	private String startTime; // 开始时间
	private String isoutstore;
	private String baseName;
	private String greenhouseName;
	private String totalprice;
	/**
	 * @return the totalprice
	 */
	public String getTotalprice() {
		return totalprice;
	}
	/**
	 * @param totalprice the totalprice to set
	 */
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}
	/**
	 * @param baseName the baseName to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	/**
	 * @return the greenhouseName
	 */
	public String getGreenhouseName() {
		return greenhouseName;
	}
	/**
	 * @param greenhouseName the greenhouseName to set
	 */
	public void setGreenhouseName(String greenhouseName) {
		this.greenhouseName = greenhouseName;
	}
	/**
	 * @return the isoutstore
	 */
	public String getIsoutstore() {
		return isoutstore;
	}
	/**
	 * @param isoutstore the isoutstore to set
	 */
	public void setIsoutstore(String isoutstore) {
		this.isoutstore = isoutstore;
	}
	/**
	 * @return the plantationMember
	 */
	public int getPlantationMember() {
		return plantationMember;
	}
	/**
	 * @param plantationMember the plantationMember to set
	 */
	public void setPlantationMember(int plantationMember) {
		this.plantationMember = plantationMember;
	}
	/**
	 * @return the technician
	 */
	public int getTechnician() {
		return technician;
	}
	/**
	 * @param technician the technician to set
	 */
	public void setTechnician(int technician) {
		this.technician = technician;
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
	 * @return the greenhouseid
	 */
	public int getGreenhouseid() {
		return greenhouseid;
	}
	/**
	 * @param greenhouseid the greenhouseid to set
	 */
	public void setGreenhouseid(int greenhouseid) {
		this.greenhouseid = greenhouseid;
	}
	/**
	 * @return the baseid
	 */
	public int getBaseid() {
		return baseid;
	}
	/**
	 * @param baseid the baseid to set
	 */
	public void setBaseid(int baseid) {
		this.baseid = baseid;
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
	/**
	 * @return the plantationMemberName
	 */
	public String getPlantationMemberName() {
		return plantationMemberName;
	}
	/**
	 * @param plantationMemberName the plantationMemberName to set
	 */
	public void setPlantationMemberName(String plantationMemberName) {
		this.plantationMemberName = plantationMemberName;
	}
	/**
	 * @return the technicianName
	 */
	public String getTechnicianName() {
		return technicianName;
	}
	/**
	 * @param technicianName the technicianName to set
	 */
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
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
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}
