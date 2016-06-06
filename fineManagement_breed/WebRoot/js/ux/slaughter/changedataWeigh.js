function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#slaughterBatchIds").combobox({
			url: '../sysSlaughter/loadSlaughterList.do',
			valueField: 'id',
			textField: 'slaughterBatch',
			multiple: false,
			disabled: true
		});
		$("#editForm").form('load', result.data);
		$("#slaughterBatchIds").combobox('select', result.data.slaughterBatchId);
		$("#weighedTime").datebox("setValue", result.data.weighedTime);
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
		$("#slaughterBatch_q").text(result.data.slaughterBatch);
		$("#slaughterType_q").text(result.data.slaughterType);
		$("#weightNo_q").text(result.data.weightNo);
		$("#weight_q").text(result.data.weight);
		$("#weighedTime_q").text(result.data.weighedTime);
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}