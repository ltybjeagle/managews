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
			<label class="ui-label">样品时间:</label>
			<input class="easyui-datebox" type="text" name="startSamplingtime"/> 至 
			<input class="easyui-datebox" type="text" name="endSamplingtime"/>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">样品名称:</label>
			<select class="easyui-combobox" id="plantids" name="plantids" style="width:100px;"></select>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">基地:</label>
			<select class="easyui-combobox" id="baseids" name="baseids" style="width:100px;"></select>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">大棚:</label>
			<select class="easyui-combobox" id="greehouseids" name="greehouseids" style="width:100px;"></select>
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
		<input class="hidden" type="text" name="baseName" id="baseName">
		<input class="hidden" type="text" name="greenhousename" id="greenhousename">
		<div class="ui-edit">
			<div class="ftitle">检测添加</div>
			<div class="fitem">  
           		<label>样品编号:</label>  
           		<input class="easyui-validatebox" readonly="true" id="sampleno" name="sampleno" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
            	<label>基地名称:</label>  
             	<select class="easyui-combobox" id="baseid" name="baseid" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
         	</div>
         	<div class="fitem">  
            	<label>大棚名称:</label>  
             	<select class="easyui-combobox" id="greenhouseid" name="greenhouseid" data-options="required:true,editable:false,panelHeight:'auto'" 
             		style="padding:2px;width:141px;">
           		</select>
         	</div>
       		<div class="fitem">  
           		<label>样品名称:</label>  
           		<select class="easyui-combobox" id="sampname" name="sampname" data-options="required:true,editable:false,panelHeight:'auto'" 
           			style="padding:2px;width:141px;">
           		</select>
       		</div>
			<div class="fitem">  
           		<label>抽样数量:</label>  
           		<input class="easyui-validatebox" id="samplingcount" name="samplingcount" data-options="required:true"/>kg
       		</div>
       		<div class="fitem">  
           		<label>抽样时间:</label>  
           		<input class="easyui-datebox" type="text" id="samplingtime" name="samplingtime"/>
       		</div>
       		<div class="fitem">  
           		<label>抽样人:</label>  
           		<input class="easyui-validatebox" id="samplingpeople" name="samplingpeople" data-options="required:true"/>
       		</div>
         	<div id="filecontrol" class="fitem">  
            	<label>上传报告:</label>  
             	<input class="easyui-filebox" name="file" data-options="prompt:'Choose a file...'" style="width:175px">
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
  	   		<div class="ftitle">检测信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>样品编号:</label></td><td><span id="sampleno_q"></span></td></tr>
  	   			<tr><td><label>基地名称:</label></td><td><span id="baseName_q"></span></td></tr>
  	   			<tr><td><label>大棚名称:</label></td><td><span id="greenhouseName_q"></span></td></tr>
  	   			<tr><td><label>样品名称:</label></td><td><span id="sampname_q"></span></td></tr>
  	   			<tr><td><label>抽样数量:</label></td><td><span id="samplingcount_q"></span></td></tr>
  	   			<tr><td><label>抽样时间:</label></td><td><span id="samplingtime_q"></span></td></tr>
  	   			<tr><td><label>抽样人:</label></td><td><span id="samplingpeople_q"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark_q"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/samping/sampingmanage.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/samping/changedatasp.js"></script>
</body>
</html>