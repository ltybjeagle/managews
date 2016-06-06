/**
 * 项目名称：com.finemanagement.controller.SysStoreManager
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.controller.store;

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
import com.finemanagement.entity.store.SysStore;
import com.finemanagement.page.store.SysStoreModel;
import com.finemanagement.service.store.SysStoreService;

/**
 *by zhangyong
 */
@Controller
@RequestMapping("/sysStore")
public class SysStoreManager extends BaseAction {
	
	@Autowired(required = false)
	private SysStoreService<SysStore> sysStoreService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysStoreModel model, HttpServletRequest request)throws Exception{
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysStore> dataList = sysStoreService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("store/sysStoremanager", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysStoreModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysStore> dataList = sysStoreService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
}
