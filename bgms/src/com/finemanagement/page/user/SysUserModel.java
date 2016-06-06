/**
 * 项目名称：com.finemanagement.page.user
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.finemanagement.page.user;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysUserModel extends BasePage {

	private Integer id; // id主键
	private String code; // 登录帐号
	private String pwd; // 登录密码
	private String nickName; // 昵称
	private Integer state; // 状态 0=可用,1=禁用
	private Integer loginCount; // 登录总次数
	private java.sql.Timestamp loginTime; // 最后登录时间
	private Integer deleted; // 删除状态 0=未删除,1=已删除
	private java.sql.Timestamp createTime; // 创建时间
	private java.sql.Timestamp updateTime; // 修改时间
	private Integer createBy; // 创建人
	private Integer updateBy; // 修改人
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
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	 * @return the loginCount
	 */
	public Integer getLoginCount() {
		return loginCount;
	}
	/**
	 * @param loginCount the loginCount to set
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	/**
	 * @return the loginTime
	 */
	public java.sql.Timestamp getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(java.sql.Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the deleted
	 */
	public Integer getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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
	
}
