function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#editForm").form('load', result.data);
		if (result.data.quarantineType == 1) {
			$("#institution").hide();
		} 
		$("#selectResults").combobox('select', result.data.quarantineResults);
		$("#quarantineResults").attr('value', result.data.quarantineResults);
		$("#quarantineTime").datebox("setValue", result.data.quarantineTime);
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
		$("#quarantineBatch_q").text(result.data.quarantineBatch);
		$("#breedingBatch_q").text(result.data.breedingBatch);
		$("#quarantineItem_q").text(result.data.quarantineItem);
		if (result.data.quarantineType == 1) {
			$("#quarantineType_q").text("企业自检");
			$("#ins").hide();
		} else {
			$("#quarantineType_q").text("检疫机构");
			$("#quarantineInstitution_q").text(result.data.quarantineInstitution);
		}
		$("#quarantineOfficer_q").text(result.data.quarantineOfficer);
		if (result.data.quarantineResults == 1) {
			$("#quarantineResults_q").text("合格");
		} else {
			$("#quarantineResults_q").text("不合格");
		}
		$("#quarantineTime_q").text(result.data.quarantineTime);
		$("#remark_q").text(result.data.remark);
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