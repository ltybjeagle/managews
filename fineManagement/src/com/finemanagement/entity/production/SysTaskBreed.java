/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-4-11
 * 修改历史：
 *    1、[2016-4-11]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysTaskBreed extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2198390533281016018L;
	private Integer id; // 任务ID
	private int fowleryid; // 归属禽舍
	private int baseid; // 归属基地
	private int taskid; // 工作类型
	private int breeder; // 种植员
	private int breedTechnician; // 技术员
	private String taskTime; // 开始时间
	private String taskContent; // 工走内容
	private String breederName;
	private String breedTechnicianName;
	private String taskName;
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
	 * @return the fowleryid
	 */
	public int getFowleryid() {
		return fowleryid;
	}
	/**
	 * @param fowleryid the fowleryid to set
	 */
	public void setFowleryid(int fowleryid) {
		this.fowleryid = fowleryid;
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
	 * @return the breeder
	 */
	public int getBreeder() {
		return breeder;
	}
	/**
	 * @param breeder the breeder to set
	 */
	public void setBreeder(int breeder) {
		this.breeder = breeder;
	}
	/**
	 * @return the breedTechnician
	 */
	public int getBreedTechnician() {
		return breedTechnician;
	}
	/**
	 * @param breedTechnician the breedTechnician to set
	 */
	public void setBreedTechnician(int breedTechnician) {
		this.breedTechnician = breedTechnician;
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
	/**
	 * @return the breederName
	 */
	public String getBreederName() {
		return breederName;
	}
	/**
	 * @param breederName the breederName to set
	 */
	public void setBreederName(String breederName) {
		this.breederName = breederName;
	}
	/**
	 * @return the breedTechnicianName
	 */
	public String getBreedTechnicianName() {
		return breedTechnicianName;
	}
	/**
	 * @param breedTechnicianName the breedTechnicianName to set
	 */
	public void setBreedTechnicianName(String breedTechnicianName) {
		this.breedTechnicianName = breedTechnicianName;
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
}
