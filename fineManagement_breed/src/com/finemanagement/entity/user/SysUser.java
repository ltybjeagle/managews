/**
 * 项目名称：com.finemanagement.entity
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.finemanagement.entity.user;

import java.sql.Timestamp;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6694613921539187319L;
	private Integer id; // id主键
	private String code; // 登录帐号
	private String pwd; // 登录密码
	private String nickName; // 昵称
	private Integer state; // 状态 0=可用, 1=禁用
	private Integer loginCount; // 登录总次数
	private Timestamp loginTime; // 最后登录时间
	private Integer deleted; // 删除状态 0=未删除, 1=已删除
	private Timestamp createTime; // 创建时间
	private Timestamp updateTime; // 修改时间
	private Integer createBy; // 创建人
	private Integer updateBy; // 修改人
	private Integer superAdmin; // 超级管理员
	private String roleStr; // 用户权限, 按","区分
	private String sessionId;
	private String sysid;
	private String stateName;
	private String token;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
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
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
	public Timestamp getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Timestamp loginTime) {
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
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
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
	/**
	 * @return the superAdmin
	 */
	public Integer getSuperAdmin() {
		return superAdmin;
	}
	/**
	 * @param superAdmin the superAdmin to set
	 */
	public void setSuperAdmin(Integer superAdmin) {
		this.superAdmin = superAdmin;
	}
	/**
	 * @return the roleStr
	 */
	public String getRoleStr() {
		return roleStr;
	}
	/**
	 * @param roleStr the roleStr to set
	 */
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
	
}
