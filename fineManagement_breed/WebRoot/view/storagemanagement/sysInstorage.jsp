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
			<label class="ui-label">加工批次:</label><input name="batchprocessing" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">入库时间:</label>
			<input class="easyui-datebox" type="text" name="startinstoretime"/> 至 
			<input class="easyui-datebox" type="text" name="endinstoretime"/>
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
			<div class="ftitle">成品入库信息</div>
			<div class="fitem">  
           		<label>加工批次:</label>  
           		<select class="easyui-combobox" id="batchprocessing" name="batchprocessing" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>加工产品名称:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="productname" name="productname" 
           			style="background-color:#d0d0d0"/>
       		</div>
			<div class="fitem">  
           		<label>加工时间:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="processingtime" name="processingtime" 
           			style="background-color:#d0d0d0"/>
       		</div>   
       		<div class="fitem">  
           		<label>加工人员:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="processingstaff" name="processingstaff" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>仓库:</label>  
           		<select class="easyui-combobox" id="warehouseid" name="warehouseid" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>入库负责人:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="principal" name="principal" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>入库时间:</label>  
           		<input class="easyui-datebox" type="text" id="instoretime" name="instoretime"/>
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
  	   		<div class="ftitle">成品入库信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>加工批次:</label></td><td><span id="batchprocessing_q"></span></td></tr>
  	   			<tr><td><label>加工产品名称:</label></td><td><span id="productname_q"></span></td></tr>
  	   			<tr><td><label>加工时间:</label></td><td><span id="processingtime_q"></span></td></tr>
  	   			<tr><td><label>加工人员:</label></td><td><span id="processingstaff_q"></span></td></tr>
  	   			<tr><td><label>仓库:</label></td><td><span id="warehouseid_q"></span></td></tr>
  	   			<tr><td><label>入库负责人:</label></td><td><span id="principal_q"></span></td></tr>
  	   			<tr><td><label>入库时间:</label></td><td><span id="instoretime_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark_q"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/storagemanagement/sysInStorage.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/storagemanagement/changedataInStorage.js"></script>
</body>
</html>