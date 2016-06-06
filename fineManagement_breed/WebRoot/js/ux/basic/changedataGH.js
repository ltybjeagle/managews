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
		$("#typeIds").combobox({
			url: '../sysGreenhouseType/loadGreenhouseTypeList.do',
			valueField: 'id',
			textField: 'greenhouseName',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#baseIds").combobox('select', result.data.baseid);
		$("#typeIds").combobox('select', result.data.typeid);
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
			if (spanVal == "createDate") {
				eval("var resObj = result.data.createTime");
				$("#createDate").text(resObj);
			} else {
				eval("var resObj = result.data." + spanVal);
				$("#" + spanVal).text(resObj);
			}
		}
		$("#query-win").dialog('open'); 
	});
}