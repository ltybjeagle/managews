package com.finemanagement.entity.iotapp;

import com.base.entity.BaseEntity;

public class SysMonitorInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1175575933184175317L;

	private String id;

	private String MonitorNum;

	private String Name;

	private String MonitorType;

	private String BlockID;

	private String IsDelete;

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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMonitorType() {
		return MonitorType;
	}

	public void setMonitorType(String monitorType) {
		MonitorType = monitorType;
	}

	public String getBlockID() {
		return BlockID;
	}

	public void setBlockID(String blockID) {
		BlockID = blockID;
	}

	public String getIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(String isDelete) {
		IsDelete = isDelete;
	}

}
