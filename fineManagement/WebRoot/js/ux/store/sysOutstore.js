$package('finems.sysOutstore');
finems.sysOutstore = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '投入品出库待确认列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'productNo', title: '商品编号', width: 100, sortable: true},
					           {field: 'inputName', title: '投入品名称', width: 180, sortable: true},
					           {field: 'classname', title: '分类', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位(元)', width: 80, sortable: true},
					           {field: 'purchaseCount', title: '数量', width: 80, sortable: true},
					           {field: 'unitPrice', title: '单价', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 120, sortable: true},
					           {field: 'mfName', title: '生产厂家', width: 220, sortable: true},
					           {field: 'operate', title: '操作', width: 150, align: 'center', formatter: function(value, row, index) {
									var html = '<a class="query_cls" href="javascript:queryOne(\'' + row.id + '\');">查看</a>';
									return html;
								}}
					           ]],
		            onLoadSuccess: function(data) {  
						$('.query_cls').linkbutton({text:'查看', plain:true}); 
					},
					toolbar: [
					           {
									id: 'btnout',
									text: '出库',
									disabled: false,
									iconCls: 'icon-add',
									handler: function() {
										var record = _box.utils.getCheckedRows();
										if (_box.utils.checkSelectOne(record)) {
											$("#inputid").val(record[0]['id']);
											$("#warehouseid").combobox({
												url: '../sysWarehouse/loadWarehouseList.do',
												valueField: 'id',
												textField: 'whName',
												multiple: false
											});
											$("#principals").combobox({
												url: '../sysEmployees/loadEmployeeList.do',
												valueField: 'id',
												textField: 'employeeName',
												multiple: false
											});
											$("#technicalstaffs").combobox({
												url: '../sysEmployees/loadEmployeeList.do',
												valueField: 'id',
												textField: 'employeeName',
												multiple: false
											});
											$("#outusers").combobox({
												url: '../sysEmployees/loadEmployeeList.do',
												valueField: 'id',
												textField: 'employeeName',
												multiple: false
											});
											_box.win.edit.dialog('open');
										}
									}
							   },
							   {
									id: 'btndetails',
									text: '出库清单',
									disabled: false,
									iconCls: 'icon-audit',
									handler: function() {
										window.location.href = urls['msPath'] + urls['msUrl'] + '/sysOutinventory/list.do?syssign=-1';
									}
							   }
						   ]
				}
			},
			init: function () {
				$("#classnames").combobox({
					url: '../sysClassify/loadClassifyList.do',
					valueField: 'classname',
					textField: 'classname',
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
	finems.sysOutstore.init();
});