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
			<label class="ui-label">仓库名称:</label><input name="whName" class="easyui-box ui-text" style="width:100px;">
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
			<div class="ftitle">仓库信息</div>    
       		<div class="fitem">  
           		<label>仓库名称:</label>  
           		<input class="easyui-validatebox" type="text" name="whName" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>仓库地址:</label>  
           		<input class="easyui-validatebox" type="text" name="whAddress" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>仓库面积（亩）:</label>  
           		<input class="easyui-validatebox" type="text" name="whArea" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>负责人:</label>  
             	<input class="easyui-validatebox" type="text" name="responsible" data-options="required:true"/>
             </div>
       		<div class="fitem">  
           		<label>联系方式:</label>  
           		<input class="easyui-validatebox" type="text" name="phoneNo" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>建设时间:</label>  
           		<input class="easyui-datebox" type="text" id="createTime" name="createTime"/>
       		</div>
       		<div class="fitem">  
           		<label>地图:</label>  
           		<input class="easyui-validatebox" type="text" name="coordinate" id="coordinate"/><a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#allmap').dialog('open')">标注地图</a>
       		</div>
       		<div class="fitem">  
           		<label>简介:</label>  
           		<input class="easyui-validatebox" type="text" name="remark"/>
       		</div>
		</div>
	</form>
</div>
<div id="query-win" class="easyui-dialog" title="查看" data-options="closed:true,modal:true" 
	style="width:560px;height:460px;">
 	<form id="pwdForm" class="ui-form" method="post">  
 		<div class="ui-edit">
  	   		<div class="ftitle">仓库信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>仓库名称:</label></td><td><span id="whName"></span></td></tr>
  	   			<tr><td><label>仓库地址:</label></td><td><span id="whAddress"></span></td></tr>
  	   			<tr><td><label>仓库面积（亩）:</label></td><td><span id="whArea"></span></td></tr>
  	   			<tr><td><label>负责人:</label></td><td><span id="responsible"></span></td></tr>
  	   			<tr><td><label>联系方式:</label></td><td><span id="phoneNo"></span></td></tr>
  	   			<tr><td><label>建设时间:</label></td><td><span id="createTime_q"></span></td></tr>
  	   			<tr><td><label>简介:</label></td><td><span id="remark"></span></td></tr>
  	   		</table>
  	   		<div class="ftitle">地图</div>
  	   		<img style="margin:10px" width="300" height="130" id="imgArea" src="" />
      </div>
 	</form>
 	<div id="querybtn" class="dialog-button">
        <a href="#" class="easyui-linkbutton" id="btn-query-close">关闭</a>  
    </div>
</div>
<div id="allmap" class="easyui-dialog" title="地图" data-options="closed:true,iconCls:'icon-save'" 
	style="width:500px;height:400px;padding:10px">
	</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/basic/sysWarehouse.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/basic/changedataWh.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=uta1DHlFNK5OVcdPphhzuoEkM79qqEcm"></script>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(117.253347,31.840769);
	map.centerAndZoom(point,15);
	var menu = new BMap.ContextMenu();
	var txtMenuItem = [
		{
			text:'放大',
			callback:function(){map.zoomIn()}
		},
		{
			text:'缩小',
			callback:function(){map.zoomOut()}
		}
	];
	for(var i=0; i < txtMenuItem.length; i++){
		menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
	}
	map.addContextMenu(menu);
	map.addEventListener("click",function(e){
		$('#coordinate').val(e.point.lng + "," + e.point.lat);
		$('#allmap').dialog('close');
	});
</script>
</body>
</html>