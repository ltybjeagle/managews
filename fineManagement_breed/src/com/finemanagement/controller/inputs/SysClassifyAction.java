/**
 * 项目名称：com.finemanagement.controller.inputs
 * 创建日期：2016-3-29
 * 修改历史：
 *    1、[2016-3-29]创建文件    by liutianyang
 */
package com.finemanagement.controller.inputs;

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
import com.finemanagement.entity.inputs.SysClassify;
import com.finemanagement.page.inputs.SysClassifyModel;
import com.finemanagement.service.inputs.SysClassifyService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysClassify") 
public class SysClassifyAction extends BaseAction {

	@Autowired(required = false)
	private SysClassifyService<SysClassify> sysClassifyService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysClassifyModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysClassify> dataList = sysClassifyService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("inputs/sysClassify", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysClassifyModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysClassify> dataList = sysClassifyService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadClassifyList") 
	public void loadClassifyList(SysClassifyModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysClassify> dataList = sysClassifyService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysClassify bean, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		String sort = bean.getSort();
		if (sort == null || "".equals(sort)) {
			bean.setSort("0");
		}
		if (bean.getId() == null) {
			sysClassifyService.add(bean);
		} else {
			sysClassifyService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysClassify bean = sysClassifyService.queryById(id);
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
		sysClassifyService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
