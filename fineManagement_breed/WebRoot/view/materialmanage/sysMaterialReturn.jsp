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
			<label class="ui-label">物资编号:</label><input name="materialno" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">物资名称:</label><input name="materialname" class="easyui-box ui-text" style="width:100px;">
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
<div id="edit-win" class="easyui-dialog" title="物资归还确认" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:400px;height:410px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">物资目录信息</div>
			<div class="fitem" style="visibility: none;">  
           		<input class="hidden" type="text" name="id" id = "id"  readonly="true" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<input class="hidden" id="syssign" name="syssign" readonly="true" data-options="width:282"/>
       		</div>       
       		<div class="fitem">  
           		<label>物资编号:</label>  
           		<input class="easyui-validatebox" type="text" id = "materialno" name="materialno" readonly="true" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>物资名称:</label>  
           		<input class="easyui-validatebox" type="text" id = "materialname" name="materialname" readonly="true" data-options="required:true"/>
       		</div>
         	<div class="fitem">  
           		<label>归还数量:</label>  
           		<input class="easyui-validatebox" type="text" name="returncount" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>单价(元):</label>  
           		<input class="easyui-validatebox" type="text" name="unitPrice" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>归还人:</label>  
           		<input class="easyui-validatebox" type="text" name="backuser" />
       		</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="text" name="principal" />
       		</div>
       		<div class="fitem">  
           		<label>仓库:</label>  
           		<select class="easyui-combobox" id="warehouseid" name="warehouseid" data-options="width:141"></select>
       		</div>
       		<div class="fitem">  
           		<label>基地:</label>  
           		<select class="easyui-combobox" id="baseid" name="baseid" data-options="width:141"></select>
       		</div>
       		<div class="fitem">  
           		<label>禽舍:</label>  
           		<select class="easyui-combobox" id="fowleryid" name="fowleryid" data-options="width:141"></select>
       		</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="text" name="remark" />
       		</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/materialmanage/sysMaterialReturn.js"></script>
</body>
</html>