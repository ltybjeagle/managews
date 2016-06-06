package com.finemanagement.controller.materialmanage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.finemanagement.entity.basic.SysWarehouse;
import com.finemanagement.entity.materialmanage.sysMaterialmanage;
import com.finemanagement.entity.materialmanage.sysStocktakingEntity;
import com.finemanagement.page.basic.SysWarehouseModel;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;
import com.finemanagement.page.materialmanage.sysStocktakingModel;
import com.finemanagement.service.basic.SysWarehouseService;
import com.finemanagement.service.materialmanage.sysMaterialService;
import com.finemanagement.service.materialmanage.sysStocktakingService;

@Controller
@RequestMapping("/sysMaterialStocktaking")
public class SysMaterialStocktaking extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	@Autowired(required = false)
	private sysStocktakingService<sysStocktakingEntity>sysStocktakingService;
	@Autowired(required = false)
	private SysWarehouseService<SysWarehouse> sysWarehouseService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysMaterialmanageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSyssign("7");//过滤掉所有数据
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("materialmanage/sysMaterialStocktaking", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSyssign("7");//过滤掉所有数据
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * json 添加列表数据
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getmaterial") 
	public void adddataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByUniteList(model);
		// 设置页面数据
		Map<String, Object> instoreMap = new HashMap<String, Object>();
		Map<String, Object> consumMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		for(int i =0; i < dataList.size();i++){
			sysMaterialmanage sys = dataList.get(i);
			if(sys.getSyssign().equals("1")){//统计入库数据
				if(instoreMap.containsKey(sys.getMaterialno()+"")){
					BigDecimal incount = new BigDecimal(instoreMap.get(sys.getMaterialno()+"")+"");
					instoreMap.put(sys.getMaterialno()+"", incount.add(new BigDecimal(sys.getStorecount()))+"");
				}else{
					instoreMap.put(sys.getMaterialno()+"", sys.getStorecount()+"");
				}
			}
			if(sys.getSyssign().equals("2")){//统计领用数据
				if(consumMap.containsKey(sys.getMaterialno()+"")){
					BigDecimal consumcount = new BigDecimal(consumMap.get(sys.getMaterialno()+"")+"");
					consumMap.put(sys.getMaterialno()+"", consumcount.add(new BigDecimal(sys.getConsumcount()))+"");
				}else{
					consumMap.put(sys.getMaterialno()+"", sys.getConsumcount()+"");
				}
			}
			if(sys.getSyssign().equals("3")){//统计归还数据
				if(returnMap.containsKey(sys.getMaterialno()+"")){
					BigDecimal returncount = new BigDecimal(returnMap.get(sys.getMaterialno()+"")+"");
					returnMap.put(sys.getMaterialno()+"", returncount.add(new BigDecimal(sys.getReturncount()))+"");
				}else{
					returnMap.put(sys.getMaterialno()+"", sys.getReturncount()+"");
				}
			}
		}
		for(Iterator<String> it = instoreMap.keySet().iterator();it.hasNext();){
			String no = (String) it.next();
			BigDecimal ins = new BigDecimal(instoreMap.get(no)+"");
			if(returnMap.get(no)!=null){
				ins = ins.add(new BigDecimal(returnMap.get(no)+""));
			}
			if(consumMap.get(no)!=null){
				ins =ins.subtract(new BigDecimal(consumMap.get(no)+""));
			}
			instoreMap.put(no, ins+"");
		}
		//重新组装列表数据
		List<sysMaterialmanage> data = new ArrayList<sysMaterialmanage>();
		for(int i =0; i < dataList.size();i++){
			sysMaterialmanage sys = dataList.get(i);
			if(instoreMap.containsKey(sys.getMaterialno()+"")){
				sys.setStorecount(instoreMap.get(sys.getMaterialno()+"")+"");
				data.add(sys);
				instoreMap.remove(sys.getMaterialno()+"");
			}
		}
		if(data.size()==0){
			for(int i =0; i < dataList.size();i++){
				sysMaterialmanage sys = dataList.get(i);
				sys.setStorecount("0");
				data.add(sys);
			}
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", data);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 盘库数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(sysMaterialmanage bean, 
			HttpServletResponse response) throws Exception {
		BigDecimal storecount = new BigDecimal(bean.getStorecount());
		BigDecimal firm = new BigDecimal(bean.getFirm());
		bean.setDifferences(firm.subtract(storecount)+"");
		if(storecount.compareTo(firm)==0){
			bean.setProfitloss("相符");
		}
		if(storecount.compareTo(firm)<0){
			bean.setProfitloss("盘盈");
		}
		if(storecount.compareTo(firm)>0){
			bean.setProfitloss("盘亏");
		}
		bean.setSyssign("4");//物资盘库
		bean.setSysid("plantsys");
		sysMaterialService.add(bean);
		sendSuccessMessage(response, "盘库成功~");
	}
	
	@RequestMapping("/getstocktalingno")
	public void getstocktalingno(sysStocktakingModel model, HttpServletResponse response)throws Exception {
		Map<String, Object> context = getRootMap();
		model.setSysid(super.getSysid());
		List<sysStocktakingEntity> dataList = sysStocktakingService.queryByList(model);
		String stocktalingno = "pkbh"+StringUtil.fillZero((dataList.size() 
				+ 1) + "", 6);
		sysStocktakingEntity bean = new sysStocktakingEntity();
		bean.setStocktalingno(stocktalingno);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/loadwarehouseidList") 
	public void loadwarehouseidList(SysWarehouseModel model, 
			HttpServletResponse response)throws Exception{
		model.setSysid(super.getSysid());
		List<SysWarehouse> dataList = sysWarehouseService.queryByList(model);
		List<SysWarehouse> newList = new ArrayList<SysWarehouse>();
		SysWarehouse sys = new SysWarehouse();
		sys.setId(0);
		sys.setWhName("--请选择--");
		newList.add(sys);
		newList.addAll(dataList);
		HtmlUtil.writerJson(response, newList);
	}
	
	@RequestMapping("/loadmaterialnoList") 
	public void loadmaterialnoList(sysMaterialmanageModel model, 
			HttpServletResponse response)throws Exception{
		model.setSysid(super.getSysid());
		List<sysMaterialmanage> dataList = sysMaterialService.queryByUniteList(model);
		// 设置页面数据
		Map<String, Object> instoreMap = new HashMap<String, Object>();
		Map<String, Object> consumMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i =0; i < dataList.size();i++){
			sysMaterialmanage sys = dataList.get(i);
			if(sys.getSyssign().equals("0")){//统计物资目录
				map.put(sys.getMaterialno()+"", "0");	
			}
			if(sys.getSyssign().equals("1")){//统计入库数据
				if(instoreMap.containsKey(sys.getMaterialno()+"")){
					BigDecimal incount = new BigDecimal(instoreMap.get(sys.getMaterialno()+"")+"");
					instoreMap.put(sys.getMaterialno()+"", incount.add(new BigDecimal(sys.getStorecount()))+"");
				}else{
					instoreMap.put(sys.getMaterialno()+"", sys.getStorecount()+"");
				}
			}
			if(sys.getSyssign().equals("2")){//统计领用数据
				if(consumMap.containsKey(sys.getMaterialno()+"")){
					BigDecimal consumcount = new BigDecimal(consumMap.get(sys.getMaterialno()+"")+"");
					consumMap.put(sys.getMaterialno()+"", consumcount.add(new BigDecimal(sys.getConsumcount()))+"");
				}else{
					consumMap.put(sys.getMaterialno()+"", sys.getConsumcount()+"");
				}
			}
			if(sys.getSyssign().equals("3")){//统计归还数据
				if(returnMap.containsKey(sys.getMaterialno()+"")){
					BigDecimal returncount = new BigDecimal(returnMap.get(sys.getMaterialno()+"")+"");
					returnMap.put(sys.getMaterialno()+"", returncount.add(new BigDecimal(sys.getReturncount()))+"");
				}else{
					returnMap.put(sys.getMaterialno()+"", sys.getReturncount()+"");
				}
			}
		}
		for(Iterator<String> it = instoreMap.keySet().iterator();it.hasNext();){
			String no = (String) it.next();
			BigDecimal ins = new BigDecimal(instoreMap.get(no)+"");
			if(returnMap.get(no)!=null){
				ins = ins.add(new BigDecimal(returnMap.get(no)+""));
			}
			if(consumMap.get(no)!=null){
				ins =ins.subtract(new BigDecimal(consumMap.get(no)+""));
			}
			instoreMap.put(no, ins+"");
		}
		
		for(Iterator<String> it = map.keySet().iterator();it.hasNext();){
			String no = (String) it.next();
			if(instoreMap.containsKey(no)||consumMap.containsKey(no)||returnMap.containsKey(no)){
			}else{
				instoreMap.put(no, "0");
			}
		}
		//重新组装列表数据
		List<sysMaterialmanage> data = new ArrayList<sysMaterialmanage>();
		for(int i =0; i < dataList.size();i++){
			sysMaterialmanage sys = dataList.get(i);
			if(instoreMap.containsKey(sys.getMaterialno()+"")){
				sys.setStorecount(instoreMap.get(sys.getMaterialno()+"")+"");
				data.add(sys);
				instoreMap.remove(sys.getMaterialno()+"");
			}
		}
		if(data.size()==0){
			for(int i =0; i < dataList.size();i++){
				sysMaterialmanage sys = dataList.get(i);
				sys.setStorecount("0");
				data.add(sys);
			}
		}
		
		List<sysMaterialmanage> newList = new ArrayList<sysMaterialmanage>();
		sysMaterialmanage sys = new sysMaterialmanage();
		sys.setId(0);
		sys.setMaterialno("--请选择--");
		newList.add(sys);
		newList.addAll(data);
		HtmlUtil.writerJson(response, newList);
	}
}
