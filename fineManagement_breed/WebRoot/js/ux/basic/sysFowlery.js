$package('finems.sysFowlery');
finems.sysFowlery = function() {
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
						$("#ftypes").combobox({
							url: '../sysFowleryType/loadSysFowleryTypeList.do',
							valueField: 'id',
							textField: 'fowleryName',
							multiple: false
						});
						_box.handler.add(function() {});
					}
				},
				dataGrid: {
					title: '禽舍列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'name', title: '禽舍名称', width: 180, sortable: true},
					           {field: 'breedArea', title: '禽舍面积', width: 100, sortable: true},
					           {field: 'baseName', title: '所属基地', width: 100, sortable: true},
					           {field: 'fowleryName', title: '禽舍类型', width: 100, sortable: true},
					           {field: 'breeder', title: '饲养员', width: 100, sortable: true},
					           {field: 'technician', title: '技术员', width: 100, sortable: true},
					           {field: 'createTime', title: '建设时间', width: 100, sortable: true},
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
				$("#baseId").combobox({
					url: '../sysBase/loadbaseList.do',
					valueField: 'id',
					textField: 'baseName',
					multiple: false
				});
				$("#ftypeid").combobox({
					url: '../sysFowleryType/loadSysFowleryTypeList.do',
					valueField: 'id',
					textField: 'fowleryName',
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
	finems.sysFowlery.init();
});