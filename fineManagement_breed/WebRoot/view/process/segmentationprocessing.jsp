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
			<label class="ui-label">加工批次:</label><input name="batchprocessing" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
            <label class="ui-label">加工时间:</label>
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
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">分割加工</div>
			<div class="fitem">  
           		<label>屠宰批次:</label>  
           		<select class="easyui-combobox" id="slaughterbatch" name="slaughterbatch" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>屠宰数量:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="numberslaughter" 
           			name="numberslaughter" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>加工批次:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="batchprocessing" 
           			name="batchprocessing" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>加工产品名称:</label>  
           		<input class="easyui-validatebox" type="processname" name="processname" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>加工时间:</label>  
           		<input class="easyui-datebox" type="text" id="processtime" name="processtime"/>
       		</div>
			<div class="fitem">  
           		<label>加工人员:</label>  
           		<input class="easyui-validatebox" id="processingstaff" name="processingstaff" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>是否完成分割:</label>  
           	<input type="radio" name="is_completed" value="1"/>完成
            <input type="radio" name="is_completed" value="2"/>未完成 
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
  	   		<div class="ftitle">分割加工</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>屠宰批次:</label></td><td><span id="sbatch"></span></td></tr>
  	   			<tr><td><label>屠宰数量:</label></td><td><span id="numberslaughter_q"></span></td></tr>
  	   			<tr><td><label>加工批次:</label></td><td><span id="batchprocessing_q"></span></td></tr>
  	   			<tr><td><label>加工产品名称:</label></td><td><span id="processname_q"></span></td></tr>
  	   			<tr><td><label>加工时间:</label></td><td><span id="processtime_q"></span></td></tr>
  	   			<tr><td><label>加工人员:</label></td><td><span id="processingstaff_q"></span></td></tr>
  	   			<tr><td><label>是否完成分割:</label></td><td><span id="is_completed_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark_q"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/process/SegmentationProcessing.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/process/changedataSegmentation.js"></script>
</body>
</html>