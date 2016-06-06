/**
 * 项目名称：com.finemanagement.controller.basic
 * 创建日期：2016-3-28
 * 修改历史：
 *    1、[2016-3-28]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysGreenhouse;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.service.basic.SysGreenhouseService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysGreenhouse") 
public class SysGreenhouseAction extends BaseAction {

	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;
	
	@RequestMapping("/manageList") 
	public ModelAndView list(SysGreenhouseModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysGreenhouse> dataList = sysGreenhouseService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysGreenhouse", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysGreenhouseModel model, String[] baseId, String[] typeId, 
			HttpServletResponse response) throws Exception {
		if (baseId != null && baseId.length > 0) {
			model.setBaseid(Integer.parseInt(baseId[0]));
		}
		if (typeId != null && typeId.length > 0) {
			model.setTypeid(Integer.parseInt(typeId[0]));
		}
		List<SysGreenhouse> dataList = sysGreenhouseService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadGreenhouseList") 
	public void loadGreenhouseList(SysGreenhouseModel model, HttpServletResponse response) throws Exception {
		List<SysGreenhouse> dataList = sysGreenhouseService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysGreenhouse bean, String[] baseIds, String[] typeIds, HttpServletResponse response) 
			throws Exception {
		bean.setBaseid(Integer.parseInt(baseIds[0]));
		bean.setTypeid(Integer.parseInt(typeIds[0]));
		if (bean.getId() == null) {
			sysGreenhouseService.add(bean);
		} else {
			sysGreenhouseService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysGreenhouse bean = sysGreenhouseService.queryById(id);
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
		sysGreenhouseService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
