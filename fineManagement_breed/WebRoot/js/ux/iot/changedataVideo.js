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