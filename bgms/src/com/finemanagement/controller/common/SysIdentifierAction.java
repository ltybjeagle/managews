/**
 * 项目名称：com.finemanagement.controller.common
 * 创建日期：2016-3-24
 * 修改历史：
 *    1、[2016-3-24]创建文件    by liutianyang
 */
package com.finemanagement.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.common.SysIdentifier;
import com.finemanagement.page.common.SysIdentifierModel;
import com.finemanagement.service.common.SysIdentifierService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysIdentifier") 
public class SysIdentifierAction extends BaseAction {

	@Autowired(required = false) 
	private SysIdentifierService<SysIdentifier> sysIdentifierService;
	
	@RequestMapping("/loadIdentifierList")
	public void loadIdentifierList(SysIdentifierModel model, HttpServletResponse response) throws Exception {
		List<SysIdentifier> identifierList = sysIdentifierService.querySysIdentifierList(model);
		HtmlUtil.writerJson(response, identifierList);
	}
}
