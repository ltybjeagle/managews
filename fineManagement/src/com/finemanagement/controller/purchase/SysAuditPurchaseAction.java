/**
 * 项目名称：com.finemanagement.controller.purchase
 * 创建日期：2016-4-6
 * 修改历史：
 *    1、[2016-4-6]创建文件    by liutianyang
 */
package com.finemanagement.controller.purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.HtmlUtil;
import com.base.util.SessionUtils;
import com.base.web.BaseAction;
import com.finemanagement.entity.purchase.SysPurchase;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.page.purchase.SysPurchaseModel;
import com.finemanagement.service.purchase.SysAuditPurchaseService;
import com.finemanagement.service.purchase.SysPurchaseService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysAuditPurchase") 
public class SysAuditPurchaseAction extends BaseAction {

	@Autowired(required = false)
	private SysAuditPurchaseService<SysPurchase> sysAuditPurchaseService;
	
	@Autowired(required = false)
	private SysPurchaseService<SysPurchase> sysPurchaseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysPurchaseModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		SysUser user = SessionUtils.getUser(request);
		model.setWaittaskid(user.getId());
		Map<String, Object> context = getRootMap();
		List<SysPurchase> dataList = sysAuditPurchaseService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("purchase/sysAuditPurchase", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysPurchaseModel model, String[] classnames, String[] taskname, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (classnames != null && classnames.length > 0) {
			model.setClassname(classnames[0]);
		}
		if (taskname != null && taskname.length > 0) {
			model.setTaskkey(taskname[0]);
		}
		SysUser user = SessionUtils.getUser(request);
		model.setWaittaskid(user.getId());
		List<SysPurchase> dataList = sysAuditPurchaseService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getId")
	public void getId(String id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysPurchase bean = sysPurchaseService.queryById(id);
		if (bean  == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/audit")
	public void audit(String[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String state = request.getParameter("state");
		SysUser user = SessionUtils.getUser(request);
		sysAuditPurchaseService.auditPurchase(user, state, id);
		sendSuccessMessage(response, "审核成功");
	}
}
