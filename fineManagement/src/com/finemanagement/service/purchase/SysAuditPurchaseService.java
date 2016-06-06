/**
 * 项目名称：com.finemanagement.service.purchase
 * 创建日期：2016-4-6
 * 修改历史：
 *    1、[2016-4-6]创建文件    by liutianyang
 */
package com.finemanagement.service.purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.finemanagement.dao.purchase.SysAuditPurchaseDao;
import com.finemanagement.entity.purchase.SysPurchase;
import com.finemanagement.entity.user.SysUser;

/**
 * 
 * @author liutianyang
 */
@Service("sysAuditPurchaseService")
public class SysAuditPurchaseService<T> extends BaseService<T> {

	@Autowired
	private SysAuditPurchaseDao<T> sysAuditPurchaseDao;
	
	@Autowired
    protected TaskService taskService;
	
	public SysAuditPurchaseDao<T> getDao() {
		return sysAuditPurchaseDao;
	}
	
	@Override
	public String getMapperObj() {
		return "com.finemanagement.dao.purchase.SysAuditPurchaseDao";
	}
	
	public void auditPurchase(SysUser user, String state, String... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		StringBuffer pids = new StringBuffer();
		for (String id : ids) {
			pids.append(id).append(",");
		}
		List<T> dataList = sysAuditPurchaseDao.queryTaskList(getMapperObj() + ".queryTaskList", 
				pids.toString().substring(0, pids.toString().length() - 1));
		for (int i = 0; i < dataList.size(); i++) {
			T t = (T) dataList.get(i);
			SysPurchase sysPurchase = (SysPurchase) t;
			Map<String, Object> variables = new HashMap<String, Object>();
			taskService.claim(sysPurchase.getTaskid() + "", user.getCode());
			sysPurchase.setAuditId(user.getId());
			if ("1".equals(state)) {
				variables.put("auditPass", true);
				taskService.complete(sysPurchase.getTaskid() + "", variables);
				Task task = taskService.createTaskQuery().processInstanceId(sysPurchase.getProcessInstanceId()).singleResult();
				if (task == null) {
					sysPurchase.setTaskname("已终审");
					sysPurchase.setTaskkey("10");
				} else {
					sysPurchase.setTaskname("已审核");
					sysPurchase.setTaskkey("09");
				}
			} else {
				variables.put("auditPass", false);
				taskService.complete(sysPurchase.getTaskid() + "", variables);
				sysPurchase.setTaskname("已退回");
				sysPurchase.setTaskkey("05");
			}
			this.updateBySelective(t);
		}
	}
}
