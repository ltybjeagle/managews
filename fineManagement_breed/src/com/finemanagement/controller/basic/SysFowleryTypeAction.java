/**
 * 项目名称：com.finemanagement.controller.basic
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysFowleryType;
import com.finemanagement.page.basic.SysFowleryTypeModel;
import com.finemanagement.service.basic.SysFowleryTypeService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysFowleryType")
public class SysFowleryTypeAction extends BaseAction {

	@Autowired(required = false)
	private SysFowleryTypeService<SysFowleryType> sysFowleryTypeService;
	
	@RequestMapping("/list") 
	public ModelAndView list(SysFowleryTypeModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysFowleryType> dataList = sysFowleryTypeService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysFowleryType", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysFowleryTypeModel model, HttpServletResponse response) throws Exception {
		List<SysFowleryType> dataList = sysFowleryTypeService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadSysFowleryTypeList") 
	public void loadSysFowleryTypeList(SysFowleryTypeModel model, HttpServletResponse response) throws Exception {
		List<SysFowleryType> dataList = sysFowleryTypeService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysFowleryType bean, HttpServletResponse response) throws Exception {
		if (bean.getId() == null) {
			sysFowleryTypeService.add(bean);
		} else {
			sysFowleryTypeService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysFowleryType bean = sysFowleryTypeService.queryById(id);
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
		sysFowleryTypeService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
