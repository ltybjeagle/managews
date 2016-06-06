$package('finems.sysSlaughter');
finems.sysSlaughter = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#quarantineBatchIds").combobox({
							url: '../sysPreSlaughterQuarantine/loadPSQList.do',
							valueField: 'id',
							textField: 'quarantineBatch',
							multiple: false,
							onSelect: function(record) {
								if (record.id == 0) {
									$("#quarantineQuantity").val("");
								} else {
									finems.progress();
									var data = {};
									data['id'] = (record.id);
									finems.getById('../sysPreSlaughterQuarantine/getId.do', data, function(result) {
										finems.closeProgress();
										$("#quarantineQuantity").val(result.data.quarantineQuantity);
									});
								}
							}
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysSlaughter/getSerializId.do', data, function(result) {
								$("#slaughterBatch").val(result.data.slaughterBatch);
							});
							$("#filecontrol").show();
						});
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							finems.progress();
							_box.form.edit.attr('action', '../sysSlaughter/save.do');
							_box.form.edit.submit();
						}
					}
				},
				dataGrid: {
					title: '屠宰列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'slaughterBatch', title: '屠宰批次', width: 180, sortable: true},
					           {field: 'quarantineBatch', title: '宰前检疫批次', width: 180, sortable: true},
					           {field: 'slaughterQuantity', title: '屠宰数量', width: 180, sortable: true},
					           {field: 'slaughterTime', title: '屠宰时间', width: 180, sortable: true},
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
	finems.sysSlaughter.init();
});