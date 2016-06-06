<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" 
	data-options="striped: false,collapsible:false,iconCls:'icon-search',border:false" >   
<form id="searchForm">
<input class="hidden" id='search_parentId' name="parentId">
<p class="ui-fields">
        <label class="ui-label">菜单名:</label> 
        <input name="name" class="easyui-box ui-text" style="width:100px;">
   </p>
   <a id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
</form>  
</div>
<!--  Search panel end -->
<!-- DataList  -->
<div region="center" border="false" >
	<table id="data-list" ></table>
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/sys/sysMenu.js"></script>
</body>
</html>