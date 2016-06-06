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
public class SysThreshold extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3101889100786883969L;
	private Integer id; // id主键
	private String ruleName; // 规则名称
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
	private String openStatus; // 状态
	private String airTemperatureMin; // 空气温度下值
	private String airTemperatureMax; // 空气温度上值
	private String airTemperatureMsg; // 空气温度提醒信息
	private String airHumidityMin; // 空气湿度下值
	private String airHumidityMax; // 空气湿度上值
	private String airHumidityMsg; // 空气湿度提醒信息
	private String soilMoistureMin; // 土壤湿度下值
	private String soilMoistureMax; // 土壤湿度上值
	private String soilMoistureMsg; // 土壤湿度提醒信息
	private String bladeTemperatureMin; // 叶片温度下值 
	private String bladeTemperatureMax; // 叶片温度上值
	private String bladeTemperatureMsg; // 叶片温度提醒信息
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
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}
	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
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
	 * @return the openStatus
	 */
	public String getOpenStatus() {
		return openStatus;
	}
	/**
	 * @param openStatus the openStatus to set
	 */
	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}
	/**
	 * @return the airTemperatureMin
	 */
	public String getAirTemperatureMin() {
		return airTemperatureMin;
	}
	/**
	 * @param airTemperatureMin the airTemperatureMin to set
	 */
	public void setAirTemperatureMin(String airTemperatureMin) {
		this.airTemperatureMin = airTemperatureMin;
	}
	/**
	 * @return the airTemperatureMax
	 */
	public String getAirTemperatureMax() {
		return airTemperatureMax;
	}
	/**
	 * @param airTemperatureMax the airTemperatureMax to set
	 */
	public void setAirTemperatureMax(String airTemperatureMax) {
		this.airTemperatureMax = airTemperatureMax;
	}
	/**
	 * @return the airTemperatureMsg
	 */
	public String getAirTemperatureMsg() {
		return airTemperatureMsg;
	}
	/**
	 * @param airTemperatureMsg the airTemperatureMsg to set
	 */
	public void setAirTemperatureMsg(String airTemperatureMsg) {
		this.airTemperatureMsg = airTemperatureMsg;
	}
	/**
	 * @return the airHumidityMin
	 */
	public String getAirHumidityMin() {
		return airHumidityMin;
	}
	/**
	 * @param airHumidityMin the airHumidityMin to set
	 */
	public void setAirHumidityMin(String airHumidityMin) {
		this.airHumidityMin = airHumidityMin;
	}
	/**
	 * @return the airHumidityMax
	 */
	public String getAirHumidityMax() {
		return airHumidityMax;
	}
	/**
	 * @param airHumidityMax the airHumidityMax to set
	 */
	public void setAirHumidityMax(String airHumidityMax) {
		this.airHumidityMax = airHumidityMax;
	}
	/**
	 * @return the airHumidityMsg
	 */
	public String getAirHumidityMsg() {
		return airHumidityMsg;
	}
	/**
	 * @param airHumidityMsg the airHumidityMsg to set
	 */
	public void setAirHumidityMsg(String airHumidityMsg) {
		this.airHumidityMsg = airHumidityMsg;
	}
	/**
	 * @return the soilMoistureMin
	 */
	public String getSoilMoistureMin() {
		return soilMoistureMin;
	}
	/**
	 * @param soilMoistureMin the soilMoistureMin to set
	 */
	public void setSoilMoistureMin(String soilMoistureMin) {
		this.soilMoistureMin = soilMoistureMin;
	}
	/**
	 * @return the soilMoistureMax
	 */
	public String getSoilMoistureMax() {
		return soilMoistureMax;
	}
	/**
	 * @param soilMoistureMax the soilMoistureMax to set
	 */
	public void setSoilMoistureMax(String soilMoistureMax) {
		this.soilMoistureMax = soilMoistureMax;
	}
	/**
	 * @return the soilMoistureMsg
	 */
	public String getSoilMoistureMsg() {
		return soilMoistureMsg;
	}
	/**
	 * @param soilMoistureMsg the soilMoistureMsg to set
	 */
	public void setSoilMoistureMsg(String soilMoistureMsg) {
		this.soilMoistureMsg = soilMoistureMsg;
	}
	/**
	 * @return the bladeTemperatureMin
	 */
	public String getBladeTemperatureMin() {
		return bladeTemperatureMin;
	}
	/**
	 * @param bladeTemperatureMin the bladeTemperatureMin to set
	 */
	public void setBladeTemperatureMin(String bladeTemperatureMin) {
		this.bladeTemperatureMin = bladeTemperatureMin;
	}
	/**
	 * @return the bladeTemperatureMax
	 */
	public String getBladeTemperatureMax() {
		return bladeTemperatureMax;
	}
	/**
	 * @param bladeTemperatureMax the bladeTemperatureMax to set
	 */
	public void setBladeTemperatureMax(String bladeTemperatureMax) {
		this.bladeTemperatureMax = bladeTemperatureMax;
	}
	/**
	 * @return the bladeTemperatureMsg
	 */
	public String getBladeTemperatureMsg() {
		return bladeTemperatureMsg;
	}
	/**
	 * @param bladeTemperatureMsg the bladeTemperatureMsg to set
	 */
	public void setBladeTemperatureMsg(String bladeTemperatureMsg) {
		this.bladeTemperatureMsg = bladeTemperatureMsg;
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
