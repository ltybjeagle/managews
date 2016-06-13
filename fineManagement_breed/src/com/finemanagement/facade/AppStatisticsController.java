/**
 * 项目名称：com.finemanagement.facade
 * 创建日期：2016-5-18
 * 修改历史：
 *    1、[2016-5-18]创建文件    by liutianyang
 */
package com.finemanagement.facade;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.BeanUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.production.SysInputs;
import com.finemanagement.entity.production.SysPlant;
import com.finemanagement.entity.slaughter.SysSlaughter;
import com.finemanagement.page.production.SysInputsModel;
import com.finemanagement.page.production.SysPlantModel;
import com.finemanagement.page.slaughter.SysSlaughterModel;
import com.finemanagement.service.production.SysInputsService;
import com.finemanagement.service.production.SysPlantService;
import com.finemanagement.service.slaughter.SysSlaughterService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping(value = "/appStatistics")
public class AppStatisticsController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppStatisticsController.class);

	@Autowired(required = false)
	private SysInputsService<SysInputs> sysInputsService; // 投入品

	@Autowired(required = false)
	private SysSlaughterService<SysSlaughter> sysSlaughterService; // 出栏

	@Autowired(required = false)
	private SysPlantService<SysPlant> sysPlantService; // 采收

	/**
	 * json 投入品列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryInputTable")
	public void appQueryInputTable(SysInputsModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			Map<String, Object> map = BeanUtil.transBean2Map(model);
			map.put("start_date", start_date);
			map.put("end_date", end_date);
			List<SysInputs> dataList = sysInputsService.queryByStatistics(map);
			log.debug("APP查询投入品使用统计成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询投入品使用统计异常!");
		}
	}

	/**
	 * json 采收列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryHarvestData")
	public void appQueryHarvestData(SysPlantModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			Map<String, Object> map = BeanUtil.transBean2Map(model);
			map.put("startStartTime", start_date);
			map.put("endStartTime", end_date);
			List<SysPlant> dataList = sysPlantService.queryByStatistics(map);
			log.debug("APP查询采收统计成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询采收统计异常!");
		}
	}

	/**
	 * json 投入产出列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryInputOutData")
	public void appQueryInputOutData(SysInputsModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			Map<String, Object> map = BeanUtil.transBean2Map(model);
			map.put("start_date", start_date);
			map.put("end_date", end_date);
			List<SysInputs> dataList = sysInputsService.queryByStatistics(map);
			log.debug("APP查询投入产出统计成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询投入产出统计异常!");
		}
	}

	/**
	 * json 出栏列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQuerySlaughterData")
	public void appQuerySlaughterData(SysSlaughterModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			Map<String, Object> map = BeanUtil.transBean2Map(model);
			map.put("start_date", start_date);
			map.put("end_date", end_date);
			List<SysSlaughter> dataList = sysSlaughterService.queryByStatistics(map);
			log.debug("APP查询出栏统计成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			log.error(e.getMessage());
			sendAppFailure(rep, "查询出栏统计异常!");
			e.printStackTrace();
		}
	}

}
