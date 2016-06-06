/**
 * 项目名称：com.finemanagement.controller.production
 * 创建日期：2016-6-5
 * 修改历史：
 *    1、[2016-6-5]创建文件    by liutianyang
 */
package com.finemanagement.controller.production;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.production.SysVariety;
import com.finemanagement.page.production.SysVarietyModel;
import com.finemanagement.service.production.SysVarietyService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysVariety")
public class SysVarietySction extends BaseAction {

	@Autowired(required = false)
	private SysVarietyService<SysVariety> sysVarietyService;
	
	@RequestMapping("/loadVarietyList") 
	public void loadVarietyList(SysVarietyModel model, HttpServletResponse response) throws Exception {
		super.indiModel(model);
		List<SysVariety> dataList = sysVarietyService.queryDataByList(model);
		HtmlUtil.writerJson(response, dataList);
	}
}
