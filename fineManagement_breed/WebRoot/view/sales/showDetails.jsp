<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
<style type="text/css">
.sign-button {
  padding-right: 80px;
  text-align: right;
}
</style>
<script type="text/javascript">
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
		<input class="hidden" type="text" name="distributionNo" id="distributionNo" value="${data.distributionNo}">
		<div class="ui-edit">
       		<div class="fitem">  
           		<label>配送单号:</label><span>${data.distributionNo}</span>
       		</div>
       		<div class="fitem">  
           		<label>配送人:</label><span>${data.distributionPerson}</span>
       		</div>
       		<div class="fitem">  
           		<label>车辆编号:</label><span>${data.vehiclesNo}</span>
       		</div>
       		<div class="fitem">  
           		<label>品牌:</label><span>${data.brand}</span>
       		</div>
       		<div class="fitem">  
            	<label>车牌号:</label><span>${data.plateNum}</span>  
            </div>
       		<div class="fitem">  
           		<label>收货单位:</label><span>${data.receivingUnit}</span>  
       		</div>
		</div>
	</form>
	<div id="editPwdbtn" class="sign-button">
        <a href="javascript:toBack();" class="easyui-linkbutton" id="btn-pwd-close">返回</a>  
    </div>
</div>
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sales/showDetails.js"></script>
</body>
</html>