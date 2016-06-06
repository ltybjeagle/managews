/**
 * 项目名称：com.finemanagement.controller.iot
 * 创建日期：2016-5-7
 * 修改历史：
 *    1、[2016-5-7]创建文件    by liutianyang
 */
package com.finemanagement.controller.iot;

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
import com.finemanagement.entity.iot.SysSensor;
import com.finemanagement.page.iot.SysSensorModel;
import com.finemanagement.service.iot.SysSensorService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysSensor")
public class SysSensorAction extends BaseAction {

	@Autowired(required = false)
	private SysSensorService<SysSensor> sysSensorService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysSensorModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysSensor> dataList = sysSensorService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("iot/sysSensor", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysSensorModel model, HttpServletResponse response) throws Exception {
		List<SysSensor> dataList = sysSensorService.queryByList(model);
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
	public void save(SysSensor bean, String[] baseIds, String[] greenhouseids, HttpServletResponse response) throws Exception {
		bean.setBaseid(Integer.parseInt(baseIds[0]));
		bean.setGreenhouseid(Integer.parseInt(greenhouseids[0]));
		if (bean.getId() == null) {
			sysSensorService.add(bean);
		} else {
			sysSensorService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSensor bean = sysSensorService.queryById(id);
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
		sysSensorService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
