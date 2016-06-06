/**
 * 项目名称：com.finemanagement.service.purchase
 * 创建日期：2016-3-30
 * 修改历史：
 *    1、[2016-3-30]创建文件    by liutianyang
 */
package com.finemanagement.service.purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.purchase.SysPurchaseDao;
import com.finemanagement.entity.purchase.SysPurchase;
import com.finemanagement.entity.user.SysUser;

/**
 * 
 * @author liutianyang
 */
@Service("sysPurchaseService")
public class SysPurchaseService<T> extends BaseService<T> {

	@Autowired
	private SysPurchaseDao<T> sysPurchaseDao;
	
	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    protected TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	
	public SysPurchaseDao<T> getDao() {
		return sysPurchaseDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.purchase.SysPurchaseDao";
	}
	
	public void addPurchase(T t, SysUser user) throws Exception {
		t = this.setUUID(t);
		SysPurchase bean = (SysPurchase) t;
		String businessKey = bean.getId();
		ProcessInstance processInstance = null;
		try {
			identityService.setAuthenticatedUserId(user.getCode() + "");
			Map<String, Object> variables = new HashMap<String, Object>();
            processInstance = runtimeService.startProcessInstanceByKey("purchase", businessKey, variables);
            String processInstanceId = processInstance.getId();
            bean.setTaskname("已录入");
            bean.setTaskkey("00");
            bean.setUserid(user.getId());
            bean.setProcessInstanceId(processInstanceId);
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
            Task task = tasks.get(0);
            taskService.claim(task.getId(), user.getCode());
			taskService.complete(task.getId());
            this.add(t);
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
	}
	
	public void deletePurchase(String... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		StringBuffer pids = new StringBuffer();
		for (String id : ids) {
			pids.append(id).append(",");
		}
		List<T> dataList = sysPurchaseDao.queryTaskList(getMapperObj() + ".queryTaskList", 
				pids.toString().substring(0, pids.toString().length() - 1));
		for (int i = 0; i < dataList.size(); i++) {
			T t = (T) dataList.get(i);
			SysPurchase sysPurchase = (SysPurchase) t;
			runtimeService.deleteProcessInstance(sysPurchase.getProcessInstanceId(), "");
			historyService.deleteHistoricProcessInstance(sysPurchase.getProcessInstanceId());
			getDao().deleteSysPurchase(getMapperObj() + ".delete", sysPurchase.getId());
		}
	}
	
	public void toAuditPurchase(SysUser user, String... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		StringBuffer pids = new StringBuffer();
		for (String id : ids) {
			pids.append(id).append(",");
		}
		List<T> dataList = sysPurchaseDao.queryTaskList(getMapperObj() + ".queryTaskList", 
				pids.toString().substring(0, pids.toString().length() - 1));
		for (int i = 0; i < dataList.size(); i++) {
			T t = (T) dataList.get(i);
			SysPurchase sysPurchase = (SysPurchase) t;
			taskService.claim(sysPurchase.getTaskid() + "", user.getCode());
			taskService.complete(sysPurchase.getTaskid() + "");
			sysPurchase.setTaskname("已送审");
			sysPurchase.setTaskkey("01");
			this.updateBySelective(t);
		}
	}
}
