/**
 * 项目名称：com.finemanagement.page.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.page.slaughter;

import com.base.page.AttachmentModel;

/**
 * 
 * @author liutianyang
 */
public class SysSlaughterModel extends AttachmentModel {

	private Integer id; // id主键
	private String slaughterBatch; // 屠宰批次
	private String quarantineBatchId; // 检疫批次ID
	private String quarantineQuantity; // 检疫数量
	private String slaughterPersonnel; // 屠宰人员
	private String slaughterQuantity; // 屠宰数量
	private String slaughterTime; // 屠宰时间
	private String remark; // 备注
	private String createTime; // 创建时间
	private String quarantineBatch; // 检疫批次
	private String start_date;
	private String end_date;

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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the slaughterBatch
	 */
	public String getSlaughterBatch() {
		return slaughterBatch;
	}

	/**
	 * @param slaughterBatch
	 *            the slaughterBatch to set
	 */
	public void setSlaughterBatch(String slaughterBatch) {
		this.slaughterBatch = slaughterBatch;
	}

	/**
	 * @return the quarantineBatchId
	 */
	public String getQuarantineBatchId() {
		return quarantineBatchId;
	}

	/**
	 * @param quarantineBatchId
	 *            the quarantineBatchId to set
	 */
	public void setQuarantineBatchId(String quarantineBatchId) {
		this.quarantineBatchId = quarantineBatchId;
	}

	/**
	 * @return the quarantineQuantity
	 */
	public String getQuarantineQuantity() {
		return quarantineQuantity;
	}

	/**
	 * @param quarantineQuantity
	 *            the quarantineQuantity to set
	 */
	public void setQuarantineQuantity(String quarantineQuantity) {
		this.quarantineQuantity = quarantineQuantity;
	}

	/**
	 * @return the slaughterPersonnel
	 */
	public String getSlaughterPersonnel() {
		return slaughterPersonnel;
	}

	/**
	 * @param slaughterPersonnel
	 *            the slaughterPersonnel to set
	 */
	public void setSlaughterPersonnel(String slaughterPersonnel) {
		this.slaughterPersonnel = slaughterPersonnel;
	}

	/**
	 * @return the slaughterQuantity
	 */
	public String getSlaughterQuantity() {
		return slaughterQuantity;
	}

	/**
	 * @param slaughterQuantity
	 *            the slaughterQuantity to set
	 */
	public void setSlaughterQuantity(String slaughterQuantity) {
		this.slaughterQuantity = slaughterQuantity;
	}

	/**
	 * @return the slaughterTime
	 */
	public String getSlaughterTime() {
		return slaughterTime;
	}

	/**
	 * @param slaughterTime
	 *            the slaughterTime to set
	 */
	public void setSlaughterTime(String slaughterTime) {
		this.slaughterTime = slaughterTime;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the quarantineBatch
	 */
	public String getQuarantineBatch() {
		return quarantineBatch;
	}

	/**
	 * @param quarantineBatch
	 *            the quarantineBatch to set
	 */
	public void setQuarantineBatch(String quarantineBatch) {
		this.quarantineBatch = quarantineBatch;
	}
}
