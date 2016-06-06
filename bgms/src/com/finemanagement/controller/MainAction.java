/**
 * 项目名称：com.finemanagement.controller
 * 创建日期：2016-3-18
 * 修改历史：
 *    1、[2016-3-18]创建文件    by liutianyang
 */
package com.finemanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.annotation.Auth;
import com.base.constants.Constants;
import com.base.entity.BaseEntity.DELETED;
import com.base.entity.TreeNode;
import com.base.util.DateUtil;
import com.base.util.MethodUtil;
import com.base.util.SessionUtils;
import com.base.util.TreeUtil;
import com.base.util.URLUtils;
import com.base.util.Constant.SuperAdmin;
import com.base.web.BaseAction;
import com.finemanagement.entity.user.SysMenu;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.page.user.SysUserModel;
import com.finemanagement.service.user.SysMenuService;
import com.finemanagement.service.user.SysUserService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysMain")
public class MainAction extends BaseAction {

	private final static Logger log = Logger.getLogger(MainAction.class);
	
	private String message = null;
	
	@Autowired(required = false) 
	private SysMenuService<SysMenu> sysMenuService; 
	
	@Autowired(required = false) 
	private SysUserService<SysUser> sysUserService; 
	
	/**
	 * 登录页面
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("login", context);
	}
	
	/**
	 * 检查用户名称
	 * @param user
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/checkuser")
	public void checkuser(SysUserModel user, HttpServletRequest req, HttpServletResponse response) throws Exception {
		SysUser u = sysUserService.queryLogin(user.getCode(), MethodUtil.MD5(user.getPwd()));
		if (u != null) {
			message = "用户: " + u.getNickName() + "登录成功";
			int loginCount = 0;
			if (u.getLoginCount() != null) {
				loginCount = u.getLoginCount();
			}
			u.setLoginCount(loginCount + 1);
			String loginTime = DateUtil.getNowPlusTime();
			u.setLoginTime(DateUtil.getDateByString(loginTime));
			sysUserService.update(u);
			SessionUtils.setUser(req, u);
			Cookie userCookie = new Cookie(Constants.COOKIE_USER, u.getCode());
			userCookie.setMaxAge(60*60*24);
			userCookie.setPath("/");
			response.addCookie(userCookie);
			// 记录成功登录日志
			log.debug(message);
			sendSuccessMessage(response, message);
		} else {
			sendFailureMessage(response, "用户名或密码错误!");
		}
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Auth(verifyLogin = false, verifyURL = false)
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SessionUtils.removeUser(request, response);
		response.sendRedirect("login.shtml");
	}

	/**
	 * 修改密码
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/modifyPwd")
	public void modifyPwd(String oldPwd, String newPwd, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		SysUser user = SessionUtils.getUser(request);
		if (user == null) {
			sendFailureMessage(response, "对不起,登录超时.");
			return;
		}
		SysUser bean = sysUserService.queryById(user.getId());
		if (bean.getId() == null || DELETED.YES.key == bean.getDeleted()) {
			sendFailureMessage(response, "对不起,用户不存在.");
			return;
		}
		if (StringUtils.isBlank(newPwd)) {
			sendFailureMessage(response, "密码不能为空.");
			return;
		}
		// 不是超级管理员，匹配旧密码
		if (!MethodUtil.ecompareMD5(oldPwd, bean.getPwd())) {
			sendFailureMessage(response, "旧密码输入不匹配.");
			return;
		}
		bean.setPwd(MethodUtil.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "Save success.");
	}
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@Auth(verifyURL = false)
	@RequestMapping("/main") 
	public ModelAndView main(HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser user = SessionUtils.getUser(request);
		List<SysMenu> rootMenus = new ArrayList<SysMenu>();
		List<SysMenu> childMenus = new ArrayList<SysMenu>();
		List<SysMenu> finalMenus = new ArrayList<SysMenu>();
		if (user.getSuperAdmin() == SuperAdmin.YES.key) {
			rootMenus = sysMenuService.getRootMenu(this.getSysid());
			childMenus = sysMenuService.getChildMenu(this.getSysid());
			finalMenus = sysMenuService.getFinalMenu(this.getSysid());
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", user.getId() + "");
			map.put("sysid", super.getSysid());
			rootMenus = sysMenuService.getRootMenuByUser(map);
			childMenus = sysMenuService.getChildMenuByUser(map);
			finalMenus = sysMenuService.getFinalMenuByUser(map);
		}
		buildData(childMenus, finalMenus, request); // 构建必要的数据
		context.put("user", user);
		context.put("menuList", treeMenu(rootMenus, childMenus, finalMenus));
		return forword("main/main", context); 
	}
	
	/**
	 * 构建树形数据
	 * @return
	 */
	private List<TreeNode> treeMenu(List<SysMenu> rootMenus, List<SysMenu> childMenus, List<SysMenu> finalMenus) {
		TreeUtil util = new TreeUtil(rootMenus, childMenus, finalMenus);
		return util.getTreeNode();
	}
	
	/**
	 * 构建树形数据
	 * @return
	 */
	private void buildData(List<SysMenu> childMenus, List<SysMenu> finalMenus, HttpServletRequest request) {
		List<String> accessUrls = new ArrayList<String>();
		for (SysMenu menu : childMenus) {
			if (StringUtils.isNotBlank(menu.getUrl())) {
				URLUtils.getBtnAccessUrls(menu.getUrl(), menu.getActions(), accessUrls);
				accessUrls.add(menu.getUrl());
			}
		}
		for (SysMenu menu : finalMenus) {
			if (StringUtils.isNotBlank(menu.getUrl())) {
				URLUtils.getBtnAccessUrls(menu.getUrl(), menu.getActions(), accessUrls);
				accessUrls.add(menu.getUrl());
			}
		}
		SessionUtils.setAccessUrl(request, getSysid(), accessUrls); // 设置可访问的URL
	}
}
