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
import com.base.web.BaseAction;
import com.finemanagement.entity.materialmanage.sysMaterialmanage;
import com.finemanagement.page.materialmanage.sysMaterialmanageModel;
import com.finemanagement.service.materialmanage.sysMaterialService;

@Controller
@RequestMapping("/sysMaterialQuery")
public class SysMaterialQueryAction extends BaseAction {
	
	@Autowired(required = false)
	private sysMaterialService<sysMaterialmanage> sysMaterialService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(sysMaterialmanageModel model, HttpServletRequest request)throws Exception{
		Map<String, Object> context = getRootMap();
		model.setSysid(super.getSysid());
		List<sysMaterialmanage>dataList = sysMaterialService.queryByUniteList(model);
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
		context.put("dataList", data);
		return forword("materialmanage/SysMaterialQuery", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(sysMaterialmanageModel model, HttpServletResponse response) throws Exception {
		model.setSysid(super.getSysid());
		List<sysMaterialmanage>dataList = sysMaterialService.queryByUniteList(model);
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
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", data);
		HtmlUtil.writerJson(response, jsonMap);
	}
}
