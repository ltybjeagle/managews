/**
 * 项目名称：com.finemanagement.facade
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
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
import com.finemanagement.entity.basic.SysBase;
import com.finemanagement.entity.basic.SysEmployees;
import com.finemanagement.entity.basic.SysGreenhouseType;
import com.finemanagement.entity.basic.SysWarehouse;
import com.finemanagement.entity.inputs.SysClassify;
import com.finemanagement.entity.inputs.SysProduct;
import com.finemanagement.entity.iot.SysSensor;
import com.finemanagement.entity.iotapp.SysMonitor;
import com.finemanagement.entity.production.SysPlant;
import com.finemanagement.entity.production.SysTask;
import com.finemanagement.page.basic.SysBaseModel;
import com.finemanagement.page.basic.SysEmployeesModel;
import com.finemanagement.page.basic.SysGreenhouseModel;
import com.finemanagement.page.basic.SysGreenhouseTypeModel;
import com.finemanagement.page.basic.SysWarehouseModel;
import com.finemanagement.page.inputs.SysClassifyModel;
import com.finemanagement.page.inputs.SysProductModel;
import com.finemanagement.page.iot.SysSensorModel;
import com.finemanagement.page.iotapp.SysIotappModel;
import com.finemanagement.page.production.SysPlantModel;
import com.finemanagement.page.production.SysTaskModel;
import com.finemanagement.service.basic.SysBaseService;
import com.finemanagement.service.basic.SysEmployeesService;
import com.finemanagement.service.basic.SysGreenhouseTypeService;
import com.finemanagement.service.basic.SysWarehouseService;
import com.finemanagement.service.facade.SysFacadeService;
import com.finemanagement.service.inputs.SysClassifyService;
import com.finemanagement.service.inputs.SysProductService;
import com.finemanagement.service.iot.SysSensorService;
import com.finemanagement.service.iotapp.SysMonitorService;
import com.finemanagement.service.production.SysPlantService;
import com.finemanagement.service.production.SysTaskService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping(value = "/appBase")
public class AppBaseController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppBaseController.class);

	@Autowired(required = false)
	private SysBaseService<SysBase> sysBaseService;

	@Autowired(required = false)
	private SysClassifyService<SysClassify> sysClassifyService;

	@Autowired(required = false)
	private SysWarehouseService<SysWarehouse> sysWarehouseService;

	@Autowired(required = false)
	private SysProductService<SysProduct> sysProductService;

	@Autowired(required = false)
	private SysGreenhouseTypeService<SysGreenhouseType> sysGreenhouseTypeService;

	@Autowired(required = false)
	private SysTaskService<SysTask> sysTaskService;

	@Autowired(required = false)
	private SysEmployeesService<SysEmployees> sysEmployeesService;

	@Autowired(required = false)
	private SysPlantService<SysPlant> sysPlantService;

	@Autowired(required = false)
	private SysFacadeService<?> sysFacadeService;

	@Autowired(required = false)
	private SysSensorService<SysSensor> sysSensorService;

	@Autowired(required = false)
	private SysMonitorService<SysMonitor> sysMonitorService;

	@RequestMapping("/appQuerybaseList")
	public void appQuerybaseList(SysBaseModel model, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			List<SysBase> dataList = sysBaseService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysBase bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("baseName", bean.getBaseName());
				resMap.put("responsible", bean.getResponsible());
				resMap.put("baseArea", bean.getBaseArea());
				resMap.put("baseAddress", bean.getBaseAddress());
				resMap.put("phoneNo", bean.getPhoneNo());
				resMap.put("createTime", bean.getCreateTime());
				resList.add(resMap);
			}
			log.debug("APP查询基地成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询基地异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appQueryGreenhouseList")
	public void appQueryGreenhouseList(SysGreenhouseModel model, HttpServletResponse rep) {
		try {
			List<Map<String, Object>> dataList = sysFacadeService.queryGreenhouseList(model);
			SysSensorModel sensor = new SysSensorModel();
			sensor.setBaseid(model.getBaseid());
			List<SysSensor> sensorList = sysSensorService.queryByList(sensor);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			SysPlantModel page = new SysPlantModel();
			page.setBaseid(model.getBaseid());
			List<SysPlant> plantList = sysPlantService.queryByList(page);
			for (Map<String, Object> bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.get("id"));
				for (SysPlant plant : plantList) {
					if (bean.get("id").equals(plant.getGreenhouseid())) {
						Map<String, Object> resplanMap = new HashMap<String, Object>();
						resplanMap.put("id", plant.getId());
						resplanMap.put("startTime", plant.getStartTime());
						resplanMap.put("varietyid", plant.getVarietyid());
						resplanMap.put("variety", plant.getVariety());
						resplanMap.put("plantArea", plant.getPlantArea());
						resplanMap.put("endTime", plant.getEndTime());
						resplanMap.put("plantationMemberName", plant.getPlantationMemberName());
						resplanMap.put("technicianName", plant.getTechnicianName());
						resMap.put("plans", resplanMap);
						break;
					}
				}
				for (SysSensor sensorbean : sensorList) {
					if (bean.get("id").equals(sensorbean.getGreenhouseid())) {
						Map<String, Object> resmonitorMap = new HashMap<String, Object>();
						SysIotappModel iotapp = new SysIotappModel();
						iotapp.setMonitorNum(sensorbean.getEquipmentNumber());
						List<SysMonitor> monitorList = sysMonitorService.querByAppList(iotapp);
						for (SysMonitor moni : monitorList) {
							resmonitorMap.put("airHumidity", moni.getAirHumidity());
							resmonitorMap.put("airTemperature", moni.getAirTemperature());
							resmonitorMap.put("diameterWidth", moni.getDiameterWidth());
							resmonitorMap.put("dissolvedOxygenCon", moni.getDissolvedOxygenCon());
							resmonitorMap.put("fruitSize", moni.getFruitSize());
							resmonitorMap.put("infraredTemperature", moni.getInfraredTemperature());
							resmonitorMap.put("lightIntensity", moni.getLightIntensity());
							resmonitorMap.put("photosyntheticRadiation", moni.getPhotosyntheticRadiation());
							resmonitorMap.put("rainFall", moni.getRainFall());
							resmonitorMap.put("soilEC", moni.getSoilEC());
							resmonitorMap.put("receivedTime", moni.getReceivedTime());
							resmonitorMap.put("soilHumidity", moni.getSoilHumidity());
							resmonitorMap.put("soilTemperature", moni.getSoilTemperature());
							resmonitorMap.put("waterPH", moni.getWaterPH());
							resmonitorMap.put("windDirection", moni.getWindDirection());
							resmonitorMap.put("windSpeed", moni.getWindSpeed());
							resMap.put("monitor", resmonitorMap);
							break;
						}
						break;
					}
				}
				resMap.put("name", bean.get("name"));
				resMap.put("ghArea", bean.get("ghArea"));
				resMap.put("technician", bean.get("technician"));
				resMap.put("plantationMember", bean.get("plantationMember"));
				resMap.put("baseid", bean.get("baseid"));
				resMap.put("baseName", bean.get("baseName"));
				resMap.put("greenhouseName", bean.get("greenhouseName"));
				resMap.put("createTime", bean.get("createTime"));
				resList.add(resMap);
			}
			log.debug("APP查询大棚成功!");
			sendAppSuccess(rep, resList);

		} catch (Exception e) {
			log.error(e.toString());
			sendAppFailure(rep, "查询大棚异常!");
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
	@RequestMapping("/appQueryGHTypeList")
	public void appQueryGHTypeList(SysGreenhouseTypeModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysGreenhouseType> dataList = sysGreenhouseTypeService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysGreenhouseType bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("greenhouseName", bean.getGreenhouseName());
				resMap.put("greenhouseCount", bean.getGreenhouseCount());
				resList.add(resMap);
			}
			log.debug("APP查询大棚类型成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询大棚类型异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appQueryTaskTypeList")
	public void appQueryTaskTypeList(SysTaskModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			List<SysTask> dataList = sysTaskService.queryTaskTypeList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysTask bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("taskName", bean.getTaskName());
				resList.add(resMap);
			}
			log.debug("APP查询任务类型成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询任务类型异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appQueryProductList")
	public void appQueryProductList(SysProductModel model, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			List<SysProduct> dataList = sysProductService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysProduct bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("productNo", bean.getProductNo());
				resMap.put("classname", bean.getClassname());
				resMap.put("inputName", bean.getInputName());
				resMap.put("brandName", bean.getBrandName());
				resMap.put("mfName", bean.getMfName());
				resMap.put("specifications", bean.getSpecifications());
				resMap.put("unit", bean.getUnit());
				resList.add(resMap);
			}
			log.debug("APP查询投入品成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询投入品异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/appQueryClassifyList")
	public void appQueryClassifyList(SysClassifyModel model, HttpServletResponse rep) {
		try {
			List<SysClassify> dataList = sysClassifyService.queryByList(model);
			log.debug("APP查询商品类型成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询商品类型异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/appQueryWhList")
	public void appQueryWhList(SysWarehouseModel model, HttpServletResponse rep) {
		try {
			List<SysWarehouse> dataList = sysWarehouseService.queryByList(model);
			log.debug("APP查询仓库成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询仓库异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appQueryEmployeeList")
	public void appQueryEmployeeList(SysEmployeesModel model, HttpServletResponse rep) throws Exception {
		try {
			super.indiModel(model);
			List<SysEmployees> dataList = sysEmployeesService.queryDataByList(model);
			log.debug("APP查询员工信息成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询员工信息异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
