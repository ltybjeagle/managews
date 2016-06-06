/**
 * 项目名称：com.finemanagement.controller.iotapp
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.controller.iotapp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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
import com.finemanagement.entity.iotapp.SysMonitor;
import com.finemanagement.entity.iotapp.SysMonitorInfo;
import com.finemanagement.entity.production.SysPlant;
import com.finemanagement.page.iotapp.SysIotappModel;
import com.finemanagement.service.iotapp.SysMonitorService;
import com.finemanagement.service.production.SysPlantService;

import net.sf.json.JSONArray;

/**
 * 
 * @author liutianyang
 * @param <T>
 */
@Controller
@RequestMapping("/sysMonitor")
public class SysMonitorAction<T> extends BaseAction {

	@Autowired(required = false)
	private SysPlantService<SysPlant> sysPlantService;

	@Autowired(required = false)
	private SysMonitorService<SysMonitor> sysMonitorService;

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("iotapp/sysMonitor", context);
	}

	@RequestMapping("/loadMonitorNumList")
	public void loadMonitorNumList(SysIotappModel model, HttpServletResponse response) throws Exception {
		List<SysMonitorInfo> dataList = sysMonitorService.queryByMonitorNumList(model);
		HtmlUtil.writerJson(response, dataList);
	}

	@RequestMapping("/dataList")
	public void dataList(SysIotappModel model, String state, String start_date, String end_date, String MonitorNum,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysIotappModel page = new SysIotappModel();
		page.setStart_date(start_date);
		page.setEnd_date(end_date);
		page.setMonitorNum(MonitorNum);
		Map<String, Object> context = getRootMap();
		List<SysMonitor> dataList = null;
		if (state == null)
			return;
		if ("year".equals(state)) {
			dataList = sysMonitorService.queryByYearList(page);
		} else if("month".equals(state)) {
			dataList = sysMonitorService.queryByMonthList(page);
		} else if("date".equals(state)) {
			dataList = sysMonitorService.queryByDateList(page);
		}
		context.put("total", dataList.size());
		context.put("rows", dataList);
		HtmlUtil.writerJson(response, context);
		// return forword("iotapp/sysMonitor", context);
	}

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/environmental")
	public ModelAndView environmental(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("iotapp/sysEnvironmental", context);
	}

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/growth")
	public ModelAndView growth(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("iotapp/sysGrowth", context);
	}

	@RequestMapping("/queryGraphData")
	public void queryGraphData(SysIotappModel model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map paramname = request.getParameterMap();
		List<SysMonitor> dataList = sysMonitorService.queryByList(model);
		Map map = new HashMap();
		for (SysMonitor sm : dataList) {
			Field[] fields = sm.getClass().getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true); // 这句使我们可以访问似有成员变量
				Object property = field.get(sm);
				if (!map.containsKey(field.getName())) {
					List list = new ArrayList();
					map.put(field.getName(), list);
					list.add(property);
				} else {
					List v = (List) map.get(field.getName());
					v.add(property);
				}

			}

		}
		map.remove("serialVersionUID");
		map.remove("id");
		List list = new ArrayList();
		Iterator it = map.keySet().iterator();
		Enumeration en = request.getParameterNames();
		while (en.hasMoreElements()) {
			Map m = new HashMap();
			Object enObj = en.nextElement();
			if (!"ReceivedTime".equalsIgnoreCase((String) enObj)) {
				m.put("name", enObj);
				m.put("data", map.get(enObj));
				list.add(m);
			}
		}
		Map<String, Object> context = getRootMap();
		context.put("x", map.get("ReceivedTime"));
		context.put("y", list);
		HtmlUtil.writerJson(response, JSONArray.fromObject(context).toString());

	}
}
