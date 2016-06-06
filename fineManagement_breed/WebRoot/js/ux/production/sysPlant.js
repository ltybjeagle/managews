$package('finems.sysPlant');
finems.sysPlant = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + urls['msUrl'] + '/sysPlant/greenhouseList.shtml';
			},
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
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
					title: '种植列表         (大棚信息:' + $("#greenhouseName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?greenhouseid='+$("#greenhouseid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'startTime', title: '种植时间', width: 150, sortable: true},
					           {field: 'endTime', title: '预计结束时间', width: 150, sortable: true},
					           {field: 'variety', title: '种植品种', width: 150, sortable: true},
					           {field: 'plantArea', title: '种植面积', width: 120, sortable: true},
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
	finems.sysPlant.init();
});