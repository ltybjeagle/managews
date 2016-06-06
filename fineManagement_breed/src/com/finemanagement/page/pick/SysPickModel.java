/**
 * 项目名称：com.finemanagement.entity
 * 创建日期：2016-4-6
 *创建文件    by zhangyong
 */
package com.finemanagement.page.pick;

import com.base.page.BasePage;

/**
 * 
 * @author zhangyong
 */
public class SysPickModel extends BasePage {

	private Integer id;//主键
	private int plantid;//种植品种
	private int baseid;//基地
	private int greehouseid;//大棚
	private String requiredquantity;//需求数量
	private String grade;//等级
	private String completetime;//完成时间
	private String releasetime;//发布时间
	private String harvesttime;//采收时间
	private String numberharvest;//采收量
	private String unitprice;//单价
	private String amt;//价钱
	private String harveststaff;//采 收人员
	private String inspectionstaff;//验收人员
	private String remark;//备注
	private String syssign;//数据标志
	private String sysid;//系统标准
	private String startCompletetime; // 开始完成时间
	private String endCompletetime; // 结束完成时间
	private String startHarvesttime; // 开始采收时间
	private String endHarvesttime; // 结束采收时间
	/**
	 * @return the startHarvesttime
	 */
	public String getStartHarvesttime() {
		return startHarvesttime;
	}
	/**
	 * @param startHarvesttime the startHarvesttime to set
	 */
	public void setStartHarvesttime(String startHarvesttime) {
		this.startHarvesttime = startHarvesttime;
	}
	/**
	 * @return the endHarvesttime
	 */
	public String getEndHarvesttime() {
		return endHarvesttime;
	}
	/**
	 * @param endHarvesttime the endHarvesttime to set
	 */
	public void setEndHarvesttime(String endHarvesttime) {
		this.endHarvesttime = endHarvesttime;
	}
	/**
	 * @return the startCompletetime
	 */
	public String getStartCompletetime() {
		return startCompletetime;
	}
	/**
	 * @param startCompletetime the startCompletetime to set
	 */
	public void setStartCompletetime(String startCompletetime) {
		this.startCompletetime = startCompletetime;
	}
	/**
	 * @return the endCompletetime
	 */
	public String getEndCompletetime() {
		return endCompletetime;
	}
	/**
	 * @param endCompletetime the endCompletetime to set
	 */
	public void setEndCompletetime(String endCompletetime) {
		this.endCompletetime = endCompletetime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPlantid() {
		return plantid;
	}
	public void setPlantid(int plantid) {
		this.plantid = plantid;
	}
	public int getBaseid() {
		return baseid;
	}
	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}
	public int getGreehouseid() {
		return greehouseid;
	}
	public void setGreehouseid(int greehouseid) {
		this.greehouseid = greehouseid;
	}
	public String getRequiredquantity() {
		return requiredquantity;
	}
	public void setRequiredquantity(String requiredquantity) {
		this.requiredquantity = requiredquantity;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCompletetime() {
		return completetime;
	}
	public void setCompletetime(String completetime) {
		this.completetime = completetime;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public String getHarvesttime() {
		return harvesttime;
	}
	public void setHarvesttime(String harvesttime) {
		this.harvesttime = harvesttime;
	}
	public String getNumberharvest() {
		return numberharvest;
	}
	public void setNumberharvest(String numberharvest) {
		this.numberharvest = numberharvest;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getHarveststaff() {
		return harveststaff;
	}
	public void setHarveststaff(String harveststaff) {
		this.harveststaff = harveststaff;
	}
	public String getInspectionstaff() {
		return inspectionstaff;
	}
	public void setInspectionstaff(String inspectionstaff) {
		this.inspectionstaff = inspectionstaff;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSyssign() {
		return syssign;
	}
	public void setSyssign(String syssign) {
		this.syssign = syssign;
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	
	
}
