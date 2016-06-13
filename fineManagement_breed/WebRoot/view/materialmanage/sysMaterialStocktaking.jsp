<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 200px;" title="盘库主单">  
	<form id="editForm_add" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="distributionPId" id="distributionPId">
		<input class="hidden" type="text" name="vehiclesId" id="vehiclesId">
		<div class="ui-edit">
       		<div class="fitem">  
           		<label>盘库单号:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="stocktalingno" name="stocktalingno" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>盘点仓库:</label>
           		<select class="easyui-combobox" id="warehouseid" name="warehouseid" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="text" id="principal" name="principal" 
           			/>
       		</div>
       		
       		<div class="fitem">  
            	<label>备注:</label>  
             	<input class="easyui-validatebox" type="text" id="remark" name="remark" 
           			style="width:250px;" />
            </div>
		</div>
		
	</form>
</div> 
<!-- Search panel end -->
<!-- DataList  -->
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<!-- Edit Form -->
<div id="add-win" class="easyui-dialog" buttons="editaddbtn" title="添加" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:400px;height:300px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">物资盘库信息</div>
			<div class="fitem">  
           		<input class="hidden" id="syssign" name="syssign" readonly="true" data-options="width:282"/>
       		</div>    
       		<div class="fitem">  
           		<label>物资编号:</label>
           		<select class="easyui-combobox" id="materialno" name="materialno" data-options="width:141"></select>  
    
       		</div>
       		<div class="fitem">  
           		<label>物资名称:</label>  
           		<input class="easyui-validatebox" id = "materialname" type="text" name="materialname" readonly="true" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>帐目数:</label>  
           		<input class="easyui-validatebox" id = "storecount" type="text" name="storecount" readonly="true" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>实盘数:</label>  
           		<input class="easyui-validatebox" id = "firm" type="text" name="firm"  data-options="required:true"/>
       		</div>
		</div>
	</form>
	<div id="editaddbtn" class="dialog-button">  
        <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-add">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">取消</a>    
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/materialmanage/sysMaterialStocktaking.js"></script>
</body>
</html>