/**
 * 项目名称：com.finemanagement.controller.purchase
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.controller.purchase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.DateUtil;
import com.base.util.HtmlUtil;
import com.base.util.SessionUtils;
import com.base.web.BaseAction;
import com.finemanagement.entity.purchase.SysPurchase;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.page.purchase.SysPurchaseModel;
import com.finemanagement.service.purchase.SysPurchaseService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysPurchase") 
public class SysPurchaseAction extends BaseAction {

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
		model.setUserid(user.getId());
		Map<String, Object> context = getRootMap();
		List<SysPurchase> dataList = sysPurchaseService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("purchase/sysPurchase", context); 
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
		model.setUserid(user.getId());
		List<SysPurchase> dataList = sysPurchaseService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysPurchase bean, String[] productNos, HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		super.saveBean(bean);
		SysUser user = SessionUtils.getUser(request);
		bean.setProductid(Integer.parseInt(productNos[0]));
		BigDecimal unitprice = new BigDecimal(bean.getUnitPrice() + "");
		BigDecimal purchaseCount = new BigDecimal(bean.getPurchaseCount() + "");
		bean.setTotalAmt(unitprice.multiply(purchaseCount).toString());
		if (bean.getId() == null || "".equals(bean.getId())) {
			bean.setCreateTime(DateUtil.getNowFormateDate());
			sysPurchaseService.addPurchase(bean, user);
		} else {
			sysPurchaseService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
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
	
	@RequestMapping("/delete")
	public void delete(String[] id, HttpServletResponse response) throws Exception {
		sysPurchaseService.deletePurchase(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	@RequestMapping("/toAudit")
	public void toAudit(String[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysUser user = SessionUtils.getUser(request);
		sysPurchaseService.toAuditPurchase(user, id);
		sendSuccessMessage(response, "送审成功");
	}
	
}
