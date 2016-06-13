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
import com.finemanagement.entity.common.SysNumberRules;
import com.finemanagement.entity.slaughter.SysWeighing;
import com.finemanagement.page.common.SysNumberRulesModel;
import com.finemanagement.page.slaughter.SysWeighingModel;
import com.finemanagement.service.common.SysNumberRulesService;
import com.finemanagement.service.slaughter.SysWeighingService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysWeighing")
public class SysWeighingAction extends BaseAction {

	@Autowired(required = false)
	private SysWeighingService<SysWeighing> sysWeighingService;
	
	@Autowired(required = false)
	private SysNumberRulesService<SysNumberRules> sysNumberRulesService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysWeighingModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysWeighing> dataList = sysWeighingService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("slaughter/sysWeighing", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysWeighingModel model, HttpServletResponse response) throws Exception {
		List<SysWeighing> dataList = sysWeighingService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		String iden = "btcz";
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
		SysWeighing bean = new SysWeighing();
		String weightNo = iden + DateUtil.getNowShortDate() + StringUtil.fillZero(mno + "", 6);
		bean.setWeightNo(weightNo);
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
	public void save(SysWeighing bean, String[] slaughterBatchIds, HttpServletResponse response) throws Exception {
		if (slaughterBatchIds != null && slaughterBatchIds.length > 0) {
			bean.setSlaughterBatchId(Integer.parseInt(slaughterBatchIds[0]));
		}
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			sysWeighingService.add(bean);
		} else {
			sysWeighingService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysWeighing bean = sysWeighingService.queryById(id);
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
		sysWeighingService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
