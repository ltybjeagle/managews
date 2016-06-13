package com.finemanagement.controller.samping;

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
import com.finemanagement.entity.samping.SysSampingEntity;

import com.finemanagement.page.common.SysNumberRulesModel;
import com.finemanagement.page.samping.SysSampingModel;
import com.finemanagement.service.common.SysNumberRulesService;
import com.finemanagement.service.samping.SysSampingService;

@Controller
@RequestMapping("/sysSamping")
public class SysSampingAction extends BaseAction {
	
	@Autowired(required = false)
	private SysSampingService<SysSampingEntity> sysSampingService;
	
	@Autowired(required = false)
	private SysNumberRulesService<SysNumberRules> sysNumberRulesService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysSampingModel model, HttpServletRequest request)throws Exception{
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysSampingEntity> dataList = sysSampingService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("samping/sampingmanage", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysSampingModel model, String[] plantids, String[] baseids, String[] fowleryids, 
			HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (plantids != null && plantids.length > 0) {
			model.setSampname(plantids[0]);
		}
		if (baseids != null && baseids.length > 0) {
			model.setBaseid(Integer.parseInt(baseids[0]));
		}
		if (fowleryids != null && fowleryids.length > 0) {
			model.setFowleryid(Integer.parseInt(fowleryids[0]));
		}
		List<SysSampingEntity> dataList = sysSampingService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		String iden = "ypbh";
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
		SysSampingEntity bean = new SysSampingEntity();
		String sampleno = iden + DateUtil.getNowShortDate() + StringUtil.fillZero(mno + "", 6);
		bean.setSampleno(sampleno);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 添加数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(SysSampingEntity bean, String[] sampname, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");  
		bean.setFilePath(realPath);
		bean.setSampname(sampname[0]);
		bean.setBaseid(Integer.parseInt(bean.getBaseName()));
		bean.setFowleryid(Integer.parseInt(bean.getGreenhousename()));
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowFormateDate());
			sysSampingService.addSamping(bean);
		} else {
			sysSampingService.updateBySelective(bean);
		}
		return "redirect:/sysSamping/list.shtml";
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSampingEntity bean = sysSampingService.querSamping(id);
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
		sysSampingService.deleteSamping(realPath, id);
		sendSuccessMessage(response, "删除成功");
	}
}
