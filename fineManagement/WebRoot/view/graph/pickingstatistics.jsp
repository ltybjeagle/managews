<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
<script src="<%=basePath%>/js/highcharts/highcharts.js"></script>
<script src="<%=basePath%>/js/highcharts/exporting.js"></script>
<script src="<%=basePath%>/js/highcharts/themes/grid.js"></script>
<script src="<%=basePath%>/js/graph/date.js"></script>
</head>
<body class="easyui-layout">
<div class="ui-search-panel" region="north" style="height: 100px;" title="过滤条件" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="searchForm">
		<p class="ui-fields">
			<select class="easyui-combobox" name="state" id="state"  onchange="gradeChange()" style="width:100px;">
		<option value="year">年份</option>
		<option value="month">月份</option>
		<option value="date">天</option>
		</select>
			<label class="ui-label">开始时间:</label>
				<input id="sd"  class="Wdate" name="start_date"  type="text"/>
			<label class="ui-label">结束时间：</label>
			    <input id="ed"  class="Wdate" name="end_date"  type="text" />	
			<label class="ui-label">菜品名称:</label><input id="plantids" name="plantids" class="easyui-combobox" style="width:100px;">
			<label class="ui-label">基地:</label><input id="baseid" name="baseid"  class="easyui-combobox" style="width:100px;">
			<label class="ui-label">大棚:</label><input id="greenhouseids" name="greenhouseids" class="easyui-combobox" style="width:100px;">
	   	</p>
	   	<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">统计</a>
	</form>  
</div> 
<div  region="center" border="false" style="overflow:auto">
   <div class="easyui-layout" style=" height:850px;width:98%">
        <div id="container" region="north" style="height:50%;margin-bottom:10px"></div>
        <div id="container1"  region="center">
            <table id="data-list" style="height:50%"></table>
        </div>
  </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/graph/picking.js"></script>
	</body>
</html>