/**
 * 项目名称：com.base.page
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.base.page;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author liutianyang
 */
public class BasePage {

	private Integer page = 1;
	
	private Integer rows = 10;
	
	private String sort;
	
	private String order;
	
	private String sysid;
	
	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();
	
	public Pager getPager() {
		pager.setPageId(getPage());
		pager.setPageSize(getRows());
		String orderField = "";
		if (StringUtils.isNotBlank(sort)) {
			orderField = sort;
		}
		if (StringUtils.isNotBlank(orderField) && StringUtils.isNotBlank(order)) {
			orderField += " " + order;
		}
		pager.setOrderField(orderField);
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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
}
