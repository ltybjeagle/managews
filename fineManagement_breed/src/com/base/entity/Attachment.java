/**
 * 项目名称：com.base.entity
 * 创建日期：2016-5-15
 * 修改历史：
 *    1、[2016-5-15]创建文件    by liutianyang
 */
package com.base.entity;

/**
 * 
 * @author liutianyang
 */
public class Attachment extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196829497291397708L;
	private String ID;
	private String RelationID;
	private String RelationNO;
	private String FileName;
	private String Url;
	private String TableName;
	private String CreateTime;
	/**
	 * @return the relationNO
	 */
	public String getRelationNO() {
		return RelationNO;
	}
	/**
	 * @param relationNO the relationNO to set
	 */
	public void setRelationNO(String relationNO) {
		RelationNO = relationNO;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the relationID
	 */
	public String getRelationID() {
		return RelationID;
	}
	/**
	 * @param relationID the relationID to set
	 */
	public void setRelationID(String relationID) {
		RelationID = relationID;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return FileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return Url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		Url = url;
	}
	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return TableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		TableName = tableName;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return CreateTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	
}
