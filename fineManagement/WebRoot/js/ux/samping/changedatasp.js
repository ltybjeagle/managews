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
			multiple: false,
			onHidePanel: function(){
				$("#greenhouseid").combobox("setValue", '');
				var baseid = $('#baseid').combobox('getValue');		
				$.ajax({
					type: "POST",
					url: "../sysGreenhouse/loadGreenhouseList.do?baseid="+baseid,
					cache: false,
					dataType : "json",
					success: function(data) {
						$("#greenhouseid").combobox("loadData", data);
					}
				}); 	
			},
			onSelect: function(record) {
				$("#baseName").val(record.id);
			}
		});
		$("#greenhouseid").combobox({
			url: '../sysGreenhouse/loadGreenhouseList.do?baseid=' + result.data.baseid,
			valueField: 'id',
			textField: 'name',
			multiple: false,
			onHidePanel: function(){
				$("#sampname").combobox("setValue", '');
				var greenhouseid = $('#greenhouseid').combobox('getValue');		
				$.ajax({
					type: "POST",
					url: "../sysPlant/loadPlantList.do?greenhouseid="+greenhouseid,
					cache: false,
					dataType : "json",
					success: function(data) {
						$("#sampname").combobox("loadData", data);
					}
				}); 	
			},
			onSelect: function(record) {
				$("#greenhousename").val(record.id);
			}
		});
		$("#sampname").combobox({
			url: '../sysPlant/loadPlantList.do?greenhouseid=' + result.data.greenhouseid,
			valueField: 'id',
			textField: 'variety',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#sampname").combobox('select', result.data.sampname);
		$("#baseid").combobox('select', result.data.baseid);
		$("#greenhouseid").combobox('select', result.data.greenhouseid);
		$("#baseName").val(result.data.baseid);
		$("#greenhousename").val(result.data.greenhouseid);
		$("#samplingtime").datebox("setValue", result.data.samplingtime);
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
		$("#sampleno_q").text(result.data.sampleno);
		$("#baseName_q").text(result.data.baseName);
		$("#greenhouseName_q").text(result.data.greenhousename);
		$("#sampname_q").text(result.data.sampname);
		$("#samplingcount_q").text(result.data.samplingcount);
		$("#samplingtime_q").text(result.data.samplingtime);
		$("#samplingpeople_q").text(result.data.samplingpeople);
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