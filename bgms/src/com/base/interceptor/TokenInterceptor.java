/**
 * 项目名称：com.base.interceptor
 * 创建日期：2016-4-20
 * 修改历史：
 *    1、[2016-4-20]创建文件    by liutianyang
 */
package com.base.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.base.util.HtmlUtil;
import com.base.util.SessionUtils;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.service.user.SysUserService;

/**
 * 
 * @author liutianyang
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

	private List<String> excludeUrls;
	
	private static final PathMatcher PATH_MATCHER = new AntPathMatcher();
	
	@Autowired(required = false) 
	private SysUserService<SysUser> sysUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!checkAllowAccess(request.getRequestURI())) {
			String token = getTokenFromRequest(request);
			Map<String, Object> result = new HashMap<String, Object>();
			if (StringUtils.isEmpty(token)) {
				result.put("resultCode", "100");
				result.put("resultMsg", "token不能为空");
				result.put("resultData", null);
				HtmlUtil.writerJson(response, result);
				return false;
			}
			SysUser user = sysUserService.queryByToken(token);
			if (user == null) {
				result.put("resultCode", "100");
				result.put("resultMsg", "token已过期，请重新登录");
				result.put("resultData", null);
				HtmlUtil.writerJson(response, result);
				return false;
			}
			SessionUtils.setAppUser(request, user);
		}
		return super.preHandle(request, response, handler);
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
			throws Exception {
		String token = getTokenFromRequest(request);
		SessionUtils.removeAppUser(request, token);
	}
	
	/**
	 * 从请求信息中获取token值
	 * 
	 * @param request
	 * @return token值
	 */
	private String getTokenFromRequest(HttpServletRequest request) {
		// 默认从header里获取token值
		String token = request.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			// 从请求信息中获取token值
			token = request.getParameter("token");
		}
		return token;
	}

	/**
	 * 检查URI是否放行
	 * 
	 * @param URI
	 * @return 返回检查结果
	 */
	private boolean checkAllowAccess(String URI) {
		if (!URI.startsWith("/")) {
			URI = "/" + URI;
		}
		for (String allow : excludeUrls) {
			if (PATH_MATCHER.match(allow, URI)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the excludeUrls
	 */
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	/**
	 * @param excludeUrls the excludeUrls to set
	 */
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

}
