<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
<style type="text/css">
.sign-button {
  padding-left: 80px;
}
</style>
<script type="text/javascript">
function save() {
	if ($("#editForm_add").form('validate')) {
		var rows = $('#data-list').datagrid('getRows');
		if (rows.length > 0) {
			finems.progress();
			var data = {};
			data['id'] = ($("#id").val());
			data['distributionNo'] = ($("#distributionNo").val());
			data['distributionPId'] = ($("#distributionPId").val());
			data['vehiclesId'] = ($("#vehiclesId").val());
			data['brand'] = ($("#brand").val());
			data['plateNum'] = ($("#plateNum").val());
			data['receivingUnit'] = ($("#receivingUnit").val());
			finems.ajaxJson('saveSign.do', data, function() {
	    		window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/list.shtml';
			});
		} else {
			finems.alert('警告', '未添加配送清单，不能保存', 'warning');
		}
	}
}

function toBack() {
	finems.progress();
	window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/list.shtml';
}
</script>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 255px;" title="配送信息">  
	<form id="editForm_add" class="ui-form" method="post">
		<input class="hidden" type="text" name="id" id="id" value="${data.id}">
		<input class="hidden" type="text" name="distributionPId" id="distributionPId" value="${data.distributionPId}">
		<input class="hidden" type="text" name="vehiclesId" id="vehiclesId" value="${data.vehiclesId}">
		<div class="ui-edit">
       		<div class="fitem">  
           		<label>配送单号:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="distributionNo" name="distributionNo" 
           			value="${data.distributionNo}" style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>配送人:</label>
           		<select class="easyui-combobox" id="distributionPIds" name="distributionPIds" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>车辆编号:</label>  
           		<select class="easyui-combobox" id="vehiclesIds" name="vehiclesIds" required="true" 
           			validType="comboxRequired" data-options="width:141">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>品牌:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="brand" name="brand" 
           			value="${data.brand}" style="background-color:#d0d0d0" />
       		</div>
       		<div class="fitem">  
            	<label>车牌号:</label>  
             	<input class="easyui-validatebox" type="text" readonly="true" id="plateNum" name="plateNum" 
           			value="${data.plateNum}" style="background-color:#d0d0d0" />
            </div>
       		<div class="fitem">  
           		<label>收货单位:</label>  
           		<input class="easyui-validatebox" type="text" id="receivingUnit" name="receivingUnit" 
           			value="${data.receivingUnit}" data-options="required:true"/>
       		</div>
		</div>
	</form>
	<div id="editPwdbtn" class="sign-button">  
        <a href="javascript:save();" class="easyui-linkbutton" id="btn-pwd-submit">保存</a>  
        <a href="javascript:toBack();" class="easyui-linkbutton" id="btn-pwd-close">返回</a>  
    </div>
</div>
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<!-- Edit Form -->
<div id="edit-win" class="easyui-dialog" title="Edit" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:530px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<input class="hidden" type="text" name="distributionNos" id="distributionNos">
		<div class="ui-edit">
			<div class="ftitle">配送清单</div>    
       		<div class="fitem">  
           		<label>产品名称:</label>  
           		<input class="easyui-validatebox" type="text" name="nameOfDishes" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>菜品类别:</label>  
           		<input class="easyui-validatebox" type="text" name="typeOfDishes" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>单位:</label>  
           		<input class="easyui-validatebox" type="text" name="unit" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>数量:</label>  
             	<input class="easyui-validatebox" type="text" name="number" data-options="required:true"/>
             </div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/toEdit.js"></script>
</body>
</html>