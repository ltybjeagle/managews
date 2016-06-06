package com.finemanagement.controller.storagemanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.finemanagement.entity.storagemanagement.SysStoragemanagement;
import com.finemanagement.page.storagemanagement.SysStorageModel;
import com.finemanagement.service.storagemanagement.SysStorageService;

@Controller
@RequestMapping("/sysProductoutstore")
public class SysOutStorage extends BaseAction {

	@Autowired(required =false)
	SysStorageService<SysStoragemanagement> sysStorageService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysStorageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("-1");
		List<SysStoragemanagement> dataList = sysStorageService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("storagemanagement/sysOutstorage", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysStorageModel model, HttpServletResponse response) throws Exception {
		model.setSyssign("-1");
		List<SysStoragemanagement> dataList = sysStorageService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 出库数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysStoragemanagement bean, String[] warehouseid, HttpServletResponse response) throws Exception {  
		bean.setWarehouseid(Integer.parseInt(warehouseid[0]));
		if(bean.getId()==null){
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			bean.setOutstoretime(df.format(new Date())+"");
			bean.setSyssign("-1");
			bean.setSysid("plantsys");
			sysStorageService.add(bean);
			sendSuccessMessage(response, "出库成功~");
		}else{
			sysStorageService.updateBySelective(bean);
			sendSuccessMessage(response, "修改成功~");
		}
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysStoragemanagement bean = sysStorageService.queryById(id);
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
		sysStorageService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
