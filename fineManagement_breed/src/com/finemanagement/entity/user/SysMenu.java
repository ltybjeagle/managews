/**
 * 项目名称：com.finemanagement.entity.user
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.finemanagement.entity.user;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysMenu extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1873707582940437217L;
	private Integer id; // 主键
	private String name; // 菜单名称
	private String url; // 系统url
	private Integer parentId; // 父id 关联sys_menu.id
	private Integer deleted; // 是否删除,0=未删除，1=已删除
	private java.sql.Timestamp createTime; // 创建时间
	private java.sql.Timestamp updateTime; // 修改时间
	private Integer rank; // 排序
	private String actions; // 注册Action 按钮|分隔
	private int subCount; // 子菜单总数
	private int levelno;
	private int isleaf;
	/**
	 * @return the levelno
	 */
	public int getLevelno() {
		return levelno;
	}
	/**
	 * @param levelno the levelno to set
	 */
	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
	/**
	 * @return the isleaf
	 */
	public int getIsleaf() {
		return isleaf;
	}
	/**
	 * @param isleaf the isleaf to set
	 */
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
	 * @return the rank
	 */
	public Integer getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	/**
	 * @return the actions
	 */
	public String getActions() {
		return actions;
	}
	/**
	 * @param actions the actions to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}
	/**
	 * @return the subCount
	 */
	public int getSubCount() {
		return subCount;
	}
	/**
	 * @param subCount the subCount to set
	 */
	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}
}
