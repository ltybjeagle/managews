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
			<label class="ui-label">姓名:</label><input name="name" class="easyui-box ui-text" style="width:100px;">
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">出车状态:</label>
			<select class="easyui-combobox" id="driverStatus" name="driverStatus" style="width:100px;">>
           		<option value="0"></option>
           		<option value="1">空闲</option>
           		<option value="2">出车</option>
           	</select>
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
		<input class="hidden" type="text" name="sex" id = "sex" value="1"/>
		<div class="ui-edit">
			<div class="ftitle">驾驶员管理</div>    
       		<div class="fitem">  
           		<label>姓名:</label>  
           		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>性别:</label>  
           		<select class="easyui-combobox" id="selectSexs" name="selectSexs" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
             		<option value="1">男</option>
             		<option value="2">女</option>
            	</select>
       		</div>
       		<div class="fitem">  
           		<label>年龄:</label>  
           		<input class="easyui-validatebox" type="text" name="age"/>岁
       		</div>
       		<div class="fitem">  
           		<label>车龄:</label>  
           		<input class="easyui-validatebox" type="text" name="carAge"/>年
       		</div>
       		<div class="fitem">  
            	<label>联系方式:</label>  
             	<input class="easyui-validatebox" type="text" name="phoneNo"/>
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
  	   		<div class="ftitle">驾驶员管理</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>姓名:</label></td><td><span id="name"></span></td></tr>
  	   			<tr><td><label>性别:</label></td><td><span id="sex_q"></span></td></tr>
  	   			<tr><td><label>年龄:</label></td><td><span id="age"></span>岁</td></tr>
  	   			<tr><td><label>车龄:</label></td><td><span id="carAge"></span>年</td></tr>
  	   			<tr><td><label>联系方式:</label></td><td><span id="phoneNo"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/sysDriver.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/changedatadriver.js"></script>
</body>
</html>