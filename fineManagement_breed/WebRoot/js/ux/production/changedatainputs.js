function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#productNos").combobox({
			url: '../sysProduct/loadSysProductList.do',
			valueField: 'id',
			textField: 'productNo',
			multiple: false,
			onSelect: function(record) {
				if (record != null && record != 'undefined') {
					finems.progress();
					var data = {};
					data['id'] = (record.id);
					finems.getById('../sysProduct/getId.do', data, function(result) {
						finems.closeProgress();
						$("#inputName").val(result.data.inputName);
						$("#classname").val(result.data.classname);
						$("#unit").val(result.data.unit);
						$("#specifications").val(result.data.specifications);
						$("#brandName").val(result.data.brandName);
						$("#mfName").val(result.data.mfName);
					});
				}
			}
		});
		$("#plantationMembers").combobox({
			url: '../sysEmployees/loadEmployeeList.do',
			valueField: 'id',
			textField: 'employeeName',
			multiple: false
		});
		$("#technicians").combobox({
			url: '../sysEmployees/loadEmployeeList.do',
			valueField: 'id',
			textField: 'employeeName',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#productNos").combobox('select', result.data.productid);
		$("#plantationMembers").combobox('select', result.data.plantationMember);
		$("#technicians").combobox('select', result.data.technician);
		$("#startTime").datebox("setValue", result.data.startTime);
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
			$("#productNo").text(result.data.productNo);
			$("#inputName_q").text(result.data.inputName);
			$("#classname_q").text(result.data.classname);
			$("#unit_q").text(result.data.unit);
			$("#specifications_q").text(result.data.specifications);
			$("#brandName_q").text(result.data.brandName);
			$("#mfName_q").text(result.data.mfName);
			$("#startTime_q").text(result.data.startTime);
			$("#purchaseCount").text(result.data.purchaseCount);
			$("#plantationMemberName").text(result.data.plantationMemberName);
			$("#technicianName").text(result.data.technicianName);
			$("#unitPrice").text(result.data.unitPrice);
			$("#remark").text(result.data.remark);
		}
		$("#query-win").dialog('open'); 
	});
}