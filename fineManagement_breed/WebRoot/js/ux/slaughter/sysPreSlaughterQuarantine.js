$package('finems.sysPreSlaughterQuarantine');
finems.sysPreSlaughterQuarantine = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysPreSlaughterQuarantine/getSerializId.do', data, function(result) {
								$("#quarantineBatch").val(result.data.quarantineBatch);
								$("#breedingBatch").val(result.data.breedingBatch);
							});
							$("#institution").hide();
							$("#filecontrol").show();
						});
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							finems.progress();
							_box.form.edit.attr('action', '../sysPreSlaughterQuarantine/save.do');
							_box.form.edit.submit();
						}
					}
				},
				dataGrid: {
					title: '宰前检疫列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'quarantineBatch', title: '检疫批次', width: 180, sortable: true},
					           {field: 'breedingBatch', title: '养殖批次', width: 180, sortable: true},
					           {field: 'quarantineItem', title: '检疫项目', width: 180, sortable: true},
					           {field: 'quarantineResults', title: '检疫结果', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "合格";
									}
									if (value == 2) {
										return "不合格";
									}
								}},
					           {field: 'quarantineTime', title: '检疫时间', width: 180, sortable: true},
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
				$("#selectResults").combobox({
					onSelect: function(record) {
						$("#quarantineResults").attr('value', record.value);
					}
				});
				 $("input[name=quarantineType]").click(function(){
					 showCont();
				 });
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

function showCont(){
	var item = $("input[name='quarantineType']:checked").val();
	if (item == 1) {
		$("#institution").hide();
	} else if (item == 2) {
		$("#institution").show();
	}
}

$(function(){
	finems.sysPreSlaughterQuarantine.init();
});