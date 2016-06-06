/**
 * 项目名称：com.finemanagement.page.purchase
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.page.production;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysTaskModel extends BasePage {

	private Integer id; // 任务ID
	private int greenhouseid; // 归属大棚
	private int baseid; // 归属基地
	private int taskid; // 工作类型
	private int plantationMember; // 种植员
	private int technician; // 技术员
	private String taskTime; // 开始时间
	private String taskContent; // 工走内容
	private String startTaskTime; // 开始工作时间
	private String endTaskTime; // 结束工作时间
	/**
	 * @return the startTaskTime
	 */
	public String getStartTaskTime() {
		return startTaskTime;
	}
	/**
	 * @param startTaskTime the startTaskTime to set
	 */
	public void setStartTaskTime(String startTaskTime) {
		this.startTaskTime = startTaskTime;
	}
	/**
	 * @return the endTaskTime
	 */
	public String getEndTaskTime() {
		return endTaskTime;
	}
	/**
	 * @param endTaskTime the endTaskTime to set
	 */
	public void setEndTaskTime(String endTaskTime) {
		this.endTaskTime = endTaskTime;
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
