/**
 * 项目名称：com.finemanagement.facade
 * 创建日期：2016-3-31
 * 修改历史：
 *    1、[2016-3-31]创建文件    by liutianyang
 */
package com.finemanagement.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.DateUtil;
import com.base.util.MethodUtil;
import com.base.util.SessionUtils;
import com.base.util.Constant.SuperAdmin;
import com.base.web.BaseAction;
import com.finemanagement.entity.common.SysIdentifier;
import com.finemanagement.entity.user.SysMenu;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.service.common.SysIdentifierService;
import com.finemanagement.service.user.SysMenuService;
import com.finemanagement.service.user.SysUserService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping(value="/appUser")
public class AppUserController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppUserController.class);
	
	@Autowired(required = false) 
	private SysUserService<SysUser> sysUserService;
	
	@Autowired(required = false) 
	private SysIdentifierService<SysIdentifier> sysIdentifierService;
	
	@Autowired(required = false) 
	private SysMenuService<SysMenu> sysMenuService; 
	
	@RequestMapping("/appLoginByUserAndPw")
	public void appLoginByUserAndPw(HttpServletRequest req, HttpServletResponse response) {
		try {
			String userName = req.getParameter("USERNAME");
			String passWord = req.getParameter("PASSWORD");
			SysUser u = sysUserService.queryLogin(userName, MethodUtil.MD5(passWord));
			if (u != null) {
				if (u.getSuperAdmin() != SuperAdmin.YES.key) {
					int loginCount = 0;
					if (u.getLoginCount() != null) {
						loginCount = u.getLoginCount();
					}
					u.setLoginCount(loginCount + 1);
					String loginTime = DateUtil.getNowPlusTime();
					u.setLoginTime(DateUtil.getDateByString(loginTime));
					String token = MethodUtil.MD5(u.getCode() + DateUtil.getNowLongTime());
					u.setToken(token);
					sysUserService.update(u);
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					List<SysIdentifier> identifierList = sysIdentifierService.querySysIdentifierByUser(u.getId());
					for (SysIdentifier sysIdentifier : identifierList) {
						Map<String, Object> sysMap = new HashMap<String, Object>();
						sysMap.put("sysid", sysIdentifier.getSysid());
						sysMap.put("sysname", sysIdentifier.getSysname());
						list.add(sysMap);
					}
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("id", u.getId() + "");
					resMap.put("code", u.getCode());
					resMap.put("nickName", u.getNickName());
					resMap.put("loginTime", u.getLoginTime() + "");
					resMap.put("token", token);
					resMap.put("sysList", list);
					log.debug("用户: " + u.getNickName() + "通过APP登录成功!");
					sendAppSuccess(response, resMap);
				} else {
					sendAppFailure(response, "超级管理员不能登录业务系统!");
				}
			} else {
				sendAppFailure(response, "用户名或密码错误!");
			}
		} catch (Exception e) {
			sendAppFailure(response, "登陆过程异常!");
		}
	}
	
	@RequestMapping("/appLoginMenuByUser")
	public void appLoginMenuByUser(String sysid, String token, HttpServletRequest req, HttpServletResponse response) {
		try {
			SysUser u = SessionUtils.getAppUser(req, token);
			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", u.getId() + "");
			map.put("sysid", sysid);
			map.put("isApp", "1");
			List<SysMenu> rootMenus = sysMenuService.getRootMenuByUser(map); // 根节点
			List<SysMenu> childMenus = sysMenuService.getChildMenuByUser(map); // 子节点
			List<Map<String, Object>> list = treeMenu(rootMenus, childMenus);
			sendAppSuccess(response, list);
		} catch (Exception e) {
			sendAppFailure(response, "获取菜单异常!");
		}
	}
	
	@RequestMapping("/appLogout")
	public void applogout(String token, HttpServletRequest req, HttpServletResponse response) {
		try {
			SysUser u = sysUserService.queryByToken(token);
			u.setToken("0");
			sysUserService.update(u);
			sendAppSuccess(response, null);
		} catch (Exception e) {
			sendAppFailure(response, "退出过程异常!");
		}
	}
	
	/**
	 * 构建树形数据
	 * @return
	 */
	private List<Map<String, Object>> treeMenu(List<SysMenu> rootMenus, List<SysMenu> childMenus) {
		List<Map<String, Object>> rootNodes = new ArrayList<Map<String, Object>>();
		for (SysMenu menu : rootMenus) {
			Map<String, Object> rootNode = new HashMap<String, Object>();
			rootNode.put("dataId", menu.getId());
			rootNode.put("parentId", menu.getParentId());
			rootNode.put("text", menu.getName());
			List<Map<String, Object>> childNodes = new ArrayList<Map<String, Object>>();
			for (SysMenu chileMenu : childMenus) {
				if (chileMenu.getParentId() == menu.getId()) {
					Map<String, Object> childNode = new HashMap<String, Object>();
					childNode.put("dataId", menu.getId());
					childNode.put("parentId", menu.getParentId());
					childNode.put("text", menu.getName());
					childNodes.add(childNode);
				}
			}
			rootNode.put("childList", childNodes);
			rootNodes.add(rootNode);
		}
		return rootNodes;
	}
}
