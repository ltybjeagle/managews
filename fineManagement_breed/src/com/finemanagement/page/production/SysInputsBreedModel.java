/**
 * 项目名称：com.finemanagement.page.production
 * 创建日期：2016-4-16
 * 修改历史：
 *    1、[2016-4-16]创建文件    by liutianyang
 */
package com.finemanagement.page.production;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysInputsBreedModel extends BasePage {

	private Integer id; // 投入品ID
	private int fowleryid; // 归属禽舍
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
	private int breeder; // 种植员
	private int breedTechnician; // 技术员
	private String breederName;
	private String breedTechnicianName;
	private String productNo;
	private String startTime; // 开始时间
	private String startStartTime; // 开始使用时间
	private String endStartTime; // 结束开始时间
	private String isoutstore;
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
	 * @return the startStartTime
	 */
	public String getStartStartTime() {
		return startStartTime;
	}
	/**
	 * @param startStartTime the startStartTime to set
	 */
	public void setStartStartTime(String startStartTime) {
		this.startStartTime = startStartTime;
	}
	/**
	 * @return the endStartTime
	 */
	public String getEndStartTime() {
		return endStartTime;
	}
	/**
	 * @param endStartTime the endStartTime to set
	 */
	public void setEndStartTime(String endStartTime) {
		this.endStartTime = endStartTime;
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
	 * @return the fowleryid
	 */
	public int getFowleryid() {
		return fowleryid;
	}
	/**
	 * @param fowleryid the fowleryid to set
	 */
	public void setFowleryid(int fowleryid) {
		this.fowleryid = fowleryid;
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
	 * @return the breeder
	 */
	public int getBreeder() {
		return breeder;
	}
	/**
	 * @param breeder the breeder to set
	 */
	public void setBreeder(int breeder) {
		this.breeder = breeder;
	}
	/**
	 * @return the breedTechnician
	 */
	public int getBreedTechnician() {
		return breedTechnician;
	}
	/**
	 * @param breedTechnician the breedTechnician to set
	 */
	public void setBreedTechnician(int breedTechnician) {
		this.breedTechnician = breedTechnician;
	}
	/**
	 * @return the breederName
	 */
	public String getBreederName() {
		return breederName;
	}
	/**
	 * @param breederName the breederName to set
	 */
	public void setBreederName(String breederName) {
		this.breederName = breederName;
	}
	/**
	 * @return the breedTechnicianName
	 */
	public String getBreedTechnicianName() {
		return breedTechnicianName;
	}
	/**
	 * @param breedTechnicianName the breedTechnicianName to set
	 */
	public void setBreedTechnicianName(String breedTechnicianName) {
		this.breedTechnicianName = breedTechnicianName;
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
