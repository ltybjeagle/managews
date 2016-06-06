function removeOne(reaordId, taskkey) {
	if (taskkey != '00' && taskkey != '05') {
		finems.alert('警告', '只有【已录入】、【已退回】的数据才能删除.', 'warning'); 
		return;
	}
	$.messager.confirm('确认', '确认删除记录?', function(r) {  
		if (r) {
			finems.progress();
			var arr = [];
			arr.push('id=' + reaordId);
	    	var data = arr.join("&");
	    	finems.deleteForm('delete.do', data, function(result) {
	    		finems.closeProgress();
	    		if (result.success) {
	    			var param = $("#searchForm").serializeObject();
		    		$('#data-list').datagrid('reload', param);
	    		} else {
	    			finems.alert('警告', result.msg, 'warning');
	    		}
			});
		}
	});
}

function editOne(reaordId, taskkey) {
	if (taskkey != '00' && taskkey != '05') {
		finems.alert('警告', '只有【已录入】、【已退回】的数据才能删除.', 'warning'); 
		return;
	}
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#productNos").combobox({
			url: '../sysProduct/loadSysProductList.do',
			valueField: 'id',
			textField: 'productNo',
			multiple: false,
			onSelect: function(record) {
				if (record.id == 0) {
					$("#inputName").val("");
					$("#classname").val("");
					$("#unit").val("");
					$("#specifications").val("");
					$("#brandName").val("");
					$("#mfName").val("");
				} else {
					finems.progress();
					var data = {};
					data['id'] = (record.id);
					finems.getById('../sysProduct/getId.do', data, function(result) {
						finems.closeProgress();
						$("#inputName").val(result.data.inputName);
						$("#classname").val(result.data.classname);
						$("#unit").val(result.data.unit);
						$("#specifications").val(result.data.specifications);
						$("#brandName").val(result.data.brandName);
						$("#mfName").val(result.data.mfName);
					});
				}
			}
		});
		$("#editForm").form('load', result.data);
		$("#productNos").combobox('select', result.data.productid);
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
		$("#productNo").text(result.data.productNo);
		$("#inputName_q").text(result.data.inputName);
		$("#classname_q").text(result.data.classname);
		$("#unit_q").text(result.data.unit);
		$("#specifications_q").text(result.data.specifications);
		$("#brandName_q").text(result.data.brandName);
		$("#mfName_q").text(result.data.mfName);
		$("#purchaseCount").text(result.data.purchaseCount);
		$("#unitPrice").text(result.data.unitPrice);
		$("#remark").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}

function showMyWindow(processInstanceId) {
	window.showModalDialog("../sysActiviti/forWardImage.do?processInstanceId=" + processInstanceId, window,
    	"dialogHeight:450px; dialogWidth: 700px; resizable: No; status: No; help: no; close :no");
}