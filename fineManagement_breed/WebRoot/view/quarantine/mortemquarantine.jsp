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
			<label class="ui-label">检疫批次:</label><input name="quarantineBatch" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">检疫结果:</label>
			<select class="easyui-combobox" id="selectResult" name="selectResult" style="width:100px;">>
           		<option value="0"></option>
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
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post" enctype="multipart/form-data"> 
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" id="quarantineResults" name="quarantineResults" value="1">
		<div class="ui-edit">
			<div class="ftitle">宰后检疫</div>
			<div class="fitem">  
           		<label>加工批次:</label>  
           		<select class="easyui-combobox" id="batchprocessing" name="batchprocessing" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
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
           		<select class="easyui-combobox" id="selectResults" name="selectResults" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
             		<option value="1">合格</option>
             		<option value="2">不合格</option>
            	</select>
       		</div>
       		<div id="filecontrol" class="fitem">  
            	<label>检疫报告:</label>  
             	<input class="easyui-filebox" name="file" data-options="prompt:'Choose a file...'" style="width:175px">
         	</div>
       		<div class="fitem">  
           		<label>检疫时间:</label>  
           		<input class="easyui-datebox" type="text" id="quarantinetime" name="quarantinetime"/>
       		</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" id="remark" name="remark" data-options="width:141"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">宰后检疫</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>加工批次:</label></td><td><span id="batchprocessing_q"></span></td></tr>
  	   			<tr><td><label>检疫批次:</label></td><td><span id="quarantineBatch_q"></span></td></tr>
  	   			<tr><td><label>检疫项目:</label></td><td><span id="quarantineitems_q"></span></td></tr>
  	   			<tr><td><label>检疫人员:</label></td><td><span id="quarantineofficers_q"></span></td></tr>
  	   			<tr><td><label>检疫结果:</label></td><td><span id="quarantineResults_q"></span></td></tr>
  	   			<tr><td><label>检疫时间:</label></td><td><span id="quarantinetime_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark_q"></span></td></tr>
  	   		</table>
  	   		<div class="ftitle">检疫报告</div>
  	   		<div id="fileMsg"></div>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/quarantine/mortemquarantine.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/quarantine/changedatamortem.js"></script>
</body>
</html>