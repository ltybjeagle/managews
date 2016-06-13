<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
<script src="<%=basePath%>/js/highcharts/highcharts.js"></script>
<script src="<%=basePath%>/js/highcharts/exporting.js"></script>
<script src="<%=basePath%>/js/highcharts/themes/grid.js"></script>
</head>
<body >
<div class="easyui-layout"fit="true">
		<div id="p" data-options="region:'west'"  style="width:50%;">
		   <object classid="clsid:D5E14042-7BF6-4E24-8B01-2F453E8154D7"
							id="RealTimePlayOcx" width="100%" height="100%"
							name="RealTimePlayOcx">
							<param name="theme" value="blue" >
							 <param name="PreviewBottomToolBar" value=1>    
							 <param name="PreviewRecordBnt" value=0>
                              <param name="showType" value="1">
				</object>			
		</div>
		<div data-options="region:'center'" title="生长监控">
		   <div class="ui-edit" style='position:relative; z-index:999; top:0;'>
	           	<form id="searchForm" class="ui-form" method="post"> 
		            <p class="ui-fields">		
			<label class="ui-label">基地:</label><input name="baseid" id="baseid" class="easyui-combobox" style="width:100px;">
		</p>
			<p class="ui-fields">
			<label class="ui-label"  style="float:left">大棚:</label><input name="greehouseids" id="greehouseids" class="easyui-combobox" style="width:100px;float:left">
	   	</p>
	   	         <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
       	     </form>
   		</div>
   		<div id="list_table">
   		</div>
	</div>
		
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/iotapp/sysGrowth.js"></script>
</body>
</html>