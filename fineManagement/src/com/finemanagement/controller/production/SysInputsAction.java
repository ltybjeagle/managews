/**
 * 项目名称：com.finemanagement.controller.production
 * 创建日期：2016-4-10
 * 修改历史：
 *    1、[2016-4-10]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysGreenhouse;
import com.finemanagement.entity.production.SysInputs;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.page.production.SysInputsModel;
import com.finemanagement.service.basic.SysGreenhouseService;
import com.finemanagement.service.production.SysInputsService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysInputs")
public class SysInputsAction extends BaseAction {

	@Autowired(required = false)
	private SysInputsService<SysInputs> sysInputsService;

	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;

	@RequestMapping("/list")
	public ModelAndView list(SysInputsModel model, HttpServletRequest request) throws Exception {
		SysGreenhouseModel greenhouseModel = new SysGreenhouseModel();
		greenhouseModel.setId(model.getGreenhouseid());
		List<SysGreenhouse> greenhouseList = sysGreenhouseService.queryByList(greenhouseModel);
		SysGreenhouse sysGreenhouse = greenhouseList.get(0);
		String greenhouseName = sysGreenhouse.getName(); // 大棚名称
		String baseName = sysGreenhouse.getBaseName(); // 基础名称
		int greenhouseid = sysGreenhouse.getId();
		int baseid = sysGreenhouse.getBaseid();
		Map<String, Object> context = getRootMap();
		List<SysInputs> dataList = sysInputsService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		context.put("greenhouseName", greenhouseName);
		context.put("baseName", baseName);
		context.put("greenhouseid", greenhouseid);
		context.put("baseid", baseid);
		return forword("production/sysInputs", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SysInputsModel model, HttpServletResponse response) throws Exception {
		List<SysInputs> dataList = sysInputsService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysInputs bean, String[] productNos, String[] plantationMembers, String[] technicians, 
			HttpServletResponse response) throws Exception {
		bean.setProductid(Integer.parseInt(productNos[0]));
		bean.setPlantationMember(Integer.parseInt(plantationMembers[0]));
		bean.setTechnician(Integer.parseInt(technicians[0]));
		if (bean.getId() == null) {
			sysInputsService.add(bean);
		} else {
			sysInputsService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysInputs bean = sysInputsService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}

	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response) throws Exception {
		sysInputsService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	@RequestMapping("/loadinputsList")
	public void loadBaseList(SysInputsModel model, HttpServletResponse response) throws Exception {
		List<SysInputs> dataList = sysInputsService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
}
