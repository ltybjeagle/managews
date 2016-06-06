function queryOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#name").text(result.data.name);
		if (result.data.sex == 1) {
			$("#sex_q").text("男");
		} else {
			$("#sex_q").text("女");
		}
		$("#age").text(result.data.age);
		$("#carAge").text(result.data.carAge);
		$("#phoneNo").text(result.data.phoneNo);
		$("#remark").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}