function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#warehouseid").combobox({
			url: '../sysWarehouse/loadWarehouseList.do',
			valueField: 'id',
			textField: 'whName',
			multiple: false
		});
		$("#batchprocessings").combobox({
			url: '../sysProductinstore/loadInStorageList.do?syssign=1',
			valueField: 'id',
			textField: 'batchprocessNo',
			multiple: false,
			onSelect: function(record) {
				if (record != null) {
					finems.progress();
					var data = {};
					data['id'] = (record.id);
					finems.getById('../sysProductinstore/getId.do', data, function(result) {
						finems.closeProgress();
						$("#productname").val(result.data.productname);
						$("#processingtime").val(result.data.processingtime);
						$("#processingstaff").val(result.data.processingstaff);
						$("#instoretime").val(result.data.instoretime);
						$("#batchprocessing").val(result.data.batchprocessing);
					});
				}
			}
		});
		$("#editForm").form('load', result.data);
		$("#batchprocessings").combobox('select', result.data.batchprocessing);
		$("#warehouseid").combobox('select', result.data.warehouseid);
		$("#outstoretime").datebox("setValue", result.data.outstoretime);
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
		$("#instoretime_q").text(result.data.instoretime);
		$("#principal_q").text(result.data.principal);
		$("#outstoretime_q").text(result.data.outstoretime);
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}