package com.finemanagement.entity.iot;

import com.base.entity.BaseEntity;

public class SysVideoConfig extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -210070006220558044L;

	private String id;// 主键id
	private String MatrixCode; // 云台矩阵编码
	private String MonitorID; // 云台矩阵 ID
	private String CameraID;// 监控点在 8800 平台数据库中生成的唯一 id
	private String CameraName;// 监控点名称
	private String DeviceIP;// ehome(单兵)设备时为 Pag（设备代理服务器）的 Ip 地址
	private String DevicePort;// 预览设备 Port 号
	private String DeviceType;// 设备类型
	private String Username;// 设备登录用户名
	private String Password;// 设备登录密码
	private String ChannelNum;// 播放通道号
	private String ProtocolType;// 协议类型，0 – TCP， 1 – UDP
	private String StreamType;// 码流类型，0 表示主码流， 1 表示子码流
	private String SrvIp;// 流媒体 IP 地址
	private String Port;// 流媒体端口号
	private String CameraIndexCode;// 监控点在 8800 平台数据库中生成的唯一编号
	private String RegionIndexCode;// 监控点所属区域在 8800 平台数据库中生成的唯一编号
	private String PagIP;// 流媒体 IP 地址
	private String PagPort;// 流媒体 IP 地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatrixCode() {
		return MatrixCode;
	}

	public void setMatrixCode(String matrixCode) {
		MatrixCode = matrixCode;
	}

	public String getMonitorID() {
		return MonitorID;
	}

	public void setMonitorID(String monitorID) {
		MonitorID = monitorID;
	}

	public String getCameraID() {
		return CameraID;
	}

	public void setCameraID(String cameraID) {
		CameraID = cameraID;
	}

	public String getCameraName() {
		return CameraName;
	}

	public void setCameraName(String cameraName) {
		CameraName = cameraName;
	}

	public String getDeviceIP() {
		return DeviceIP;
	}

	public void setDeviceIP(String deviceIP) {
		DeviceIP = deviceIP;
	}

	public String getDevicePort() {
		return DevicePort;
	}

	public void setDevicePort(String devicePort) {
		DevicePort = devicePort;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getUser() {
		return Username;
	}

	public void setUser(String user) {
		Username = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getChannelNum() {
		return ChannelNum;
	}

	public void setChannelNum(String channelNum) {
		ChannelNum = channelNum;
	}

	public String getProtocolType() {
		return ProtocolType;
	}

	public void setProtocolType(String protocolType) {
		ProtocolType = protocolType;
	}

	public String getStreamType() {
		return StreamType;
	}

	public void setStreamType(String streamType) {
		StreamType = streamType;
	}

	public String getSrvIp() {
		return SrvIp;
	}

	public void setSrvIp(String srvIp) {
		SrvIp = srvIp;
	}

	public String getPort() {
		return Port;
	}

	public void setPort(String port) {
		Port = port;
	}

	public String getCameraIndexCode() {
		return CameraIndexCode;
	}

	public void setCameraIndexCode(String cameraIndexCode) {
		CameraIndexCode = cameraIndexCode;
	}

	public String getRegionIndexCode() {
		return RegionIndexCode;
	}

	public void setRegionIndexCode(String regionIndexCode) {
		RegionIndexCode = regionIndexCode;
	}

	public String getPagIP() {
		return PagIP;
	}

	public void setPagIP(String pagIP) {
		PagIP = pagIP;
	}

	public String getPagPort() {
		return PagPort;
	}

	public void setPagPort(String pagPort) {
		PagPort = pagPort;
	}

}
