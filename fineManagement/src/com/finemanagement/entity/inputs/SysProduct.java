/**
 * 项目名称：com.finemanagement.entity.inputs
 * 创建日期：2016-3-29
 * 修改历史：
 *    1、[2016-3-29]创建文件    by liutianyang
 */
package com.finemanagement.entity.inputs;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysProduct extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5763048946000355509L;
	private Integer id; // id主键
	private String productNo; // 商品编号
	private String inputName; // 投入品名称
	private int classifyId; // 分类
	private String unit; // 单位符号
	private String specifications; // 规格
	private int brandId; // 品牌
	private int mfid; // 厂家
	private String remark; // 备注
	private String classname;
	private String brandName;
	private String mfName;
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
	 * @return the classifyId
	 */
	public int getClassifyId() {
		return classifyId;
	}
	/**
	 * @param classifyId the classifyId to set
	 */
	public void setClassifyId(int classifyId) {
		this.classifyId = classifyId;
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
	 * @return the brandId
	 */
	public int getBrandId() {
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	/**
	 * @return the mfid
	 */
	public int getMfid() {
		return mfid;
	}
	/**
	 * @param mfid the mfid to set
	 */
	public void setMfid(int mfid) {
		this.mfid = mfid;
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
