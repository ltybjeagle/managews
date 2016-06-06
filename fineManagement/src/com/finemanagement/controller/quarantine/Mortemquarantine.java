package com.finemanagement.controller.quarantine;

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
import com.finemanagement.entity.quarantine.SysQuarantine;
import com.finemanagement.page.puarantine.SysQuarantineModel;
import com.finemanagement.service.puarantine.QuarantineService;

@Controller
@RequestMapping("/mortemquarantine")
public class Mortemquarantine extends BaseAction{
	
	@Autowired(required = false)
	private QuarantineService<SysQuarantine> quarantineService;
	  
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysQuarantineModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		List<SysQuarantine> dataList = quarantineService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
	    return forword("/quarantine/mortemquarantine", context); 
	}
	  
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysQuarantineModel model, HttpServletResponse response) throws Exception {
		List<SysQuarantine> dataList = quarantineService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		SysQuarantineModel model = new SysQuarantineModel();
		model.setCreateTime(DateUtil.getNowShortDate());
		List<SysQuarantine> dataList = quarantineService.queryByList(model);
		Map<String, Object> context = getRootMap();
		SysQuarantine bean = new SysQuarantine();
		String quarantineBatch = "zhjypc" + DateUtil.getNowShortDate() + StringUtil.fillZero((dataList.size() 
				+ 1) + "", 3);
		bean.setQuarantineBatch(quarantineBatch);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
		
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysQuarantine bean = quarantineService.queryById(id);
		if (bean  == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
		
	/**
	 * 产品采收
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysQuarantine bean, String[] batchprocessing, HttpServletResponse response) throws Exception {
		bean.setBatchprocessing(batchprocessing[0]);
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			quarantineService.add(bean);
		} else {
			quarantineService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
		
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response) throws Exception {
		quarantineService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
