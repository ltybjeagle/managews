/**
 * 项目名称：com.finemanagement.entity.basic
 * 创建日期：2016-5-29
 * 修改历史：
 *    1、[2016-5-29]创建文件    by liutianyang
 */
package com.finemanagement.entity.basic;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysEmployees extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3578532412388798114L;
	private Integer id; // id主键
	private String employeeCode; // 用户编码
	private String employeeName; // 用户名称
	private String phone; // 联系方式
	private String department; // 部门
	private String remark; // 备注
	private String sysid;
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
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
