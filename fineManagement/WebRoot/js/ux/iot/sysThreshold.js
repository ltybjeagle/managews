$package('finems.sysVideo');
finems.sysVideo = function() {
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
						$("#greenhouseids").combobox({
							url: '../sysGreenhouse/loadGreenhouseList.do',
							valueField: 'id',
							textField: 'name',
							multiple: false
						});
						_box.handler.add(function(result) {
						});
					}
				},
				dataGrid: {
					title: '阀值设置列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'ruleName', title: '阀值规则名称', width: 180, sortable: true},
					           {field: 'openStatus', title: '状态', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "开启";
									}
									if (value == 2) {
										return "关闭";
									}
								}},
							   {field: 'baseName', title: '基地名称', width: 180, sortable: true},
					           {field: 'greenhouseName', title: '大棚名称', width: 180, sortable: true},
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
	finems.sysVideo.init();
});