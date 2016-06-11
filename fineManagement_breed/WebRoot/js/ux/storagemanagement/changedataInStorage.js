function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#batchprocessing").combobox({
			url: '../segmentationprocess/loadProcessList.do',
			valueField: 'id',
			textField: 'batchprocessing',
			multiple: false,
			onSelect: function(record) {
				if (record.id == 0) {
					$("#productname").val("");
					$("#processingtime").val("");
					$("#processingstaff").val("");
				} else {
					finems.progress();
					var data = {};
					data['id'] = (record.id);
					finems.getById('../segmentationprocess/getId.do', data, function(result) {
						finems.closeProgress();
						$("#productname").val(result.data.processname);
						$("#processingtime").val(result.data.processtime);
						$("#processingstaff").val(result.data.processingstaff);
					});
				}
			}
		});
		$("#warehouseid").combobox({
			url: '../sysWarehouse/loadWarehouseList.do',
			valueField: 'id',
			textField: 'whName',
			multiple: false,
			onSelect: function(record) {
				if (record.id == 0) {
					$("#principal").val("");
				} else {
					finems.progress();
					var data = {};
					data['id'] = (record.id);
					finems.getById('../sysWarehouse/getId.do', data, function(result) {
						finems.closeProgress();
						$("#principal").val(result.data.responsible);
					});
				}
			}
		});
		$("#editForm").form('load', result.data);
		$("#batchprocessing").combobox('select', result.data.batchprocessing);
		$("#warehouseid").combobox('select', result.data.warehouseid);
		$("#instoretime").datebox("setValue", result.data.instoretime);
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
		$("#batchprocessing_q").text(result.data.batchprocessNo);
		$("#productname_q").text(result.data.productname);
		$("#processingtime_q").text(result.data.processingtime);
		$("#processingstaff_q").text(result.data.processingstaff);
		$("#warehouseid_q").text(result.data.whName);
		$("#principal_q").text(result.data.principal);
		$("#instoretime_q").text(result.data.instoretime);
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}