/**
 * 项目名称：com.finemanagement.controller.inputs
 * 创建日期：2016-3-29
 * 修改历史：
 *    1、[2016-3-29]创建文件    by liutianyang
 */
package com.finemanagement.controller.inputs;

import java.util.ArrayList;
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
import com.base.util.StringUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.inputs.SysProduct;
import com.finemanagement.page.inputs.SysProductModel;
import com.finemanagement.service.inputs.SysProductService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysProduct") 
public class SysProductAction extends BaseAction {

	@Autowired(required = false)
	private SysProductService<SysProduct> sysProductService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list") 
	public ModelAndView list(SysProductModel model, HttpServletRequest request) throws Exception {
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysProduct> dataList = sysProductService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("inputs/sysProduct", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysProductModel model, String[] classifyId, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (classifyId != null && classifyId.length > 0) {
			model.setClassifyId(Integer.parseInt(classifyId[0]));
		}
		List<SysProduct> dataList = sysProductService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadSysProductList") 
	public void loadSysProductList(SysProductModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysProduct> dataList = sysProductService.queryDataByList(model);
		List<SysProduct> newList = new ArrayList<SysProduct>();
		SysProduct sp = new SysProduct();
		sp.setId(0);
		sp.setProductNo("--请选择--");
		newList.add(sp);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		SysProductModel model = new SysProductModel();
		super.indiModel(model);
		List<SysProduct> dataList = sysProductService.queryDataByList(model);
		int mno = 1;
		if (dataList != null && dataList.size() > 0) {
			SysProduct sysProduct = dataList.get(0);
			mno = sysProduct.getId();
			mno++;
		}
		Map<String, Object> context = getRootMap();
		SysProduct bean = new SysProduct();
		String productNo = "trp" + StringUtil.fillZero(mno + "", 6);
		bean.setProductNo(productNo);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 添加或修改数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysProduct bean, String[] classifyIds, String[] brandIds, String[] mfids, 
			HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		bean.setClassifyId(Integer.parseInt(classifyIds[0]));
		bean.setBrandId(Integer.parseInt(brandIds[0]));
		bean.setMfid(Integer.parseInt(mfids[0]));
		if (bean.getId() == null) {
			sysProductService.add(bean);
		} else {
			sysProductService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysProduct bean = sysProductService.queryById(id);
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
		sysProductService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
