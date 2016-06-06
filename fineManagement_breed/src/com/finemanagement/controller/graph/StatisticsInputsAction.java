package com.finemanagement.controller.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.BeanUtil;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.inputs.SysProduct;
import com.finemanagement.entity.pick.SysPick;
import com.finemanagement.entity.production.SysInputs;
import com.finemanagement.entity.slaughter.SysSlaughter;
import com.finemanagement.page.inputs.SysProductModel;
import com.finemanagement.page.pick.SysPickModel;
import com.finemanagement.page.production.SysInputsModel;
import com.finemanagement.page.production.SysPlantModel;
import com.finemanagement.page.slaughter.SysSlaughterModel;
import com.finemanagement.service.inputs.SysProductService;
import com.finemanagement.service.pick.SysPickService;
import com.finemanagement.service.production.SysInputsService;
import com.finemanagement.service.production.SysPlantService;
import com.finemanagement.service.slaughter.SysSlaughterService;

@Controller
@RequestMapping("/statisticsInputs")
public class StatisticsInputsAction<T> extends BaseAction {

	@Autowired(required = false)
	SysProductService<SysProduct> sysProductService;

	@Autowired(required = false)
	private SysInputsService<SysInputs> sysInputsService; // 投入品

	@Autowired(required = false)
	private SysPickService<SysPick> sysPickService; // 采摘

	@Autowired(required = false)
	private SysSlaughterService<SysSlaughter> sysSlaughterService; // 出栏

	@Autowired(required = false)
	private SysPlantService<T> sysPlantService; // 采收

	/**
	 * 投入品使用统计
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/inputstatistics")
	public ModelAndView inputstatisticslist(SysInputsModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();

		return forword("graph/inputstatistics", context);
	}

	/**
	 * 采收统计
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/harveststatistics")
	public ModelAndView harveststatisticslist(SysProductModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();

		return forword("graph/harveststatistics", context);
	}

	/**
	 * 采摘统计
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/pickingstatistics")
	public ModelAndView pickingstatisticslist(SysProductModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("graph/pickingstatistics", context);
	}

	/**
	 * 投入产出统计
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/inputoutputstatistics")
	public ModelAndView inputoutputstatisticslist(SysProductModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("graph/inputoutputstatistics", context);
	}

	/**
	 * 出栏统计
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/slaughterstatistics")
	public ModelAndView slaughterstatisticslist(SysProductModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("graph/slaughterstatistics", context);
	}

	/**
	 * json 投入品列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/inputtable")
	public void dataList(SysInputsModel model, String state, String start_date, String end_date,
			HttpServletResponse response) throws Exception {

		// Map<String, Object> map = BeanUtil.transBean2Map(model);
		List<SysInputs> dataList = null;
		if (state == null)
			return;
		if ("year".equals(state)) {
			dataList = sysInputsService.queryByYearList(model);
		} else if ("month".equals(state)) {
			dataList = sysInputsService.queryByMonthList(model);
		} else if ("date".equals(state)) {
			dataList = sysInputsService.queryByDateList(model);
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 采收列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/harvesttable")
	public void harvestDataList(SysPlantModel model, String state, String start_date, String end_date,
			HttpServletResponse response) throws Exception {
		model.setStartTime(start_date);
		model.setEndTime(end_date);
		List<T> dataList = null;
		if (state == null)
			return;
		if ("year".equals(state)) {
			dataList = sysPlantService.queryByYearList(model);
		} else if ("month".equals(state)) {
			dataList = sysPlantService.queryByMonthList(model);
		} else if ("date".equals(state)) {
			dataList = sysPlantService.queryByDateList(model);
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 投入产出列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/inputouttable")
	public void inputoutDataList(SysInputsModel model, String state, String start_date, String end_date,
			HttpServletResponse response) throws Exception {

		Map<String, Object> map = BeanUtil.transBean2Map(model);
		map.put("start_date", start_date);
		map.put("end_date", end_date);
		List<SysInputs> dataList = null;

		if (state == null)
			return;
		if ("year".equals(state)) {
			dataList = sysInputsService.queryByYearList(model);
		} else if ("month".equals(state)) {
			dataList = sysInputsService.queryByMonthList(model);
		} else if ("date".equals(state)) {
			dataList = sysInputsService.queryByDateList(model);
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 采摘列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/pickingtable")
	public void pickingDataList(SysPickModel model, String state, String start_date, String end_date,
			HttpServletResponse response) throws Exception {

		Map<String, Object> map = BeanUtil.transBean2Map(model);
		map.put("start_date", start_date);
		map.put("end_date", end_date);
		List<SysPick> dataList = null;
		if (state == null)
			return;
		if ("year".equals(state)) {
			dataList = sysPickService.queryByYearList(model);
		} else if ("month".equals(state)) {
			dataList = sysPickService.queryByMonthList(model);
		} else if ("date".equals(state)) {
			dataList = sysPickService.queryByDateList(model);
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 出栏列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/slaughtertable")
	public void slaughterDataList(SysSlaughterModel model, String state, String start_date, String end_date,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = BeanUtil.transBean2Map(model);
		map.put("start_date", start_date);
		map.put("end_date", end_date);

		List<SysSlaughter> dataList = null;
		if (state == null)
			return;
		if ("year".equals(state)) {
			dataList = sysSlaughterService.queryByYearList(model);
		} else if ("month".equals(state)) {
			dataList = sysSlaughterService.queryByMonthList(model);
		} else if ("date".equals(state)) {
			dataList = sysSlaughterService.queryByDateList(model);
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * json 统计页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	// @RequestMapping("/inputsgraph")
	// public void graphdataList(SysInputsModel model, String start_date, String
	// end_date, HttpServletResponse response)
	// throws Exception {
	//
	// Map<String, Object> map = BeanUtil.transBean2Map(model);
	// map.put("start_date", start_date);
	// map.put("end_date", end_date);
	// List<SysInputs> dataList = sysInputsService.queryByStatistics(map);
	// // 设置页面数据
	// Map<String, Object> jsonMap = new HashMap<String, Object>();
	// List<Object> jsonArray = new ArrayList<Object>();
	// Map<String, Object> unitMap = new HashMap<String, Object>();
	// Map<String, Object> yearMap = new HashMap<String, Object>();
	// jsonMap.put("name", "数量"); // 对应series.name
	// unitMap.put("name", "价格");
	// JSONArray list = new JSONArray();
	// JSONArray yearlist = new JSONArray();
	// JSONArray uintlist = new JSONArray();
	// for (SysInputs sin : dataList) {
	// list.put(Integer.parseInt(sin.getPurchaseCount()));
	// uintlist.put(Integer.parseInt(sin.getUnitPrice()));
	// yearlist.put(sin.getStartTime());// 对应Y轴显示
	// }
	// jsonMap.put("list", list);
	// unitMap.put("list", uintlist);
	// yearMap.put("year", yearlist);
	// jsonArray.add(jsonMap);
	// jsonArray.add(unitMap);
	// jsonArray.add(yearMap);
	//
	// HtmlUtil.writerJson(response, jsonArray);
	// }
}
