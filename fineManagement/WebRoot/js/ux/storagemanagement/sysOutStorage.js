$package('finems.sysOutstorage');

finems.sysOutstorage = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#batchprocessings").combobox('select', result.data.batchprocessing);
							$("#warehouseid").combobox('select', result.data.warehouseid);
						});
					}
				},
				dataGrid: {
					title: '成品出库列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'batchprocessNo', title: '加工批次', width: 180, sortable: true},
					           {field: 'productname', title: '加工产品名称', width: 180, sortable: true},
					           {field: 'outstoretime', title: '出库时间', width: 120, sortable: true},
					           {field: 'processingtime', title: '加工时间', width: 120, sortable: true},
					           {field: 'whName', title: '仓库', width: 180, sortable: true}
					           ]],
					           toolbar: [
								           {id: 'btnadd', text: '添加', btnType: 'add'},
								           {id: 'btnedit', text: '修改', btnType: 'edit'},
								           {id: 'btndelete', text: '删除', btnType: 'remove'}
								          ]
					
				}
			},
			init: function () {
				$("#warehouseid").combobox({
					url: '../sysWarehouse/loadWarehouseList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false,
					disabled: true
				});
				$("#batchprocessings").combobox({
					url: '../sysProductinstore/loadInStorageList.do?syssign=1',
					valueField: 'id',
					textField: 'batchprocessNo',
					multiple: false,
					onSelect: function(record) {
						finems.progress();
						var data = {};
						data['id'] = (record.id);
						finems.getById('../sysProductinstore/getId.do', data, function(result) {
							finems.closeProgress();
							$("#productname").val(result.data.productname);
							$("#processingtime").val(result.data.processingtime);
							$("#processingstaff").val(result.data.processingstaff);
							$("#instoretime").val(result.data.instoretime);
							$("#warehouseid").combobox('select', result.data.warehouseid);
							$("#batchprocessing").val(result.data.batchprocessing);
						});
					}
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysOutstorage.init();
});