$package('finems.sysInstorage');

finems.sysInstorage = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#batchprocessing").combobox('select', result.data.batchprocessing);
							$("#warehouseid").combobox('select', result.data.warehouseid);
						});
					}
				},
				dataGrid: {
					title: '成品入库列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'batchprocessNo', title: '加工批次', width: 180, sortable: true},
					           {field: 'productname', title: '加工产品名称', width: 180, sortable: true},
					           {field: 'instoretime', title: '入库时间', width: 120, sortable: true},
					           {field: 'processingtime', title: '加工时间', width: 100, sortable: true},
					           {field: 'whName', title: '仓库', width: 220, sortable: true}
					           ]],
					           toolbar: [
								           {id: 'btnadd', text: '添加', btnType: 'add'},
								           {id: 'btnedit', text: '修改', btnType: 'edit'},
								           {id: 'btndelete', text: '删除', btnType: 'remove'}
								          
								          ]
					
				}
			},
			init: function () {
				$("#batchprocessing").combobox({
					url: '../segmentationprocess/loadProcessList.do',
					valueField: 'id',
					textField: 'batchprocessing',
					multiple: false,
					onSelect: function(record) {
						if (record.id == 0) {
							$("#productname").val("");
							$("#processingtime").val("");
							$("#processingstaff").val("");
						} else {
							finems.progress();
							var data = {};
							data['id'] = (record.id);
							finems.getById('../segmentationprocess/getId.do', data, function(result) {
								finems.closeProgress();
								$("#productname").val(result.data.processname);
								$("#processingtime").val(result.data.processtime);
								$("#processingstaff").val(result.data.processingstaff);
							});
						}
					}
				});
				$("#warehouseid").combobox({
					url: '../sysWarehouse/loadWarehouseList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false,
					onSelect: function(record) {
						if (record.id == 0) {
							$("#principal").val("");
						} else {
							finems.progress();
							var data = {};
							data['id'] = (record.id);
							finems.getById('../sysWarehouse/getId.do', data, function(result) {
								finems.closeProgress();
								$("#principal").val(result.data.responsible);
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
	finems.sysInstorage.init();
});