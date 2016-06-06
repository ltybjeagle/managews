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
import com.finemanagement.entity.basic.SysFowlery;
import com.finemanagement.page.basic.SysFowleryModel;
import com.finemanagement.service.basic.SysFowleryService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysFowlery")
public class SysFowleryAction extends BaseAction {

	@Autowired(required = false)
	private SysFowleryService<SysFowlery> sysFowleryService;

	@RequestMapping("/list")
	public ModelAndView list(SysFowleryModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysFowlery> dataList = sysFowleryService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("basic/sysFowlery", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SysFowleryModel model, HttpServletResponse response) throws Exception {
		List<SysFowlery> dataList = sysFowleryService.queryByList(model);
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
	public void save(SysFowlery bean, String[] baseIds, String[] ftypes, HttpServletResponse response)
			throws Exception {
		bean.setBaseid(Integer.parseInt(baseIds[0]));
		bean.setFtype(Integer.parseInt(ftypes[0]));
		if (bean.getId() == null) {
			sysFowleryService.add(bean);
		} else {
			sysFowleryService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysFowlery bean = sysFowleryService.queryById(id);
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
		sysFowleryService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	@RequestMapping("/loadFowlerList")
	public void loadBaseList(SysFowleryModel model, HttpServletResponse response) throws Exception {
		List<SysFowlery> dataList = sysFowleryService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
}
