/**
 * 项目名称：com.base.web
 * 创建日期：2016-3-17
 * 修改历史：
 *    1、[2016-3-17]创建文件    by liutianyang
 */
package com.base.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.base.entity.BaseEntity;
import com.base.page.BasePage;
import com.base.util.HtmlUtil;
import com.base.util.edit.MyEditor;

/**
 * 
 * @author liutianyang
 */
public class BaseAction {

	public final static String SUCCESS = "success";
	
	public final static String MSG = "msg";
	
	public final static String DATA = "data";
	
	public final static String LOGOUT_FLAG = "logoutFlag";
	
	// 系统标识
	@Value("#{applicationProperties['system.sysid']}")
	private String sysid;
	
	/**
	 * @return the sysid
	 */
	public String getSysid() {
		return sysid;
	}

	/**
	 * @param sysid the sysid to set
	 */
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(int.class, new MyEditor());
	}
	
	protected void indiModel(BasePage model) {
		model.setSysid(getSysid());
	}
	
	protected void saveBean(BaseEntity bean) {
		bean.setSysid(getSysid());
	}
	
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 所有ActionMap 统一从这里获取
	 * @return
	 */
	public Map<String, Object> getRootMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		return rootMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModelAndView forword(String viewName, Map context) {
		return new ModelAndView(viewName, context);
	}
	
	public ModelAndView error(String errMsg) {
		return new ModelAndView("error");
	}
	
	/**
	 * 提示成功信息
	 * @param message
	 */
	public void sendSuccessMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		HtmlUtil.writerJson(response, result);
	}
	
	/**
	 * 提示成功信息
	 * @param message
	 */
	public void sendAppSuccess(HttpServletResponse response, Object obj) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", "200");
		result.put("resultMsg", "操作成功!");
		result.put("resultData", obj);
		HtmlUtil.writerJson(response, result);
	}
	
	/**
	 * 提示失败信息
	 * @param message
	 */
	public void sendFailureMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		HtmlUtil.writerJson(response, result);
	}
	
	/**
	 * 提示失败信息
	 * @param message
	 */
	public void sendAppFailure(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("resultCode", "100");
		result.put("resultMsg", message);
		result.put("resultData", null);
		HtmlUtil.writerJson(response, result);
	}
}
