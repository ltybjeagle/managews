function showIninventory(storeId) {
	var data = {};
	data['id'] = (storeId);
	finems.getById('../sysIninventory/getId.do', data, function(result) {
		$("#productNo").text(result.data.productNo);
		$("#inputName").text(result.data.inputName);
		$("#classname").text(result.data.classname);
		$("#specifications").text(result.data.specifications);
		$("#unit").text(result.data.unit);
		$("#brandName").text(result.data.brandName);
		$("#mfName").text(result.data.mfName);
		$("#purchaseCount").text(result.data.purchaseCount);
		$("#instoretime").text(result.data.instoretime);
		$("#unitPrice").text(result.data.unitPrice);
		$("#whName").text(result.data.whName);
		$("#principal").text(result.data.principal);
		$("#remark").text(result.data.remark);
		$("#edit-pwd-win").dialog('open');
	});
}

function showOutinventory(storeId) {
	var data = {};
	data['id'] = (storeId);
	finems.getById('../sysOutinventory/getId.do', data, function(result) {
		$("#productNo").text(result.data.productNo);
		$("#inputName").text(result.data.inputName);
		$("#classname").text(result.data.classname);
		$("#specifications").text(result.data.specifications);
		$("#unit").text(result.data.unit);
		$("#brandName").text(result.data.brandName);
		$("#mfName").text(result.data.mfName);
		$("#purchaseCount").text(result.data.purchaseCount);
		$("#outstoretime").text(result.data.outstoretime);
		$("#unitPrice").text(result.data.unitPrice);
		$("#whName").text(result.data.whName);
		$("#baseName").text(result.data.baseName);
		$("#greenhouseName").text(result.data.greenhouseName);
		$("#technicalstaff").text(result.data.technicalstaff);
		$("#outuser").text(result.data.outuser);
		$("#principal").text(result.data.principal);
		$("#remark").text(result.data.remark);
		$("#edit-pwd-win").dialog('open');
	});
}