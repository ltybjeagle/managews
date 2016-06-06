function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
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
		$("#plantationMembers").combobox('select', result.data.plantationMember);
		$("#technicians").combobox('select', result.data.technician);
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
		var spanList = $("#query-win span");
		var spanListSize = spanList.length;
		for (var i = 0; i < spanListSize; i++) {
			var spanObj = spanList[i];
			var spanVal = spanObj["id"];
			if (spanVal == "startTime_q") {
				eval("var resObj = result.data.startTime");
				$("#startTime_q").text(resObj);
			} else if (spanVal == "endTime_q") {
				eval("var resObj = result.data.endTime");
				$("#endTime_q").text(resObj);
			} else {
				eval("var resObj = result.data." + spanVal);
				$("#" + spanVal).text(resObj);
			}
		}
		$("#query-win").dialog('open'); 
	});
}