function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#plantid").combobox({
			url: '../sysPlant/loadPlantList.do',
			valueField: 'id',
			textField: 'variety',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#plantid").combobox('select', result.data.plantid);
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
		$("#plant_q").text(result.data.variety);
		$("#requiredquantity_q").text(result.data.requiredquantity);
		$("#grade_q").text(result.data.grade);
		$("#completetime_q").text(result.data.completetime);
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}