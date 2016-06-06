package com.finemanagement.entity.iotapp;

import com.base.entity.BaseEntity;

public class SysMonitor extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3076538723628528642L;

	private String id;// 主键

	private String MonitorNum;// 传感器标识(硬件组定义)

	private String AirTemperature;// 空气温度

	private String AirHumidity;// 空气湿度

	private String PhotosyntheticRadiation;// 光合有效辐射

	private String SoilTemperature;// 土壤温度

	private String SoilHumidity;// 土壤湿度

	private String SoilEC;// 土壤EC值

	private String InfraredTemperature;// 红外线叶片温度

	private String DissolvedOxygenCon;// 溶解氧

	private String WaterPH;// PH值

	private String LightIntensity;// 光照强度

	private String RainFall;// 降雨量

	private String WindSpeed;// 风速

	private String WindDirection;// 风向

	private String DiameterWidth;//

	private String FruitSize;//

	private String ReceivedTime;// 采集时间

	private String IsScan;// 是否被扫描

	private String start_date;// 开始时间

	private String end_date;// 结束时间

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonitorNum() {
		return MonitorNum;
	}

	public void setMonitorNum(String monitorNum) {
		MonitorNum = monitorNum;
	}

	public String getAirTemperature() {
		return AirTemperature;
	}

	public void setAirTemperature(String airTemperature) {
		AirTemperature = airTemperature;
	}

	public String getAirHumidity() {
		return AirHumidity;
	}

	public void setAirHumidity(String airHumidity) {
		AirHumidity = airHumidity;
	}

	public String getPhotosyntheticRadiation() {
		return PhotosyntheticRadiation;
	}

	public void setPhotosyntheticRadiation(String photosyntheticRadiation) {
		PhotosyntheticRadiation = photosyntheticRadiation;
	}

	public String getSoilTemperature() {
		return SoilTemperature;
	}

	public void setSoilTemperature(String soilTemperature) {
		SoilTemperature = soilTemperature;
	}

	public String getSoilHumidity() {
		return SoilHumidity;
	}

	public void setSoilHumidity(String soilHumidity) {
		SoilHumidity = soilHumidity;
	}

	public String getSoilEC() {
		return SoilEC;
	}

	public void setSoilEC(String soilEC) {
		SoilEC = soilEC;
	}

	public String getInfraredTemperature() {
		return InfraredTemperature;
	}

	public void setInfraredTemperature(String infraredTemperature) {
		InfraredTemperature = infraredTemperature;
	}

	public String getDissolvedOxygenCon() {
		return DissolvedOxygenCon;
	}

	public void setDissolvedOxygenCon(String dissolvedOxygenCon) {
		DissolvedOxygenCon = dissolvedOxygenCon;
	}

	public String getWaterPH() {
		return WaterPH;
	}

	public void setWaterPH(String waterPH) {
		WaterPH = waterPH;
	}

	public String getLightIntensity() {
		return LightIntensity;
	}

	public void setLightIntensity(String lightIntensity) {
		LightIntensity = lightIntensity;
	}

	public String getRainFall() {
		return RainFall;
	}

	public void setRainFall(String rainFall) {
		RainFall = rainFall;
	}

	public String getWindSpeed() {
		return WindSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		WindSpeed = windSpeed;
	}

	public String getWindDirection() {
		return WindDirection;
	}

	public void setWindDirection(String windDirection) {
		WindDirection = windDirection;
	}

	public String getDiameterWidth() {
		return DiameterWidth;
	}

	public void setDiameterWidth(String diameterWidth) {
		DiameterWidth = diameterWidth;
	}

	public String getFruitSize() {
		return FruitSize;
	}

	public void setFruitSize(String fruitSize) {
		FruitSize = fruitSize;
	}

	public String getReceivedTime() {
		return ReceivedTime;
	}

	public void setReceivedTime(String receivedTime) {
		ReceivedTime = receivedTime;
	}

	public String getIsScan() {
		return IsScan;
	}

	public void setIsScan(String isScan) {
		IsScan = isScan;
	}

}
