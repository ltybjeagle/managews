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
			<label class="ui-label">使用时间:</label>
			<input class="easyui-datebox" type="text" id="startStartTime" name="startStartTime"/> 至 
			<input class="easyui-datebox" type="text" id="endStartTime" name="endStartTime"/>
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
	style="width:560px;height:500px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="fowleryName" id="fowleryName" value="${fowleryName}">
		<input class="hidden" type="text" name="baseName" id="baseName" value="${baseName}">
		<input class="hidden" type="text" name="fowleryid" id="fowleryid" value="${fowleryid}">
		<input class="hidden" type="text" name="baseid" id="baseid" value="${baseid}">
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="pno" id="pno" value="0">
		<div class="ui-edit">
			<div class="ftitle">投入品信息</div>    
       		<div class="fitem">  
           		<label>商品编号:</label>  
           		<select class="easyui-combobox" id="productNos" name="productNos" required="true" validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>投入品名称:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="inputName" name="inputName" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
            	<label>分类:</label>  
             	<input class="easyui-validatebox" type="text" readonly="true" id="classname" name="classname" style="background-color:#d0d0d0" />
         	</div>
       		<div class="fitem">  
           		<label>单位:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="unit" name="unit" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>规格:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="specifications" name="specifications" style="background-color:#d0d0d0" />
       		</div>
       		<div class="fitem">  
            	<label>品牌:</label>  
             	<input class="easyui-validatebox" type="text" readonly="true" id="brandName" name="brandName" style="background-color:#d0d0d0" />
         	</div>
       		<div class="fitem">  
            	<label>厂家:</label>  
             	<input class="easyui-validatebox" type="text" readonly="true" id="mfName" name="mfName" style="background-color:#d0d0d0" />
         	</div>
         	<div class="fitem">  
            	<label>使用时间:</label>  
             	<input class="easyui-datebox" type="text" id="startTime" name="startTime"/>
         	</div>
         	<div class="fitem">  
           		<label>投入数量:</label>  
           		<input class="easyui-validatebox" type="text" name="purchaseCount" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>单价:</label>  
           		<input class="easyui-validatebox" type="text" name="unitPrice" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>饲养员:</label>  
             	<select class="easyui-combobox" id="breeders" name="breeders" data-options="required:true,editable:false,panelHeight:'auto'" 
           			style="padding:2px;width:141px;">
           		</select>
         	</div>
       		<div class="fitem">  
           		<label>技术员:</label>  
           		<select class="easyui-combobox" id="breedTechnicians" name="breedTechnicians" data-options="required:true,editable:false,panelHeight:'auto'" 
           			style="padding:2px;width:141px;">
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
  	   		<div class="ftitle">投入品信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>商品编号:</label></td><td><span id="productNo"></span></td></tr>
  	   			<tr><td><label>投入品名称:</label></td><td><span id="inputName_q"></span></td></tr>
  	   			<tr><td><label>分类:</label></td><td><span id="classname_q"></span></td></tr>
  	   			<tr><td><label>单位:</label></td><td><span id="unit_q"></span></td></tr>
  	   			<tr><td><label>规格:</label></td><td><span id="specifications_q"></span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span id="brandName_q"></span></td></tr>
  	   			<tr><td><label>厂家:</label></td><td><span id="mfName_q"></span></td></tr>
  	   			<tr><td><label>使用时间:</label></td><td><span id="startTime_q"></span></td></tr>
  	   			<tr><td><label>投入数量:</label></td><td><span id="purchaseCount"></span></td></tr>
  	   			<tr><td><label>单价:</label></td><td><span id="unitPrice"></span></td></tr>
  	   			<tr><td><label>饲养员:</label></td><td><span id="breederName"></span></td></tr>
  	   			<tr><td><label>技术员:</label></td><td><span id="breedTechnicianName"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/sysInputsbreed.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/changedataBreedinputs.js"></script>
</body>
</html>