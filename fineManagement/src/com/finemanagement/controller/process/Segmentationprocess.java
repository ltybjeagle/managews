package com.finemanagement.controller.process;

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
import com.base.util.StringUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.process.SysProcess;
import com.finemanagement.page.process.SysProcessModel;
import com.finemanagement.service.process.ProessService;

@Controller
@RequestMapping("/segmentationprocess")
public class Segmentationprocess extends BaseAction{
	
  @Autowired(required = false)
  private ProessService<SysProcess> proessService;
  /**
   * ilook 首页
   * @param model
   * @param request
   * @return
   */
  @RequestMapping("/list")
  public ModelAndView list(SysProcessModel model, HttpServletRequest request)throws Exception{
    Map<String, Object> context = getRootMap();
   // model.setSyssign("harvestplants");
    List<SysProcess> dataList = proessService.queryByList(model);
    // 设置页面数据
    context.put("dataList", dataList);
    return forword("/process/segmentationprocessing", context); 
  }
  
  /**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysProcessModel model, HttpServletResponse response) throws Exception {
		List<SysProcess> dataList = proessService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/loadProcessList") 
	public void loadProcessList(SysProcessModel model, HttpServletResponse response) throws Exception {
		model.setIs_completed("1");
		List<SysProcess> dataList = proessService.queryByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		SysProcessModel model = new SysProcessModel();
		model.setCreateTime(DateUtil.getNowShortDate());
		List<SysProcess> dataList = proessService.queryByList(model);
		Map<String, Object> context = getRootMap();
		SysProcess bean = new SysProcess();
		String batchprocessing = "jgpc" + DateUtil.getNowShortDate() + StringUtil.fillZero((dataList.size() 
				+ 1) + "", 3);
		bean.setBatchprocessing(batchprocessing);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 产品采收
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysProcess bean, String[] slaughterbatch, HttpServletResponse response) throws Exception {
		bean.setSlaughterbatch(slaughterbatch[0]);
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowShortDate());
			proessService.add(bean);
		} else {
			proessService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysProcess bean = proessService.queryById(id);
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
		proessService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
}
