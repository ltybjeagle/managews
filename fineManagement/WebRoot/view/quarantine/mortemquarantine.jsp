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
			<label class="ui-label">检疫批次:</label><input name="quarantineitems" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
				<label class="ui-label">检疫结果:</label>
			<select class="easyui-combobox" id="quarantineResults" name="quarantineResults" data-options="required:true">
             		<option value="1">合格</option>
             		<option value="2">不合格</option>
            </select>
		</p>
	   	 	<p class="ui-fields">
	   	  	<label class="ui-label">检疫时间:</label>
			<input class="easyui-datebox" type="text" name="start_date"/> 至 
			<input class="easyui-datebox" type="text" name="end_date"/>
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
		<input class="hidden" type="text" id="quarantineResults" name="quarantineResults">
		<div class="ui-edit">
			<div class="ftitle">宰后检疫</div>
			<div class="fitem">  
           		<label>加工批次:</label>  
           		<select class="easyui-combobox" id="batchprocessing" name="batchprocessing" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>检疫批次:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="quarantineBatch" 
           			name="quarantineBatch" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>检疫项目:</label>  
           		<input class="easyui-validatebox" type="quarantineitems" name="quarantineitems" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>检疫人员:</label>  
           		<input class="easyui-validatebox" type="quarantineofficers" name="quarantineofficers" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>检疫结果:</label>  
           		<select class="easyui-combobox" id="selectResults" name="selectResults" data-options="required:true">
             		<option value="1">合格</option>
             		<option value="2">不合格</option>
            	</select>
       		</div>
       		<div class="fitem">  
           		<label>检疫时间:</label>  
           		<input class="easyui-datebox" type="text" name="quarantinetime"/>
       		</div>
       			<div id="filecontrol" class="fitem">  
            	<label>检疫报告:</label>  
             	<input class="easyui-filebox" name="file" data-options="prompt:'Choose a file...'" style="width:175px">
         	</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" id="remark" name="remark" data-options="width:141"/>
       		</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/quarantine/mortemquarantine.js"></script>
</body>
</html>