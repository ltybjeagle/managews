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
			<label class="ui-label">盘点单号:</label><input name="stocktalingno" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">盘库时间:</label><input name="stocktimestart" type="text" class="easyui-datebox" style="width:100px;">
			<label class="ui-label">至</label><input name="stocktimeend" type="text" class="easyui-datebox" style="width:100px;">
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
<script type="text/javascript" src="<%=basePath%>/js/ux/materialmanage/SysStocktaking.js"></script>
</body>
</html>