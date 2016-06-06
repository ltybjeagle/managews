<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 200px;" title="盘库主单">  
	<form id="editForm_add" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="distributionPId" id="distributionPId">
		<input class="hidden" type="text" name="vehiclesId" id="vehiclesId">
		<div class="ui-edit">
       		<div class="fitem">  
           		<label>盘库单号:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="stocktalingno" name="stocktalingno" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>盘点仓库:</label>
           		<select class="easyui-combobox" id="warehouseid" name="warehouseid" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="text" id="principal" name="principal" 
           			/>
       		</div>
       		
       		<div class="fitem">  
            	<label>备注:</label>  
             	<input class="easyui-validatebox" type="text" id="remark" name="remark" 
           			style="width:250px;" />
            </div>
		</div>
		
	</form>
</div> 
<!-- Search panel end -->
<!-- DataList  -->
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<!-- Edit Form -->

<script type="text/javascript" src="<%=basePath%>/js/ux/materialmanage/sysMaterialStockDetail.js"></script>
</body>
</html>