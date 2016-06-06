$package('finems.mortemquarantine');
finems.mortemquarantine = function() {
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
							disabled: false
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../mortemquarantine/getSerializId.do', data, function(result) {
								$("#quarantineBatch").val(result.data.quarantineBatch);
							});
							$("#filecontrol").show();
						});
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							finems.progress();
							_box.form.edit.attr('action', '../mortemquarantine/save.do');
							_box.form.edit.submit();
						}
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
				$("#selectResults").combobox({
					onSelect: function(record) {
						$("#quarantineResults").attr('value', record.value);
					}
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
	finems.mortemquarantine.init();
});