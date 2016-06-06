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
			<label class="ui-label">发布时间:</label>
			<input class="easyui-datebox" type="text" name="startReleaseTime"/> 至 
			<input class="easyui-datebox" type="text" name="endReleaseTime"/>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">状态:</label>
			<select class="easyui-combobox" id="distributionStatus" name="distributionStatus" style="width:100px;">>
           		<option value="0"></option>
           		<option value="1">已配送</option>
           		<option value="2">未配送</option>
           	</select>
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
		<div class="ui-edit">
			<div class="ftitle">签收确认</div>    
       		<div class="fitem">  
           		<label>签收人:</label>  
           		<input class="easyui-validatebox" type="text" id="signPerson" name="signPerson" data-options="required:true"/>
       		</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/sysSign.js"></script>
</body>
</html>