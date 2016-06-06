/**
 * 项目名称：com.finemanagement.entity.iot
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.entity.iot;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysSensor extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2801551576048981676L;
	private Integer id; // id主键
	private String equipmentNumber; // 设备编号
	private String acquisitionPoint; // 采集点
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
	private String baseName; // 基地名称
	private String greenhouseName; // 大棚名称
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
	 * @return the equipmentNumber
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}
	/**
	 * @param equipmentNumber the equipmentNumber to set
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	/**
	 * @return the acquisitionPoint
	 */
	public String getAcquisitionPoint() {
		return acquisitionPoint;
	}
	/**
	 * @param acquisitionPoint the acquisitionPoint to set
	 */
	public void setAcquisitionPoint(String acquisitionPoint) {
		this.acquisitionPoint = acquisitionPoint;
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
}
