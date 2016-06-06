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
			<label class="ui-label">工作时间:</label>
			<input class="easyui-datebox" type="text" name="startTaskTime"/> 至 
			<input class="easyui-datebox" type="text" name="endTaskTime"/>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">任务类型:</label>
			<select class="easyui-combobox" id="taskid" name="taskid" style="width:100px;"></select>
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
		<input class="hidden" type="text" name="fowleryName" id="fowleryName" value="${fowleryName}">
		<input class="hidden" type="text" name="baseName" id="baseName" value="${baseName}">
		<input class="hidden" type="text" name="fowleryid" id="fowleryid" value="${fowleryid}">
		<input class="hidden" type="text" name="baseid" id="baseid" value="${baseid}">
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="pno" id="pno" value="0">
		<div class="ui-edit">
			<div class="ftitle">养殖任务</div>    
       		<div class="fitem">  
           		<label>任务类型:</label>  
           		<select class="easyui-combobox" id="taskids" name="taskids" data-options="required:true,editable:false,panelHeight:'auto'"
           			style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
            	<label>饲养员:</label>  
             	<select class="easyui-combobox" id="breeders" name="breeders" data-options="required:true,editable:false,panelHeight:'auto'"
           			style="padding:2px;width:141px;">
           		</select>
         	</div>
       		<div class="fitem">  
           		<label>技术员:</label>  
           		<select class="easyui-combobox" id="breedTechnicians" name="breedTechnicians" data-options="required:true,editable:false,panelHeight:'auto'"
           			style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
            	<label>任务时间:</label>  
             	<input class="easyui-datebox" type="text" id="taskTime" name="taskTime"/>
         	</div>
       		<div class="fitem">  
           		<label>工作内容:</label>  
           		<input class="easyui-validatebox" type="text" name="taskContent"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">养殖任务</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>任务类型:</label></td><td><span id="taskName"></span></td></tr>
  	   			<tr><td><label>饲养员:</label></td><td><span id="breederName"></span></td></tr>
  	   			<tr><td><label>技术员:</label></td><td><span id="breedTechnicianName"></span></td></tr>
  	   			<tr><td><label>任务时间:</label></td><td><span id="taskTime_q"></span></td></tr>
  	   			<tr><td><label>工作内容:</label></td><td><span id="taskContent"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/sysTaskBreed.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/changedataBreedtask.js"></script>
</body>
</html>