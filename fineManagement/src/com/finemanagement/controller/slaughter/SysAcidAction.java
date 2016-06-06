/**
 * 项目名称：com.finemanagement.controller.slaughter
 * 创建日期：2016-5-2
 * 修改历史：
 *    1、[2016-5-2]创建文件    by liutianyang
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
import com.finemanagement.entity.slaughter.SysAcid;
import com.finemanagement.page.slaughter.SysAcidModel;
import com.finemanagement.service.slaughter.SysAcidService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysAcid")
public class SysAcidAction extends BaseAction {

	@Autowired(required = false)
	private SysAcidService<SysAcid> sysAcidService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysAcidModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysAcid> dataList = sysAcidService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("slaughter/sysAcid", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysAcidModel model, HttpServletResponse response) throws Exception {
		List<SysAcid> dataList = sysAcidService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		SysAcidModel model = new SysAcidModel();
		model.setCreateTime(DateUtil.getNowShortDate());
		List<SysAcid> dataList = sysAcidService.queryByList(model);
		Map<String, Object> context = getRootMap();
		SysAcid bean = new SysAcid();
		String acidBatch = "pspc" + DateUtil.getNowShortDate() + StringUtil.fillZero((dataList.size() 
				+ 1) + "", 3);
		bean.setAcidBatch(acidBatch);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysAcid bean, String[] slaughterBatchIds, HttpServletResponse response) throws Exception {
		bean.setSlaughterBatchId(Integer.parseInt(slaughterBatchIds[0]));
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			sysAcidService.add(bean);
		} else {
			sysAcidService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysAcid bean = sysAcidService.queryById(id);
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
		sysAcidService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
