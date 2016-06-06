/**
 * 项目名称：com.finemanagement.page.production
 * 创建日期：2016-4-16
 * 修改历史：
 *    1、[2016-4-16]创建文件    by liutianyang
 */
package com.finemanagement.page.production;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysCattleSlaughterModel extends BasePage {

	private Integer id; // id主键
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
