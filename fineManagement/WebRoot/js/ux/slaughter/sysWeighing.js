$package('finems.sysWeighing');
finems.sysWeighing = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#slaughterBatchIds").combobox({
							url: '../sysSlaughter/loadSlaughterListByProcess.do',
							valueField: 'id',
							textField: 'slaughterBatch',
							multiple: false,
							disabled: false
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysWeighing/getSerializId.do', data, function(result) {
								$("#weightNo").val(result.data.weightNo);
							});
						});
					},
					edit: function() {
						$("#slaughterBatchIds").combobox({
							url: '../sysSlaughter/loadSlaughterList.do',
							valueField: 'id',
							textField: 'slaughterBatch',
							multiple: false,
							disabled: true
						});
						_box.handler.edit(function(result) {
							$("#slaughterBatchIds").combobox('select', result.data.slaughterBatchId);
						});
					}
				},
				dataGrid: {
					title: '白条称重列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'weightNo', title: '白条编号', width: 180, sortable: true},
					           {field: 'slaughterBatch', title: '屠宰批次', width: 180, sortable: true},
					           {field: 'weight', title: '重量', width: 180, sortable: true},
					           {field: 'weighedTime', title: '称重时间', width: 180, sortable: true}
					           ]]
				}
			},
			init: function () {
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysWeighing.init();
});