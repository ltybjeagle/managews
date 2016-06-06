$package('finems.sysGreenhouse');
finems.sysGreenhouse = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#baseIds").combobox({
							url: '../sysBase/loadbaseList.do',
							valueField: 'id',
							textField: 'baseName',
							multiple: false
						});
						$("#typeIds").combobox({
							url: '../sysGreenhouseType/loadGreenhouseTypeList.do',
							valueField: 'id',
							textField: 'greenhouseName',
							multiple: false
						});
						_box.handler.add(function() {});
					}
				},
				dataGrid: {
					title: '大棚列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'name', title: '大棚名称', width: 180, sortable: true},
					           {field: 'ghArea', title: '大棚面积', width: 80, sortable: true},
					           {field: 'baseName', title: '所属基地', width: 180, sortable: true},
					           {field: 'greenhouseName', title: '大棚类型', width: 120, sortable: true},
					           {field: 'createTime', title: '建设时间', width: 150, sortable: true},
					           {field: 'remark', title: '备注', width: 200, sortable: true},
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
				$("#baseId").combobox({
					url: '../sysBase/loadbaseList.do',
					valueField: 'id',
					textField: 'baseName',
					multiple: false
				});
				$("#typeId").combobox({
					url: '../sysGreenhouseType/loadGreenhouseTypeList.do',
					valueField: 'id',
					textField: 'greenhouseName',
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
	finems.sysGreenhouse.init();
});