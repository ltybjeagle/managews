<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
<div class="ui-search-panel" region="north" style="height: 280px;" title="配送信息">  
	<form id="editForm_add" class="ui-form" method="post">
		<input class="hidden" type="text" name="distributionNo" id="distributionNo" value="${data.distributionNo}">
		<div class="ui-edit">
			<table id="query_table_win">
  	   			<tr><td><label>配送单号:</label></td><td><span>${data.distributionNo}</span></td></tr>
  	   			<tr><td><label>配送人:</label></td><td><span>${data.distributionPerson}</span></td></tr>
  	   			<tr><td><label>车辆编号:</label></td><td><span>${data.vehiclesNo}</span></td></tr>
  	   			<tr><td><label>品牌:</label></td><td><span>${data.brand}</span></td></tr>
  	   			<tr><td><label>车牌号:</label></td><td><span>${data.plateNum}</span></td></tr>
  	   			<tr><td><label>收货单位:</label></td><td><span>${data.receivingUnit}</span></td></tr>
  	   		</table>
       		<div class="ftitle">配送图片:</div>
       		<div class="fitem">
       			<c:forEach var="item" items="${data.list}">
	       			<a href='<%=basePath%>${item.url}' download>${item.fileName}</a>
	       		</c:forEach>
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