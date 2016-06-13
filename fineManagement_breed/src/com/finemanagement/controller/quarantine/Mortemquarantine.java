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
import com.finemanagement.entity.common.SysNumberRules;
import com.finemanagement.entity.quarantine.SysQuarantine;
import com.finemanagement.page.common.SysNumberRulesModel;
import com.finemanagement.page.puarantine.SysQuarantineModel;
import com.finemanagement.service.common.SysNumberRulesService;
import com.finemanagement.service.puarantine.QuarantineService;

@Controller
@RequestMapping("/mortemquarantine")
public class Mortemquarantine extends BaseAction{
	
	@Autowired(required = false)
	private QuarantineService<SysQuarantine> quarantineService;
	
	@Autowired(required = false)
	private SysNumberRulesService<SysNumberRules> sysNumberRulesService;
	  
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
	public void dataList(SysQuarantineModel model, String[] selectResult, HttpServletResponse response) throws Exception {
		if (selectResult != null && selectResult.length > 0 && !"0".equals(selectResult[0])) {
			model.setQuarantineResults(selectResult[0]);
		}
		List<SysQuarantine> dataList = quarantineService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		String iden = "zhjypc";
		SysNumberRulesModel model = new SysNumberRulesModel();
		super.indiModel(model);
		model.setRuleIden(iden);
		List<SysNumberRules> dataList = sysNumberRulesService.queryDataByList(model);
		int mno = 1;
		if (dataList != null && dataList.size() > 0) {
			SysNumberRules sysNumberRules = dataList.get(0);
			mno = sysNumberRules.getRuleNum();
			mno++;
			sysNumberRules.setRuleNum(mno);
			sysNumberRulesService.updateBySelective(sysNumberRules);
		} else {
			SysNumberRules sysNumberRules = new SysNumberRules();
			super.saveBean(sysNumberRules);
			sysNumberRules.setRuleIden(iden);
			sysNumberRules.setRuleNum(mno);
			sysNumberRulesService.add(sysNumberRules);
		}
		Map<String, Object> context = getRootMap();
		SysQuarantine bean = new SysQuarantine();
		String quarantineBatch = iden + DateUtil.getNowShortDate() + StringUtil.fillZero(mno + "", 6);
		bean.setQuarantineBatch(quarantineBatch);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
		
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysQuarantine bean = quarantineService.queryQuarantine(id);
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
	public String save(SysQuarantine bean, String[] batchprocessing, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile"); 
		bean.setFilePath(realPath);
		bean.setBatchprocessing(batchprocessing[0]);
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			quarantineService.addQuarantine(bean);
		} else {
			quarantineService.updateBySelective(bean);
		}
		return "redirect:/mortemquarantine/list.shtml";
	}
		
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");
		quarantineService.deletePreSlaughterQuarantine(realPath, id);
		sendSuccessMessage(response, "删除成功");
	}
}
