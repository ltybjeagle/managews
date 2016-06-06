/**
 * 项目名称：com.finemanagement.controller
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.entity.BaseEntity.DELETED;
import com.base.entity.BaseEntity.STATE;
import com.base.util.DateUtil;
import com.base.util.HtmlUtil;
import com.base.util.MethodUtil;
import com.base.util.SessionUtils;
import com.base.web.BaseAction;
import com.finemanagement.entity.user.SysRole;
import com.finemanagement.entity.user.SysRoleRel;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.entity.user.SysRoleRel.RelType;
import com.finemanagement.exception.ServiceException;
import com.finemanagement.page.user.SysUserModel;
import com.finemanagement.service.user.SysRoleRelService;
import com.finemanagement.service.user.SysRoleService;
import com.finemanagement.service.user.SysUserService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysUser") 
public class SysUserAction extends BaseAction {

	@Autowired(required = false)
	private SysUserService<SysUser> sysUserService; 
	
	@Autowired(required = false) 
	private SysRoleService<SysRole> sysRoleService;
	
	@Autowired(required = false) 
	private SysRoleRelService<SysRoleRel> sysRoleRelService;
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysUserModel model, HttpServletRequest request) throws Exception {
		Map<String, Object>  context = getRootMap();
		List<SysUser> dataList = sysUserService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sys/sysUser", context); 
	}
	
	/**
	 * json 列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysUserModel model, HttpServletResponse response) throws Exception {
		List<SysUser> dataList = sysUserService.queryByList(model);
		for (SysUser user : dataList) {
			List<SysRole> list = sysRoleService.queryByUserid(user.getId());
			user.setRoleStr(rolesToStr(list));
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 角色列表转成字符串
	 * @param list
	 * @return
	 */
	private String rolesToStr(List<SysRole> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			SysRole role = list.get(i);
			str.append(role.getRoleName());
			if ((i + 1) < list.size()) {
				str.append(",");
			}
		}
		return str.toString();
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(SysUser bean, HttpServletResponse response) throws Exception {
		SysUser u = sysUserService.getUserCountByCode(bean.getCode());
		String loginTime = DateUtil.getNowPlusTime();
		String retMsg = "";
		if (bean.getId() == null) {
			if (u != null) {
				throw new ServiceException("用户已存在.");
			}
			bean.setCreateTime(DateUtil.getDateByString(loginTime));
			bean.setUpdateTime(DateUtil.getDateByString(loginTime));
			bean.setDeleted(DELETED.NO.key);
			bean.setPwd(MethodUtil.MD5(password));
			sysUserService.add(bean);
			retMsg = "保存成功,默认用户密码：888888";
		} else {
			if(u != null){
				throw new ServiceException("用户已存在.");
			}
			bean.setUpdateTime(DateUtil.getDateByString(loginTime));
			if (STATE.DISABLE.key == bean.getState()){
				sysRoleRelService.deleteByObjId(bean.getId(), RelType.USER.key);
			}
			sysUserService.updateBySelective(bean);
			retMsg = "保存成功";
		}
		sendSuccessMessage(response, retMsg);
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser bean = sysUserService.queryById(id);
		if (bean  == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser user = SessionUtils.getUser(request);
		for (Integer userid : id) {
			SysUser bean = sysUserService.queryById(userid);
			if (user.getCode().equals(bean.getCode())) {
				sendFailureMessage(response, "删除用户【" + bean.getNickName() + "】是当前登录用户,不能删除");
				return;
			} else {
				sysRoleRelService.deleteByObjId(userid, 1);
				sysUserService.delete(userid);
			}
		}
		sendSuccessMessage(response, "删除成功");
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updatePwd")
	public void updatePwd(Integer id, String oldPwd, String newPwd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean isAdmin = SessionUtils.isAdmin(request); // 是否超级管理员
		SysUser bean = sysUserService.queryById(id);
		if (bean.getId() == null || DELETED.YES.key == bean.getDeleted()) {
			sendFailureMessage(response, "Sorry ,User is not exists.");
			return;
		}
		if (StringUtils.isBlank(newPwd)) {
			sendFailureMessage(response, "Password is required.");
			return;
		}
		// 不是超级管理员，匹配旧密码
	 	if (!isAdmin && !MethodUtil.ecompareMD5(oldPwd,bean.getPwd())) {
			sendFailureMessage(response, "Wrong old password.");
			return;
		}
		bean.setPwd(MethodUtil.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 用户授权页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userRole") 
	public ModelAndView  userRole(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("/sys/sysUserRole", context);
	}
	
	/**
	 * 用户授权列表
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/userList") 
	public void  userList(SysUserModel model, HttpServletResponse response) throws Exception {
		model.setState(STATE.ENABLE.key);
		dataList(model, response);
	}
	
	/**
	 * 查询用户信息
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUser") 
	public void getUser(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser bean = sysUserService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		Integer[] roleIds = null;
		List<SysRoleRel> roles = sysUserService.getUserRole(bean.getId());
		if (roles != null) {
			roleIds = new Integer[roles.size()];
			int i = 0;
			for (SysRoleRel rel : roles ) {
				roleIds[i] = rel.getRoleId();
				i++;
			}
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", bean.getId());
		data.put("code", bean.getCode());
		data.put("roleIds", roleIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addUserRole")
	public void addUserRole(Integer id, Integer roleIds[], HttpServletResponse response) throws Exception {
		sysUserService.addUserRole(id, roleIds);
		sendSuccessMessage(response, "保存成功");
	}
}
