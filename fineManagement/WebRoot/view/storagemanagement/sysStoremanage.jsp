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
			<label class="ui-label">仓库:</label><input name="warehouseid" class="easyui-box ui-text" style="width:100px;">
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
           		<label>仓库:</label>  
           		<select class="easyui-combobox" type="warehouseid" name="warehouseid"  data-options="width:141"></select>
       		</div>
       		<div class="fitem">  
           		<label>登记时间:</label>  
           		<input class="easyui-validatebox" id="registertime" name="registertime" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<select class="easyui-combobox" type="principal" name="principal" data-options="width:141"></select>
       		</div> 
       		<div class="fitem">  
           		<label>描述:</label>  
           		<input class="easyui-validatebox" id="description" name="description"  data-options="width:282"/>
       		</div> 
       		<div class="fitem">  
            	<label>备注:</label>  
             	<input class="easyui-validatebox" id="text" name="remark" data-options="width:282"/>
         	</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/storagemanagement/sysStoremanage.js"></script>
</body>
</html>