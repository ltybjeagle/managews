package com.finemanagement.controller.materialmanage;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.base.web.BaseAction;
import com.finemanagement.entity.basic.SysBase;
import com.finemanagement.entity.basic.SysGreenhouse;
import com.finemanagement.entity.basic.SysWarehouse;
import com.finemanagement.entity.materialmanage.sysMaterialmanage;

import com.finemanagement.page.basic.SysBaseModel;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.page.basic.SysWarehouseModel;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;

import com.finemanagement.service.basic.SysBaseService;
import com.finemanagement.service.basic.SysGreenhouseService;
import com.finemanagement.service.basic.SysWarehouseService;
import com.finemanagement.service.materialmanage.sysMaterialService;

@Controller
@RequestMapping("/sysMaterialConsum")
public class SysMaterialConsum extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	@Autowired(required = false)
	private SysWarehouseService<SysWarehouse> sysWarehouseService;
	@Autowired(required = false)
	private SysBaseService<SysBase> sysBaseService;
	
	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysMaterialmanageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("0");//物资领用
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("materialmanage/sysMaterialConsum", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSyssign("0");
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 领用数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(sysMaterialmanage bean, 
			HttpServletResponse response) throws Exception {  
		sysMaterialmanage sysMaterialmanage = sysMaterialService.queryById(bean.getSyssign());
		BigDecimal unitprice = new BigDecimal(bean.getUnitPrice()+"");
		BigDecimal consumcount = new BigDecimal(bean.getConsumcount()+"");
		bean.setTotalprice(unitprice.multiply(consumcount).toString());
		bean.setMaterialname(sysMaterialmanage.getMaterialname());
		bean.setMaterialno(sysMaterialmanage.getMaterialno());
		bean.setMfName(sysMaterialmanage.getMfName());
		bean.setSpecifications(sysMaterialmanage.getSpecifications());
		bean.setUnit(sysMaterialmanage.getUnit());
		bean.setWhName(sysMaterialmanage.getWhName());
		bean.setBrandName(sysMaterialmanage.getBrandName());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		bean.setConsumtime(df.format(new Date())+"");
		bean.setSyssign("2");//领用
		bean.setSysid("plantsys");
		sysMaterialService.add(bean);
		sendSuccessMessage(response, "领用成功~");
	}
	
	@RequestMapping("/loadwarehouseidList") 
	public void loadwarehouseidList(SysWarehouseModel model, 
			HttpServletResponse response)throws Exception{
		model.setSysid(super.getSysid());
		List<SysWarehouse> dataList = sysWarehouseService.queryByList(model);
		List<SysWarehouse> newList = new ArrayList<SysWarehouse>();
		SysWarehouse sys = new SysWarehouse();
		sys.setId(0);
		sys.setWhName("--请选择--");
		newList.add(sys);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
	@RequestMapping("/loadbaseidList") 
	public void loadbaseidList(SysBaseModel model, 
			HttpServletResponse response)throws Exception{
		model.setSysid(super.getSysid());
		List<SysBase> dataList = sysBaseService.queryByList(model);
		List<SysBase> newList = new ArrayList<SysBase>();
		SysBase sys = new SysBase();
		sys.setId(0);
		sys.setBaseName("--请选择--");
		newList.add(sys);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
	@RequestMapping("/loadgreehouseidList") 
	public void loadgreehouseidList(SysGreenhouseModel model, 
			HttpServletResponse response)throws Exception{
		model.setSysid(super.getSysid());
		List<SysGreenhouse> dataList = sysGreenhouseService.queryByList(model);
		List<SysGreenhouse> newList = new ArrayList<SysGreenhouse>();
		SysGreenhouse sys = new SysGreenhouse();
		sys.setId(0);
		sys.setName("--请选择--");
		newList.add(sys);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
}
