/**
 * 项目名称：com.finemanagement.page.common
 * 创建日期：2016-6-12
 * 修改历史：
 *    1、[2016-6-12]创建文件    by liutianyang
 */
package com.finemanagement.page.common;

import com.base.page.BasePage;

/**
 * 
 * @author liutianyang
 */
public class SysNumberRulesModel extends BasePage {

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
