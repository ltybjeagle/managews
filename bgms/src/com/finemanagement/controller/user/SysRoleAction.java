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

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.DateUtil;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.user.SysMenu;
import com.finemanagement.entity.user.SysRole;
import com.finemanagement.entity.user.SysRoleRel;
import com.finemanagement.entity.user.SysRoleRel.RelType;
import com.finemanagement.page.user.SysMenuModel;
import com.finemanagement.page.user.SysRoleModel;
import com.finemanagement.service.user.SysMenuService;
import com.finemanagement.service.user.SysRoleRelService;
import com.finemanagement.service.user.SysRoleService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysRole") 
public class SysRoleAction extends BaseAction {
	
	@Autowired(required = false) 
	private SysRoleService<SysRole> sysRoleService; 
	
	@Autowired(required = false) 
	private SysMenuService<SysMenu> sysMenuService; 
	
	@Autowired(required = false) 
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	/**
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/role")
	public ModelAndView list(SysRoleModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("sys/sysRole", context); 
	}
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void datalist(SysRoleModel model, HttpServletResponse response) throws Exception {
		List<SysRole> dataList = sysRoleService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(SysRole bean, Integer[] menuIds, Integer[] btnIds, String[] sysIds, HttpServletResponse response) 
			throws Exception {
		String nowTime = DateUtil.getNowPlusTime();
		StringBuffer menus = new StringBuffer();
		for (Integer menuid : menuIds) {
			menus.append(menuid).append(",");
			SysMenu menu = sysMenuService.queryById(menuid);
			if (menu.getLevelno() == 2 && menu.getIsleaf() == 0) {
				SysMenuModel model = new SysMenuModel();
				model.setParentId(menu.getId());
				List<SysMenu> menuList = sysMenuService.queryDataByList(model);
				for (SysMenu subMenu : menuList) {
					menus.append(subMenu.getId()).append(",");
				}
			}
		}
		String[] menuStrs = menus.toString().split(",");
		Integer[] menuInter = new Integer[menuStrs.length];
		int i = 0 ;
		for (String menuId : menuStrs) {
			menuInter[i] = Integer.parseInt(menuId);
			i++;
		}
		if (bean.getId() == null) {
			bean.setSysid(sysIds[0]);
			bean.setCreateTime(DateUtil.getDateByString(nowTime));
			bean.setUpdateTime(DateUtil.getDateByString(nowTime));
			sysRoleService.add(bean);
			List<SysRole> list = sysRoleService.queryRoleByList(bean);
			SysRole sysRole = list.get(0);
			sysRoleService.roleAdd(sysRole, menuInter, btnIds);
		} else {
			bean.setUpdateTime(DateUtil.getDateByString(nowTime));
			sysRoleService.update(bean, menuInter, btnIds);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = new HashMap<String, Object> ();
		SysRole bean = sysRoleService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		// 获取权限关联的菜单
		Integer[] menuIds = null;
		List<SysMenu> menuList = sysMenuService.getMenuByRoleId(id);
		if (menuList != null) {
			List<SysMenu> newList = new ArrayList<SysMenu>();
			for (SysMenu item : menuList) {
				if (item.getLevelno() == 3) {
					continue;
				}
				newList.add(item);
			}
			menuIds = new Integer[newList.size()];
			int i = 0;
			for (SysMenu item : newList) {
				menuIds[i] = item.getId();
				i++;
			}
		}
		// 获取权限下关联的按钮
		Integer[] btnIds = null;
		List<SysRoleRel> btnList = sysRoleRelService.queryByRoleId(id, RelType.BTN.key);
		if (btnList != null) {
			btnIds = new Integer[btnList.size()];
			int i = 0;
			for (SysRoleRel item : btnList) {
				btnIds[i] = item.getObjId();
				i++;
			}
		}
		// 将对象转成Map
		Map<String, Object> data = BeanUtils.describe(bean);
		data.put("menuIds", menuIds);
		data.put("btnIds", btnIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response) throws Exception {
		for (Integer roleid : id) {
			sysRoleRelService.deleteByRoleId(roleid);
			sysRoleService.delete(roleid);
		}
		sendSuccessMessage(response, "删除成功");
	}
	
	@RequestMapping("/loadRoleList")
	public void loadRoleList(HttpServletResponse response) throws Exception {
		List<SysRole> roloList = sysRoleService.queryAllList();
		HtmlUtil.writerJson(response, roloList);
	}
}
