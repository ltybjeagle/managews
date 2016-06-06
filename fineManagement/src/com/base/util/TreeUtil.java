/**
 * 项目名称：com.base.util
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.base.util;

import java.util.ArrayList;
import java.util.List;

import com.base.entity.TreeNode;
import com.finemanagement.entity.user.SysMenu;

/**
 * 
 * @author liutianyang
 */
public class TreeUtil {

	private final static String MENU_ID = "menu_";
	
	List<SysMenu> rootMenus;
	List<SysMenu> childMenus;
	List<SysMenu> finalMenus;
	
	public TreeUtil(List<SysMenu> rootMenus, List<SysMenu> childMenus, List<SysMenu> finalMenus) {
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
		this.finalMenus = finalMenus;
	}  
	
	public List<TreeNode> getTreeNode(){
		return getRootNodes();
	}
	
	/**
	 * @param menu
	 * @return
	 */
	private TreeNode MenuToNode(SysMenu menu) {
		if (menu == null) {
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(MENU_ID + menu.getId());
		node.setDataId(menu.getId());
		node.setText(menu.getName());
		node.setUrl(menu.getUrl());
		node.setParentId(menu.getParentId());
		node.getAttributes().put("type", "0");
		node.getAttributes().put("id", menu.getId());
		node.setLevelno(menu.getLevelno());
		node.setIsleaf(menu.getIsleaf());
		return node;
	}
	
	private List<TreeNode> getRootNodes() {
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		for (SysMenu menu : rootMenus) {
			TreeNode node = MenuToNode(menu);
			if (node != null) {
				addChlidNodes(node);
				rootNodes.add(node);
			}
		}
		return rootNodes;
	}
	
	/**
	 * @param menu
	 * @return
	 */
	private void addChlidNodes(TreeNode rootNode) {
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		for (SysMenu menu : childMenus) {
			if (rootNode.getDataId().equals(menu.getParentId())) {
				TreeNode node = MenuToNode(menu);
				if (menu.getIsleaf() == 0) {
					addFinalNodes(node);
				}
				childNodes.add(node);
			}
		}
		rootNode.setChildren(childNodes);
	}
	
	/**
	 * @param menu
	 * @return
	 */
	private void addFinalNodes(TreeNode childNode) {
		List<TreeNode> finalNodes = new ArrayList<TreeNode>();
		for (SysMenu menu : finalMenus) {
			if (childNode.getDataId().equals(menu.getParentId())) {
				TreeNode node = MenuToNode(menu);
				finalNodes.add(node);
			}
		}
		childNode.setChildren(finalNodes);
	}
}
