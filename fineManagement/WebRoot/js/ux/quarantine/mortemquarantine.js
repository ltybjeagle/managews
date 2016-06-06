$package('finems.mortemquarantine');
finems.mortemquarantine = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#batchprocessing").combobox({
							url: '../segmentationprocess/loadProcessList.do',
							valueField: 'id',
							textField: 'batchprocessing',
							multiple: false,
							disabled: false
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../mortemquarantine/getSerializId.do', data, function(result) {
								$("#quarantineBatch").val(result.data.quarantineBatch);
							});
						});
					},
					edit: function() {
						$("#batchprocessing").combobox({
							url: '../segmentationprocess/loadProcessList.do',
							valueField: 'id',
							textField: 'batchprocessing',
							multiple: false,
							disabled: true
						});
						_box.handler.edit(function(result) {
							$("#batchprocessing").combobox('select', result.data.batchprocessing);
							$("#selectResults").combobox('select', result.data.quarantineResults);
							$("#quarantineResults").attr('value', result.data.quarantineResults);
						});
					}
				},
				dataGrid: {
					title: '宰后检疫列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'quarantineBatch', title: '检疫批次', width: 180, sortable: true},
					           {field: 'pbatch', title: '加工批次', width: 120, sortable: true},
					           {field: 'quarantineitems', title: '检疫项目', width: 100, sortable: true},
					           {field: 'quarantineofficers', title: '检疫人员', width: 100, sortable: true},
					           {field: 'quarantineResults', title: '检疫结果', width: 120, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "合格";
									}
									if (value == 2) {
										return "不合格";
									}
								}},
					           {field: 'quarantinetime', title: '检疫时间', width: 120, sortable: true},
					           {field: 'remark', title: '备注', width: 120, sortable: true}
					           ]],
					toolbar: [
					          {id: 'btnadd', text: '添加', btnType: 'add'},
					          {id: 'btnedit', text: '修改', btnType: 'edit'},
					          {id: 'btndelete', text: '删除', btnType: 'remove'}
					          ]
				}
			},
			init: function () {
				$("#selectResults").combobox({
					onSelect: function(record) {
						$("#quarantineResults").attr('value', record.value);
					}
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.mortemquarantine.init();
});