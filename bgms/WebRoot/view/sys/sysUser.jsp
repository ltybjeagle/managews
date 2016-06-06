<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body  class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
<form id="searchForm">
	<p class="ui-fields">
	    <label class="ui-label">用户账号:</label><input name="code" class="easyui-box ui-text" style="width:100px;">
       <label class="ui-label">昵称: </label><input name="nickName" class="easyui-box ui-text" style="width:100px;">
   </p>
   <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
 </form>  
</div> 
<!--  Search panel end -->
<!-- DataList  -->
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<!-- Edit Form -->
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">  
 	<form id="editForm" class="ui-form" method="post">  
 		 <input class="hidden" type="text" name="id">
 		 <input class="hidden" name="deleted">
 		 <div class="ui-edit">
  	   <div class="ftitle">系统用户信息</div>    
        <div class="fitem">  
            <label>用户账号:</label>  
            <input class="easyui-validatebox" type="text" name="code" data-options="required:true,validType:'code'">
        </div>  
         
        <div class="fitem">  
            <label>昵称:</label>  
            <input class="easyui-validatebox" type="text" name="nickName" data-options="required:true,validType:'length[1,10]'">
        </div>
         <div class="fitem">  
            <label>状态:</label>  
            <select class="easyui-combobox" id="state" name="state" data-options="required:true,editable:false,panelHeight:'auto'" 
            	style="padding:2px;width:141px;">
                	<option value="0">可用</option>
                	<option value="1">禁用</option>
               	</select>
        </div> 
      </div>
 	</form>
</div>
<!-- Edit Password Form -->
<div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="修改密码" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<input class="hidden" name="id">
 		<div class="ui-edit">
  	   	<div class="ftitle">系统用户信息</div>    
        <div class="fitem">  
            <label>用户账号:</label>  
            <input class="easyui-validatebox" type="text" readonly="readonly" name="code">
        </div>  
        <div class="fitem">  
           <label>旧密码:</label>  
           <input id="oldPwd" name="oldPwd" type="password" class="easyui-validatebox" data-options="required:true"/>
        </div>
         <div class="fitem">  
            <label>新置密码:</label>  
            <input id="newPwd" name="newPwd" type="password" class="easyui-validatebox" data-options="required:true" />
        </div> 
        <div class="fitem">  
            <label>确认密码:</label>  
           <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"   required="required" validType="equals['#newPwd']" />
        </div> 
      </div>
 	</form>
 	 <div id="editPwdbtn" class="dialog-button">  
        <a href="#" class="easyui-linkbutton" id="btn-pwd-submit">保存</a>  
        <a href="#" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
    </div>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">系统用户信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>昵称:</label></td><td><span id="nickName"></span></td></tr>
  	   			<tr><td><label>帐号:</label></td><td><span id="code"></span></td></tr>
  	   			<tr><td><label>状态:</label></td><td><span id="stateName"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sys/sysUser.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/sys/changedataUser.js"></script>
</body>
</html>