/**
 * 项目名称：com.finemanagement.controller.basic
 * 创建日期：2016-5-30
 * 修改历史：
 *    1、[2016-5-30]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysEmployees;
import com.finemanagement.page.basic.SysEmployeesModel;
import com.finemanagement.service.basic.SysEmployeesService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysEmployees") 
public class SysEmployeesAction extends BaseAction {

	@Autowired(required = false)
	private SysEmployeesService<SysEmployees> sysEmployeesService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysEmployeesModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysEmployees> dataList = sysEmployeesService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysEmployees", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysEmployeesModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysEmployees> dataList = sysEmployeesService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadEmployeeList") 
	public void loadEmployeeList(SysEmployeesModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysEmployees> dataList = sysEmployeesService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysEmployees bean, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (bean.getId() == null) {
			sysEmployeesService.add(bean);
		} else {
			sysEmployeesService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysEmployees bean = sysEmployeesService.queryById(id);
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
		sysEmployeesService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
