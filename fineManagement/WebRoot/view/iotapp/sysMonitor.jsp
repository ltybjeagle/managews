<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
<script src="<%=basePath%>/js/highcharts/highcharts.js"></script>
<script src="<%=basePath%>/js/highcharts/exporting.js"></script>
<script src="<%=basePath%>/js/highcharts/themes/grid.js"></script>
<style type="text/css">
.panel-body {
    overflow: hidden;
}

#RealTimePlayOcx, #details, #bottom {
	float: left;
}

#details {
	padding-left: 30px;
}

#monitor {
	padding-left: 30px;
}

span {
	padding-left: 50px;
}
</style>
</head>
<body >
<div id="monitor" region="center" border="false" >
	<input class="hidden" type="text" name="videoId" id="videoId">
	<input class="hidden" type="text" name="videoChannelNumber" id="videoChannelNumber">
	<div class="ui-edit" style='position:relative; z-index:999; top:0;'>
		<div class="ftitle">视频</div>
		<div class="fitem" >  
       		<select class="easyui-combobox" id="videoIds" name="videoIds"  data-options="width:141">
       		</select>
       		<a href="#" class="easyui-linkbutton" id="btn-search">打开</a>
   		</div>
	</div>
	
	<object classid="clsid:D5E14042-7BF6-4E24-8B01-2F453E8154D7"
							id="RealTimePlayOcx" width="600px" height="350px"
							name="RealTimePlayOcx">
							<param name="theme" value="blue" >
							 <param name="PreviewBottomToolBar" value=1>    
							 <param name="PreviewRecordBnt" value=0>
                              <param name="showType" value="1">
						</object>
	<div id="details">
		<div class="ui-edit" style="width: 400px">
			<div class="ftitle">种植信息</div>
			<div class="fitem">  
				<label>所属基地:</label><span id="baseName"></span>
	   		</div>
	   		<div class="fitem">  
				<label>大棚编号:</label><span id="greenhouseName"></span>
	   		</div>
	   		<div class="fitem">  
				<label>种植面积:</label><span id="plantArea"></span>
	   		</div>
	   		<div class="fitem">  
				<label>大棚类型:</label><span id="greenhouseType"></span>
	   		</div>
	   		<div class="fitem">  
				<label>主要品种:</label><span id="variety"></span>
	   		</div>
	   		<div class="fitem">  
				<label>种植员:</label><span id="plantationMemberName"></span>
	   		</div>
	   		<div class="fitem">  
				<label>技术员:</label><span id="technicianName"></span>
	   		</div>
	   		<div class="fitem">  
				<label>技术员联系方式:</label><span id="basePhone"></span>
	   		</div>
   		</div>
	</div>
	<div id="bottom" style="width:100%">
		<div class="ui-edit">
			<div class="ftitle">传感数据</div>
			<div>
			    <input type="checkbox" name="xz" value="AirTemperature"   />空气温度℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="AirHumidity"  />空气湿度%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="PhotosyntheticRadiation" />光合有效辐射（umol/m^2*s）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="SoilHumidity"  />土壤湿度%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="SoilEC"  />土壤EC值&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" name="xz" value="InfraredTemperature"  />叶片温度℃
                <input type="checkbox" name="xz" value="FruitSize"  />果实大小微变化
                <input type="checkbox" name="xz" value="DiameterWidth"  />茎秆直径微变化
             </div>
			<div id="container" style="width:1000px"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
function selectVideo() {
	if ($("#videoId").val() != "" && $("#videoChannelNumber").val() != "") {
		try {
			$("#video").attr("src", $("#videoChannelNumber").val());
			$("#video").attr("autoplay", "true");
		} catch (e) {
			finems.alert('警告', '视频处理异常，异常：' + e.message, 'warning');
		} 
	} else {
		finems.alert('警告', '请选择视频编号', 'warning');
	}
}


(function() {
	$("#videoIds").combobox({
		url: '../sysVideo/loadVideoList.do',
		valueField: 'id',
		textField: 'equipmentNumber',
		multiple: false,
		onSelect: function(record) {
			if (record.id == 0) {
				$("#videoId").val("");
				$("#videoChannelNumber").val("");
			} else {
				finems.progress();
				var data = {};
				data['id'] = (record.id);
				finems.getById('../sysVideo/getId.do', data, function(result) {
					$("#videoId").val(result.data.id);
					$("#videoChannelNumber").val(result.data.videoChannelNumber);
					$("#baseName").text(result.data.baseName);
					$("#greenhouseName").text(result.data.greenhouseName);
					var data_n = {};
					data_n['greenhouseid'] = (result.data.greenhouseid);
					finems.ajaxJson('queryPlant.do', data_n, function(result_n) {
						finems.closeProgress();
						$("#plantArea").text(result_n.data.plantArea);
						$("#variety").text(result_n.data.variety);
						$("#plantationMemberName").text(result_n.data.plantationMemberName);
						$("#technicianName").text(result_n.data.technicianName);
						$("#basePhone").text(result_n.data.basePhone);
						$("#greenhouseType").text(result_n.data.greenhouseType);
					});
				});
			}
		}
	});
})(jQuery);
</script>
<script type="text/javascript" src="<%=basePath%>/js/ux/iotapp/sysMonitor.js"></script>
</body>
</html>