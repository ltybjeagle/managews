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
			<label class="ui-label">任务时间:</label><input name="taskTime" class="easyui-box ui-text" style="width:100px;">
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
			<div class="ftitle">养殖信息</div>    
       		<div class="fitem">  
           		<label>任务类型:</label>  
           		<select class="easyui-combobox" id="taskids" name="taskids" required="true" validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
            	<label>饲养员:</label>  
             	<select class="easyui-combobox" id="breeders" name="breeders" required="true" validType="comboxRequired" data-options="width:141">
           		</select>
         	</div>
       		<div class="fitem">  
           		<label>技术员:</label>  
           		<select class="easyui-combobox" id="breedTechnicians" name="breedTechnicians" required="true" validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
            	<label>任务时间:</label>  
             	<input class="easyui-datebox" type="text" name="taskTime"/>
         	</div>
       		<div class="fitem">  
           		<label>工作内容:</label>  
           		<input class="easyui-validatebox" type="text" name="taskContent" data-options="required:true"/>
       		</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/production/sysTaskBreed.js"></script>
</body>
</html>