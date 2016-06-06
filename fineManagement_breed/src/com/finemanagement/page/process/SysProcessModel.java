package com.finemanagement.page.process;

import com.base.page.BasePage;

public class SysProcessModel extends BasePage {
	private Integer id;// 主键
	private String slaughterbatch;// 屠宰批次
	private String numberslaughter;// 屠宰数量
	private String processname;// 加工产品名称
	private String processtime;// 加工时间
	private String processingstaff;// 加工人员
	private String is_completed;// 是否完成分割
	private String remark;// 备注
	private String createTime; // 创建时间
	private String batchprocessing;// 加工批次
	private String end_date;
	private String start_date;

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the batchprocessing
	 */
	public String getBatchprocessing() {
		return batchprocessing;
	}

	/**
	 * @param batchprocessing
	 *            the batchprocessing to set
	 */
	public void setBatchprocessing(String batchprocessing) {
		this.batchprocessing = batchprocessing;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlaughterbatch() {
		return slaughterbatch;
	}

	public void setSlaughterbatch(String slaughterbatch) {
		this.slaughterbatch = slaughterbatch;
	}

	public String getNumberslaughter() {
		return numberslaughter;
	}

	public void setNumberslaughter(String numberslaughter) {
		this.numberslaughter = numberslaughter;
	}

	public String getProcessname() {
		return processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public String getProcesstime() {
		return processtime;
	}

	public void setProcesstime(String processtime) {
		this.processtime = processtime;
	}

	public String getProcessingstaff() {
		return processingstaff;
	}

	public void setProcessingstaff(String processingstaff) {
		this.processingstaff = processingstaff;
	}

	public String getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(String is_completed) {
		this.is_completed = is_completed;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
