/**
 * 项目名称：com.base.util.json
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.base.util.json;

import org.json.JSONString;

/**
 * 
 * @author liutianyang
 */
public class JSONStringObject implements JSONString {

	private String jsonString = null;
	
	public JSONStringObject(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public String toString() {
        return jsonString;
    }

    public String toJSONString() {
        return jsonString;
    }

}
