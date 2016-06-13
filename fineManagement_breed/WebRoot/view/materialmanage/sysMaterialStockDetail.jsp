<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<div class="ui-search-panel" region="north" style="height: 160px;" title="盘库主单">  
	<form id="editForm_add" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="stocktalingno" id="stocktalingno" value="${data.stocktalingno}">
		<div class="ui-edit">
       		<div class="fitem">  
           		<label>盘库单号:</label>  
           		<span>${data.stocktalingno}</span>
       		</div>
       		<div class="fitem">  
           		<label>盘点仓库:</label>
           		<span>${data.whName}</span>
       		</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<span>${data.principal}</span>
       		</div>
       		
       		<div class="fitem">  
            	<label>备注:</label>  
             	<span>${data.remark}</span>
            </div>
		</div>
		
	</form>
</div> 
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/materialmanage/sysMaterialStockDetail.js"></script>
</body>
</html>