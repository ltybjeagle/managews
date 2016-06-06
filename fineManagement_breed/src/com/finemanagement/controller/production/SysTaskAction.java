/**
 * 项目名称：com.finemanagement.controller.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
 */
package com.finemanagement.controller.production;

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
import com.finemanagement.entity.basic.SysGreenhouse;
import com.finemanagement.entity.production.SysTask;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.page.production.SysTaskModel;
import com.finemanagement.service.basic.SysGreenhouseService;
import com.finemanagement.service.production.SysTaskService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysTask")
public class SysTaskAction extends BaseAction {

	@Autowired(required = false)
	private SysTaskService<SysTask> sysTaskService;
	
	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;
	
	@RequestMapping("/list") 
	public ModelAndView list(SysTaskModel model, HttpServletRequest request) throws Exception {
		SysGreenhouseModel greenhouseModel = new SysGreenhouseModel();
		greenhouseModel.setId(model.getGreenhouseid());
		List<SysGreenhouse> greenhouseList = sysGreenhouseService.queryByList(greenhouseModel);
		SysGreenhouse sysGreenhouse = greenhouseList.get(0);
		String greenhouseName = sysGreenhouse.getName(); // 大棚名称
		String baseName = sysGreenhouse.getBaseName(); // 基础名称
		int greenhouseid = sysGreenhouse.getId();
		int baseid = sysGreenhouse.getBaseid();
		Map<String, Object> context = getRootMap();
		List<SysTask> dataList = sysTaskService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		context.put("greenhouseName", greenhouseName);
		context.put("baseName", baseName);
		context.put("greenhouseid", greenhouseid);
		context.put("baseid", baseid);
		return forword("production/sysTask", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysTaskModel model, String[] taskid, HttpServletResponse response) throws Exception {
		if (taskid != null && taskid.length > 0) {
			model.setTaskid(Integer.parseInt(taskid[0]));
		}
		List<SysTask> dataList = sysTaskService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadTaskTypeList") 
	public void loadTaskTypeList(SysTaskModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysTask> dataList = sysTaskService.queryTaskTypeList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysTask bean, String[] taskids, String[] plantationMembers, String[] technicians, 
			HttpServletResponse response) throws Exception {
		bean.setPlantationMember(Integer.parseInt(plantationMembers[0]));
		bean.setTechnician(Integer.parseInt(technicians[0]));
		bean.setTaskid(Integer.parseInt(taskids[0]));
		if (bean.getId() == null) {
			sysTaskService.add(bean);
		} else {
			sysTaskService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysTask bean = sysTaskService.queryById(id);
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
		sysTaskService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
