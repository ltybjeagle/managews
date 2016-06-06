/**
 * 项目名称：com.finemanagement.entity.basic
 * 创建日期：2016-3-28
 * 修改历史：
 *    1、[2016-3-28]创建文件    by liutianyang
 */
package com.finemanagement.entity.basic;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysGreenhouseType extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6071634060475385688L;
	private Integer id; // id主键
	private String greenhouseName; // 大棚类型名称
	private String greenhouseCount; // 大棚数量
	private String remark; //备注
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
	 * @return the greenhouseCount
	 */
	public String getGreenhouseCount() {
		return greenhouseCount;
	}
	/**
	 * @param greenhouseCount the greenhouseCount to set
	 */
	public void setGreenhouseCount(String greenhouseCount) {
		this.greenhouseCount = greenhouseCount;
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
