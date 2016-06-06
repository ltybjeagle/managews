<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>蓝海精细化管理系统</title>
<%@ include file="/view/resource.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/learunui-startmenu.css">
<script type="text/javascript" src="<%=basePath%>/js/ux/main/main.js"></script>
</head>
<body class="easyui-layout">
<div class="ui-header" data-options="region:'north',border:false" style="height:68px;overflow: hidden;">
<div class="header">
<div class="logo fleft">
    <img src="<%=basePath%>/plug-in/login/images/loginlogo-2.png" />
</div>
<div id="Headermenu">
	<ul id="topnav">
		<li id="metnav_5" class="list">
			<div style="height:23px"></div>
          	<div>
          		欢迎 <span class="orange">${user.nickName}</span> 第[<span class="orange">${user.loginCount}</span>]次登录
          	</div>
          	<div id="CurrentTime"></div>
      	</li>
		<li id="metnav_5" class="list">
          <a id="nav_5" class="modify-pwd-btn"><span class="c5"></span>修改密码</a>
      	</li>
		<li id="metnav_4" class="list">
			<a id="nav_4" href="<%=basePath%>/sysMain/logout.shtml"><span class="c4"></span>安全退出</a>
		</li>
	</ul>
</div>
</div>
</div>
<!-- 树形菜单 -->
<div data-options="region:'west',split:true,title:'功能导航'" style="width:200px;">
	<div id="tree-box" class="easyui-accordion" data-options="fit:true,border:false">
		<c:forEach var="item" items="${menuList}">
		<div title="${item.text}" style="overflow:auto";>
			<ul id="tree" class="easyui-tree" data-options="lines:true"> 
				<c:forEach var="node" items="${item.children}">
				<c:choose>
					<c:when test="${node.isleaf == 0}">
						<li><span>${node.text}</span>
						<ul>
							<c:forEach var="fnode" items="${node.children}">
								<li><a class="menu-item" href="<%=basePath%>${fnode.url}" style="padding-left: 15px;">
									<span>${fnode.text}</span></a></li>
							</c:forEach>
						</ul>
						</li>
					</c:when>
					<c:otherwise>
						<li><a class="menu-item" href="<%=basePath%>${node.url}" style="padding-left: 15px;">
							<span>${node.text}</span></a></li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</ul>
		</div>
		</c:forEach>
	</div>
</div>
<div data-options="region:'south',split:true,border:false" style="height: 30px;overflow:hidden;">
	<div class="panel-header" style="border: none;text-align: center;" ></div>
</div>
<!-- 中间内容页面 -->
<div data-options="region:'center'" >
	<div class="easyui-tabs" id="tab-box" data-options="fit:true,border:false">
		<div title="Welcome" style="padding:20px;overflow:hidden;"> 
			<div style="margin-top:35px;text-align:center">
				<img src="<%=basePath%>/plug-in/login/images/welcome.png" />
			</div>
		</div>
	</div>	
</div>
<!--  modify password start -->
<div id="modify-pwd-win"  class="easyui-dialog" buttons="#editPwdbtn" title="修改用户密码" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
<form id="pwdForm" action="modifyPwd.do" class="ui-form" method="post">
   		 <input class="hidden" name="id">
   		 <input class="hidden" name="code">
   		 <div class="ui-edit">
          <div class="fitem">  
             <label>旧密码:</label>  
             <input id="oldPwd" name="oldPwd" type="password" class="easyui-validatebox"  data-options="required:true"/>
          </div>
           <div class="fitem">  
              <label>新密码:</label>  
              <input id="newPwd" name="newPwd" type="password" class="easyui-validatebox" data-options="required:true" />
          </div> 
          <div class="fitem">  
              <label>重复密码:</label>  
             <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"   required="required" validType="equals['#newPwd']" />
          </div> 
        </div>
   	 </form>
   	 <div id="editPwdbtn" class="dialog-button" >  
          <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">保存</a>  
          <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
       </div>
</div>
<!-- modify password end  -->
<script type="text/javascript">
$(document).ready(function() {
	ServerCurrentTime();
});
</script>
</body>
</html>