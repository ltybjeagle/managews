function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#taskids").combobox({
			url: '../sysTask/loadTaskTypeList.do',
			valueField: 'id',
			textField: 'taskName',
			multiple: false
		});
		$("#breeders").combobox({
			url: '../sysEmployees/loadEmployeeList.do',
			valueField: 'id',
			textField: 'employeeName',
			multiple: false
		});
		$("#breedTechnicians").combobox({
			url: '../sysEmployees/loadEmployeeList.do',
			valueField: 'id',
			textField: 'employeeName',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#breeders").combobox('select', result.data.breeder);
		$("#breedTechnicians").combobox('select', result.data.breedTechnician);
		$("#taskids").combobox('select', result.data.taskid);
		$("#taskTime").datebox("setValue", result.data.taskTime);
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
			if (spanVal == "taskTime_q") {
				eval("var resObj = result.data.taskTime");
				$("#taskTime_q").text(resObj);
			} else {
				eval("var resObj = result.data." + spanVal);
				$("#" + spanVal).text(resObj);
			}
		}
		$("#query-win").dialog('open'); 
	});
}