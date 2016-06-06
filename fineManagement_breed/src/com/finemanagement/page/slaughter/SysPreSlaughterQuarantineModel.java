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
public class SysPreSlaughterQuarantineModel extends AttachmentModel {

	private Integer id; // id主键
	private String quarantineBatch; // 检疫批次
	private String breedingBatch; // 养殖批次
	private String quarantineItem; // 检疫项目
	private String quarantineQuantity; // 检疫数量
	private Integer quarantineType; // 检疫类型
	private String quarantineInstitution; // 检疫机构
	private String quarantineOfficer; // 检疫人员
	private Integer quarantineResults; // 检疫结果
	private String quarantineTime; // 检疫时间
	private String createTime; // 创建时间
	private String remark; // 备注
	private String start_date;// 虚列
	private String end_date;// 虚列

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_end() {
		return end_date;
	}

	public void setEnd_end(String end_date) {
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
	 * @return the breedingBatch
	 */
	public String getBreedingBatch() {
		return breedingBatch;
	}

	/**
	 * @param breedingBatch
	 *            the breedingBatch to set
	 */
	public void setBreedingBatch(String breedingBatch) {
		this.breedingBatch = breedingBatch;
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

	/**
	 * @return the quarantineItem
	 */
	public String getQuarantineItem() {
		return quarantineItem;
	}

	/**
	 * @param quarantineItem
	 *            the quarantineItem to set
	 */
	public void setQuarantineItem(String quarantineItem) {
		this.quarantineItem = quarantineItem;
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
	 * @return the quarantineType
	 */
	public Integer getQuarantineType() {
		return quarantineType;
	}

	/**
	 * @param quarantineType
	 *            the quarantineType to set
	 */
	public void setQuarantineType(Integer quarantineType) {
		this.quarantineType = quarantineType;
	}

	/**
	 * @return the quarantineInstitution
	 */
	public String getQuarantineInstitution() {
		return quarantineInstitution;
	}

	/**
	 * @param quarantineInstitution
	 *            the quarantineInstitution to set
	 */
	public void setQuarantineInstitution(String quarantineInstitution) {
		this.quarantineInstitution = quarantineInstitution;
	}

	/**
	 * @return the quarantineOfficer
	 */
	public String getQuarantineOfficer() {
		return quarantineOfficer;
	}

	/**
	 * @param quarantineOfficer
	 *            the quarantineOfficer to set
	 */
	public void setQuarantineOfficer(String quarantineOfficer) {
		this.quarantineOfficer = quarantineOfficer;
	}

	/**
	 * @return the quarantineResults
	 */
	public Integer getQuarantineResults() {
		return quarantineResults;
	}

	/**
	 * @param quarantineResults
	 *            the quarantineResults to set
	 */
	public void setQuarantineResults(Integer quarantineResults) {
		this.quarantineResults = quarantineResults;
	}

	/**
	 * @return the quarantineTime
	 */
	public String getQuarantineTime() {
		return quarantineTime;
	}

	/**
	 * @param quarantineTime
	 *            the quarantineTime to set
	 */
	public void setQuarantineTime(String quarantineTime) {
		this.quarantineTime = quarantineTime;
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
}
