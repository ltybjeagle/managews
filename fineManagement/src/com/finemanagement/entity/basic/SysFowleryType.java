/**
 * 项目名称：com.finemanagement.entity.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.entity.basic;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysFowleryType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2988669905874935814L;
	private Integer id; // id主键
	private String fowleryName; // 禽舍类型名称
	private String fowleryCount; // 禽舍数量
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
	 * @return the fowleryName
	 */
	public String getFowleryName() {
		return fowleryName;
	}
	/**
	 * @param fowleryName the fowleryName to set
	 */
	public void setFowleryName(String fowleryName) {
		this.fowleryName = fowleryName;
	}
	/**
	 * @return the fowleryCount
	 */
	public String getFowleryCount() {
		return fowleryCount;
	}
	/**
	 * @param fowleryCount the fowleryCount to set
	 */
	public void setFowleryCount(String fowleryCount) {
		this.fowleryCount = fowleryCount;
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
