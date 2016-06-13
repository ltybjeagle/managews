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
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="searchForm">
		<p class="ui-fields">
		<label class="ui-label">检测点:</label>
        <input id="MonitorNum" name="MonitorNum" class="easyui-combobox" style="width:100px;">	
		<label class="ui-label">时间:</label>
		</select>
		<label class="ui-label">时间:</label>
			<select class="easyui-combobox" name="state" id="state"  onchange="gradeChange()" style="width:100px;">
		<option value="year">年份</option>
		<option value="month">月份</option>
		<option value="date">天</option>
		</select>
				<input id="sd"  class="Wdate" name="start_date"  type="text"/>
			<label class="ui-label">至:</label>
			    <input id="ed"  class="Wdate" name="end_date"  type="text" />	
	   	</p>
	   	<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</form>  
</div> 
<div  region="center" border="false" style="overflow:auto">
<div>
			    <input type="checkbox" name="xz" value="airTemperature"   />空气温度℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="airHumidity"  />空气湿度%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="photosyntheticRadiation" />光合有效辐射（umol/m^2*s）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="soilHumidity"  />土壤湿度%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="soilEC"  />土壤EC值&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="infraredTemperature"  />叶片温度℃
                <input type="checkbox" name="xz" value="fruitSize"  />果实大小微变化
                <input type="checkbox" name="xz" value="diameterWidth"  />茎秆直径微变化
</div>
<div id="container" style="height:380px; margin: 15 auto;"></div>
<div style="height:340px;" >
	<table id="data-list"></table>
</div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/iotapp/sysEnvironmental.js"></script>
	</body>
</html>