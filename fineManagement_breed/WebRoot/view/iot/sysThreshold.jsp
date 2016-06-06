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
			<label class="ui-label">规则名称:</label><input name="ruleName" class="easyui-box ui-text" style="width:100px;">
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
	style="width:760px;height:480px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">阈值设置</div>    
       		<div class="fitem">  
           		<label>规则名称:</label>  
           		<input class="easyui-validatebox" type="text" name="ruleName" data-options="required:true"/>
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
         	<div class="fitem">  
           		<label>开启状态:</label>  
           		<input type="radio" name="openStatus" value="1"/>开启
        		<input type="radio" name="openStatus" value="2"/>关闭 
       		</div>
       		<div class="ftitle">环境数据</div>
       		<div class="fitem">  
           		<label>空气温度（℃）:</label>  
           		<input class="easyui-validatebox" type="text" name="airTemperatureMin" size="3"/>~
           		<input class="easyui-validatebox" type="text" name="airTemperatureMax" size="3"/>
           		<label>提醒内容:</label>  
           		<input class="easyui-validatebox" type="text" name="airTemperatureMsg" size="60"/>
       		</div>
       		<div class="ftitle"></div>
       		<div class="fitem">  
           		<label>空气湿度（%）:</label>  
           		<input class="easyui-validatebox" type="text" name="airHumidityMin" size="3"/>~
           		<input class="easyui-validatebox" type="text" name="airHumidityMax" size="3"/>
           		<label>提醒内容:</label>  
           		<input class="easyui-validatebox" type="text" name="airHumidityMsg" size="60"/>
       		</div>
       		<div class="ftitle"></div>
       		<div class="fitem">  
           		<label>土壤湿度（%）:</label>  
           		<input class="easyui-validatebox" type="text" name="soilMoistureMin" size="3"/>~
           		<input class="easyui-validatebox" type="text" name="soilMoistureMax" size="3"/>
           		<label>提醒内容:</label>  
           		<input class="easyui-validatebox" type="text" name="soilMoistureMsg" size="60"/>
       		</div>
       		<div class="ftitle"></div>
       		<div class="fitem">  
           		<label>叶片温度（℃）:</label>  
           		<input class="easyui-validatebox" type="text" name="bladeTemperatureMin" size="3"/>~
           		<input class="easyui-validatebox" type="text" name="bladeTemperatureMax" size="3"/>
           		<label>提醒内容:</label>  
           		<input class="easyui-validatebox" type="text" name="bladeTemperatureMsg" size="60"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">阈值设置</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>规则名称:</label></td><td><span id="ruleName"></span></td></tr>
  	   			<tr><td><label>所属基地:</label></td><td><span id="baseName"></span></td></tr>
  	   			<tr><td><label>所属大棚:</label></td><td><span id="greenhouseName"></span></td></tr>
  	   			<tr><td><label>开启状态:</label></td><td><span id="openStatus"></span></td></tr>
  	   		</table>
  	   		<div class="ftitle">环境数据</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>空气温度（℃）:</label></td><td><span id="airTemperatureMin"></span>~<span id="airTemperatureMax"></span></td>
  	   			<td><label>提醒内容:</label></td><td><span id="airTemperatureMsg"></span></td></tr>
  	   			<tr><td><label>空气湿度（%）:</label></td><td><span id="airHumidityMin"></span>~<span id="airHumidityMax"></span></td>
  	   			<td><label>提醒内容:</label></td><td><span id="airHumidityMsg"></span></td></tr>
  	   			<tr><td><label>土壤湿度（%）:</label></td><td><span id="soilMoistureMin"></span>~<span id="soilMoistureMax"></span></td>
  	   			<td><label>提醒内容:</label></td><td><span id="soilMoistureMsg"></span></td></tr>
  	   			<tr><td><label>叶片温度（℃）:</label></td><td><span id="bladeTemperatureMin"></span>~<span id="bladeTemperatureMax"></span></td>
  	   			<td><label>提醒内容:</label></td><td><span id="bladeTemperatureMsg"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/iot/sysThreshold.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/iot/changedataThreshold.js"></script>
</body>
</html>