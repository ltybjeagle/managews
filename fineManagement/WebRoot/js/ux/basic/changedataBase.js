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
			eval("var resObj = result.data." + spanVal);
			$("#" + spanVal).text(resObj);
		}
		$("#imgArea").attr("src", "http://api.map.baidu.com/staticimage/v2?ak=uta1DHlFNK5OVcdPphhzuoEkM79qqEcm&width=260&height=106&center=" 
				+ result.data.coordinate + "&zoom=15&markers=" + result.data.coordinate); 
		$("#query-win").dialog('open'); 
	});
}