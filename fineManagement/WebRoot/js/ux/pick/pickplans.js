$package('finems.pickplans');
finems.pickplans = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#plantid").combobox({
							url: '../sysPlant/loadPlantList.do',
							valueField: 'id',
							textField: 'variety',
							multiple: false
						});
						_box.handler.add(function(result) {});
					}
				},
				dataGrid: {
					title: '采收计划列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'variety', title: '菜品名称', width: 100, sortable: true},
					           {field: 'completetime', title: '完成时间', width: 180, sortable: true},
					           {field: 'releasetime', title: '发布时间', width: 120, sortable: true},
					           {field: 'grade', title: '等级', width: 80, sortable: true},
					           {field: 'requiredquantity', title: '需求量', width: 80, sortable: true},
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
				$("#plantids").combobox({
					url: '../sysPlant/loadPlantList.do',
					valueField: 'id',
					textField: 'variety',
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
	finems.pickplans.init();
});