package com.finemanagement.controller.materialmanage;

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
import com.finemanagement.entity.materialmanage.sysMaterialmanage;
import com.finemanagement.entity.materialmanage.sysStocktakingEntity;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;
import com.finemanagement.page.materialmanage.sysStocktakingModel;
import com.finemanagement.service.materialmanage.sysMaterialService;
import com.finemanagement.service.materialmanage.sysStocktakingService;

@Controller
@RequestMapping("/sysMaterialStockDetail")
public class SysMaterialStockDetail extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	
	@Autowired(required = false)
	private sysStocktakingService<sysStocktakingEntity> sysStocktakingService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysStocktakingModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		sysStocktakingEntity bean = sysStocktakingService.queryById(model.getId());
		sysMaterialmanageModel detailModel = new sysMaterialmanageModel();
		detailModel.setStocktalingno(bean.getStocktalingno());
		detailModel.setSyssign("4"); // 物资盘库数据
		detailModel.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(detailModel);
		// 设置页面数据
		context.put("dataList", dataList);
		context.put("data", bean);
		return forword("materialmanage/sysMaterialStockDetail", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSyssign("4"); // 物资盘库数据
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
}
