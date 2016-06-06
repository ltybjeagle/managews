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
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post" enctype="multipart/form-data"> 
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="quarantineResults" id="quarantineResults" value="1"/>
		<div class="ui-edit">
			<div class="ftitle">宰前检疫</div>    
       		<div class="fitem">  
           		<label>检疫批次:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="quarantineBatch" name="quarantineBatch" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>养殖批次:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="breedingBatch" name="breedingBatch" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>检疫项目:</label>  
           		<input class="easyui-validatebox" type="text" name="quarantineItem" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>检疫数量:</label>  
             	<input class="easyui-validatebox" type="text" name="quarantineQuantity" data-options="required:true"/>头
             </div>
       		<div class="fitem">  
           		<label>检疫类型:</label>  
           		<input type="radio" name="quarantineType" value="1" checked="checked"/>企业自检
        		<input type="radio" name="quarantineType" value="2"/>检疫机构 
       		</div>
       		<div id="institution" class="fitem">  
           		<label>检疫机构:</label>  
           		<input class="easyui-validatebox" type="text" id="quarantineInstitution" name="quarantineInstitution" />
       		</div>
       		<div class="fitem">  
           		<label>检疫人员:</label>  
           		<input class="easyui-validatebox" type="text" name="quarantineOfficer" data-options="required:true"/>
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
           		<input class="easyui-datebox" type="text" id="quarantineTime" name="quarantineTime"/>
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
  	   		<div class="ftitle">宰前检疫</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>检疫批次:</label></td><td><span id="quarantineBatch_q"></span></td></tr>
  	   			<tr><td><label>养殖批次:</label></td><td><span id="breedingBatch_q"></span></td></tr>
  	   			<tr><td><label>检疫项目:</label></td><td><span id="quarantineItem_q"></span></td></tr>
  	   			<tr><td><label>检疫类型:</label></td><td><span id="quarantineType_q"></span></td></tr>
  	   			<tr id="ins"><td><label>检疫机构:</label></td><td><span id="quarantineInstitution_q"></span></td></tr>
  	   			<tr><td><label>检疫人员:</label></td><td><span id="quarantineOfficer_q"></span></td></tr>
  	   			<tr><td><label>检疫结果:</label></td><td><span id="quarantineResults_q"></span></td></tr>
  	   			<tr><td><label>检疫时间:</label></td><td><span id="quarantineTime_q"></span></td></tr>
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
<script type="text/javascript" src="<%=basePath%>/js/ux/slaughter/sysPreSlaughterQuarantine.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/slaughter/changedataPresla.js"></script>
</body>
</html>