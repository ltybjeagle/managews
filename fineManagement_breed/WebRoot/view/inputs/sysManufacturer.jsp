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
			<label class="ui-label">厂家名称:</label><input name="mfName" class="easyui-box ui-text" style="width:100px;">
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
			<div class="ftitle">厂家信息</div>    
       		<div class="fitem">  
           		<label>厂家名称:</label>  
           		<input class="easyui-validatebox" type="text" name="mfName" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>厂家地址:</label>  
           		<input class="easyui-validatebox" type="text" name="mfArea"/>
       		</div>
       		<div class="fitem">  
           		<label>联系方式:</label>  
           		<input class="easyui-validatebox" type="text" name="mfPhoneNo"/>
       		</div>
       		<div class="fitem">  
           		<label>厂家介绍:</label>  
           		<input class="easyui-validatebox" type="text" name="remark"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">厂家信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>厂家名称:</label></td><td><span id="mfName"></span></td></tr>
  	   			<tr><td><label>厂家地址:</label></td><td><span id="mfArea"></span></td></tr>
  	   			<tr><td><label>联系方式:</label></td><td><span id="mfPhoneNo"></span></td></tr>
  	   			<tr><td><label>厂家介绍:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/inputs/sysManufacturer.js"></script>
</body>
</html>