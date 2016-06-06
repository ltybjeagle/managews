$package('finems.sysTask');
finems.sysTask = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + urls['msUrl'] + '/sysPlant/greenhouseList.shtml';
			},
			config: {
				btnUrl: urls['msPath'] + '/sysPlant/greenhouseList.shtml',
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#taskids").combobox({
							url: '../sysTask/loadTaskTypeList.do',
							valueField: 'id',
							textField: 'taskName',
							multiple: false
						});
						$("#plantationMembers").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						$("#technicians").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						_box.handler.add(function() {});
					}
				},
				dataGrid: {
					title: '任务列表         (大棚信息:' + $("#greenhouseName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?greenhouseid='+$("#greenhouseid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'taskTime', title: '工作时间', width: 100, sortable: true},
					           {field: 'taskName', title: '任务类型', width: 100, sortable: true},
					           {field: 'taskContent', title: '工作内容', width: 120, sortable: true},
					           {field: 'plantationMemberName', title: '种植员', width: 100, sortable: true},
					           {field: 'technicianName', title: '技术员', width: 100, sortable: true},
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
		             toolbar:[
							{id: 'btnadd', text: '添加', btnType: 'add'},
							{id: 'btndelete', text: '删除', btnType: 'remove'},
							{
								id: 'btnback',
								text: 'back',
								disabled: false,
								iconCls: 'icon-back',
								handler: function() {
									_this.toBack();
								}
							}
						]
				}
			},
			init: function () {
				$("#taskid").combobox({
					url: '../sysTask/loadTaskTypeList.do',
					valueField: 'id',
					textField: 'taskName',
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
	finems.sysTask.init();
});