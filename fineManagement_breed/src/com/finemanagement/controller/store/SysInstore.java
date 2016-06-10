/**
 * 项目名称：com.finemanagement.controller.SysStoreManager
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.controller.store;

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
import com.base.web.BaseAction;

import com.finemanagement.entity.purchase.SysPurchase;
import com.finemanagement.entity.store.SysStore;
import com.finemanagement.page.purchase.SysPurchaseModel;
import com.finemanagement.service.purchase.SysPurchaseService;
import com.finemanagement.service.store.SysStoreService;

/**
 *by zhangyong
 */
@Controller
@RequestMapping("/sysInstore")
public class SysInstore extends BaseAction {
	
	@Autowired(required =false)
	SysStoreService<SysStore> sysStoreService;
	
	@Autowired(required = false)
	private SysPurchaseService<SysPurchase> sysPurchaseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysPurchaseModel model, HttpServletRequest request)throws Exception{
		super.indiModel(model);
		model.setTaskkey("10");
		model.setIsinstore("0");
		Map<String, Object> context = getRootMap();
		List<SysPurchase> dataList = sysPurchaseService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("store/sysInstore", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysPurchaseModel model, String[] classnames, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (classnames != null && classnames.length > 0) {
			model.setClassname(classnames[0]);
		}
		model.setTaskkey("10");
		model.setIsinstore("0");
		List<SysPurchase> dataList = sysPurchaseService.queryByList(model);
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
	
	/**
	 * 入库数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysStore bean, String purchaseid, String[] warehouseid, HttpServletResponse response
			) throws Exception {  
		super.saveBean(bean);
		SysPurchase sysPurchase = sysPurchaseService.queryById(purchaseid);
		bean.setProductNo(sysPurchase.getProductNo());
		bean.setInputName(sysPurchase.getInputName());
		bean.setClassname(sysPurchase.getClassname());
		bean.setUnit(sysPurchase.getUnit());
		bean.setSpecifications(sysPurchase.getSpecifications());
		bean.setBrandName(sysPurchase.getBrandName());
		bean.setMfName(sysPurchase.getMfName());
		BigDecimal unitprice = new BigDecimal(sysPurchase.getUnitPrice() + "");
		BigDecimal purchaseCount = new BigDecimal(bean.getPurchaseCount() + "");
		bean.setUnitPrice(sysPurchase.getUnitPrice());
		bean.setTotalprice(unitprice.multiply(purchaseCount).toString());
		bean.setWarehouseid(Integer.parseInt(warehouseid[0]));
		bean.setInstoretime(DateUtil.getNowFormateDate());
		bean.setSyssign("1");
		bean.setProcessInstanceId(purchaseid);
		sysStoreService.add(bean);
		// 更新采购计划表
		sysStoreService.updateplan(bean);
		sendSuccessMessage(response, "入库成功~");
	}
}
