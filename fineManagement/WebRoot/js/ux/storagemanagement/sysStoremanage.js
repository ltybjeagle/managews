$package('finems.sysStoremanage');

finems.sysStoremanage = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#technicalstaff").combobox('select', result.data.classifyId);
							$("#principal").combobox('select', result.data.brandId);
						});
					}
				},
				dataGrid: {
					title: '产品目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'registertime', title: '登记时间', width: 80, sortable: true},
					           {field: 'principal', title: '负责人', width: 80, sortable: true},
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
				$("#principal").combobox({
					url: '../sysInstore/loadTechnicalstaffList.do',
					valueField: 'id',
					textField: 'classname',
					multiple: false
				});
				$("#warehouseid").combobox({
					url: '../sysWarehouse/loadWarehouseList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysStoremanage.init();
});