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
import com.finemanagement.entity.sales.SysDriver;
import com.finemanagement.page.sales.SysDriverModel;
import com.finemanagement.service.sales.SysDriverService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysDriver")
public class SysDriverAction extends BaseAction {

	@Autowired(required = false)
	private SysDriverService<SysDriver> sysDriverService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysDriverModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysDriver> dataList = sysDriverService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sales/sysDriver", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysDriverModel model, String[] driverStatus, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (driverStatus != null && driverStatus.length > 0 && !"0".equals(driverStatus[0])) {
			model.setDriverStatus(driverStatus[0]);
		} else {
			model.setDriverStatus("");
		}
		List<SysDriver> dataList = sysDriverService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadDriverList") 
	public void loadDriverList(SysDriverModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysDriver> dataList = sysDriverService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysDriver bean, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (bean.getId() == null) {
			sysDriverService.add(bean);
		} else {
			sysDriverService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysDriver bean = sysDriverService.queryById(id);
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
		sysDriverService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
