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
		$("#ftypes").combobox({
			url: '../sysFowleryType/loadSysFowleryTypeList.do',
			valueField: 'id',
			textField: 'fowleryName',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#baseIds").combobox('select', result.data.baseid);
		$("#ftypes").combobox('select', result.data.ftype);
		$("#createTime").datebox("setValue", result.data.createTime);
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
		$("#imgArea").attr("src", "http://api.map.baidu.com/staticimage/v2?ak=uta1DHlFNK5OVcdPphhzuoEkM79qqEcm&width=260&height=106&center=" 
				+ result.data.coordinate + "&zoom=15&markers=" + result.data.coordinate);
		$("#query-win").dialog('open'); 
	});
}