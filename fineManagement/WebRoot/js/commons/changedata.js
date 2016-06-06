//服务器当前日期
function ServerCurrentTime() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth();
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    var sec = now.getSeconds();
    var week;
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;
    var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    week = arr_week[day];
    var time = "";
    time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec;
    $("#CurrentTime").text(time);
    var timer = setTimeout("ServerCurrentTime()", 1000);
}

function removeOne(reaordId) {
	$.messager.confirm('确认', '确认删除记录?', function(r) {  
		if (r) {
			finems.progress();
			var arr = [];
			arr.push('id=' + reaordId);
	    	var data = arr.join("&");
	    	finems.deleteForm('delete.do', data, function(result) {
	    		finems.closeProgress();
	    		if (result.success) {
	    			var param = $("#searchForm").serializeObject();
		    		$('#data-list').datagrid('reload', param);
	    		} else {
	    			finems.alert('警告', result.msg, 'warning');
	    		}
			});
		}
	});
}

function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#editForm").form('load', result.data);
		$("#edit-win").dialog({title: "编辑"});
		$("#edit-win").dialog('open'); 
	});
}

function queryOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		var spanList = $("#query-win span");
		var spanListSize = spanList.length;
		for (var i = 0; i < spanListSize; i++) {
			var spanObj = spanList[i];
			var spanVal = spanObj["id"];
			eval("var resObj = result.data." + spanVal);
			$("#" + spanVal).text(resObj);
		}
		$("#query-win").dialog('open'); 
	});
}