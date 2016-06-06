/**
 * 项目名称：com.finemanagement.entity.user
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.entity.user;

import com.base.entity.BaseEntity;

/**
 * 
 * @author liutianyang
 */
public class SysRoleRel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8168105167156124970L;
	private Integer roleId; // 角色主键 sys_role.id
	private Integer objId; // 关联主键 type=0管理sys_menu.id, type=1关联sys_user.id
	private Integer relType; // 关联类型 0=菜单,1=用户
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the objId
	 */
	public Integer getObjId() {
		return objId;
	}
	/**
	 * @param objId the objId to set
	 */
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	/**
	 * @return the relType
	 */
	public Integer getRelType() {
		return relType;
	}
	/**
	 * @param relType the relType to set
	 */
	public void setRelType(Integer relType) {
		this.relType = relType;
	}
	/**
	 * 枚举
	 */
	public static enum RelType {
		MENU(0, "菜单"), USER(1, "用户"), BTN(2, "按钮");
		public int key;
		public String value;
		private RelType(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public static RelType get(int key) {
			RelType[] values = RelType.values();
			for (RelType object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}
}
