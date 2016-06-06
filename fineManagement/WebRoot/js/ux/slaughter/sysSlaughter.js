$package('finems.sysSlaughter');
finems.sysSlaughter = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysSlaughter/getSerializId.do', data, function(result) {
								$("#slaughterBatch").val(result.data.slaughterBatch);
							});
						});
					},
					edit: function() {
						_box.handler.edit(function(result) {
							$("#quarantineBatchIds").combobox('select', result.data.quarantineBatchId);
						});
					}
				},
				dataGrid: {
					title: '屠宰列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'slaughterBatch', title: '屠宰批次', width: 180, sortable: true},
					           {field: 'quarantineBatch', title: '宰前检疫批次', width: 180, sortable: true},
					           {field: 'slaughterQuantity', title: '屠宰数量', width: 180, sortable: true},
					           {field: 'slaughterTime', title: '屠宰时间', width: 180, sortable: true}
					           ]]
				}
			},
			init: function () {
				$("#quarantineBatchIds").combobox({
					url: '../sysPreSlaughterQuarantine/loadPSQList.do',
					valueField: 'id',
					textField: 'quarantineBatch',
					multiple: false,
					onSelect: function(record) {
						if (record.id == 0) {
							$("#quarantineQuantity").val("");
						} else {
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
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysSlaughter.init();
});