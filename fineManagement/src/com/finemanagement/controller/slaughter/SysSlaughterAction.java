/**
 * 项目名称：com.finemanagement.controller.slaughter
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
 */
package com.finemanagement.controller.slaughter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.DateUtil;
import com.base.util.HtmlUtil;
import com.base.util.StringUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.slaughter.SysSlaughter;
import com.finemanagement.page.slaughter.SysSlaughterModel;
import com.finemanagement.service.slaughter.SysSlaughterService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysSlaughter")
public class SysSlaughterAction extends BaseAction {

	@Autowired(required = false)
	private SysSlaughterService<SysSlaughter> sysSlaughterService;

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysSlaughterModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysSlaughter> dataList = sysSlaughterService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("slaughter/sysSlaughter", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SysSlaughterModel model, HttpServletResponse response) throws Exception {
		List<SysSlaughter> dataList = sysSlaughterService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/loadSlaughterList")
	public void loadSlaughterList(SysSlaughterModel model, HttpServletResponse response) throws Exception {
		List<SysSlaughter> dataList = sysSlaughterService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}

	@RequestMapping("/loadSlaughterListByProcess")
	public void loadSlaughterListByProcess(HttpServletResponse response) throws Exception {
		List<SysSlaughter> dataList = sysSlaughterService.queryListByProcess();
		HtmlUtil.writerJson(response, dataList);
	}

	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		SysSlaughterModel model = new SysSlaughterModel();
		model.setCreateTime(DateUtil.getNowShortDate());
		List<SysSlaughter> dataList = sysSlaughterService.queryByList(model);
		Map<String, Object> context = getRootMap();
		SysSlaughter bean = new SysSlaughter();
		String slaughterBatch = "tzpc" + DateUtil.getNowShortDate()
				+ StringUtil.fillZero((dataList.size() + 1) + "", 3);
		bean.setSlaughterBatch(slaughterBatch);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysSlaughter bean, String[] quarantineBatchIds, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		bean.setQuarantineBatchId(quarantineBatchIds[0]);
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");
		//bean.setFilePath(realPath);
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			sysSlaughterService.add(bean);
		} else {
			sysSlaughterService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSlaughter bean = sysSlaughterService.queryById(id);
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
		sysSlaughterService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
