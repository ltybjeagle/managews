/**
 * 项目名称：com.finemanagement
 * 创建日期：2016-4-06
 *  by zhangyong
 */
package com.finemanagement.controller.pick;

import java.math.BigDecimal;
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
import com.finemanagement.entity.pick.SysPick;
import com.finemanagement.page.pick.SysPickModel;
import com.finemanagement.service.pick.SysPickService;

/**
 *by zhangyong
 */
@Controller
@RequestMapping("/sysPickplants")
public class SysPickPlants extends BaseAction {

	@Autowired(required = false)
	private SysPickService<SysPick> sysPickService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysPickModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("pickplants");
		List<SysPick> dataList = sysPickService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("/pick/pickplants", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysPickModel model, String[] plantids, String[] baseids, String[] greehouseids, 
			HttpServletResponse response) throws Exception {
		if (plantids != null && plantids.length > 0) {
			model.setPlantid(Integer.parseInt(plantids[0]));
		}
		if (baseids != null && baseids.length > 0) {
			model.setBaseid(Integer.parseInt(baseids[0]));
		}
		if (greehouseids != null && greehouseids.length > 0) {
			model.setGreehouseid(Integer.parseInt(greehouseids[0]));
		}
		model.setSyssign("pickplants");
		List<SysPick> dataList = sysPickService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 产品采收
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(SysPick bean, String[] plantid, String[] baseid, String[]greehouseid, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");  
		bean.setFilePath(realPath);
		bean.setPlantid(Integer.parseInt(plantid[0]));
		bean.setBaseid(Integer.parseInt(baseid[0]));
		bean.setGreehouseid(Integer.parseInt(greehouseid[0]));
		bean.setSysid("plantsys");
		bean.setSyssign("pickplants");
		bean.setHarvesttime(DateUtil.getNowFormateDate());
		if (bean.getUnitprice() != null && !"".equals(bean.getUnitprice()) 
				&& bean.getNumberharvest() != null && !"".equals(bean.getNumberharvest())) {
			BigDecimal unitprice = new BigDecimal(bean.getUnitprice() + "");
			BigDecimal purchaseCount = new BigDecimal(bean.getNumberharvest() + "");
			bean.setAmt(unitprice.multiply(purchaseCount).toString());
		}
		if (bean.getId() == null) {
			sysPickService.addPickPlants(bean);
		} else {
			sysPickService.updateBySelective(bean);
		}
		return "redirect:/sysPickplants/list.shtml";
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysPick bean = sysPickService.querPickPlants(id);
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
		sysPickService.deletePickPlants(realPath, id);
		sendSuccessMessage(response, "删除成功");
	}
}
