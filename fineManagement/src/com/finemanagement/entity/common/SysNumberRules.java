/**
 * 项目名称：com.finemanagement.entity.common
 * 创建日期：2016-6-12
 * 修改历史：
 *    1、[2016-6-12]创建文件    by liutianyang
 */
package com.finemanagement.entity.common;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysNumberRules extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4616207615335321014L;
	private String ruleIden;
	private int ruleNum;
	/**
	 * @return the ruleIden
	 */
	public String getRuleIden() {
		return ruleIden;
	}
	/**
	 * @param ruleIden the ruleIden to set
	 */
	public void setRuleIden(String ruleIden) {
		this.ruleIden = ruleIden;
	}
	/**
	 * @return the ruleNum
	 */
	public int getRuleNum() {
		return ruleNum;
	}
	/**
	 * @param ruleNum the ruleNum to set
	 */
	public void setRuleNum(int ruleNum) {
		this.ruleNum = ruleNum;
	}
}
