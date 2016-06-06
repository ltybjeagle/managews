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
import com.finemanagement.entity.basic.SysGreenhouseType;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.page.basic.SysGreenhouseTypeModel;
import com.finemanagement.service.basic.SysGreenhouseService;
import com.finemanagement.service.basic.SysGreenhouseTypeService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysGreenhouseType")
public class SysGreenhouseTypeAction extends BaseAction {

	@Autowired(required = false)
	private SysGreenhouseTypeService<SysGreenhouseType> sysGreenhouseTypeService;
	
	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;
	
	@RequestMapping("/greenHouseTypelist") 
	public ModelAndView list(SysGreenhouseTypeModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysGreenhouseType> dataList = sysGreenhouseTypeService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysGreenhouseType", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysGreenhouseTypeModel model, HttpServletResponse response) throws Exception {
		List<SysGreenhouseType> dataList = sysGreenhouseTypeService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadGreenhouseTypeList") 
	public void loadGreenhouseTypeList(SysGreenhouseTypeModel model, HttpServletResponse response) throws Exception {
		List<SysGreenhouseType> dataList = sysGreenhouseTypeService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysGreenhouseType bean, HttpServletResponse response) throws Exception {
		if (bean.getId() == null) {
			sysGreenhouseTypeService.add(bean);
		} else {
			sysGreenhouseTypeService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysGreenhouseType bean = sysGreenhouseTypeService.queryById(id);
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
				sendFailureMessage(response, "大棚类型有关联大棚信息，不能删除!");
				return;
			}
		}
		sysGreenhouseTypeService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
