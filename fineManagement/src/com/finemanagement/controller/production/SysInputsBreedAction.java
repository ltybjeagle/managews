/**
 * 项目名称：com.finemanagement.controller.production
 * 创建日期：2016-4-16
 * 修改历史：
 *    1、[2016-4-16]创建文件    by liutianyang
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
import com.finemanagement.entity.production.SysInputsBreed;
import com.finemanagement.page.basic.SysFowleryModel;
import com.finemanagement.page.production.SysInputsBreedModel;
import com.finemanagement.service.basic.SysFowleryService;
import com.finemanagement.service.production.SysInputsBreedService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysInputsBreed")
public class SysInputsBreedAction extends BaseAction {

	@Autowired(required = false)
	private SysInputsBreedService<SysInputsBreed> sysInputsBreedService;
	
	@Autowired(required = false)
	private SysFowleryService<SysFowlery> sysFowleryService;
	
	@RequestMapping("/list") 
	public ModelAndView list(SysInputsBreedModel model, HttpServletRequest request) throws Exception {
		SysFowleryModel sysFowleryModel = new SysFowleryModel();
		sysFowleryModel.setId(model.getFowleryid());
		List<SysFowlery> sysFowleryList = sysFowleryService.queryByList(sysFowleryModel);
		SysFowlery sysFowlery = sysFowleryList.get(0);
		String fowleryName = sysFowlery.getName(); // 猪舍名称
		String baseName = sysFowlery.getBaseName(); // 基地名称
		int fowleryid = sysFowlery.getId();
		int baseid = sysFowlery.getBaseid();
		Map<String, Object> context = getRootMap();
		List<SysInputsBreed> dataList = sysInputsBreedService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		context.put("fowleryName", fowleryName);
		context.put("baseName", baseName);
		context.put("fowleryid", fowleryid);
		context.put("baseid", baseid);
		return forword("production/sysInputsBreed", context);
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysInputsBreedModel model, HttpServletResponse response) throws Exception {
		List<SysInputsBreed> dataList = sysInputsBreedService.queryByList(model);
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
	public void save(SysInputsBreed bean, String[] productNos, String[] breeders, String[] breedTechnicians, 
			HttpServletResponse response) throws Exception {
		bean.setBreeder(Integer.parseInt(breeders[0]));
		bean.setBreedTechnician(Integer.parseInt(breedTechnicians[0]));
		bean.setProductid(Integer.parseInt(productNos[0]));
		if (bean.getId() == null) {
			sysInputsBreedService.add(bean);
		} else {
			sysInputsBreedService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysInputsBreed bean = sysInputsBreedService.queryById(id);
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
		sysInputsBreedService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
