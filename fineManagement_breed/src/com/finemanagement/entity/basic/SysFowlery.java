/**
 * 项目名称：com.finemanagement.entity.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.entity.basic;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysFowlery extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; // id主键
	private String name; // 禽舍名称
	private String breedArea; // 禽舍面积
	private Integer baseid; // 基地
	private Integer ftype; // 类型
	private String createTime; // 创建时间
	private String remark; // 备注
	private String breeder; // 饲养员
	private String technician; // 技术员
	private String baseName;
	private String fowleryName;
	private String coordinate;// 地图坐标
	/**
	 * @return the coordinate
	 */
	public String getCoordinate() {
		return coordinate;
	}
	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}
	/**
	 * @param baseName the baseName to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	/**
	 * @return the fowleryName
	 */
	public String getFowleryName() {
		return fowleryName;
	}
	/**
	 * @param fowleryName the fowleryName to set
	 */
	public void setFowleryName(String fowleryName) {
		this.fowleryName = fowleryName;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the breedArea
	 */
	public String getBreedArea() {
		return breedArea;
	}
	/**
	 * @param breedArea the breedArea to set
	 */
	public void setBreedArea(String breedArea) {
		this.breedArea = breedArea;
	}
	/**
	 * @return the baseid
	 */
	public Integer getBaseid() {
		return baseid;
	}
	/**
	 * @param baseid the baseid to set
	 */
	public void setBaseid(Integer baseid) {
		this.baseid = baseid;
	}
	/**
	 * @return the ftype
	 */
	public Integer getFtype() {
		return ftype;
	}
	/**
	 * @param ftype the ftype to set
	 */
	public void setFtype(Integer ftype) {
		this.ftype = ftype;
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
	 * @return the breeder
	 */
	public String getBreeder() {
		return breeder;
	}
	/**
	 * @param breeder the breeder to set
	 */
	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}
	/**
	 * @return the technician
	 */
	public String getTechnician() {
		return technician;
	}
	/**
	 * @param technician the technician to set
	 */
	public void setTechnician(String technician) {
		this.technician = technician;
	}
	
}
