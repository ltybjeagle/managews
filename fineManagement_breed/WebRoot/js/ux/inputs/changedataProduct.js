function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#classifyIds").combobox({
			url: '../sysClassify/loadClassifyList.do',
			valueField: 'id',
			textField: 'classname',
			multiple: false
		});
		$("#brandIds").combobox({
			url: '../sysBrand/loadBrandList.do',
			valueField: 'id',
			textField: 'brandName',
			multiple: false
		});
		$("#mfids").combobox({
			url: '../sysManufacturer/loadManufacturerList.do',
			valueField: 'id',
			textField: 'mfName',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#classifyIds").combobox('select', result.data.classifyId);
		$("#brandIds").combobox('select', result.data.brandId);
		$("#mfids").combobox('select', result.data.mfid);
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
			if (spanVal == "productNoVal") {
				eval("var resObj = result.data.productNo");
				$("#productNoVal").text(resObj);
			} else {
				eval("var resObj = result.data." + spanVal);
				$("#" + spanVal).text(resObj);
			}
		}
		$("#query-win").dialog('open'); 
	});
}