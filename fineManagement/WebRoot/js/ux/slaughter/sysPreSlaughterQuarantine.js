$package('finems.sysPreSlaughterQuarantine');
finems.sysPreSlaughterQuarantine = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysPreSlaughterQuarantine/getSerializId.do', data, function(result) {
								$("#quarantineBatch").val(result.data.quarantineBatch);
								$("#breedingBatch").val(result.data.breedingBatch);
							});
						});
					},
					edit: function() {
						_box.handler.edit(function(result) {
							$("#selectResults").combobox('select', result.data.quarantineResults);
							$("#quarantineResults").attr('value', result.data.quarantineResults);
						});
					}
				},
				dataGrid: {
					title: '宰前检疫列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'quarantineBatch', title: '检疫批次', width: 180, sortable: true},
					           {field: 'breedingBatch', title: '养殖批次', width: 180, sortable: true},
					           {field: 'quarantineItem', title: '检疫项目', width: 180, sortable: true},
					           {field: 'quarantineResults', title: '检疫结果', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "合格";
									}
									if (value == 2) {
										return "不合格";
									}
								}},
					           {field: 'quarantineTime', title: '检疫时间', width: 180, sortable: true}
					           ]]
				}
			},
			init: function () {
				_box = new YDataGrid(_this.config);
				_box.init();
				$("#selectResults").combobox({
					onSelect: function(record) {
						$("#quarantineResults").attr('value', record.value);
					}
				});

				 var item = $('input[name=items][checked]').val(); 
				 $("input[name=quarantineType]").click(function(){
					 showCont();
					 
				 });
			}
	}
	return _this;
}();
function showCont(){
 switch($("input[name=quarantineType]:checked").attr("value")){
  case "1":
	  $("#quarantineInstitution").attr("readonly", true);
	  $("#quarantineInstitution").validatebox({required:false});
	  $("#quarantineInstitution").css("backgroundColor", "#d0d0d0");
   break;
  case "2":
	  $("#quarantineInstitution").attr("readonly", false); 
	  $("#quarantineInstitution").css("backgroundColor", "#FFFFFF");
	  $("#quarantineInstitution").validatebox({required:true});
   break;
  default:
   break;
 }
}
$(function(){
	finems.sysPreSlaughterQuarantine.init();
});