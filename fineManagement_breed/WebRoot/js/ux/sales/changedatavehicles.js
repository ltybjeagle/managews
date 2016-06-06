function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#editForm").form('load', result.data);
		$("#selectTypes").combobox('select', result.data.carType);
		$("#selectBelongs").combobox('select', result.data.belong);
		$("#saleDate").datebox('setValue', result.data.saleDate);
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
		$("#vehiclesNo").text(result.data.vehiclesNo);
		if (result.data.carType == 1) {
			$("#carType_q").text("大型货车");
		} else if (result.data.carType == 2) {
			$("#carType_q").text("小型货车");
		} else if (result.data.carType == 3) {
			$("#carType_q").text("小型汽车");
		} else if (result.data.carType == 4) {
			$("#carType_q").text("其他");
		}
		if (result.data.belong == 1) {
			$("#belong_q").text("自有");
		} else if (result.data.belong == 2) {
			$("#belong_q").text("外有");
		}
		$("#plateNum").text(result.data.plateNum);
		$("#brand").text(result.data.brand);
		$("#carAge").text(result.data.carAge);
		$("#saleDate_q").text(result.data.saleDate);
		$("#saleSum").text(result.data.saleSum);
		$("#remark").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}