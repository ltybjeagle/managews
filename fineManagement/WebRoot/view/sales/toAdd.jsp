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
			$('#editForm_add').submit();
		} else {
			finems.alert('警告', '未添加配送清单，不能保存', 'warning');
		}
	}
}

function toBack() {
	finems.progress();
	var rows = $('#data-list').datagrid('getRows');
	if (rows.length > 0) {
		finems.alert('警告', '已经添加配送清单，返回后将全部清除', 'warning', function() {
			var arr = [];
			for (var i=0; i < rows.length; i++) {
				arr.push('id=' + rows[i]['id']);
			}
	    	var data = arr.join("&");
	    	finems.deleteForm('delete.do', data, function(result) {
	    		finems.closeProgress();
	    		window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/list.shtml';
			});
		});
	} else {
		window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/list.shtml';
	}
}
</script>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 270px;" title="配送信息">  
	<form id="editForm_add" class="ui-form" action="<%=basePath%>/sysSign/saveSign.do" method="post" enctype="multipart/form-data"> 
		<input class="hidden" type="text" name="distributionPId" id="distributionPId">
		<input class="hidden" type="text" name="vehiclesId" id="vehiclesId">
		<div class="ui-edit">
       		<div class="fitem">  
           		<label>配送单号:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="distributionNo" name="distributionNo" 
           			style="background-color:#d0d0d0"/>
       		</div>
       		<div class="fitem">  
           		<label>配送人:</label>
           		<select class="easyui-combobox" id="distributionPIds" name="distributionPIds" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>车辆编号:</label>  
           		<select class="easyui-combobox" id="vehiclesIds" name="vehiclesIds" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;">
           		</select>
       		</div>
       		<div class="fitem">  
           		<label>品牌:</label>  
           		<input class="easyui-validatebox" type="text" readonly="true" id="brand" name="brand" 
           			style="background-color:#d0d0d0" />
       		</div>
       		<div class="fitem">  
            	<label>车牌号:</label>  
             	<input class="easyui-validatebox" type="text" readonly="true" id="plateNum" name="plateNum" 
           			style="background-color:#d0d0d0" />
            </div>
       		<div class="fitem">  
           		<label>收货单位:</label>  
           		<input class="easyui-validatebox" type="text" id="receivingUnit" name="receivingUnit" data-options="required:true"/>
       		</div>
       		<div id="filecontrol" class="fitem">  
            	<label>上传报告:</label>  
             	<input class="easyui-filebox" name="file" data-options="prompt:'Choose a file...'" style="width:175px">
         	</div>
		</div>
		<div id="editPwdbtn" class="sign-button">  
	        <a href="javascript:save();" class="easyui-linkbutton" id="btn-pwd-submit">保存</a>  
	        <a href="javascript:toBack();" class="easyui-linkbutton" id="btn-pwd-close">返回</a>  
	    </div>
	</form>
</div>
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<!-- Edit Form -->
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
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
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/toAdd.js"></script>
</body>
</html>