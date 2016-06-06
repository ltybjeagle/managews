package com.finemanagement.page.puarantine;

import com.base.page.BasePage;

public class SysQuarantineModel extends BasePage{
	

    private Integer id;//主键
    
    private String quarantineofficers;//检疫人员
    
    private String quarantineitems;//检疫项目
    
    private String quarantineResults;//检疫结果
    
    private String quarantinetime;//检疫时间
    
    private String remark;//备注
    
    private String batchprocessing; //加工批次
    private String quarantineBatch; // 检疫批次
    private String createTime; // 创建时间

	/**
	 * @return the quarantineBatch
	 */
	public String getQuarantineBatch() {
		return quarantineBatch;
	}

	/**
	 * @param quarantineBatch the quarantineBatch to set
	 */
	public void setQuarantineBatch(String quarantineBatch) {
		this.quarantineBatch = quarantineBatch;
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

	public String getQuarantineofficers() {
		return quarantineofficers;
	}

	public void setQuarantineofficers(String quarantineofficers) {
		this.quarantineofficers = quarantineofficers;
	}

	public String getQuarantineitems() {
		return quarantineitems;
	}

	public void setQuarantineitems(String quarantineitems) {
		this.quarantineitems = quarantineitems;
	}

	public String getQuarantineResults() {
		return quarantineResults;
	}

	public void setQuarantineResults(String quarantineResults) {
		this.quarantineResults = quarantineResults;
	}

	public String getQuarantinetime() {
		return quarantinetime;
	}

	public void setQuarantinetime(String quarantinetime) {
		this.quarantinetime = quarantinetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBatchprocessing() {
		return batchprocessing;
	}

	public void setBatchprocessing(String batchprocessing) {
		this.batchprocessing = batchprocessing;
	}
    
    

}
