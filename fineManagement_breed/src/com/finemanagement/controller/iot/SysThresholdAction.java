/**
 * 项目名称：com.finemanagement.controller.iot
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.controller.iot;

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
import com.finemanagement.entity.iot.SysThreshold;
import com.finemanagement.page.iot.SysThresholdModel;
import com.finemanagement.service.iot.SysThresholdService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysThreshold")
public class SysThresholdAction extends BaseAction {

	@Autowired(required = false)
	private SysThresholdService<SysThreshold> sysThresholdService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysThresholdModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysThreshold> dataList = sysThresholdService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("iot/sysThreshold", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysThresholdModel model, HttpServletResponse response) throws Exception {
		List<SysThreshold> dataList = sysThresholdService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysThreshold bean, String[] baseIds, String[] greenhouseids, HttpServletResponse response) throws Exception {
		bean.setBaseid(Integer.parseInt(baseIds[0]));
		bean.setGreenhouseid(Integer.parseInt(greenhouseids[0]));
		if (bean.getId() == null) {
			sysThresholdService.add(bean);
		} else {
			sysThresholdService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysThreshold bean = sysThresholdService.queryById(id);
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
		sysThresholdService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
