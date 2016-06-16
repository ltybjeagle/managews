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
<body>
<div class="easyui-layout" data-options="fit:true">
<div class="ui-search-panel" region="north" style="height:100px" title="过滤条件" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
<form id="searchForm" style="float:left">
	<div>
	<p class="ui-fields"><label class="ui-label">商品编号:</label>
	<input name="productid" id="productid" class="easyui-box ui-text"   missingMessage="商品编号必须填写" style="width:100px;"></p>
	<p class="ui-fields"><label class="ui-label">投入品名称:</label>
	<input name="inputid" id="inputid" class="easyui-combobox"  missingMessage="投入品名称必须填写" style="width:100px;"></p>
	<p class="ui-fields"><label class="ui-label">使用基地:</label>
	<input name="baseid" id="baseid" class="easyui-combobox" style="width:100px;"></p>
	<p class="ui-fields"><label class="ui-label" style="float:left">使用大棚:</label>
	<input name="greehouseids" id="greehouseids" class="easyui-combobox" style="width:100px;float:left"></p>
	<a href="#" id="btn-search" class="easyui-linkbutton"  iconCls="icon-search">统计</a>
	</div>
	<div>
	<p class="ui-fields"><select class="easyui-combobox" name="state" id="state" onchange="gradeChange()" style="width:100px;">
	<option value="year">年份</option><option value="month">月份</option><option value="date">天</option></select></p>
	<p class="ui-fields"><label class="ui-label">开始时间:</label><input id="sd"  class="Wdate" name="start_date"  type="text"/></p>
	<p class="ui-fields"><label class="ui-label">结束时间：</label><input id="ed"  class="Wdate" name="end_date"  type="text" /></p>
	</div>
</form>  
</div> 
<div region="center" border="false" style="overflow:auto">
	<div class="easyui-layout" style=" height:850px;width:98%">
        <div id="container" region="north" style="height:50%"></div>
        <div id="container1"  region="center" style="height:50%"><table id="data-list" ></table></div>
	</div>
</div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/graph/inputs.js"></script>
</body>
</html>