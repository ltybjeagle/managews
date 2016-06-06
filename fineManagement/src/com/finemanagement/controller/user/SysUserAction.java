/**
 * 项目名称：com.finemanagement.controller
 * 创建日期：2016-3-19
 * 修改历史：
 *    1、[2016-3-19]创建文件    by liutianyang
 */
package com.finemanagement.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.HtmlUtil;
import com.base.web.BaseAction;
import com.finemanagement.entity.user.SysUser;
import com.finemanagement.service.user.SysUserService;

/**
 * 
 * @author liutianyang
 */
@Controller
@RequestMapping("/sysUser") 
public class SysUserAction extends BaseAction {

	@Autowired(required = false)
	private SysUserService<SysUser> sysUserService; 
	
	// 种植员标识
	@Value("#{applicationProperties['system.plantationMember']}")
	private String plantationMember;
	
	// 技术员标识
	@Value("#{applicationProperties['system.technician']}")
	private String technician;
	
	// 饲养员标识
	@Value("#{applicationProperties['system.breeder']}")
	private String breeder;
	
	// 饲养技术员标识
	@Value("#{applicationProperties['system.breedTechnician']}")
	private String breedTechnician;
	
	/**
	 * @return the technician
	 */
	public String getTechnician() {
		return technician;
	}

	/**
	 * @param technician the technician to set
	 */
	public void setTechnician(String technician) {
		this.technician = technician;
	}

	/**
	 * @return the plantationMember
	 */
	public String getPlantationMember() {
		return plantationMember;
	}

	/**
	 * @param plantationMember the plantationMember to set
	 */
	public void setPlantationMember(String plantationMember) {
		this.plantationMember = plantationMember;
	}
	
	@RequestMapping("/queryPlantationMemberList") 
	public void  queryPlantationMemberList(HttpServletResponse response) throws Exception {
		List<SysUser> dataList = sysUserService.queryUserListByRole(plantationMember);
		HtmlUtil.writerJson(response, dataList);
	}
	
	@RequestMapping("/queryTechnicianList") 
	public void  queryTechnicianList(HttpServletResponse response) throws Exception {
		List<SysUser> dataList = sysUserService.queryUserListByRole(technician);
		HtmlUtil.writerJson(response, dataList);
	}
	
	@RequestMapping("/queryBreederList") 
	public void  queryBreederList(HttpServletResponse response) throws Exception {
		List<SysUser> dataList = sysUserService.queryUserListByRole(breeder);
		HtmlUtil.writerJson(response, dataList);
	}
	
	@RequestMapping("/queryBreedTechnicianList") 
	public void  queryBreedTechnicianList(HttpServletResponse response) throws Exception {
		List<SysUser> dataList = sysUserService.queryUserListByRole(breedTechnician);
		HtmlUtil.writerJson(response, dataList);
	}
}
