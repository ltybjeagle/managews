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
			<label class="ui-label">排酸批次:</label><input name="acidBatch" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   		<p class="ui-fields">
	   	<label class="ui-label">排酸时间:</label>
			<input class="easyui-datebox" type="text" name="startTime"/> 至 
			<input class="easyui-datebox" type="text" name="endTime"/>
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
<div id="edit-win" class="easyui-dialog" title="Edit" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">排酸管理</div>    
       		<div class="fitem">  
           		<label>排酸批次:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="acidBatch" name="acidBatch" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>屠宰批次:</label>  
           		<select class="easyui-combobox" id="slaughterBatchIds" name="slaughterBatchIds" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>屠宰数量:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="slaughterQuantity" 
           			name="slaughterQuantity" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
            	<label>排酸数量:</label>  
             	<input class="easyui-validatebox" type="text" name="acidNo" data-options="required:true"/>
             </div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="text" name="principal" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>开始时间:</label>  
           		<input class="easyui-datebox" type="text" id="startTime" name="startTime"/>
       		</div>
       		<div class="fitem">  
           		<label>结束时间:</label>  
           		<input class="easyui-datebox" type="text" id="endTime" name="endTime"/>
       		</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="text" name="remark"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">排酸管理</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>排酸批次:</label></td><td><span id="acidBatch_q"></span></td></tr>
  	   			<tr><td><label>屠宰批次:</label></td><td><span id="slaughterBatch_q"></span></td></tr>
  	   			<tr><td><label>屠宰数量:</label></td><td><span id="slaughterQuantity_q"></span></td></tr>
  	   			<tr><td><label>排酸数量:</label></td><td><span id="acidNo_q"></span></td></tr>
  	   			<tr><td><label>负责人:</label></td><td><span id="principal_q"></span></td></tr>
  	   			<tr><td><label>开始时间:</label></td><td><span id="startTime_q"></span></td></tr>
  	   			<tr><td><label>结束时间:</label></td><td><span id="endTime_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark_q"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/slaughter/sysAcid.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/slaughter/changedataAcid.js"></script>
</body>
</html>