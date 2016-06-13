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
			<label class="ui-label">物资编号:</label><input name="materialno" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   		<p class="ui-fields">
			<label class="ui-label">物资名称:</label><input name="materialname" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">归还时间:</label><input name="returntimestart" type="text" class="easyui-datebox" style="width:100px;">
			<label class="ui-label">至</label><input name="returntimeend" type="text" class="easyui-datebox" style="width:100px;">
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
<div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="详情" data-options="closed:true,modal:true" 
	style="width:560px;height:430px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">物资目录信息</div>
  	   		<table id="store">
  	   			<tr><td><label>物资编号:</label></td><td><span id="materialno"></span></td>
  	   			<td><label>物资名称:</label></td><td><span id="materialname"></span></td></tr>
  	   			<tr><td><label>单位:</label></td><td><span id="unit"></span></td>
  	   			<td><label>规格:</label></td><td><span id="specifications"></span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span id="brandName"></span></td>
  	   			<td><label>生产厂家:</label></td><td><span id="mfName"></span></td></tr>
  	   		</table>    
        	<div class="ftitle">归还信息</div>    
        	<table id="store">
  	   			<tr><td><label>归还数量:</label></td><td><span id="returncount"></span></td>
  	   			<td><label>归还时间:</label></td><td><span id="returntime"></span></td></tr>
  	   			<tr><td><label>单价:</label></td><td><span id="unitPrice"></span></td>
  	   			<td><label>仓库:</label></td><td><span id="whName"></span></td></tr>
  	   			<tr><td><label>负责人:</label></td><td><span id="principal"></span></td>
  	   			<td><label>归还人:</label></td><td><span id="backuser"></span></td></tr>
  	   			<tr><td><label>所属基地:</label></td><td><span id="baseName"></span></td>
  	   			<td><label>所属禽舍:</label></td><td><span id="greenhousename"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>    
      </div>
 	</form>
</div> 
<script type="text/javascript" src="<%=basePath%>/js/ux/materialmanage/sysMaterialReturnDetail.js"></script>
</body>
</html>