$package('finems.sysBreed');
finems.sysBreed = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + urls['msUrl'] + '/sysBreed/sysfowleryList.shtml';
			},
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#varietyids").combobox({
							url: '../sysVariety/loadVarietyList.do',
							valueField: 'id',
							textField: 'varietyName',
							multiple: false
						});
						$("#breeders").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						$("#breedTechnicians").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						_box.handler.add(function() {});
					}
				},
				dataGrid: {
					title: '养殖列表         (禽舍信息:' + $("#fowleryName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?fowleryid='+$("#fowleryid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'startTime', title: '饲养时间', width: 100, sortable: true},
					           {field: 'endTime', title: '预计结束时间', width: 100, sortable: true},
					           {field: 'variety', title: '养殖品种', width: 120, sortable: true},
					           {field: 'breedArea', title: '养殖面积', width: 100, sortable: true},
					           {field: 'breederName', title: '饲养员', width: 100, sortable: true},
					           {field: 'breedTechnicianName', title: '技术员', width: 100, sortable: true},
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
	finems.sysBreed.init();
});