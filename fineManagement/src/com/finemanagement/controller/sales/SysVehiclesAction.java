/**
 * 项目名称：com.finemanagement.controller.sales
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
 */
package com.finemanagement.controller.sales;

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
import com.finemanagement.entity.sales.SysVehicles;
import com.finemanagement.page.sales.SysVehiclesModel;
import com.finemanagement.service.sales.SysVehiclesService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysVehicles")
public class SysVehiclesAction extends BaseAction {

	@Autowired(required = false)
	private SysVehiclesService<SysVehicles> sysVehiclesService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysVehiclesModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysVehicles> dataList = sysVehiclesService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sales/sysVehicles", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysVehiclesModel model, HttpServletResponse response) throws Exception {
		List<SysVehicles> dataList = sysVehiclesService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadVehiclesList") 
	public void loadVehiclesList(SysVehiclesModel model, HttpServletResponse response) throws Exception {
		List<SysVehicles> dataList = sysVehiclesService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysVehicles bean, HttpServletResponse response) throws Exception {
		if (bean.getId() == null) {
			sysVehiclesService.add(bean);
		} else {
			sysVehiclesService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysVehicles bean = sysVehiclesService.queryById(id);
		if (bean  == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response) throws Exception {
		sysVehiclesService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
