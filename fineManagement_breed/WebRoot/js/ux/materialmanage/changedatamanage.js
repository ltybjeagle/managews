function queryOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#materialno_q").text(result.data.materialno);
		$("#materialname").text(result.data.materialname);
		$("#unit").text(result.data.unit);
		$("#specifications").text(result.data.specifications);
		$("#brandName").text(result.data.brandName);
		$("#mfName").text(result.data.mfName);
		$("#remark").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}