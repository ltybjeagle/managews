function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#baseid").combobox({
			url: '../sysBase/loadbaseList.do',
			valueField: 'id',
			textField: 'baseName',
			multiple: false
		});
		$("#greehouseid").combobox({
			url: '../sysGreenhouse/loadGreenhouseList.do',
			valueField: 'id',
			textField: 'name',
			multiple: false,
			onHidePanel: function(){
				$("#plantid").combobox("setValue", '');
				var greehouseid = $('#greehouseid').combobox('getValue');		
				$.ajax({
					type: "POST",
					url: "../sysPlant/loadPlantList.do?greenhouseid="+greehouseid,
					cache: false,
					dataType : "json",
					success: function(data) {
						$("#plantid").combobox("loadData", data);
					}
				}); 	
			}
		});
		$("#plantid").combobox({
			url: '../sysPlant/loadPlantList.do?greenhouseid=' + result.data.greehouseid,
			valueField: 'id',
			textField: 'variety',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#baseid").combobox('select', result.data.baseid);
		$("#greehouseid").combobox('select', result.data.greehouseid);
		$("#plantid").combobox('select', result.data.plantid);
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
		$("#base_q").text(result.data.baseName);
		$("#greehouse_q").text(result.data.greenhousename);
		$("#plant_q").text(result.data.variety);
		$("#numberharvest_q").text(result.data.numberharvest);
		$("#grade_q").text(result.data.grade);
		$("#unitprice_q").text(result.data.unitprice);
		$("#inspectionstaff_q").text(result.data.inspectionstaff);
		$("#remark_q").text(result.data.remark);
		$("#query-win").dialog('open'); 
	});
}