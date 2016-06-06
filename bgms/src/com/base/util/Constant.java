/**
 * 项目名称：com.base.util
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.base.util;

/**
 * 
 * @author liutianyang
 */
public class Constant {

	/**
	 * 超级管理员常量
	 */
	public static enum SuperAdmin {
		NO(0, "否"), YES(1, "是");
		public int key;
		public String value;
		private SuperAdmin(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public static SuperAdmin get(int key) {
			SuperAdmin[] values = SuperAdmin.values();
			for (SuperAdmin object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}
}
