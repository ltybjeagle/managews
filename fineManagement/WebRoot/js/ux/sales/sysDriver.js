$package('finems.sysDriver');
finems.sysDriver = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#selectSexs").combobox({
							onSelect: function(record) {
								$("#sex").attr('value', record.value);
							}
						});
						_box.handler.add(function() {
						});
					},
					edit: function() {
						_box.handler.edit(function(result) {
							$("#selectSexs").combobox('select', result.data.sex);
							$("#sex").attr('value', result.data.sex);
						});
					}
				},
				dataGrid: {
					title: '驾驶员管理列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'name', title: '姓名', width: 180, sortable: true},
					           {field: 'phoneNo', title: '联系方式', width: 180, sortable: true},
					           {field: 'sex', title: '性别', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "男";
									}
									if (value == 2) {
										return "女";
									}
								}},
							   {field: 'age', title: '年龄', width: 180, sortable: true},
					           {field: 'carAge', title: '车龄', width: 180, sortable: true},
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
	finems.sysDriver.init();
});