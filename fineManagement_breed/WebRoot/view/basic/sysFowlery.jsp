<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="searchForm">
		<p class="ui-fields">
			<label class="ui-label">所属基地:</label>
			<select class="easyui-combobox" id="baseId" name="baseId" style="width:100px;"></select>
	   	</p>
	   	<p class="ui-fields">
			<label class="ui-label">禽舍类型:</label>
			<select class="easyui-combobox" id="ftypeid" name="ftypeid" style="width:100px;"></select>
	   	</p>
	   	<a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</form>  
</div> 
<div region="center" border="false" >
	<table id="data-list"></table>
</div>
<div id="edit-win" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" 
	style="width:560px;height:460px;">
	<form id="editForm" class="ui-form" method="post"> 
		<input class="hidden" type="text" name="id">
		<div class="ui-edit">
			<div class="ftitle">禽舍信息</div>    
       		<div class="fitem">  
           		<label>禽舍名称:</label>  
           		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
           		<label>禽舍面积:</label>  
           		<input class="easyui-validatebox" type="text" name="breedArea" data-options="required:true"/>
       		</div>
       		<div class="fitem">  
            	<label>所属基地:</label>  
             	<select class="easyui-combobox" id="baseIds" name="baseIds" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;"></select>
         	</div>
         	<div class="fitem">  
            	<label>禽舍类型:</label>  
             	<select class="easyui-combobox" id="ftypes" name="ftypes" data-options="required:true,editable:false,panelHeight:'auto'"
             		style="padding:2px;width:141px;"></select>
         	</div>
         	<div class="fitem">  
           		<label>饲养员:</label>  
           		<input class="easyui-validatebox" type="text" name="breeder"/>
       		</div>
         	<div class="fitem">  
           		<label>技术员:</label>  
           		<input class="easyui-validatebox" type="text" name="technician"/>
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
  	   		<div class="ftitle">禽舍信息</div>
  	   		<table id="query_table_win">
  	   			<tr><td><label>禽舍名称:</label></td><td><span id="name"></span></td></tr>
  	   			<tr><td><label>禽舍面积:</label></td><td><span id="breedArea"></span></td></tr>
  	   			<tr><td><label>所属基地:</label></td><td><span id="baseName"></span></td></tr>
  	   			<tr><td><label>禽舍类型:</label></td><td><span id="fowleryName"></span></td></tr>
  	   			<tr><td><label>饲养员:</label></td><td><span id="breeder"></span></td></tr>
  	   			<tr><td><label>技术员:</label></td><td><span id="technician"></span></td></tr>
  	   			<tr><td><label>建设时间:</label></td><td><span id="createDate"></span></td></tr>
  	   			<tr><td><label>备注:</label></td><td><span id="remark"></span></td></tr>
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
<script type="text/javascript" src="<%=basePath%>/js/ux/basic/sysFowlery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ux/basic/changedataFowlery.js"></script>
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