package com.finemanagement.page.samping;

import com.base.page.BasePage;

public class SysSampingModel extends BasePage {
	private Integer id;//主键
	private int baseid;//基地
	private int greenhouseid;//大棚
	private String samplingpeople;//抽样人
	private String sampleno;//样品编号
	private String sampname;//样品名称
	private String samplingcount;//抽样数量
	private String samplingtime;//抽样时间
	private String remark;//
	private String sysid;//
	private String createTime; // 创建时间
	private String startSamplingtime;
	private String endSamplingtime;
	/**
	 * @return the startSamplingtime
	 */
	public String getStartSamplingtime() {
		return startSamplingtime;
	}
	/**
	 * @param startSamplingtime the startSamplingtime to set
	 */
	public void setStartSamplingtime(String startSamplingtime) {
		this.startSamplingtime = startSamplingtime;
	}
	/**
	 * @return the endSamplingtime
	 */
	public String getEndSamplingtime() {
		return endSamplingtime;
	}
	/**
	 * @param endSamplingtime the endSamplingtime to set
	 */
	public void setEndSamplingtime(String endSamplingtime) {
		this.endSamplingtime = endSamplingtime;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getBaseid() {
		return baseid;
	}
	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}
	
	public int getGreenhouseid() {
		return greenhouseid;
	}
	public void setGreenhouseid(int greenhouseid) {
		this.greenhouseid = greenhouseid;
	}
	public String getSamplingpeople() {
		return samplingpeople;
	}
	public void setSamplingpeople(String samplingpeople) {
		this.samplingpeople = samplingpeople;
	}
	public String getSampleno() {
		return sampleno;
	}
	public void setSampleno(String sampleno) {
		this.sampleno = sampleno;
	}
	public String getSampname() {
		return sampname;
	}
	public void setSampname(String sampname) {
		this.sampname = sampname;
	}
	public String getSamplingcount() {
		return samplingcount;
	}
	public void setSamplingcount(String samplingcount) {
		this.samplingcount = samplingcount;
	}
	public String getSamplingtime() {
		return samplingtime;
	}
	public void setSamplingtime(String samplingtime) {
		this.samplingtime = samplingtime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	
}
