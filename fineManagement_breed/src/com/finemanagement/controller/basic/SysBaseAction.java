/**
 * 项目名称：com.finemanagement.controller.basic
 * 创建日期：2016-3-23
 * 修改历史：
 *    1、[2016-3-23]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysBase;
import com.finemanagement.entity.basic.SysGreenhouse;
import com.finemanagement.page.basic.SysBaseModel;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.service.basic.SysBaseService;
import com.finemanagement.service.basic.SysGreenhouseService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysBase") 
public class SysBaseAction extends BaseAction {

	@Autowired(required = false)
	private SysBaseService<SysBase> sysBaseService;
	
	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysBaseModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysBase> dataList = sysBaseService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysBase", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysBaseModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysBase> dataList = sysBaseService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadbaseList") 
	public void loadBaseList(SysBaseModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysBase> dataList = sysBaseService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysBase bean, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (bean.getId() == null) {
			sysBaseService.add(bean);
		} else {
			sysBaseService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysBase bean = sysBaseService.queryById(id);
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
		SysGreenhouseModel sgh = new SysGreenhouseModel();
		for (Integer baseid : id) {
			sgh.setBaseid(baseid);
			List<SysGreenhouse> dataList = sysGreenhouseService.queryByList(sgh);
			if (dataList.size() > 0) {
				sendFailureMessage(response, "基地下面有关联大棚信息，不能删除!");
				return;
			}
		}
		sysBaseService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
