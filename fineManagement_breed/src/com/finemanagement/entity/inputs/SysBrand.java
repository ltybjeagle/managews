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
public class SysBrand extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6152140277118794549L;
	private Integer id; // id主键
	private String brandName; //品牌名称
	private String remark; // 备注
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
	
}
