<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="searchForm">
		<p class="ui-fields">
        	<label class="ui-label">角色名:</label> 
         	<input name="roleName" class="easyui-box ui-text" style="width:100px;">
   		</p>  
   		<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>	
	</form>  
</div> 
<!-- Search panel end -->
<!-- DataList  -->
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<!-- Edit Form -->
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">  
	<form id="editForm" class="ui-form" method="post">  
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
 	   		<div class="ftitle">角色信息</div>
 	   		<div class="fitem">  
            	<label>归属系统:</label>  
             	<select class="easyui-combobox" id="sysIds" name="sysIds" data-options="required:true,width:141"></select>
         	</div>   
         	<div class="fitem">  
           		<label>角色编码:</label>  
           		<input class="easyui-validatebox" type="text" name="code" data-options="required:true,validType:'length[1,50]'">
       		</div>  
       		<div class="fitem">  
           		<label>角色名:</label>  
           		<input class="easyui-validatebox" type="text" name="roleName" data-options="required:true,validType:'length[1,10]'">
       		</div>  
       		<div class="fitem">  
           		<label>状态:</label>  
         		<select class="easyui-combobox" name="state" id="state" data-options="required:true,editable:false,panelHeight:'auto'" 
         			style="padding:2px;width:141px;">
             		<option value="0">可用</option>
             		<option value="1">禁用</option>
            	</select>
       		</div>
        	<div class="fitem" style="">  
           		<label>功能权限:</label>
           		<div style="border: 1px solid #A4BED4; width:230px;height:200px;margin-left: 105px ;overflow: auto; ">  
           			<ul id="menu-tree"  >
           			</ul>
           		</div>
        	</div>
      	</div>
 	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">角色信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>归属系统:</label></td><td><span id="sysname"></span></td></tr>
  	   			<tr><td><label>角色编码:</label></td><td><span id="code"></span></td></tr>
  	   			<tr><td><label>角色名:</label></td><td><span id="roleName"></span></td></tr>
  	   			<tr><td><label>状态:</label></td><td><span id="stateName"></span></td></tr>
  	   			<tr><td><label>功能权限:</label></td><td>
           		<div style="border: 1px solid #A4BED4; width:230px;height:200px;overflow: auto; ">  
           			<ul id="menu-tree1">
           			</ul>
           		</div>
           		</td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sys/sysRole.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/sys/changedataRole.js"></script>
</body>
</html>