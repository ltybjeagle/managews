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
import com.finemanagement.entity.common.SysNumberRules;
import com.finemanagement.entity.slaughter.SysPreSlaughterQuarantine;
import com.finemanagement.page.common.SysNumberRulesModel;
import com.finemanagement.page.slaughter.SysPreSlaughterQuarantineModel;
import com.finemanagement.service.common.SysNumberRulesService;
import com.finemanagement.service.slaughter.SysPreSlaughterQuarantineService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysPreSlaughterQuarantine") 
public class SysPreSlaughterQuarantineAction extends BaseAction {

	@Autowired(required = false)
	private SysPreSlaughterQuarantineService<SysPreSlaughterQuarantine> sysPreSlaughterQuarantineService;
	
	@Autowired(required = false)
	private SysNumberRulesService<SysNumberRules> sysNumberRulesService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysPreSlaughterQuarantineModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysPreSlaughterQuarantine> dataList = sysPreSlaughterQuarantineService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("slaughter/sysPreSlaughterQuarantine", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysPreSlaughterQuarantineModel model, String[] selectResult, HttpServletResponse response) 
			throws Exception {
		if (selectResult != null && selectResult.length > 0 && !"0".equals(selectResult[0])) {
			model.setQuarantineResults(Integer.parseInt(selectResult[0]));
		}
		List<SysPreSlaughterQuarantine> dataList = sysPreSlaughterQuarantineService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping("/loadPSQList")
	public void loadPreSlaughterQuarantineList(SysPreSlaughterQuarantineModel model, HttpServletResponse response) 
			throws Exception {
		List<SysPreSlaughterQuarantine> dataList = sysPreSlaughterQuarantineService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		String iden = "jypc";
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
		SysPreSlaughterQuarantine bean = new SysPreSlaughterQuarantine();
		String quarantineBatch = iden + DateUtil.getNowShortDate() + StringUtil.fillZero(mno + "", 6);
		String breedingBatch = "yzpc" + DateUtil.getNowShortDate() + StringUtil.fillZero(mno + "", 6);
		bean.setQuarantineBatch(quarantineBatch);
		bean.setBreedingBatch(breedingBatch);
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
	public String save(SysPreSlaughterQuarantine bean, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");  
		bean.setFilePath(realPath);
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			sysPreSlaughterQuarantineService.addPreSlaughterQuarantine(bean);
		} else {
			sysPreSlaughterQuarantineService.updateBySelective(bean);
		}
		return "redirect:/sysPreSlaughterQuarantine/list.shtml";
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysPreSlaughterQuarantine bean = sysPreSlaughterQuarantineService.queryPreSlaughterQuarantine(id);
		if (bean  == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");
		sysPreSlaughterQuarantineService.deletePreSlaughterQuarantine(realPath, id);
		sendSuccessMessage(response, "删除成功");
	}
}
