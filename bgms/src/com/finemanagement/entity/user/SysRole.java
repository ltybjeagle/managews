/**
 * 项目名称：com.finemanagement.entity.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.entity.user;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysRole extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8466847606583489705L;
	private Integer id; // id主键
	private String code; // 角色编码
	private String roleName; // 角色名称
	private java.sql.Timestamp createTime; // 创建时间
	private Integer createBy; // 创建人
	private java.sql.Timestamp updateTime; // 修改时间
	private Integer updateBy; // 修改人
	private Integer state; // 状态0=可用 1=禁用
	private String descr; // 角色描述
	private String sysid; // 系统标识
	private String sysname; // 系统名称
	private String stateName;
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the createTime
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the createBy
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * @return the updateTime
	 */
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the updateBy
	 */
	public Integer getUpdateBy() {
		return updateBy;
	}
	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the descr
	 */
	public String getDescr() {
		return descr;
	}
	/**
	 * @param descr the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
	/**
	 * @return the sysid
	 */
	public String getSysid() {
		return sysid;
	}
	/**
	 * @param sysid the sysid to set
	 */
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	/**
	 * @return the sysname
	 */
	public String getSysname() {
		return sysname;
	}
	/**
	 * @param sysname the sysname to set
	 */
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	
}
