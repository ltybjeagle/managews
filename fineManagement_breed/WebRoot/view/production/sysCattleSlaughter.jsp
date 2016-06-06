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
			<label class="ui-label">出栏时间:</label>
			<input class="easyui-datebox" type="text" name="start_date"/> 至 
			<input class="easyui-datebox" type="text" name="end_date"/>
	   	</p>
	   	<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</form>  
</div> 
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post" enctype="multipart/form-data"> 
		<input class="hidden" type="text" name="fowleryName" id="fowleryName" value="${fowleryName}">
		<input class="hidden" type="text" name="baseName" id="baseName" value="${baseName}">
		<input class="hidden" type="text" name="fowleryid" id="fowleryid" value="${fowleryid}">
		<input class="hidden" type="text" name="baseid" id="baseid" value="${baseid}">
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="pno" id="pno" value="0">
		<div class="ui-edit">
			<div class="ftitle">出栏信息</div>    
       		<div class="fitem">  
           		<label>养殖品种:</label>  
           		<select class="easyui-combobox" id="breedids" name="breedids" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>出栏数量:</label>  
           		<input class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>等级:</label>  
             	<input class="easyui-validatebox" type="text" name="cattleLevel" data-options="required:true"/>
         	</div>
       		<div class="fitem">  
            	<label>单价:</label>  
             	<input class="easyui-validatebox" type="text" name="unitPrice" data-options="required:true"/>
         	</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="text" name="charge" data-options="required:true" />
       		</div>
       		<div class="fitem">  
           		<label>验收人:</label>  
           		<input class="easyui-validatebox" type="text" name="verification" data-options="required:true" />
       		</div>
       		<div class="fitem">  
            	<label>出栏时间:</label>  
             	<input class="easyui-datebox" type="text" id="cattleTime" name="cattleTime"/>
         	</div>
         	<div id="filecontrol" class="fitem">  
            	<label>附件资料:</label>  
             	<input class="easyui-filebox" name="file" data-options="prompt:'Choose a file...'" style="width:175px">
         	</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="text" name="remark" />
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">出栏信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>养殖品种:</label></td><td><span id="breedName"></span></td></tr>
  	   			<tr><td><label>出栏数量:</label></td><td><span id="count"></span></td></tr>
  	   			<tr><td><label>等级:</label></td><td><span id="cattleLevel"></span></td></tr>
  	   			<tr><td><label>单价:</label></td><td><span id="unitPrice"></span></td></tr>
  	   			<tr><td><label>负责人:</label></td><td><span id="charge"></span></td></tr>
  	   			<tr><td><label>验收人:</label></td><td><span id="verification"></span></td></tr>
  	   			<tr><td><label>出栏时间:</label></td><td><span id="cattleTime_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
  	   		<div class="ftitle">附件资料</div>
  	   		<div id="fileMsg"></div>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/sysCattleSlaughter.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/changedataCattle.js"></script>
</body>
</html>