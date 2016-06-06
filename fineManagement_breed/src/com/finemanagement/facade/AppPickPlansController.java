/**
 * 项目名称：com.finemanagement.facade
 * 创建日期：2016-5-18
 * 修改历史：
 *    1、[2016-5-18]创建文件    by liutianyang
 */
package com.finemanagement.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.DateUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.pick.SysPick;
import com.finemanagement.page.pick.SysPickModel;
import com.finemanagement.service.pick.SysPickService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping(value="/appPickPlans")
public class AppPickPlansController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppPickPlansController.class);
	
	@Autowired(required = false)
	private SysPickService<SysPick> sysPickService;
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryPickPlansList") 
	public void appQueryPickPlansList(SysPickModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			model.setSyssign("pickplans");
			List<SysPick> dataList = sysPickService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysPick bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("harvesttime", bean.getHarvesttime());
				resMap.put("variety", bean.getVariety());
				resMap.put("grade", bean.getGrade());
				resMap.put("numberharvest", bean.getNumberharvest());
				resMap.put("unitprice", bean.getUnitprice());
				resMap.put("amt", bean.getAmt());
				resMap.put("harveststaff", bean.getHarveststaff());
				resMap.put("inspectionstaff", bean.getInspectionstaff());
				resMap.put("baseName", bean.getBaseName());
				resMap.put("greenhousename", bean.getGreenhousename());
				resList.add(resMap);
			}
			log.debug("APP查询采收计划成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询采收计划异常!");
		}
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryHarvestPlansList") 
	public void appQueryHarvestPlansList(SysPickModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			model.setSyssign("harvestplants");
			List<SysPick> dataList = sysPickService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysPick bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("harvesttime", bean.getHarvesttime());
				resMap.put("variety", bean.getVariety());
				resMap.put("grade", bean.getGrade());
				resMap.put("numberharvest", bean.getNumberharvest());
				resMap.put("unitprice", bean.getUnitprice());
				resMap.put("amt", bean.getAmt());
				resMap.put("harveststaff", bean.getHarveststaff());
				resMap.put("inspectionstaff", bean.getInspectionstaff());
				resMap.put("baseName", bean.getBaseName());
				resMap.put("greenhousename", bean.getGreenhousename());
				resList.add(resMap);
			}
			log.debug("APP查询采摘计划成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询采摘计划异常!");
		}
	}
	
	@RequestMapping("/appSavePickPlansList")
	public void appSavePickPlansList(SysPick bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			bean.setSyssign("pickplans");
			bean.setReleasetime(DateUtil.getNowFormateDate());
			sysPickService.add(bean);
			log.debug("APP保存采收计划成功!");
			sendAppSuccess(rep, null);
		} catch (Exception e) {
			sendAppFailure(rep, "保存采收计划异常!");
		}
	}
	
	@RequestMapping("/appSaveHarvestPlansList")
	public void appSaveHarvestPlansList(SysPick bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			bean.setSyssign("harvestplants");
			bean.setHarvesttime(DateUtil.getNowFormateDate());
			if (bean.getUnitprice() != null && !"".equals(bean.getUnitprice()) 
					&& bean.getNumberharvest() != null && !"".equals(bean.getNumberharvest())) {
				BigDecimal unitprice = new BigDecimal(bean.getUnitprice() + "");
				BigDecimal purchaseCount = new BigDecimal(bean.getNumberharvest() + "");
				bean.setAmt(unitprice.multiply(purchaseCount).toString());
			}
			sysPickService.add(bean);
			log.debug("APP保存采收计划成功!");
			sendAppSuccess(rep, null);
		} catch (Exception e) {
			sendAppFailure(rep, "保存采收计划异常!");
		}
	}
	
}
