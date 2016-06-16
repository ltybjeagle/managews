/**
 * 项目名称：com.finemanagement.facade
 * 创建日期：2016-4-25
 * 修改历史：
 *    1、[2016-4-25]创建文件    by liutianyang
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
import com.finemanagement.entity.production.SysInputs;
import com.finemanagement.entity.purchase.SysPurchase;
import com.finemanagement.entity.store.SysStore;
import com.finemanagement.page.production.SysInputsModel;
import com.finemanagement.page.purchase.SysPurchaseModel;
import com.finemanagement.page.store.SysStoreModel;
import com.finemanagement.service.production.SysInputsService;
import com.finemanagement.service.purchase.SysPurchaseService;
import com.finemanagement.service.store.SysStoreService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping(value = "/appStore")
public class AppStoreController extends BaseAction {

	private final static Logger log = Logger.getLogger(AppStoreController.class);

	@Autowired(required = false)
	private SysStoreService<SysStore> sysStoreService;

	@Autowired(required = false)
	private SysPurchaseService<SysPurchase> sysPurchaseService;

	@Autowired(required = false)
	private SysInputsService<SysInputs> sysInputsService;

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appQueryStoreList")
	public void appQueryStoreList(SysStoreModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			List<SysStore> dataList = sysStoreService.queryByList(model);
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			for (SysStore bean : dataList) {
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("id", bean.getId());
				resMap.put("productNo", bean.getProductNo());
				resMap.put("inputName", bean.getInputName());
				resMap.put("classname", bean.getClassname());
				resMap.put("specifications", bean.getSpecifications());
				resMap.put("unit", bean.getUnit());
				resMap.put("purchaseCount", bean.getPurchaseCount());
				resMap.put("unitPrice", bean.getUnitPrice());
				resMap.put("totalprice", bean.getTotalprice());
				resMap.put("brandName", bean.getBaseName());
				resMap.put("mfName", bean.getMfName());
				resMap.put("whName", bean.getWhName());
				resList.add(resMap);
			}
			log.debug("APP查询库存成功!");
			sendAppSuccess(rep, resList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询库存异常!");
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
	@RequestMapping("/appQueryPurchaseList")
	public void appQueryPurchaseList(SysPurchaseModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			model.setTaskkey("10");
			model.setIsinstore("0");
			List<SysPurchase> dataList = sysPurchaseService.queryByList(model);
			log.debug("APP查询待入库信息成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询待入库信息异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/appSavePurchaseToStore")
	public void appSavePurchaseToStore(SysStore bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.saveBean(bean);
			String purchaseid = req.getParameter("purchaseid");
			SysPurchase sysPurchase = sysPurchaseService.queryById(purchaseid);
			bean.setProductNo(sysPurchase.getProductNo());
			bean.setInputName(sysPurchase.getInputName());
			bean.setClassname(sysPurchase.getClassname());
			bean.setUnit(sysPurchase.getUnit());
			bean.setSpecifications(sysPurchase.getSpecifications());
			bean.setBrandName(sysPurchase.getBrandName());
			bean.setMfName(sysPurchase.getMfName());
			BigDecimal unitprice = new BigDecimal(sysPurchase.getUnitPrice() + "");
			BigDecimal purchaseCount = new BigDecimal(sysPurchase.getPurchaseCount() + "");
			bean.setPurchaseCount(sysPurchase.getPurchaseCount());
			bean.setUnitPrice(sysPurchase.getUnitPrice());
			bean.setTotalprice(unitprice.multiply(purchaseCount).toString());
			bean.setInstoretime(DateUtil.getNowFormateDate());
			bean.setSyssign("1");
			bean.setProcessInstanceId(purchaseid);
			sysStoreService.add(bean);
			// 更新采购计划表
			sysStoreService.updateplan(bean);
			log.debug("APP保存入库信息成功!");
			sendAppSuccess(rep, bean);
		} catch (Exception e) {
			sendAppFailure(rep, "保存入库信息异常!");
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
	@RequestMapping("/appQueryIninventoryList")
	public void appQueryIninventoryList(SysStoreModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			List<SysStore> dataList = sysStoreService.queryByList(model);
			log.debug("APP查询入库清单成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询入库清单异常!");
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
	@RequestMapping("/appQueryInputsList")
	public void appQueryInputsList(SysInputsModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			model.setIsoutstore("0");
			List<SysInputs> dataList = sysInputsService.queryByList(model);
			log.debug("APP查询出库投入品成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询出库投入品异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 入库数据
	 * 
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appSaveInputsToStore")
	public void appSaveInputsToStore(SysStore bean, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.saveBean(bean);
			String inputid = req.getParameter("inputid");
			SysInputs sysInputs = sysInputsService.queryById(inputid);
			bean.setProductNo(sysInputs.getProductNo());
			bean.setInputName(sysInputs.getInputName());
			bean.setBrandName(sysInputs.getBrandName());
			bean.setClassname(sysInputs.getClassname());
			bean.setMfName(sysInputs.getMfName());
			bean.setBaseid(sysInputs.getBaseid());
			bean.setGreenhouseid(sysInputs.getGreenhouseid());
			bean.setSpecifications(sysInputs.getSpecifications());
			bean.setUnit(sysInputs.getUnit());
			bean.setUnitPrice(sysInputs.getUnitPrice());
			bean.setPurchaseCount(sysInputs.getPurchaseCount());
			BigDecimal unitprice = new BigDecimal(sysInputs.getUnitPrice() + "");
			BigDecimal purchaseCount = new BigDecimal(sysInputs.getPurchaseCount() + "");
			bean.setTotalprice(unitprice.multiply(purchaseCount).toString());
			bean.setOutstoretime(DateUtil.getNowFormateDate());
			bean.setSyssign("-1");
			// bean.setSysid("plantsys");
			bean.setProcessInstanceId(inputid + "");
			sysStoreService.add(bean);
			// 更新投入品表
			sysStoreService.updateinput(bean);
			log.debug("APP保存投入品出库信息成功!");
			sendAppSuccess(rep, bean);
		} catch (Exception e) {
			sendAppFailure(rep, "保存投入品出库信息异常!");
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
	@RequestMapping("/appQueryOutinventoryList")
	public void appQueryOutinventoryList(SysStoreModel model, HttpServletRequest req, HttpServletResponse rep) {
		try {
			super.indiModel(model);
			List<SysStore> dataList = sysStoreService.queryByList(model);
			log.debug("APP查询出库清单成功!");
			sendAppSuccess(rep, dataList);
		} catch (Exception e) {
			sendAppFailure(rep, "查询出库清单异常!");
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
