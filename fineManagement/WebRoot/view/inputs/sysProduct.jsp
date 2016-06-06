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
			<select class="easyui-combobox" id="classifyId" name="classifyId" style="width:100px;"></select>
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
		<div class="ui-edit">
			<div class="ftitle">产品目录信息</div>    
       		<div class="fitem">  
           		<label>商品编号:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="productNo" name="productNo" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>投入品名称:</label>  
           		<input class="easyui-validatebox" type="text" name="inputName" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>分类:</label>  
             	<select class="easyui-combobox" id="classifyIds" name="classifyIds" data-options="width:141"></select>
         	</div>
       		<div class="fitem">  
           		<label>单位:</label>  
           		<input class="easyui-validatebox" type="text" name="unit" />
       		</div>
       		<div class="fitem">  
           		<label>规格:</label>  
           		<input class="easyui-validatebox" type="text" name="specifications" />
       		</div>
       		<div class="fitem">  
            	<label>品牌:</label>  
             	<select class="easyui-combobox" id="brandIds" name="brandIds" data-options="width:141"></select>
         	</div>
       		<div class="fitem">  
            	<label>厂家:</label>  
             	<select class="easyui-combobox" id="mfids" name="mfids" data-options="width:141"></select>
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
  	   		<div class="ftitle">产品目录信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>商品编号:</label></td><td><span id="productNoVal"></span></td></tr>
  	   			<tr><td><label>投入品名称:</label></td><td><span id="inputName"></span></td></tr>
  	   			<tr><td><label>分类:</label></td><td><span id="classname"></span></td></tr>
  	   			<tr><td><label>单位:</label></td><td><span id="unit"></span></td></tr>
  	   			<tr><td><label>规格:</label></td><td><span id="specifications"></span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span id="brandName"></span></td></tr>
  	   			<tr><td><label>厂家:</label></td><td><span id="mfName"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/inputs/sysProduct.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/inputs/changedataProduct.js"></script>
</body>
</html>