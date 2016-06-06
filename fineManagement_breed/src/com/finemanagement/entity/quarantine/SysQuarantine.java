package com.finemanagement.entity.quarantine;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.base.entity.Attachment;

public class SysQuarantine extends Attachment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2102163224231845368L;
    private Integer id;//主键
    private String uuid;
    private String quarantineofficers;//检疫人员
    private String quarantineitems;//检疫项目
    private String quarantineResults;//检疫人员
    private String quarantinetime;//检疫时间
    private String remark;//备注
    private String batchprocessing; //加工批次
    private String quarantineBatch; // 检疫批次
    private String createTime; // 创建时间
    private String pbatch;
    private MultipartFile file;
    private String filePath;
    List<SysQuarantine> list;
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the list
	 */
	public List<SysQuarantine> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<SysQuarantine> list) {
		this.list = list;
	}

	/**
	 * @return the pbatch
	 */
	public String getPbatch() {
		return pbatch;
	}

	/**
	 * @param pbatch the pbatch to set
	 */
	public void setPbatch(String pbatch) {
		this.pbatch = pbatch;
	}

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
