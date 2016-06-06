$package('finems.segmentationprocessing');
finems.segmentationprocess = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
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
	finems.segmentationprocess.init();
});