$package('finems.sysCattleSlaughter');
finems.sysCattleSlaughter = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + urls['msUrl'] + '/sysBreed/sysfowleryList.shtml';
			},
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#breedids").combobox({
							url: '../sysBreed/loadBreedList.do',
							valueField: 'id',
							textField: 'variety',
							multiple: false
						});
						_box.handler.add(function() {
							$("#filecontrol").show();
						});
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							finems.progress();
							_box.form.edit.attr('action', '../sysCattleSlaughter/save.do');
							_box.form.edit.submit();
						}
					}
				},
				dataGrid: {
					title: '出栏列表         (禽舍信息:' + $("#fowleryName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?fowleryid='+$("#fowleryid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'cattleTime', title: '出栏时间', width: 100, sortable: true},
					           {field: 'breedName', title: '产品名称', width: 100, sortable: true},
					           {field: 'cattleLevel', title: '等级', width: 120, sortable: true},
					           {field: 'unitPrice', title: '单价', width: 100, sortable: true},
					           {field: 'count', title: '数量', width: 100, sortable: true},
					           {field: 'charge', title: '负责人', width: 100, sortable: true},
					           {field: 'verification', title: '验证人', width: 100, sortable: true},
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
	finems.sysCattleSlaughter.init();
});