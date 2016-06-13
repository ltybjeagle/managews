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
				$("#fowleryid").combobox("setValue", '');
				var baseid = $('#baseid').combobox('getValue');		
				$.ajax({
					type: "POST",
					url: "../sysFowlery/loadFowlerList.do?baseid="+baseid,
					cache: false,
					dataType : "json",
					success: function(data) {
						$("#fowleryid").combobox("loadData", data);
					}
				}); 	
			},
			onSelect: function(record) {
				$("#baseName").val(record.id);
			}
		});
		$("#fowleryid").combobox({
			url: '../sysFowlery/loadFowlerList.do?baseid=' + result.data.baseid,
			valueField: 'id',
			textField: 'name',
			multiple: false,
			onHidePanel: function(){
				$("#sampname").combobox("setValue", '');
				var fowleryid = $('#fowleryid').combobox('getValue');		
				$.ajax({
					type: "POST",
					url: "../sysBreed/loadBreedList.do?fowleryid="+fowleryid,
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
			url: '../sysBreed/loadBreedList.do?fowleryid=' + result.data.fowleryid,
			valueField: 'id',
			textField: 'variety',
			multiple: false
		});
		$("#editForm").form('load', result.data);
		$("#sampname").combobox('select', result.data.sampname);
		$("#baseid").combobox('select', result.data.baseid);
		$("#fowleryid").combobox('select', result.data.fowleryid);
		$("#baseName").val(result.data.baseid);
		$("#greenhousename").val(result.data.fowleryid);
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