/**
 * 项目名称：com.finemanagement.entity
 * 创建日期：2016-4-6
 *创建文件    by zhangyong
 */
package com.finemanagement.entity.pick;

import org.springframework.web.multipart.MultipartFile;

import com.base.entity.Attachment;

/**
 * 
 * @author zhangyong
 */
public class SysPick extends Attachment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -999053774129291146L;
	private Integer id;// 主键
	private int plantid;// 种植品种
	private int baseid;// 基地
	private int greehouseid;// 大棚
	private String requiredquantity;// 需求数量
	private String grade;// 等级
	private String completetime;// 完成时间
	private String releasetime;// 发布时间
	private String harvesttime;// 采收时间
	private String numberharvest;// 采收量
	private String unitprice;// 单价
	private String amt;// 价钱
	private Integer harveststaffer;
	private Integer inspectionstaffer;
	private String harveststaff;// 采 收人员
	private String inspectionstaff;// 验收人员
	private String remark;// 备注
	private String syssign;// 数据标志
	private String sysid;// 系统标准
	private String variety;// 种植产品名称
	private String greenhousename;// 大棚名称
	private String baseName;// 基地名称
	private String unitPrice;// 单价
	private String purchaseCount;// 总数
	private String startTime;// 统计时间
	private MultipartFile file;
    private String filePath;
    private String sysNo;
	/**
	 * @return the harveststaffer
	 */
	public Integer getHarveststaffer() {
		return harveststaffer;
	}

	/**
	 * @param harveststaffer the harveststaffer to set
	 */
	public void setHarveststaffer(Integer harveststaffer) {
		this.harveststaffer = harveststaffer;
	}

	/**
	 * @return the inspectionstaffer
	 */
	public Integer getInspectionstaffer() {
		return inspectionstaffer;
	}

	/**
	 * @param inspectionstaffer the inspectionstaffer to set
	 */
	public void setInspectionstaffer(Integer inspectionstaffer) {
		this.inspectionstaffer = inspectionstaffer;
	}

	/**
	 * @return the sysNo
	 */
	public String getSysNo() {
		return sysNo;
	}

	/**
	 * @param sysNo the sysNo to set
	 */
	public void setSysNo(String sysNo) {
		this.sysNo = sysNo;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(String purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPlantid() {
		return plantid;
	}

	public void setPlantid(int plantid) {
		this.plantid = plantid;
	}

	public int getBaseid() {
		return baseid;
	}

	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}

	public int getGreehouseid() {
		return greehouseid;
	}

	public void setGreehouseid(int greehouseid) {
		this.greehouseid = greehouseid;
	}

	public String getRequiredquantity() {
		return requiredquantity;
	}

	public void setRequiredquantity(String requiredquantity) {
		this.requiredquantity = requiredquantity;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCompletetime() {
		return completetime;
	}

	public void setCompletetime(String completetime) {
		this.completetime = completetime;
	}

	public String getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}

	public String getHarvesttime() {
		return harvesttime;
	}

	public void setHarvesttime(String harvesttime) {
		this.harvesttime = harvesttime;
	}

	public String getNumberharvest() {
		return numberharvest;
	}

	public void setNumberharvest(String numberharvest) {
		this.numberharvest = numberharvest;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getHarveststaff() {
		return harveststaff;
	}

	public void setHarveststaff(String harveststaff) {
		this.harveststaff = harveststaff;
	}

	public String getInspectionstaff() {
		return inspectionstaff;
	}

	public void setInspectionstaff(String inspectionstaff) {
		this.inspectionstaff = inspectionstaff;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSyssign() {
		return syssign;
	}

	public void setSyssign(String syssign) {
		this.syssign = syssign;
	}

	public String getSysid() {
		return sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getGreenhousename() {
		return greenhousename;
	}

	public void setGreenhousename(String greenhousename) {
		this.greenhousename = greenhousename;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

}
