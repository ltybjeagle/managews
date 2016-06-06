/**
 * 项目名称：com.finemanagement.controller
 * 创建日期：2016-4-6
 * 修改历史：
 *    1、[2016-4-6]创建文件    by liutianyang
 */
package com.finemanagement.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.interceptor.Command;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.activiti.HistoryProcessInstanceDiagramCmd;
import com.base.web.BaseAction;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysActiviti")
public class ActivitiAction extends BaseAction {

	@Autowired
	protected RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;
	
	@RequestMapping("/forWardImage")
	public ModelAndView forWardImage(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		String processInstanceId = request.getParameter("processInstanceId");
		context.put("processInstanceId", processInstanceId);
		return forword("viewProcessInstanceHistory", context); 
	}
	
	@RequestMapping("/traceImage")
	public void traceImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String processInstanceId = request.getParameter("processInstanceId");
		Command<InputStream> cmd = new HistoryProcessInstanceDiagramCmd(processInstanceId);
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine(); 
		InputStream is = processEngine.getManagementService().executeCommand(cmd);
		int len = 0;
        byte[] b = new byte[1024];
        while ((len = is.read(b, 0, 1024)) != -1) {
        	response.getOutputStream().write(b, 0, len);
        }
	}
	
	@RequestMapping("/taskHistoryList")
	public void taskHistoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String processInstanceId = request.getParameter("processInstanceId");
		List<HistoricTaskInstance> historicTasks = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(processInstanceId).list();
		StringBuffer rows = new StringBuffer();
        for (HistoricTaskInstance hi : historicTasks) {
        	rows.append("{'name':'" + hi.getName() + "','processInstanceId':'" + hi.getProcessInstanceId() + 
        			"','startTime':'" + hi.getStartTime() + "','endTime':'" + hi.getEndTime() + "','assignee':'" + 
        			hi.getAssignee() + "','deleteReason':'" + hi.getDeleteReason() + "'},");
        }
        String rowStr = StringUtils.substringBeforeLast(rows.toString(), ",");
        JSONObject jObject = JSONObject.fromObject("{'total':" + historicTasks.size() + ",'rows':[" + rowStr + "]}");
        // 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out= null;
		out = response.getWriter();
		out.print(jObject.toString());
		out.flush();
		out.close();
	}
}
