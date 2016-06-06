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
			<label class="ui-label">商品编号:</label><input name="productNo" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">投入品名称:</label><input name="inputName" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">分类:</label>
			<select class="easyui-combobox" id="classnames" name="classnames" style="width:100px;"></select>
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
<div id="edit-win" class="easyui-dialog" title="入库确认" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="purchaseid" id="purchaseid">
		<div class="ui-edit">
			<div class="ftitle">入库确认</div>
			<div class="fitem">  
           		<label>仓库:</label>  
           		<select class="easyui-combobox" id="warehouseid" name="warehouseid" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>入库负责人:</label>  
           		<input class="easyui-validatebox" name="principal" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>技术人员:</label>  
           		<input class="easyui-validatebox" name="technicalstaff" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
            	<label>备注:</label>  
             	<input class="easyui-validatebox" id="text" name="remark" data-options="width:282"/>
         	</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">采购信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>商品编号:</label></td><td><span id="productNo"></span></td></tr>
  	   			<tr><td><label>投入品名称:</label></td><td><span id="inputName"></span></td></tr>
  	   			<tr><td><label>分类:</label></td><td><span id="classname"></span></td></tr>
  	   			<tr><td><label>单位:</label></td><td><span id="unit"></span></td></tr>
  	   			<tr><td><label>规格:</label></td><td><span id="specifications"></span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span id="brandName"></span></td></tr>
  	   			<tr><td><label>厂家:</label></td><td><span id="mfName"></span></td></tr>
  	   			<tr><td><label>采购数量:</label></td><td><span id="purchaseCount"></span></td></tr>
  	   			<tr><td><label>单价:</label></td><td><span id="unitPrice"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/store/sysInstore.js"></script>
</body>
</html>