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
			<label class="ui-label">设备编号:</label><input name="equipmentNumber" class="easyui-box ui-text" style="width:100px;">
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
			<div class="ftitle">添加视频</div>    
       		<div class="fitem">  
           		<label>设备编号:</label>  
           		<input class="easyui-validatebox" type="text" name="equipmentNumber" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>视频监测点名称:</label>  
           		<input class="easyui-validatebox" type="text" name="videoMonitoringPoint" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>视频通道号:</label>  
           		<input class="easyui-validatebox" type="text" name="videoChannelNumber" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>所属基地:</label>  
             	<select class="easyui-combobox" id="baseIds" name="baseIds" data-options="required:true,editable:false,panelHeight:'auto'" 
             		style="padding:2px;width:141px;">
           		</select>
         	</div>
         	<div class="fitem">  
            	<label>所属大棚:</label>  
             	<select class="easyui-combobox" id="greenhouseids" name="greenhouseids" data-options="required:true,editable:false,panelHeight:'auto'" 
             		style="padding:2px;width:141px;">
           		</select>
         	</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">视频设置</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>设备编号:</label></td><td><span id="equipmentNumber"></span></td></tr>
  	   			<tr><td><label>视频监测点名称:</label></td><td><span id="videoMonitoringPoint"></span></td></tr>
  	   			<tr><td><label>视频通道号:</label></td><td><span id="videoChannelNumber"></span></td></tr>
  	   			<tr><td><label>所属基地:</label></td><td><span id="baseName"></span></td></tr>
  	   			<tr><td><label>所属大棚:</label></td><td><span id="greenhouseName"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/iot/sysVideo.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/iot/changedataVideo.js"></script>
</body>
</html>