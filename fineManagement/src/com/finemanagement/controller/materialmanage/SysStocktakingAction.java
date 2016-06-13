package com.finemanagement.controller.materialmanage;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.finemanagement.entity.materialmanage.sysStocktakingEntity;
import com.finemanagement.page.materialmanage.sysStocktakingModel;
import com.finemanagement.service.materialmanage.sysStocktakingService;

@Controller
@RequestMapping("/SysStocktakingAction")
public class SysStocktakingAction extends BaseAction {
	
	@Autowired(required = false)
	private sysStocktakingService<sysStocktakingEntity> sysStocktakingService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysStocktakingModel model, HttpServletRequest request)throws Exception{
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<sysStocktakingEntity> dataList = sysStocktakingService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("materialmanage/SysStocktaking", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysStocktakingModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<sysStocktakingEntity> dataList = sysStocktakingService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(sysStocktakingEntity bean, HttpServletResponse response) throws Exception { 
		super.saveBean(bean);
		if(bean.getId()==null){
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			bean.setStocktime(df.format(new Date())+"");
			sysStocktakingService.add(bean);
			sendSuccessMessage(response, "添加成功~");
		}else{
			sysStocktakingService.updateBySelective(bean);
			sendSuccessMessage(response, "修改成功~");
		}	
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		sysStocktakingEntity bean = sysStocktakingService.queryById(id);
		if (bean  == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
}
