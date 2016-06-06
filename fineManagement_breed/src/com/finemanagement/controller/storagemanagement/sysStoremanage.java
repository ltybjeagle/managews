package com.finemanagement.controller.storagemanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.storagemanagement.sysStoremanageEntity;
import com.finemanagement.page.slaughter.SysSlaughterModel;
import com.finemanagement.page.storagemanagement.sysStoremanageModel;
import com.finemanagement.service.storagemanagement.sysStoremanageService;

@Controller
@RequestMapping("/sysStoragemanagement")
public class sysStoremanage extends BaseAction {

	@Autowired(required = false)
	sysStoremanageService<sysStoremanageEntity> sysStoremanageService;

	/**
	 * ilook 首页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysStoremanageModel model, HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		List<sysStoremanageEntity> dataList = sysStoremanageService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("storagemanagement/sysStoremanage", context);
	}

	/**
	 * json 列表页面
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(sysStoremanageModel model, HttpServletResponse response) throws Exception {
		List<sysStoremanageEntity> dataList = sysStoremanageService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}

	/**
	 * 入库数据
	 * 
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(sysStoremanageEntity bean, String[] warehouseids, String[] principals, 
			HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		if (warehouseids != null && warehouseids.length > 0 && !"".equals(warehouseids[0])) {
			bean.setWarehouseid(warehouseids[0]);
		}
		if (principals != null && principals.length > 0 && !"".equals(principals[0])) {
			bean.setPrincipal(principals[0]);
		}
		if (bean.getId() == null) {
			sysStoremanageService.add(bean);
			sendSuccessMessage(response, "入库成功~");
		} else {
			sysStoremanageService.updateBySelective(bean);
			sendSuccessMessage(response, "修改成功~");
		}
	}

	@RequestMapping("/loadstoremanageList")
	public void loadSlaughterList(SysSlaughterModel model, HttpServletResponse response) throws Exception {
		List<sysStoremanageEntity> dataList = sysStoremanageService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}

	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		sysStoremanageEntity bean = sysStoremanageService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}

	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response) throws Exception {
		sysStoremanageService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
