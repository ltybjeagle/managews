/**
 * 项目名称：com.finemanagement.controller.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.controller.basic;

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
import com.finemanagement.page.basic.SysWarehouseModel;
import com.finemanagement.service.basic.SysWarehouseService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysWarehouse") 
public class SysWarehouseAction extends BaseAction {

	@Autowired(required = false)
	private SysWarehouseService<SysWarehouse> sysWarehouseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysWarehouseModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysWarehouse> dataList = sysWarehouseService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysWarehouse", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysWarehouseModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysWarehouse> dataList = sysWarehouseService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadWarehouseList") 
	public void loadWarehouseList(SysWarehouseModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysWarehouse> dataList = sysWarehouseService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysWarehouse bean, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (bean.getId() == null) {
			sysWarehouseService.add(bean);
		} else {
			sysWarehouseService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysWarehouse bean = sysWarehouseService.queryById(id);
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
		sysWarehouseService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
