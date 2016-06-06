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
			<label class="ui-label">车辆编号:</label><input name="vehiclesNo" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">车牌号:</label><input name="plateNum" class="easyui-box ui-text" style="width:100px;">
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
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="carType" id = "carType"/>
		<input class="hidden" type="text" name="belong" id = "belong"/>
		<div class="ui-edit">
			<div class="ftitle">车辆管理</div>    
       		<div class="fitem">  
           		<label>车辆编号:</label>  
           		<input class="easyui-validatebox" type="text" name="vehiclesNo" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>车牌号:</label>  
           		<input class="easyui-validatebox" type="text" name="plateNum" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>品牌:</label>  
           		<input class="easyui-validatebox" type="text" name="brand"/>
       		</div>
       		<div class="fitem">  
           		<label>车龄:</label>  
           		<input class="easyui-validatebox" type="text" name="carAge"/>年
       		</div>
       		<div class="fitem">  
           		<label>车辆类型:</label>  
           		<select class="easyui-combobox" id="selectTypes" name="selectTypes" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           			<option value=""></option>
             		<option value="1">大型货车</option>
             		<option value="2">小型货车</option>
             		<option value="3">小型汽车</option>
             		<option value="4">其他</option>
            	</select>
       		</div>
       		<div class="fitem">  
           		<label>购买日期:</label>  
           		<input class="easyui-datebox" type="text" id="saleDate" name="saleDate"/>
       		</div>
       		<div class="fitem">  
            	<label>购买金额:</label>  
             	<input class="easyui-validatebox" type="text" name="saleSum"/>元
             </div>
             <div class="fitem">  
           		<label>所属类型:</label>  
           		<select class="easyui-combobox" id="selectBelongs" name="selectBelongs" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           			<option value=""></option>
             		<option value="1">自有</option>
             		<option value="2">外有</option>
            	</select>
       		</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="text" name="remark"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">车辆管理</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>车辆编号:</label></td><td><span id="vehiclesNo"></span></td></tr>
  	   			<tr><td><label>车牌号:</label></td><td><span id="plateNum"></span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span id="brand"></span></td></tr>
  	   			<tr><td><label>车龄:</label></td><td><span id="carAge"></span>年</td></tr>
  	   			<tr><td><label>车辆类型:</label></td><td><span id="carType_q"></span></td></tr>
  	   			<tr><td><label>购买日期:</label></td><td><span id="saleDate_q"></span></td></tr>
  	   			<tr><td><label>购买金额:</label></td><td><span id="saleSum"></span>元</td></tr>
  	   			<tr><td><label>所属类型:</label></td><td><span id="belong_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/sysVehicles.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/changedatavehicles.js"></script>
</body>
</html>