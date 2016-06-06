/**
 * 项目名称：com.finemanagement.controller
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.entity.TreeNode;
import com.base.entity.BaseEntity.DELETED;
import com.base.util.HtmlUtil;
import com.base.util.TreeUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.user.SysMenu;
import com.finemanagement.page.user.SysMenuModel;
import com.finemanagement.service.user.SysMenuService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuAction extends BaseAction {

	@Autowired(required = false)
	private SysMenuService<SysMenu> sysMenuService;
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/menu")
	public ModelAndView menu(SysMenuModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		model.setDeleted(DELETED.NO.key);
		List<SysMenu> dataList = sysMenuService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sys/sysMenu", context); 
	}
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  dataList(SysMenuModel model, HttpServletResponse response) throws Exception {
		List<SysMenu> dataList = sysMenuService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getMenuTree")
	public void getMenuTree(Integer id, String sysid, String roleId, HttpServletResponse response) throws Exception {
		List<TreeNode> menuTree = new ArrayList<TreeNode>();
		if (roleId != null && !"".equals(roleId)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("sysid", sysid);
			map.put("roleId", roleId);
			menuTree = treeMenu(map);
		} else {
			menuTree = treeMenu(sysid);
		}
		HtmlUtil.writerJson(response, menuTree);
	}
	
	/**
	 * 构建树形菜单
	 * @return
	 */
	public List<TreeNode> treeMenu(String sysid) {
		List<SysMenu> rootMenus = sysMenuService.getRoleRootMenu(sysid); // 根节点
		List<SysMenu> childMenus = sysMenuService.getRoleChildMenu(sysid); // 子节点
		List<SysMenu> finalMenus = sysMenuService.getRoleFinalMenu(sysid); // 末级节点
		TreeUtil util = new TreeUtil(rootMenus, childMenus, finalMenus);
		return util.getTreeNode();
	}
	
	/**
	 * 构建树形菜单
	 * @return
	 */
	public List<TreeNode> treeMenu(Map<String, String> map) {
		List<SysMenu> rootMenus = sysMenuService.getRoleRootMenuByRel(map); // 根节点
		List<SysMenu> childMenus = sysMenuService.getRoleChildMenuByRel(map); // 子节点
		List<SysMenu> finalMenus = sysMenuService.getRoleFinalMenuByRel(map); // 末级节点
		TreeUtil util = new TreeUtil(rootMenus, childMenus, finalMenus);
		return util.getTreeNode();
	}
}
