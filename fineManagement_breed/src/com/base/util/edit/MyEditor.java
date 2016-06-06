/**
 * 项目名称：com.base.util.edit
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.base.util.edit;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

/**
 * 类型转换器
 * @author liutianyang
 */
public class MyEditor extends PropertyEditorSupport {

	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals(""))
			text = "0";
		if ( !StringUtils.hasText(text)) {
			setValue(null);
		} else {
			// 这句话是最重要的，他的目的是通过传入参数的类型来匹配相应的databind
			setValue(Integer.parseInt(text));
		}
	}
	
	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	public String getAsText() {
		return getValue().toString();
	}
}
