function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#principals").combobox({
			url: '../sysEmployees/loadEmployeeList.do',
			valueField: 'id',
			textField: 'employeeName',
			multiple: false
		});
		$("#warehouseids").combobox({
			url: '../sysWarehouse/loadWarehouseList.do',
			valueField: 'id',
			textField: 'whName',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#principals").combobox('select', result.data.principal);
		$("#warehouseids").combobox('select', result.data.warehouseid);
		$("#registertime").datebox("setValue", result.data.registertime);
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
		$("#whName").text(result.data.whName);
		$("#registertime_q").text(result.data.registertime);
		$("#principalName").text(result.data.principalName);
		$("#description").text(result.data.description);
		$("#remark").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}