package com.finemanagement.controller.samping;

import java.io.File;
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
import com.finemanagement.entity.samping.SysSampingEntity;

import com.finemanagement.page.samping.SysSampingModel;
import com.finemanagement.service.samping.SysSampingService;

@Controller
@RequestMapping("/sysSamping")
public class SysSampingAction extends BaseAction {
	
	@Autowired(required = false)
	private SysSampingService<SysSampingEntity> sysSampingService;
	
	/**
	 * ilook 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysSampingModel model, HttpServletRequest request)throws Exception{
		super.indiModel(model);
		Map<String, Object> context = getRootMap();
		List<SysSampingEntity> dataList = sysSampingService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("samping/sampingmanage", context); 
	}
	
	/**
	 * json 列表页面
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void dataList(SysSampingModel model, String[] plantids, String[] baseids, String[] greehouseids, 
			HttpServletResponse response) throws Exception {
		super.indiModel(model);
		if (plantids != null && plantids.length > 0) {
			model.setSampname(plantids[0]);
		}
		if (baseids != null && baseids.length > 0) {
			model.setBaseid(Integer.parseInt(baseids[0]));
		}
		if (greehouseids != null && greehouseids.length > 0) {
			model.setGreenhouseid(Integer.parseInt(greehouseids[0]));
		}
		List<SysSampingEntity> dataList = sysSampingService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getSerializId")
	public void getSerializId(HttpServletResponse response) throws Exception {
		SysSampingModel model = new SysSampingModel();
		super.indiModel(model);
		model.setCreateTime(DateUtil.getNowFormateDate());
		List<SysSampingEntity> dataList = sysSampingService.queryDataByList(model);
		Map<String, Object> context = getRootMap();
		SysSampingEntity bean = new SysSampingEntity();
		String sampleno = "ypbh" + DateUtil.getNowShortDate() + StringUtil.fillZero((dataList.size() 
				+ 1) + "", 3);
		bean.setSampleno(sampleno);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 添加数据
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(SysSampingEntity bean, String[] sampname, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		super.saveBean(bean);
		String realPath = request.getSession().getServletContext().getRealPath("/uploadfile");  
		bean.setFilePath(realPath);
		bean.setSampname(sampname[0]);
		bean.setBaseid(Integer.parseInt(bean.getBaseName()));
		bean.setGreenhouseid(Integer.parseInt(bean.getGreenhousename()));
		if (bean.getId() == null) {
			bean.setCreateTime(DateUtil.getNowFormateDate());
			sysSampingService.addSamping(bean);
		} else {
			sysSampingService.updateBySelective(bean);
		}
		return "redirect:/sysSamping/list.shtml";
	}
	
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response) throws Exception {
		Map<String, Object> context = getRootMap();
		SysSampingEntity bean = sysSampingService.queryById(id);
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
		for (Integer sid : id) {
			SysSampingEntity bean = sysSampingService.queryById(sid);
			List<SysSampingEntity> list = sysSampingService.queryFileByNo(bean.getSampleno());
			for (SysSampingEntity file : list) {
				File samFile = new File(realPath + "/" + file.getFileName());
				if (samFile.isFile() && samFile.exists()) {
					samFile.delete();
				}
				//sysSampingService.deleteFileByID(file.getID());
			}
		}
		sysSampingService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
}
