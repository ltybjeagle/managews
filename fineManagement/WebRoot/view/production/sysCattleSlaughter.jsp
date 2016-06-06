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
			<label class="ui-label">出栏时间:</label><input name="cattleTime" class="easyui-box ui-text" style="width:100px;">
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
		<input class="hidden" type="text" name="fowleryName" id="fowleryName" value="${fowleryName}">
		<input class="hidden" type="text" name="baseName" id="baseName" value="${baseName}">
		<input class="hidden" type="text" name="fowleryid" id="fowleryid" value="${fowleryid}">
		<input class="hidden" type="text" name="baseid" id="baseid" value="${baseid}">
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="pno" id="pno" value="0">
		<div class="ui-edit">
			<div class="ftitle">出栏信息</div>    
       		<div class="fitem">  
           		<label>养殖品种:</label>  
           		<input class="easyui-validatebox" type="text" name="breedid" data-options="required:true"/>
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>出栏数量:</label>  
           		<input class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>等级:</label>  
             	<input class="easyui-validatebox" type="text" name="cattleLevel" data-options="required:true"/>
         	</div>
       		<div class="fitem">  
            	<label>单价:</label>  
             	<input class="easyui-validatebox" type="text" name="unitPrice" data-options="required:true"/>
         	</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="text" name="charge" data-options="required:true" />
       		</div>
       		<div class="fitem">  
           		<label>验收人:</label>  
           		<input class="easyui-validatebox" type="text" name="verification" data-options="required:true" />
       		</div>
       		<div class="fitem">  
            	<label>出栏时间:</label>  
             	<input class="easyui-datebox" type="text" name="cattleTime"/>
         	</div>
         	<div class="fitem">  
            	<label>附件资料:</label>  
             	<input class="easyui-validatebox" type="text" name="verification" data-options="required:true" />
         	</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="text" name="remark" data-options="required:true"/>
       		</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/sysCattleSlaughter.js"></script>
</body>
</html>