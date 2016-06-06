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
			<label class="ui-label">采收时间:</label>
			<input class="easyui-datebox" type="text" name="startHarvesttime"/> 至 
			<input class="easyui-datebox" type="text" name="endHarvesttime"/>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">基地:</label>
			<select class="easyui-combobox" id="baseids" name="baseids" style="width:100px;"></select>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">大棚:</label>
			<select class="easyui-combobox" id="greehouseids" name="greehouseids" style="width:100px;"></select>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">菜品名称:</label>
			<select class="easyui-combobox" id="plantids" name="plantids" style="width:100px;"></select>
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
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">产品采摘信息</div>
			<div class="fitem">  
           		<label>基地:</label>  
				<select class="easyui-combobox" id="baseid" name="baseid" data-options="required:true,editable:false,panelHeight:'auto'"
           			style="padding:2px;width:141px;"></select>           			
       		</div>
       		<div class="fitem">  
           		<label>大棚:</label>  
           		<select class="easyui-combobox" id="greehouseid" name="greehouseid" data-options="required:true,editable:false,panelHeight:'auto'"
           			style="padding:2px;width:141px;"></select>
       		</div>
       		<div class="fitem">  
           		<label>种植产品:</label>  
           		<select class="easyui-combobox" id="plantid" name="plantid" data-options="required:true,editable:false,panelHeight:'auto'"
           			style="padding:2px;width:141px;"></select>
       		</div>
       		<div class="fitem">  
           		<label>采购数量:</label>  
           		<input class="easyui-validatebox" id="numberharvest" name="numberharvest" data-options="width:282"/>斤
       		</div>
			<div class="fitem">  
           		<label>等级:</label>  
           		<input class="easyui-validatebox" id="grade" name="grade"  data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>单价:</label>  
           		<input class="easyui-validatebox" id="unitprice" name="unitprice"  data-options="width:282"/>元
       		</div>
       		<div class="fitem">  
           		<label>验收人:</label>  
           		<input class="easyui-validatebox" id="inspectionstaff" name="inspectionstaff"  data-options="width:282"/>
       		</div>    
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" id="remark" name="remark"  data-options="width:282"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">产品采摘信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>基地:</label></td><td><span id="base_q"></span></td></tr>
  	   			<tr><td><label>大棚:</label></td><td><span id="greehouse_q"></span></td></tr>
  	   			<tr><td><label>种植产品:</label></td><td><span id="plant_q"></span></td></tr>
  	   			<tr><td><label>采购数量:</label></td><td><span id="numberharvest_q"></span></td></tr>
  	   			<tr><td><label>等级:</label></td><td><span id="grade_q"></span></td></tr>
  	   			<tr><td><label>单价:</label></td><td><span id="unitprice_q"></span></td></tr>
  	   			<tr><td><label>验收人:</label></td><td><span id="inspectionstaff_q"></span></td></tr>
  	   			<tr><td><label>简介:</label></td><td><span id="remark_q"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/pick/harvestplants.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/pick/changedataharvest.js"></script>
</body>
</html>