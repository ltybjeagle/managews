/**
 * 项目名称：com.finemanagement.entity.slaughter
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
 */
package com.finemanagement.entity.slaughter;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysAcid extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4712760727989161688L;
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
	private Integer id; // id主键
	private String acidBatch; // 排酸批次号
	private Integer slaughterBatchId; // 屠宰批次ID
	private String slaughterQuantity; // 屠宰数量
	private String acidNo; // 排酸数量
	private String principal; // 负责人
	private String startTime; // 开始时间
	private String endTime; // 结束时间
	private String remark; // 备注
	private String slaughterBatch; // 屠宰批次号
	private String createTime; // 创建时间
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
	 * @return the acidBatch
	 */
	public String getAcidBatch() {
		return acidBatch;
	}
	/**
	 * @param acidBatch the acidBatch to set
	 */
	public void setAcidBatch(String acidBatch) {
		this.acidBatch = acidBatch;
	}
	/**
	 * @return the slaughterBatchId
	 */
	public Integer getSlaughterBatchId() {
		return slaughterBatchId;
	}
	/**
	 * @param slaughterBatchId the slaughterBatchId to set
	 */
	public void setSlaughterBatchId(Integer slaughterBatchId) {
		this.slaughterBatchId = slaughterBatchId;
	}
	/**
	 * @return the slaughterQuantity
	 */
	public String getSlaughterQuantity() {
		return slaughterQuantity;
	}
	/**
	 * @param slaughterQuantity the slaughterQuantity to set
	 */
	public void setSlaughterQuantity(String slaughterQuantity) {
		this.slaughterQuantity = slaughterQuantity;
	}
	/**
	 * @return the acidNo
	 */
	public String getAcidNo() {
		return acidNo;
	}
	/**
	 * @param acidNo the acidNo to set
	 */
	public void setAcidNo(String acidNo) {
		this.acidNo = acidNo;
	}
	/**
	 * @return the principal
	 */
	public String getPrincipal() {
		return principal;
	}
	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the slaughterBatch
	 */
	public String getSlaughterBatch() {
		return slaughterBatch;
	}
	/**
	 * @param slaughterBatch the slaughterBatch to set
	 */
	public void setSlaughterBatch(String slaughterBatch) {
		this.slaughterBatch = slaughterBatch;
	}

}
