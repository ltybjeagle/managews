function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#quarantineBatchIds").combobox({
			url: '../sysPreSlaughterQuarantine/loadPSQList.do',
			valueField: 'id',
			textField: 'quarantineBatch',
			multiple: false,
			onSelect: function(record) {
				if (record != null) {
					finems.progress();
					var data = {};
					data['id'] = (record.id);
					finems.getById('../sysPreSlaughterQuarantine/getId.do', data, function(result) {
						finems.closeProgress();
						$("#quarantineQuantity").val(result.data.quarantineQuantity);
					});
				}
			}
		});
		$("#editForm").form('load', result.data);
		$("#quarantineBatchIds").combobox('select', result.data.quarantineBatchId);
		$("#slaughterTime").datebox("setValue", result.data.slaughterTime);
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
		$("#slaughterBatch_q").text(result.data.slaughterBatch);
		$("#quarantineBatch_q").text(result.data.quarantineBatch);
		$("#quarantineQuantity_q").text(result.data.quarantineQuantity);
		$("#slaughterPersonnel_q").text(result.data.slaughterPersonnel);
		$("#slaughterQuantity_q").text(result.data.slaughterQuantity);
		$("#slaughterTime_q").text(result.data.slaughterTime);
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