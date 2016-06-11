<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="searchForm">
		<p class="ui-fields">
			<label class="ui-label">仓库:</label>
			<select class="easyui-combobox" id="warehouseid" name="warehouseid" style="width:100px;"></select>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">登记时间:</label>
			<input class="easyui-datebox" type="text" name="startregistertime"/> 至 
			<input class="easyui-datebox" type="text" name="endregistertime"/>
	   	</p>
	   	<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</form>  
</div> 
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">储藏管理</div>  
       		<div class="fitem">  
           		<label>仓库:</label>  
           		<select class="easyui-combobox" id="warehouseids" name="warehouseids" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;"></select>
       		</div>
       		<div class="fitem">  
           		<label>登记时间:</label>  
           		<input class="easyui-datebox" type="text" id="registertime" name="registertime"/>
       		</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<select class="easyui-combobox" id="principals" name="principals" data-options="editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;"></select>
       		</div> 
       		<div class="fitem">  
           		<label>描述:</label>  
           		<input class="easyui-validatebox" name="description"  data-options="width:282"/>
       		</div> 
       		<div class="fitem">  
            	<label>备注:</label>  
             	<input class="easyui-validatebox" name="remark" data-options="width:282"/>
         	</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">储藏管理</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>仓库:</label></td><td><span id="whName"></span></td></tr>
  	   			<tr><td><label>登记时间:</label></td><td><span id="registertime_q"></span></td></tr>
  	   			<tr><td><label>负责人:</label></td><td><span id="principalName"></span></td></tr>
  	   			<tr><td><label>描述:</label></td><td><span id="description"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/storagemanagement/sysStoremanage.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/storagemanagement/changedataManage.js"></script>
</body>
</html>