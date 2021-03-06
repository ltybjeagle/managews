/**
 * 项目名称：com.finemanagement.entity.production
 * 创建日期：2016-4-16
 * 修改历史：
 *    1、[2016-4-16]创建文件    by liutianyang
 */
package com.finemanagement.entity.production;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.base.entity.Attachment;

/**
 * 
 * @author liutianyang
 */
public class SysCattleSlaughter extends Attachment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1573275096927960051L;
	private Integer id; // id主键
	private String uuid;
	private int fowleryid; // 归属禽舍
	private int baseid; // 归属基地
	private int breedid; // 养殖产品
	private String count; // 出栏数量
	private String cattleLevel; // 等级
	private String unitPrice; // 单价
	private String charge; // 责任人
	private String verification; // 验证人
	private String cattleTime; // 出栏时间
	private String remark; // 备注
	private String breedName;
	private MultipartFile file;
    private String filePath;
    List<SysCattleSlaughter> list;
	/**
	 * @return the list
	 */
	public List<SysCattleSlaughter> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<SysCattleSlaughter> list) {
		this.list = list;
	}
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
	 * @return the breedName
	 */
	public String getBreedName() {
		return breedName;
	}
	/**
	 * @param breedName the breedName to set
	 */
	public void setBreedName(String breedName) {
		this.breedName = breedName;
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
	 * @return the fowleryid
	 */
	public int getFowleryid() {
		return fowleryid;
	}
	/**
	 * @param fowleryid the fowleryid to set
	 */
	public void setFowleryid(int fowleryid) {
		this.fowleryid = fowleryid;
	}
	/**
	 * @return the baseid
	 */
	public int getBaseid() {
		return baseid;
	}
	/**
	 * @param baseid the baseid to set
	 */
	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}
	/**
	 * @return the breedid
	 */
	public int getBreedid() {
		return breedid;
	}
	/**
	 * @param breedid the breedid to set
	 */
	public void setBreedid(int breedid) {
		this.breedid = breedid;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * @return the cattleLevel
	 */
	public String getCattleLevel() {
		return cattleLevel;
	}
	/**
	 * @param cattleLevel the cattleLevel to set
	 */
	public void setCattleLevel(String cattleLevel) {
		this.cattleLevel = cattleLevel;
	}
	/**
	 * @return the unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the charge
	 */
	public String getCharge() {
		return charge;
	}
	/**
	 * @param charge the charge to set
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	/**
	 * @return the verification
	 */
	public String getVerification() {
		return verification;
	}
	/**
	 * @param verification the verification to set
	 */
	public void setVerification(String verification) {
		this.verification = verification;
	}
	/**
	 * @return the cattleTime
	 */
	public String getCattleTime() {
		return cattleTime;
	}
	/**
	 * @param cattleTime the cattleTime to set
	 */
	public void setCattleTime(String cattleTime) {
		this.cattleTime = cattleTime;
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
