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
			<label class="ui-label">加工批次:</label><input name="batchprocessing" class="easyui-box ui-text" style="width:100px;">
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
	style="width:400px;height:410px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">操作信息</div>
			<div class="fitem">  
           		<label>加工批次:</label>  
           		<select class="easyui-combobox" id="batchprocessing" name="batchprocessing" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>加工产品名称:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="productname" name="productname" 
           			style="background-color:#d0d0d0"/>
       		</div>
			<div class="fitem">  
           		<label>加工时间:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="processingtime" name="processingtime" 
           			style="background-color:#d0d0d0"/>
       		</div>   
       		<div class="fitem">  
           		<label>加工人员:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="processingstaff" name="processingstaff" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>仓库:</label>  
           		<select class="easyui-combobox" id="warehouseid" name="warehouseid" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>入库负责人:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="principal" name="principal" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>入库时间:</label>  
           		<input class="easyui-datebox" type="text" name="instoretime"/>
       		</div> 
       		<div class="fitem">  
            	<label>备注:</label>  
             	<input class="easyui-validatebox" name="remark" data-options="width:282"/>
         	</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/storagemanagement/sysInStorage.js"></script>
</body>
</html>