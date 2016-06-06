$package('finems.segmentationprocessing');
finems.segmentationprocess = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						_box.handler.add(function() {
							$("#slaughterbatch").combobox({
								url: '../sysSlaughter/loadSlaughterListByProcess.do',
								valueField: 'id',
								textField: 'slaughterBatch',
								multiple: false,
								disabled: false,
								onSelect: function(record) {
									if (record.id == 0) {
										$("#numberslaughter").val("");
									} else {
										finems.progress();
										var data = {};
										data['id'] = (record.id);
										finems.getById('../sysSlaughter/getId.do', data, function(result) {
											finems.closeProgress();
											$("#numberslaughter").val(result.data.slaughterQuantity);
										});
									}
								}
							});
							var data = {};
							finems.ajaxJson('../segmentationprocess/getSerializId.do', data, function(result) {
								$("#batchprocessing").val(result.data.batchprocessing);
							});
						});
					},
					edit: function() {
						$("#slaughterbatch").combobox({
							url: '../sysSlaughter/loadSlaughterList.do',
							valueField: 'id',
							textField: 'slaughterBatch',
							multiple: false,
							disabled: true
						});
						_box.handler.edit(function(result) {
							$("#slaughterbatch").combobox('select', result.data.slaughterbatch);
						});
					}
				},
				dataGrid: {
					title: '加工分割列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'batchprocessing', title: '加工批次', width: 180, sortable: true},
					           {field: 'processname', title: '产品名称', width: 100, sortable: true},
					           {field: 'processtime', title: '加工时间', width: 180, sortable: true},
					           {field: 'is_completed', title: '是否分割', width: 120, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "完成";
									}
									if (value == 2) {
										return "未完成";
									}
								}},
					           {field: 'processingstaff', title: '加工人员', width: 180, sortable: true},
					           {field: 'remark', title: '备注', width: 120, sortable: true},
					           ]],
					toolbar: [
					          {id: 'btnadd', text: '添加', btnType: 'add'},
					          {id: 'btnedit', text: '修改', btnType: 'edit'},
					          {id: 'btndelete', text: '删除', btnType: 'remove'}
					          ]
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
	finems.segmentationprocess.init();
});