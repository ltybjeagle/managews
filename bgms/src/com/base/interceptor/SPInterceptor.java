/**
 * 项目名称：com.base.interceptor
 * 创建日期：2016-5-20
 * 修改历史：
 *    1、[2016-5-20]创建文件    by liutianyang
 */
package com.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.base.util.SessionUtils;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.service.user.SysUserService;

/**
 * 
 * @author liutianyang
 */
public class SPInterceptor extends HandlerInterceptorAdapter {

	@Autowired(required = false) 
	private SysUserService<SysUser> sysUserService; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String userCode = SessionUtils.getUserCode(request);
		if (userCode != null && !"".equals(userCode)) {
			SysUser user = sysUserService.queryByCode(userCode);
			if (user != null) {
				SessionUtils.setUser(request, user);
				String baseUri = request.getContextPath();
				response.sendRedirect(baseUri + "/sysMain/main.shtml");
				return true;
			}
		}
		return super.preHandle(request, response, handler);
	}
}
