$package('finems.sysInstorage');

finems.sysInstorage = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
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
						_box.handler.add(function(result) {});
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
	finems.sysInstorage.init();
});