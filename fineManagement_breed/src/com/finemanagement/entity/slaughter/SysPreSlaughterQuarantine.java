/**
 * 项目名称：com.finemanagement.entity.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.entity.slaughter;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.base.entity.Attachment;

/**
 * 
 * @author liutianyang
 */
public class SysPreSlaughterQuarantine extends Attachment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8141609051776060127L;
	private Integer id; // id主键
	private String uuid;
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
	private MultipartFile file;
    private String filePath;
    List<SysPreSlaughterQuarantine> list;
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
	public List<SysPreSlaughterQuarantine> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<SysPreSlaughterQuarantine> list) {
		this.list = list;
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
	 * @return the breedingBatch
	 */
	public String getBreedingBatch() {
		return breedingBatch;
	}
	/**
	 * @param breedingBatch the breedingBatch to set
	 */
	public void setBreedingBatch(String breedingBatch) {
		this.breedingBatch = breedingBatch;
	}
	/**
	 * @return the quarantineItem
	 */
	public String getQuarantineItem() {
		return quarantineItem;
	}
	/**
	 * @param quarantineItem the quarantineItem to set
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
	 * @param quarantineQuantity the quarantineQuantity to set
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
	 * @param quarantineType the quarantineType to set
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
	 * @param quarantineInstitution the quarantineInstitution to set
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
	 * @param quarantineOfficer the quarantineOfficer to set
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
	 * @param quarantineResults the quarantineResults to set
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
	 * @param quarantineTime the quarantineTime to set
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
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
