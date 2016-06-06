function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#slaughterbatch").combobox({
			url: '../sysSlaughter/loadSlaughterList.do',
			valueField: 'id',
			textField: 'slaughterBatch',
			multiple: false,
			disabled: true
		});
		$("#editForm").form('load', result.data);
		$("#slaughterbatch").combobox('select', result.data.slaughterbatch);
		$("#processtime").datebox("setValue", result.data.processtime);
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
		$("#sbatch").text(result.data.sbatch);
		$("#numberslaughter_q").text(result.data.numberslaughter);
		$("#batchprocessing_q").text(result.data.batchprocessing);
		$("#processname_q").text(result.data.processname);
		$("#processtime_q").text(result.data.processtime);
		$("#processingstaff_q").text(result.data.processingstaff);
		if (result.data.is_completed == 1) {
			$("#is_completed_q").text("完成");
		} else {
			$("#is_completed_q").text("未完成");
		}
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}