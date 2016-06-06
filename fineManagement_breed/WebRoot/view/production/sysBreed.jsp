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
			<label class="ui-label">养殖时间:</label>
			<input class="easyui-datebox" type="text" name="startStartTime"/> 至 
			<input class="easyui-datebox" type="text" name="endStartTime"/>
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
			<div class="ftitle">养殖信息</div>    
       		<div class="fitem">  
           		<label>养殖品种:</label>  
           		<select class="easyui-combobox" id="varietyids" name="varietyids" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>养殖面积:</label>  
           		<input class="easyui-validatebox" type="text" name="breedArea" data-options="required:true"/>
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
           		<label>人员工资:</label>  
           		<input class="easyui-validatebox" type="text" name="wages" />元
       		</div>
       		<div class="fitem">  
            	<label>饲养时间:</label>  
             	<input class="easyui-datebox" type="text" id="startTime" name="startTime"/>
         	</div>
       		<div class="fitem">  
            	<label>预计结束时间:</label>  
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
  	   		<div class="ftitle">养殖信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>养殖品种:</label></td><td><span id="variety"></span></td></tr>
  	   			<tr><td><label>养殖面积:</label></td><td><span id="breedArea"></span></td></tr>
  	   			<tr><td><label>饲养员:</label></td><td><span id="breederName"></span></td></tr>
  	   			<tr><td><label>技术员:</label></td><td><span id="breedTechnicianName"></span></td></tr>
  	   			<tr><td><label>人员工资:</label></td><td><span id="wages"></span></td></tr>
  	   			<tr><td><label>饲养时间:</label></td><td><span id="startTime_q"></span></td></tr>
  	   			<tr><td><label>预计结束时间:</label></td><td><span id="endTime_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/sysBreed.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/changedataBreed.js"></script>
</body>
</html>