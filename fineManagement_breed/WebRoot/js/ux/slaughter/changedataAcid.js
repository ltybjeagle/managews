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
		$("#startTime").datebox("setValue", result.data.startTime);
		$("#endTime").datebox("setValue", result.data.endTime);
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
		$("#acidBatch_q").text(result.data.acidBatch);
		$("#slaughterBatch_q").text(result.data.slaughterBatch);
		$("#slaughterQuantity_q").text(result.data.slaughterQuantity);
		$("#acidNo_q").text(result.data.acidNo);
		$("#principal_q").text(result.data.principal);
		$("#startTime_q").text(result.data.startTime);
		$("#endTime_q").text(result.data.endTime);
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}