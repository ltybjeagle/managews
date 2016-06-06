$package('finems.sysAcid');
finems.sysAcid = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#slaughterBatchIds").combobox({
							url: '../sysSlaughter/loadSlaughterList.do',
							valueField: 'id',
							textField: 'slaughterBatch',
							multiple: false,
							disabled: false,
							onSelect: function(record) {
								if (record.id == 0) {
									$("#slaughterQuantity").val("");
								} else {
									finems.progress();
									var data = {};
									data['id'] = (record.id);
									finems.getById('../sysSlaughter/getId.do', data, function(result) {
										finems.closeProgress();
										$("#slaughterQuantity").val(result.data.slaughterQuantity);
									});
								}
							}
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysAcid/getSerializId.do', data, function(result) {
								$("#acidBatch").val(result.data.acidBatch);
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
					title: '排酸管理列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'slaughterBatch', title: '屠宰批次', width: 180, sortable: true},
					           {field: 'acidBatch', title: '排酸批次', width: 180, sortable: true},
					           {field: 'startTime', title: '排酸开始时间', width: 180, sortable: true},
					           {field: 'endTime', title: '排酸结束时间', width: 180, sortable: true}
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
	finems.sysAcid.init();
});