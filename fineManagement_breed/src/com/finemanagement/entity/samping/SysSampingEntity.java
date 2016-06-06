package com.finemanagement.entity.samping;

import org.springframework.web.multipart.MultipartFile;

import com.base.entity.Attachment;

public class SysSampingEntity extends Attachment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4099112798363145069L;
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
	private String baseName;
    private String greenhousename;
    private String createTime; // 创建时间
    private String variety;
    private MultipartFile file;
    private String filePath;
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
	 * @return the variety
	 */
	public String getVariety() {
		return variety;
	}
	/**
	 * @param variety the variety to set
	 */
	public void setVariety(String variety) {
		this.variety = variety;
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
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getGreenhousename() {
		return greenhousename;
	}
	public void setGreenhousename(String greenhousename) {
		this.greenhousename = greenhousename;
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
