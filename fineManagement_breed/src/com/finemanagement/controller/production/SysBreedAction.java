/**
 * 项目名称：com.finemanagement.controller.production
 * 创建日期：2016-4-11
 * 修改历史：
 *    1、[2016-4-11]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysFowlery;
import com.finemanagement.entity.production.SysBreed;
import com.finemanagement.page.basic.SysFowleryModel;
import com.finemanagement.page.production.SysBreedModel;
import com.finemanagement.service.basic.SysFowleryService;
import com.finemanagement.service.production.SysBreedService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysBreed") 
public class SysBreedAction extends BaseAction {

	@Autowired(required = false)
	private SysBreedService<SysBreed> sysBreedService;
	
	@Autowired(required = false)
	private SysFowleryService<SysFowlery> sysFowleryService;
	
	@RequestMapping("/sysfowleryList") 
	public ModelAndView list(SysFowleryModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysFowlery> dataList = sysFowleryService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("production/fowleryList", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/sysfowlerydataList") 
	public void dataList(SysFowleryModel model, HttpServletResponse response) throws Exception {
		List<SysFowlery> dataList = sysFowleryService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/list") 
	public ModelAndView list(SysBreedModel model, HttpServletRequest request) throws Exception {
		SysFowleryModel sysFowleryModel = new SysFowleryModel();
		sysFowleryModel.setId(model.getFowleryid());
		List<SysFowlery> sysFowleryList = sysFowleryService.queryByList(sysFowleryModel);
		SysFowlery sysFowlery = sysFowleryList.get(0);
		String fowleryName = sysFowlery.getName(); // 猪舍名称
		String baseName = sysFowlery.getBaseName(); // 基地名称
		int fowleryid = sysFowlery.getId();
		int baseid = sysFowlery.getBaseid();
		Map<String, Object> context = getRootMap();
		List<SysBreed> dataList = sysBreedService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		context.put("fowleryName", fowleryName);
		context.put("baseName", baseName);
		context.put("fowleryid", fowleryid);
		context.put("baseid", baseid);
		return forword("production/sysBreed", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysBreedModel model, HttpServletResponse response) throws Exception {
		List<SysBreed> dataList = sysBreedService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadBreedList") 
	public void loadBreedList(SysBreedModel model, HttpServletResponse response) throws Exception {
		List<SysBreed> dataList = sysBreedService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysBreed bean, String[] breeders, String[] breedTechnicians, String[] varietyids, 
			HttpServletResponse response) throws Exception {
		bean.setBreeder(Integer.parseInt(breeders[0]));
		bean.setBreedTechnician(Integer.parseInt(breedTechnicians[0]));
		if (varietyids != null && varietyids.length > 0) {
			bean.setVarietyid(Integer.parseInt(varietyids[0]));
		}
		if (bean.getId() == null) {
			sysBreedService.add(bean);
		} else {
			sysBreedService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysBreed bean = sysBreedService.queryById(id);
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
		sysBreedService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
