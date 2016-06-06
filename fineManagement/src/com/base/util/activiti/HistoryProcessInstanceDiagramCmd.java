/**
 * 项目名称：com.base.util.activiti
 * 创建日期：2016-4-4
 * 修改历史：
 *    1、[2016-4-4]创建文件    by liutianyang
 */
package com.base.util.activiti;

import java.io.InputStream;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;

/**
 * 
 * @author liutianyang
 */
public class HistoryProcessInstanceDiagramCmd implements Command<InputStream> {

	protected String historyProcessInstanceId;
	
	public HistoryProcessInstanceDiagramCmd(String historyProcessInstanceId) {
        this.historyProcessInstanceId = historyProcessInstanceId;
    }
	
	public InputStream execute(CommandContext commandContext) {
		try {
            CustomProcessDiagramGenerator customProcessDiagramGenerator = new CustomProcessDiagramGenerator();
            return customProcessDiagramGenerator.generateDiagram(historyProcessInstanceId);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
	}
}
