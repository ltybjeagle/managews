/**
 * 项目名称：com.finemanagement.controller.SysStoreManager
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.controller.store;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.finemanagement.entity.production.SysInputsBreed;
import com.finemanagement.entity.store.SysStore;
import com.finemanagement.page.production.SysInputsBreedModel;
import com.finemanagement.page.store.SysStoreModel;
import com.finemanagement.service.production.SysInputsBreedService;
import com.finemanagement.service.store.SysStoreService;

/**
 *by zhangyong
 */
@Controller
@RequestMapping("/sysOutputs")
public class SysOutstore extends BaseAction {
	
	@Autowired(required =false)
	SysStoreService<SysStore> sysStoreService;
	
	@Autowired(required = false)
	private SysInputsBreedService<SysInputsBreed> sysInputsBreedService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysInputsBreedModel model, HttpServletRequest request)throws Exception{
		model.setIsoutstore("0");
		Map<String, Object> context = getRootMap();
		List<SysInputsBreed> dataList = sysInputsBreedService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("store/sysOutstore", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysInputsBreedModel model, String[] classnames, HttpServletResponse response) throws Exception {
		if (classnames != null && classnames.length > 0 && !"".equals(classnames[0])) {
			model.setClassname(classnames[0]);
		}
		model.setIsoutstore("0");
		List<SysInputsBreed> dataList = sysInputsBreedService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadBaseidList") 
	public void loadSysBaseidList(SysStoreModel model, HttpServletResponse response) throws Exception {
		List<SysStore> dataList = sysStoreService.queryByList(model);
		List<SysStore> newList = new ArrayList<SysStore>();
		SysStore sp = new SysStore();
		sp.setId(0);
		sp.setBaseName("--请选择--");
		newList.add(sp);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
	
	@RequestMapping("/loadGreenhouseidList") 
	public void loadSysgreenhouseidList(SysStoreModel model, HttpServletResponse response) throws Exception {
		List<SysStore> dataList = sysStoreService.queryByList(model);
		List<SysStore> newList = new ArrayList<SysStore>();
		SysStore sp = new SysStore();
		sp.setId(0);
		sp.setGreenhouseName("--请选择--");
		newList.add(sp);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysInputsBreed bean = sysInputsBreedService.queryById(id);
		if (bean == null) {
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
	public void save(SysStore bean, Integer inputid, String[] warehouseid, String[] principals, String[] technicalstaffs, 
			String[] outusers, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (principals != null && principals.length > 0) {
			bean.setPrincipal(principals[0]);
		}
		if (technicalstaffs != null && technicalstaffs.length > 0) {
			bean.setTechnicalstaff(technicalstaffs[0]);
		}
		if (outusers != null && outusers.length > 0) {
			bean.setOutuser(outusers[0]);
		}
		SysInputsBreed sysInputs = sysInputsBreedService.queryById(inputid);
		bean.setProductNo(sysInputs.getProductNo());
		bean.setInputName(sysInputs.getInputName());
		bean.setBrandName(sysInputs.getBrandName());
		bean.setClassname(sysInputs.getClassname());
		bean.setMfName(sysInputs.getMfName());
		bean.setBaseid(sysInputs.getBaseid());
		bean.setFowleryid(sysInputs.getFowleryid());
		bean.setSpecifications(sysInputs.getSpecifications());
		bean.setUnit(sysInputs.getUnit());
		bean.setUnitPrice(sysInputs.getUnitPrice());
		BigDecimal unitprice = new BigDecimal(sysInputs.getUnitPrice() + "");
		BigDecimal purchaseCount = new BigDecimal(bean.getPurchaseCount() + "");
		bean.setTotalprice(unitprice.multiply(purchaseCount).toString());
		bean.setWarehouseid(Integer.parseInt(warehouseid[0]));
		bean.setOutstoretime(DateUtil.getNowFormateDate());
		bean.setSyssign("-1");
		bean.setSysid(super.getSysid());
		bean.setProcessInstanceId(inputid + "");
		sysStoreService.add(bean);
		// 更新投入品表
		sysStoreService.updateinput(bean);
		sendSuccessMessage(response, "出库成功~");
	}
}
