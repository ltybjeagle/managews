package com.finemanagement.controller.materialmanage;

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
import com.finemanagement.entity.materialmanage.sysMaterialmanage;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;
import com.finemanagement.service.materialmanage.sysMaterialService;

@Controller
@RequestMapping("/sysMaterialQuery")
public class SysMaterialQueryAction extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysMaterialmanageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSysid(super.getSysid());
		model.setSort("materialno");
		List<sysMaterialmanage> dataList = sysMaterialService.queryByUniteList(model);
		context.put("dataList", dataList);
		return forword("materialmanage/SysMaterialQuery", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSysid(super.getSysid());
		model.setSort("materialno");
		List<sysMaterialmanage> dataList = sysMaterialService.queryByUniteList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
}
