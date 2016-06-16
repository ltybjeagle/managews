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
import com.finemanagement.entity.iot.SysVideo;
import com.finemanagement.entity.iot.SysVideoConfig;
import com.finemanagement.entity.iotapp.SysMonitor;
import com.finemanagement.page.iot.SysSensorModel;
import com.finemanagement.page.iot.SysVideoModel;
import com.finemanagement.page.iotapp.SysIotappModel;
import com.finemanagement.service.facade.SysFacadeService;
import com.finemanagement.service.iot.SysVideoConfigService;
import com.finemanagement.service.iot.SysVideoService;
import com.finemanagement.service.iotapp.SysMonitorService;

@Controller
@RequestMapping(value = "/appThings")
public class AppThingsController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppThingsController.class);

	@Autowired(required = false)
	private SysFacadeService<?> sysFacadeService;

	@Autowired(required = false)
	private SysMonitorService<SysMonitor> sysMonitorService;

	@Autowired(required = false)
	private SysVideoService<SysVideo> sysVideoService;

	@Autowired(required = false)
	private SysVideoConfigService<SysVideoConfig> sysVideoConfigService;

	/**
	 * 视频查询接口
	 * 
	 * @param model
	 * @param req
	 * @param rep
	 */
	@RequestMapping("/appQueryVideoList")
	public void appQueryVideoList(SysVideoModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysVideo> dataList = sysVideoService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysVideo bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("baseId", bean.getBaseid());
				resMap.put("baseName", bean.getBaseName());
				resMap.put("greenhouseId", bean.getGreenhouseid());
				resMap.put("greenhouseName", bean.getGreenhouseName());
				resMap.put("equipmentNumber", bean.getEquipmentNumber());
				resMap.put("videoChannelNumber", bean.getVideoChannelNumber());
				resMap.put("videoMonitoringPoint", bean.getVideoMonitoringPoint());
				resList.add(resMap);
			}
			log.debug("APP查询视频信息成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			log.error(e.getMessage());
			sendAppFailure(rep, "查询视频异常!");
			e.printStackTrace();
		}

	}

	/**
	 * 查询传感器数据
	 * 
	 * @param model
	 * @param req
	 * @param rep
	 */
	@RequestMapping("/appQueryMonitorList")
	public void appQueryMonitorList(SysIotappModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysMonitor> dataList = sysMonitorService.querByAppList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysMonitor bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("airHumidity", bean.getAirHumidity());
				resMap.put("airTemperature", bean.getAirTemperature());
				resMap.put("dissolvedOxygenCon", bean.getDissolvedOxygenCon());
				resMap.put("diameterWidth", bean.getDiameterWidth());
				resMap.put("infraredTemperature", bean.getInfraredTemperature());
				resMap.put("soilEC", bean.getSoilEC());
				resMap.put("fruitSize", bean.getFruitSize());
				resMap.put("lightIntensity", bean.getLightIntensity());
				resMap.put("waterPH", bean.getWaterPH());
				resMap.put("windSpeed", bean.getWindSpeed());
				resMap.put("windDirection", bean.getWindDirection());
				resMap.put("receivedTime", bean.getReceivedTime());
				resMap.put("monitorNum", bean.getMonitorNum());
				resMap.put("photosyntheticRadiation", bean.getPhotosyntheticRadiation());
				resMap.put("soilHumidity", bean.getSoilHumidity());
				resMap.put("soilTemperature", bean.getSoilTemperature());
				resList.add(resMap);
			}
			log.debug("APP查询传感器成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			log.error(e.getMessage());
			sendAppFailure(rep, "查询传感器数据异常!");
			e.printStackTrace();
		}

	}

	@RequestMapping("/appQueryVideoConfigList")
	public void appQueryVideoConfigList(SysVideoModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			List<SysVideo> videoList = sysVideoService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysVideo sv : videoList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				SysVideoConfig videoConfig = sysVideoConfigService.queryById(sv.getConfig_id());
				resMap.put("ip", videoConfig.getDeviceIP());
				resMap.put("equipmentNumber", sv.getEquipmentNumber());
				resMap.put("user", videoConfig.getUser());
				resMap.put("password", videoConfig.getPassword());
				resMap.put("port", videoConfig.getDevicePort());
				resMap.put("videoChannelNumber", sv.getVideoChannelNumber());
				resMap.put("vdeoMonitoringPoint", sv.getVideoMonitoringPoint());
				resList.add(resMap);
			}
			log.debug("APP查询传感器成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			log.error(e.getMessage());
			sendAppFailure(rep, "查询传感器数据异常!");
		}
	}

	public void appQueryMonitorList(SysSensorModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			Object obj = req.getParameter("MonitorNum");
			List<Map<String, Object>> dataList = sysFacadeService.querSensorTypeList(obj);
			log.debug("APP查询传感器大棚信息成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			log.error(e.getMessage());
			sendAppFailure(rep, "查询传感器数据异常!");
			e.printStackTrace();
		}
	}

	public void aqqQuerySensorType(SysSensorModel model, HttpServletRequest req, HttpServletResponse rep) {

		String type = req.getParameter("MonitorType");
		try {
			List<Map<String, Object>> dataList = sysFacadeService.querMonitorTypeList(type);
			log.debug("APP查询传感器监控信息成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			log.error(e.getMessage());
			sendAppFailure(rep, "查询传感器数据异常!");
			e.printStackTrace();
		}

	}

}
