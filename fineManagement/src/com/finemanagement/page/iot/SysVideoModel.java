/**
 * 项目名称：com.finemanagement.page.iot
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.page.iot;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysVideoModel extends BasePage {

	private Integer id; // id主键
	private String equipmentNumber; // 设备编号
	private String videoChannelNumber; // 视频通道号
	private String videoMonitoringPoint; // 视频通道号
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
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
	 * @return the videoChannelNumber
	 */
	public String getVideoChannelNumber() {
		return videoChannelNumber;
	}
	/**
	 * @param videoChannelNumber the videoChannelNumber to set
	 */
	public void setVideoChannelNumber(String videoChannelNumber) {
		this.videoChannelNumber = videoChannelNumber;
	}
	/**
	 * @return the videoMonitoringPoint
	 */
	public String getVideoMonitoringPoint() {
		return videoMonitoringPoint;
	}
	/**
	 * @param videoMonitoringPoint the videoMonitoringPoint to set
	 */
	public void setVideoMonitoringPoint(String videoMonitoringPoint) {
		this.videoMonitoringPoint = videoMonitoringPoint;
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
}
