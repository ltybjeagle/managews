function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#breedids").combobox({
			url: '../sysBreed/loadBreedList.do',
			valueField: 'id',
			textField: 'variety',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#breedids").combobox('select', result.data.breedid);
		$("#cattleTime").datebox("setValue", result.data.cattleTime);
		$("#filecontrol").hide();
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
		$("#breedName").text(result.data.breedName);
		$("#count").text(result.data.count);
		$("#cattleLevel").text(result.data.cattleLevel);
		$("#unitPrice").text(result.data.unitPrice);
		$("#charge").text(result.data.charge);
		$("#verification").text(result.data.verification);
		$("#cattleTime_q").text(result.data.cattleTime);
		$("#remark").text(result.data.remark);
		var list = result.data.list;
		var html = "<table>";
		for (var i = 0; i < list.length; i++) {
			html = html + "<tr><td><a href='" + urls['msPath'] + urls['msUrl'] + list[i].url + "' download>" + list[i].fileName + "</a></td></tr>"
		}
		html = html + "</table>";
		$("#fileMsg").html(html);
		$("#query-win").dialog('open'); 
	});
}