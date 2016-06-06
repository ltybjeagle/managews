/**
 * 项目名称：com.finemanagement
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.controller.pick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.DateUtil;
import com.base.util.HtmlUtil;
import com.base.web.BaseAction;

import com.finemanagement.entity.pick.SysPick;

import com.finemanagement.page.pick.SysPickModel;

import com.finemanagement.service.pick.SysPickService;

/**
 *by zhangyong
 */
@Controller
@RequestMapping("/sysPickplans")
public class SysPickPlans extends BaseAction {
	
	@Autowired(required = false)
	private SysPickService<SysPick> sysPickService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysPickModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("pickplans");
		List<SysPick> dataList = sysPickService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("/pick/pickplans", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysPickModel model, String[] plantids, HttpServletResponse response) throws Exception {
		if (plantids != null && plantids.length > 0) {
			model.setPlantid(Integer.parseInt(plantids[0]));
		}
		model.setSyssign("pickplans");
		List<SysPick> dataList = sysPickService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 采收计划
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysPick bean, String[] plantid, HttpServletResponse response) throws Exception {
		bean.setPlantid(Integer.parseInt(plantid[0]));
		bean.setSysid("plantsys");
		bean.setSyssign("pickplans");
		bean.setReleasetime(DateUtil.getNowFormateDate());
		if (bean.getId() == null) {
			sysPickService.add(bean);
		} else {
			sysPickService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysPick bean = sysPickService.queryById(id);
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
		sysPickService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
