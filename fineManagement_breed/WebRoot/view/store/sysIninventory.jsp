<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
<style type="text/css">
#store tr td {
	width: 100px;
}
</style>
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
	   	<p class="ui-fields">
			<label class="ui-label">入库时间:</label>
			<input class="easyui-datebox" type="text" name="startInstoretime"/> 至 
			<input class="easyui-datebox" type="text" name="endInstoretime"/>
	   	</p>
	   	<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</form>  
</div> 
<!-- Search panel end -->
<!-- DataList  -->
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="详情" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">投入品信息</div>
  	   		<table id="store">
  	   			<tr><td><label>商品编号:</label></td><td><span id="productNo"></span></td>
  	   			<td><label>投入品名称:</label></td><td><span id="inputName"></span></td></tr>
  	   			<tr><td><label>分类:</label></td><td><span id="classname"></span></td>
  	   			<td><label>规格:</label></td><td><span id="specifications"></span></td></tr>
  	   			<tr><td><label>单位:</label></td><td><span id="unit"></span></td>
  	   			<td><label>库存:</label></td><td><span id="baseName"></span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span id="brandName"></span></td>
  	   			<td><label>生产厂家:</label></td><td><span id="mfName"></span></td></tr>
  	   		</table>    
        	<div class="ftitle">投入品入库记录</div>    
        	<table id="store">
  	   			<tr><td><label>入库数量:</label></td><td><span id="purchaseCount"></span></td>
  	   			<td><label>入库时间:</label></td><td><span id="instoretime"></span></td></tr>
  	   			<tr><td><label>单价:</label></td><td><span id="unitPrice"></span></td>
  	   			<td><label>仓库:</label></td><td><span id="whName"></span></td></tr>
  	   			<tr><td><label>负责人:</label></td><td><span id="principalName"></span></td><tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>    
      </div>
 	</form>
</div> 
<script type="text/javascript" src="<%=basePath%>/js/ux/store/sysIninventory.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/store/changedata_in.js"></script>
</body>
</html>