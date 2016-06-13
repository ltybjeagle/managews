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
import com.finemanagement.entity.basic.SysWarehouse;
import com.finemanagement.entity.materialmanage.sysMaterialmanage;
import com.finemanagement.page.basic.SysWarehouseModel;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;
import com.finemanagement.service.basic.SysWarehouseService;
import com.finemanagement.service.materialmanage.sysMaterialService;

@Controller
@RequestMapping("/sysMaterialInstore")
public class SysMaterialInstore extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	
	@Autowired(required = false)
	private SysWarehouseService<SysWarehouse> sysWarehouseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysMaterialmanageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("0");//物资入库
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("materialmanage/sysMaterialInstore", context); 
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
	 * 入库数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(sysMaterialmanage bean, HttpServletResponse response) throws Exception {  
		sysMaterialmanage sysMaterialmanage = sysMaterialService.queryById(bean.getSyssign());
		bean.setMaterialname(sysMaterialmanage.getMaterialname());
		bean.setMaterialno(sysMaterialmanage.getMaterialno());
		bean.setMfName(sysMaterialmanage.getMfName());
		bean.setSpecifications(sysMaterialmanage.getSpecifications());
		bean.setUnit(sysMaterialmanage.getUnit());
		bean.setWhName(sysMaterialmanage.getWhName());
		bean.setBrandName(sysMaterialmanage.getBrandName());
		BigDecimal unitprice = new BigDecimal(bean.getUnitPrice());
		BigDecimal purchaseCount = new BigDecimal(bean.getStorecount());
		bean.setTotalprice(unitprice.multiply(purchaseCount).toString());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		bean.setInstoretime(df.format(new Date())+"");
		bean.setSyssign("1");//物资入库
		bean.setSysid(super.getSysid());
		sysMaterialService.add(bean);
		sendSuccessMessage(response, "入库成功~");
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
} 
