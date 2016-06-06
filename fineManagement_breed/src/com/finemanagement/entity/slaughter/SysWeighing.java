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
public class SysWeighing extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5988486449940342724L;
	private Integer id; // id主键
	private Integer slaughterBatchId; // 屠宰批次ID
	private String slaughterType; // 屠宰类型
	private String weightNo; // 白条编号
	private String weight; // 重量
	private String weighedTime; // 称重时间
	private String remark; // 备注
	private String slaughterBatch; // 屠宰批次号
	private String createTime; // 创建时间
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
	 * @return the slaughterType
	 */
	public String getSlaughterType() {
		return slaughterType;
	}
	/**
	 * @param slaughterType the slaughterType to set
	 */
	public void setSlaughterType(String slaughterType) {
		this.slaughterType = slaughterType;
	}
	/**
	 * @return the weightNo
	 */
	public String getWeightNo() {
		return weightNo;
	}
	/**
	 * @param weightNo the weightNo to set
	 */
	public void setWeightNo(String weightNo) {
		this.weightNo = weightNo;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return the weighedTime
	 */
	public String getWeighedTime() {
		return weighedTime;
	}
	/**
	 * @param weighedTime the weighedTime to set
	 */
	public void setWeighedTime(String weighedTime) {
		this.weighedTime = weighedTime;
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
}
