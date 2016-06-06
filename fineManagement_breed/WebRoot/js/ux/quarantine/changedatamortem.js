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
			disabled: true
		});
		$("#editForm").form('load', result.data);
		$("#batchprocessing").combobox('select', result.data.batchprocessing);
		$("#selectResults").combobox('select', result.data.quarantineResults);
		$("#quarantineResults").attr('value', result.data.quarantineResults);
		$("#quarantinetime").datebox("setValue", result.data.quarantinetime);
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
		$("#batchprocessing_q").text(result.data.pbatch);
		$("#quarantineBatch_q").text(result.data.quarantineBatch);
		$("#quarantineitems_q").text(result.data.quarantineitems);
		$("#quarantineofficers_q").text(result.data.quarantineofficers);
		$("#quarantinetime_q").text(result.data.quarantinetime);
		if (result.data.quarantineResults == 1) {
			$("#quarantineResults_q").text("合格");
		} else {
			$("#quarantineResults_q").text("不合格");
		}
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