/**
 * 项目名称：com.base.util
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.base.util;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.base.constants.Constants;
import com.base.util.Constant.SuperAdmin;
import com.finemanagement.entity.user.SysUser;

/**
 * Cookie 工具类
 * @author liutianyang
 */
@SuppressWarnings({ "unchecked" })
public class SessionUtils {

	protected static final Logger logger = Logger.getLogger(SessionUtils.class);
	
	private static final String SESSION_USER = "session_user_";
	
	private static final String SESSION_ACCESS_URLS = "_session_access_urls_"; // 系统能够访问的URL
	
	/**
	 * 设置session的值
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttr(HttpServletRequest request, String key, Object value) {
		request.getSession(true).setAttribute(key, value);
	}
	
	/**
	 * 获取session的值
	 * @param request
	 * @param key
	 * @param value
	 */
	public static Object getAttr(HttpServletRequest request, String key) {
		return request.getSession(true).getAttribute(key);
	}
	
	/**
	 * 删除Session值
	 * @param request
	 * @param key
	 */
	public static void removeAttr(HttpServletRequest request, String key) {
		request.getSession(true).removeAttribute(key);
	}
	 
	/**
	 * 设置用户信息 到session
	 * @param request
	 * @param user
	 */
	public static void setUser(HttpServletRequest request, SysUser user) {
		String sessionId = user.getCode();
		request.getSession(true).setAttribute(SESSION_USER + sessionId, user);
	}
	
	/**
	 * 设置用户信息 到session
	 * @param request
	 * @param user
	 */
	public static void setAppUser(HttpServletRequest request, SysUser user) {
		request.getSession(true).setAttribute(SESSION_USER + user.getToken(), user);
	}
	
	/**
	 * 从session中获取用户信息
	 * @param request
	 * @return SysUser
	 */
	public static SysUser getUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		String sessionid = "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cook = cookies[i];
			if (cook.getName().equalsIgnoreCase(Constants.COOKIE_USER)) {
				sessionid = cook.getValue().toString();
				break;
			}
		}
		return (SysUser) request.getSession(true).getAttribute(SESSION_USER + sessionid);
	}
	
	/**
	 * 从session中获取用户信息
	 * @param request
	 * @return SysUser
	 */
	public static String getUserCode(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		String sessionid = "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cook = cookies[i];
			if (cook.getName().equalsIgnoreCase(Constants.COOKIE_USER)) {
				sessionid = cook.getValue().toString();
				break;
			}
		}
		return sessionid;
	}
	
	/**
	 * 从session中获取用户信息
	 * @param request
	 * @return SysUser
	 */
	public static SysUser getAppUser(HttpServletRequest request, String token) {
		return (SysUser) request.getSession(true).getAttribute(SESSION_USER + token);
	}
	
	/**
	 * 从session中获取用户信息
	 * @param request
	 * @return SysUser
	 */
	public static Integer getUserId(HttpServletRequest request) {
		SysUser user = getUser(request);
		if (user != null) {
			return user.getId();
		}
		return null; 
	}
	
	/**
	 * 从session中删除用户信息
	 * @param request
	 * @return SysUser
	 */
	public static void removeUser(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String sessionid = "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cook = cookies[i];
			if (cook.getName().equalsIgnoreCase(Constants.COOKIE_USER)) {
				sessionid = cook.getValue().toString();
				cook.setValue(null);
				cook.setPath("/");
				cook.setMaxAge(0);
		        response.addCookie(cook);
				break;
			}
		}
		removeAttr(request, SESSION_USER + sessionid);
	}
	
	/**
	 * 从session中删除用户信息
	 * @param request
	 * @return SysUser
	 */
	public static void removeAppUser(HttpServletRequest request, String token) {
		removeAttr(request, SESSION_USER + token);
	}
	 
	/**
	 * 判断当前登录用户是否超级管理员
	 * @param request
	 * @return
	 */
	public static boolean isAdmin(HttpServletRequest request) { 
		SysUser user = getUser(request);
		if (user == null  || user.getSuperAdmin() != SuperAdmin.YES.key) {
			return false;
		}
		return true;
	}
	 
	/**
	 * 设置系统能够访问的URL
	 * @param request
	 * @return
	 */
	public static void setAccessUrl(HttpServletRequest request, String sysid, List<String> accessUrls) {
		Cookie[] cookies = request.getCookies();
		String sessionid = "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cook = cookies[i];
			if (cook.getName().equalsIgnoreCase(Constants.COOKIE_USER)) {
				sessionid = cook.getValue().toString();
				break;
			}
		}
		setAttr(request, sysid + SESSION_ACCESS_URLS + sessionid, accessUrls);
	}
	
	/**
	 * 判断URL是否可访问
	 * @param request
	 * @return
	 */
	public static boolean isAccessUrl(HttpServletRequest request, String sysid, String url) { 
		Cookie[] cookies = request.getCookies();
		String sessionid = "";
		for (int i = 0; i < cookies.length; i++) {
			Cookie cook = cookies[i];
			if (cook.getName().equalsIgnoreCase(Constants.COOKIE_USER)) {
				sessionid = cook.getValue().toString();
				break;
			}
		}
		List<String> accessUrls = (List<String>) getAttr(request, sysid + SESSION_ACCESS_URLS + sessionid);
		if (accessUrls == null || accessUrls.isEmpty() || !accessUrls.contains(url)) {
			return false;
		}
		return true;
	}
}
