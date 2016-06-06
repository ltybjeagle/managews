/**
 * 项目名称：com.test.facade
 * 创建日期：2016-3-31
 * 修改历史：
 *    1、[2016-3-31]创建文件    by liutianyang
 */
package com.test.facade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

/**
 * 
 * @author liutianyang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/spring-common.xml", 
	"classpath*:/spring/spring-mybatis.xml", "classpath*:/spring/spring-servlet.xml"})
public class AppController {

	// 模拟request,response  
	private MockHttpServletRequest request;  
      
    // 执行测试方法之前初始化模拟request,response  
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
    }         
    /** 
     *  
     * @Title：testLogin 
     * @Description: 测试用户登录   
     */  
    @Test  
    public void testLogin() {   
        try {  
        	request.setParameter("USERNAME", "test01");
        	request.setParameter("PASSWORD", "888888");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
