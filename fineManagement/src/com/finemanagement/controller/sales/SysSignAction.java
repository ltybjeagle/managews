/**
 * 项目名称：com.finemanagement.controller.sales
 * 创建日期：2016-5-5
 * 修改历史：
 *    1、[2016-5-5]创建文件    by liutianyang
 */
package com.finemanagement.controller.sales;

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
import com.base.web.BaseAction;
import com.finemanagement.entity.sales.SysDistribution;
import com.finemanagement.entity.sales.SysSign;
import com.finemanagement.page.sales.SysDistributionModel;
import com.finemanagement.page.sales.SysSignModel;
import com.finemanagement.service.sales.SysDistributionService;
import com.finemanagement.service.sales.SysSignService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysSign")
public class SysSignAction extends BaseAction {

	@Autowired(required = false)
	private SysSignService<SysSign> sysSignService;
	
	@Autowired(required = false)
	private SysDistributionService<SysDistribution> sysDistributionService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysSignModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysSign> dataList = sysSignService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sales/sysSign", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysSignModel model, String[] distributionStatus, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (distributionStatus != null && distributionStatus.length > 0) {
			model.setDistributionStatus(Integer.parseInt(distributionStatus[0]));
		}
		List<SysSign> dataList = sysSignService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAdd") 
	public ModelAndView toAdd(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("sales/toAdd", context); 
	}
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/toEdit") 
	public ModelAndView toEdit(Integer id, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSign bean = sysSignService.queryById(id);
		context.put("data", bean);
		return forword("sales/toEdit", context); 
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSign bean = new SysSign();
		String distributionNo = DateUtil.getNowPlusTimeMill();
		bean.setDistributionNo(distributionNo);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/getDistributionList")
	public void getDistributionList(SysDistributionModel model, HttpServletResponse response) 
			throws Exception {
		List<SysDistribution> dataList = sysDistributionService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveSign")
	public void save(SysSign bean, HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (bean.getId() == null) {
			bean.setDistributionStatus(2);
			bean.setReleaseTime(DateUtil.getNowPlusTime());
			sysSignService.add(bean);
		} else {
			sysSignService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysDistribution bean, String distributionNos, HttpServletResponse response) throws Exception {
		if (bean.getId() == null) {
			bean.setDistributionNo(distributionNos);
			sysDistributionService.add(bean);
		} else {
			sysDistributionService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysDistribution bean = sysDistributionService.queryById(id);
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
		sysDistributionService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	@RequestMapping("/deleteSign")
	public void deleteSign(Integer[] id, HttpServletResponse response) throws Exception {
		for (Integer id_ : id) {
			SysSign bean = sysSignService.queryById(id_);
			sysDistributionService.deleteDistributionList(bean.getDistributionNo());
		}
		sysSignService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	@RequestMapping("/signOk")
	public void signOk(Integer[] id, String signPerson, HttpServletResponse response) throws Exception {
		for (Integer id_ : id) {
			SysSign bean = sysSignService.queryById(id_);
			bean.setSignPerson(signPerson);
			bean.setSignTime(DateUtil.getNowLongTime());
			bean.setDistributionStatus(1);
			sysSignService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "签收成功");
	}
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showDetails") 
	public ModelAndView showDetails(Integer id, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSignModel model = new SysSignModel();
		model.setId(id);
		List<SysSign> dataList = sysSignService.queryByList(model);
		SysSign bean = dataList.get(0);
		context.put("data", bean);
		return forword("sales/showDetails", context); 
	}
}
