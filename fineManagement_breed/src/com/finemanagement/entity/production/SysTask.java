/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysTask extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1584265469902590150L;
	private Integer id; // 任务ID
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
	private int taskid; // 工作类型
	private int plantationMember; // 种植员
	private int technician; // 技术员
	private String taskTime; // 开始时间
	private String taskContent; // 工走内容
	private String plantationMemberName;
	private String technicianName;
	private String taskName;
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
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the plantationMemberName
	 */
	public String getPlantationMemberName() {
		return plantationMemberName;
	}
	/**
	 * @param plantationMemberName the plantationMemberName to set
	 */
	public void setPlantationMemberName(String plantationMemberName) {
		this.plantationMemberName = plantationMemberName;
	}
	/**
	 * @return the technicianName
	 */
	public String getTechnicianName() {
		return technicianName;
	}
	/**
	 * @param technicianName the technicianName to set
	 */
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
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
	 * @return the taskid
	 */
	public int getTaskid() {
		return taskid;
	}
	/**
	 * @param taskid the taskid to set
	 */
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	/**
	 * @return the plantationMember
	 */
	public int getPlantationMember() {
		return plantationMember;
	}
	/**
	 * @param plantationMember the plantationMember to set
	 */
	public void setPlantationMember(int plantationMember) {
		this.plantationMember = plantationMember;
	}
	/**
	 * @return the technician
	 */
	public int getTechnician() {
		return technician;
	}
	/**
	 * @param technician the technician to set
	 */
	public void setTechnician(int technician) {
		this.technician = technician;
	}
	/**
	 * @return the taskTime
	 */
	public String getTaskTime() {
		return taskTime;
	}
	/**
	 * @param taskTime the taskTime to set
	 */
	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}
	/**
	 * @return the taskContent
	 */
	public String getTaskContent() {
		return taskContent;
	}
	/**
	 * @param taskContent the taskContent to set
	 */
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
}
