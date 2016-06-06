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
			<label class="ui-label">禽舍名称:</label><input name="name" class="easyui-box ui-text" style="width:100px;">
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
			<div class="ftitle">禽舍信息</div>    
       		<div class="fitem">  
           		<label>禽舍名称:</label>  
           		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>禽舍面积:</label>  
           		<input class="easyui-validatebox" type="text" name="breedArea" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>所属基地:</label>  
             	<select class="easyui-combobox" id="baseIds" name="baseIds" data-options="width:141"></select>
         	</div>
         	<div class="fitem">  
            	<label>禽舍类型:</label>  
             	<select class="easyui-combobox" id="ftypes" name="ftypes" data-options="width:141"></select>
         	</div>
         	<div class="fitem">  
           		<label>饲养员:</label>  
           		<input class="easyui-validatebox" type="text" name="breeder" data-options="required:true"/>
       		</div>
         	<div class="fitem">  
           		<label>技术员:</label>  
           		<input class="easyui-validatebox" type="text" name="technician" data-options="required:true"/>
       		</div>
         	<div class="fitem">  
           		<label>建设时间:</label>  
           		<input class="easyui-datebox" type="text" name="createTime"/>
       		</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="text" name="remark" data-options="required:true"/>
       		</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/basic/sysFowlery.js"></script>
</body>
</html>