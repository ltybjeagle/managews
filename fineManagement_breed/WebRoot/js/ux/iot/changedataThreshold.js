function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#baseIds").combobox({
			url: '../sysBase/loadbaseList.do',
			valueField: 'id',
			textField: 'baseName',
			multiple: false
		});
		$("#greenhouseids").combobox({
			url: '../sysGreenhouse/loadGreenhouseList.do',
			valueField: 'id',
			textField: 'name',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#baseIds").combobox('select', result.data.baseid);
		$("#greenhouseids").combobox('select', result.data.greenhouseid);
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
			if (spanVal == "openStatus") {
				eval("var resObj = result.data.openStatus");
				if (resObj == 1) {
					$("#openStatus").text("开启");
				} else {
					$("#openStatus").text("关闭");
				}
			} else {
				eval("var resObj = result.data." + spanVal);
				$("#" + spanVal).text(resObj);
			}
		}
		$("#query-win").dialog('open'); 
	});
}