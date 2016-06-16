/**
 * 项目名称：com.finemanagement.facade
 * 创建日期：2016-4-19
 * 修改历史：
 *    1、[2016-4-19]创建文件    by liutianyang
 */
package com.finemanagement.facade;

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

import com.base.web.BaseAction;
import com.finemanagement.entity.basic.SysFowlery;
import com.finemanagement.entity.basic.SysFowleryType;
import com.finemanagement.entity.basic.SysGreenhouse;
import com.finemanagement.entity.production.SysBreed;
import com.finemanagement.entity.production.SysInputs;
import com.finemanagement.entity.production.SysInputsBreed;
import com.finemanagement.entity.production.SysPlant;
import com.finemanagement.entity.production.SysTask;
import com.finemanagement.entity.production.SysTaskBreed;
import com.finemanagement.page.basic.SysFowleryModel;
import com.finemanagement.page.basic.SysFowleryTypeModel;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.page.production.SysBreedModel;
import com.finemanagement.page.production.SysInputsBreedModel;
import com.finemanagement.page.production.SysInputsModel;
import com.finemanagement.page.production.SysPlantModel;
import com.finemanagement.page.production.SysTaskBreedModel;
import com.finemanagement.page.production.SysTaskModel;
import com.finemanagement.service.basic.SysFowleryService;
import com.finemanagement.service.basic.SysFowleryTypeService;
import com.finemanagement.service.basic.SysGreenhouseService;
import com.finemanagement.service.production.SysBreedService;
import com.finemanagement.service.production.SysInputsBreedService;
import com.finemanagement.service.production.SysInputsService;
import com.finemanagement.service.production.SysPlantService;
import com.finemanagement.service.production.SysTaskBreedService;
import com.finemanagement.service.production.SysTaskService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping(value = "/appProduction")
public class AppProductionController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppProductionController.class);

	@Autowired(required = false)
	private SysGreenhouseService<SysGreenhouse> sysGreenhouseService;

	@Autowired(required = false)
	private SysPlantService<SysPlant> sysPlantService;

	@Autowired(required = false)
	private SysTaskService<SysTask> sysTaskService;

	@Autowired(required = false)
	private SysInputsService<SysInputs> sysInputsService;

	@Autowired(required = false)
	private SysFowleryTypeService<SysFowleryType> sysFowleryTypeService;

	@Autowired(required = false)
	private SysFowleryService<SysFowlery> sysFowleryService;

	@Autowired(required = false)
	private SysBreedService<SysBreed> sysBreedService;

	@Autowired(required = false)
	private SysTaskBreedService<SysTaskBreed> sysTaskBreedService;

	@Autowired(required = false)
	private SysInputsBreedService<SysInputsBreed> sysInputsBreedService;

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryFowleryTypeList")
	public void appQueryFowleryTypeList(SysFowleryTypeModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysFowleryType> dataList = sysFowleryTypeService.queryByList(model);
			log.debug("APP查询禽舍类型成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询禽舍类型异常!");
		}
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryGHList")
	public void appQueryGHList(SysGreenhouseModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysGreenhouse> dataList = sysGreenhouseService.queryByList(model);
			log.debug("APP查询大棚成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询大棚异常!");
		}
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryFowleryList")
	public void appQueryFowleryList(SysFowleryModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysFowlery> dataList = sysFowleryService.queryByList(model);
			log.debug("APP查询禽舍成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询禽舍异常!");
		}
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryPlantList")
	public void appQueryPlantList(SysPlantModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysPlant> dataList = sysPlantService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysPlant bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("startTime", bean.getStartTime());
				resMap.put("variety", bean.getVariety());
				resMap.put("plantArea", bean.getPlantArea());
				resMap.put("endTime", bean.getEndTime());
				resMap.put("plantationMemberName", bean.getPlantationMemberName());
				resMap.put("technicianName", bean.getTechnicianName());
				resList.add(resMap);
			}
			log.debug("APP查询种植记录成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询种植记录异常!");
		}
	}

	@RequestMapping("/appSavePlantList")
	public void appSavePlantList(SysPlant bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			sysPlantService.add(bean);
			log.debug("APP保存种植计划成功!");
			sendAppSuccess(rep, null);
		} catch (Exception e) {
			sendAppFailure(rep, "保存种植计划异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryBreedList")
	public void appQueryBreedList(SysBreedModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysBreed> dataList = sysBreedService.queryByList(model);
			log.debug("APP查询养殖记录成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询养殖记录异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryTaskList")
	public void appQueryTaskList(SysTaskModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysTask> dataList = sysTaskService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysTask bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("taskTime", bean.getTaskTime());
				resMap.put("taskName", bean.getTaskName());
				resMap.put("taskContent", bean.getTaskContent());
				resMap.put("plantationMemberName", bean.getPlantationMemberName());
				resMap.put("technicianName", bean.getTechnicianName());
				resList.add(resMap);
			}
			log.debug("APP查询种植任务成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询种植任务异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryTaskBreed")
	public void appQueryTaskBreed(SysTaskBreedModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysTaskBreed> dataList = sysTaskBreedService.queryByList(model);
			log.debug("APP查询养殖任务成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询养殖任务异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appQueryInputsList")
	public void appQueryInputsList(SysInputsModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysInputs> dataList = sysInputsService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysInputs bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("startTime", bean.getStartTime());
				resMap.put("classname", bean.getClassname());
				resMap.put("inputName", bean.getInputName());
				resMap.put("brandName", bean.getBrandName());
				resMap.put("mfName", bean.getMfName());
				resMap.put("purchaseCount", bean.getPurchaseCount());
				resMap.put("unit", bean.getUnit());
				resMap.put("plantationMemberName", bean.getPlantationMemberName());
				resMap.put("technicianName", bean.getTechnicianName());
				resMap.put("remark", bean.getRemark());
				resList.add(resMap);
			}
			log.debug("APP查询种植投入品成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询种植投入品异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appSaveTaskList")
	public void appSaveTaskList(SysTask bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			sysTaskService.add(bean);
			log.debug("APP保存种植任务成功!");
			sendAppSuccess(rep, null);
		} catch (Exception e) {
			sendAppFailure(rep, "保存种植任务异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appSaveTaskBreedList")
	public void appSaveTaskBreedList(SysTaskBreed bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			sysTaskBreedService.add(bean);
			log.debug("APP保存养殖任务成功!");
			sendAppSuccess(rep, bean);
		} catch (Exception e) {
			sendAppFailure(rep, "保存养殖任务异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appQueryInputsBreed")
	public void appQueryInputsBreed(SysInputsBreedModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysInputsBreed> dataList = sysInputsBreedService.queryByList(model);
			log.debug("APP查询养殖投入品成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询养殖投入品异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appSaveInputsList")
	public void appSaveInputsList(SysInputs bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			sysInputsService.add(bean);
			log.debug("APP保存种植投入品成功!");
			sendAppSuccess(rep, null);
		} catch (Exception e) {
			sendAppFailure(rep, "保存种植投入品异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appSaveInputsBreed")
	public void appSaveInputsBreed(SysInputsBreed bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			sysInputsBreedService.add(bean);
			log.debug("APP保存养殖投入品成功!");
			sendAppSuccess(rep, bean);
		} catch (Exception e) {
			sendAppFailure(rep, "保存养殖投入品异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
