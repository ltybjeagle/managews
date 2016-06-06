/**
 * 项目名称：com.finemanagement.entity.inputs
 * 创建日期：2016-3-28
 * 修改历史：
 *    1、[2016-3-28]创建文件    by liutianyang
 */
package com.finemanagement.entity.inputs;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysClassify extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4103474705270530419L;
	private Integer id; // id主键
	private String classname; // 分类名称
	private String sort; // 排序
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
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}
	/**
	 * @param classname the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
