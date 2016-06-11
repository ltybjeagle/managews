$package('finems.sysStoremanage');
finems.sysStoremanage = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#principals").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						$("#warehouseids").combobox({
							url: '../sysWarehouse/loadWarehouseList.do',
							valueField: 'id',
							textField: 'whName',
							multiple: false
						});
						_box.handler.add(function(result) {});
					}
				},
				dataGrid: {
					title: '产品目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'registertime', title: '登记时间', width: 80, sortable: true},
					           {field: 'principalName', title: '负责人', width: 80, sortable: true},
					           {field: 'whName', title: '仓库', width: 220, sortable: true},
					           {field: 'operate', title: '操作', width: 180, align: 'center', formatter: function(value, row, index) {
									var html = "<a class='query_cls' href='javascript:queryOne(" + row.id + ");'>查看</a>" +
											"<a class='edit_cls' href='javascript:editOne(" + row.id + ");'>编辑</a>" +
											"<a class='del_cls' href='javascript:removeOne(" + row.id + ");'>删除</a>";
									return html;
								}}
					           ]],
					           onLoadSuccess: function(data) {  
									$('.query_cls').linkbutton({text:'查看', plain:true}); 
									$('.edit_cls').linkbutton({text:'编辑', plain:true}); 
									$('.del_cls').linkbutton({text:'删除', plain:true});
								},
					           toolbar: [
								           {id: 'btnadd', text: '添加', btnType: 'add'},
								           {id: 'btndelete', text: '删除', btnType: 'remove'}
								          ]
					
				}
			},
			init: function () {
				$("#warehouseid").combobox({
					url: '../sysWarehouse/loadWarehouseList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false
				});
				_box = new YDataGrid(_this.config);
				_box.init();
				$('#btn-query-close').click(function() {
					 $.messager.confirm('确认', '你确认关闭窗口?', function(r) {  
						 if (r) {  
							 $('#query-win').dialog('close');
						 }  
					 });
				 });
			}
	}
	return _this;
}();

$(function(){
	finems.sysStoremanage.init();
});