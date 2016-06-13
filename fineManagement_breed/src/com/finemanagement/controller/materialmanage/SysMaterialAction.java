package com.finemanagement.controller.materialmanage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finemanagement.page.common.SysNumberRulesModel;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;

import com.finemanagement.service.common.SysNumberRulesService;
import com.finemanagement.service.materialmanage.sysMaterialService;
import com.finemanagement.entity.common.SysNumberRules;
import com.finemanagement.entity.materialmanage.sysMaterialmanage;

import com.base.util.HtmlUtil;
import com.base.util.StringUtil;
import com.base.web.BaseAction;

@Controller
@RequestMapping("/sysMaterialmanage")
public class SysMaterialAction extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	
	@Autowired(required = false)
	private SysNumberRulesService<SysNumberRules> sysNumberRulesService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysMaterialmanageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("0");//物资
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("materialmanage/Sysmaterialmanage", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSyssign("0");//物资
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
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
	public void save(sysMaterialmanage bean, HttpServletResponse response) throws Exception {  
		super.saveBean(bean);
		bean.setMfid(bean.getMfid());
		bean.setBrandId(bean.getBrandId());
		if(bean.getId()==null){
			bean.setSyssign("0");
			sysMaterialService.add(bean);
			sendSuccessMessage(response, "添加成功~");
		}else{
			sysMaterialService.updateBySelective(bean);
			sendSuccessMessage(response, "修改成功~");
		}	
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		sysMaterialmanage bean = sysMaterialService.queryById(id);
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
		sysMaterialService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	@RequestMapping("/getmaterialno")
	public void getMaterialno(HttpServletResponse response)throws Exception {
		String iden = "wzbh";
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
		String materialno = iden + StringUtil.fillZero(mno + "", 6);
		sysMaterialmanage bean = new sysMaterialmanage();
		bean.setMaterialno(materialno);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
}
