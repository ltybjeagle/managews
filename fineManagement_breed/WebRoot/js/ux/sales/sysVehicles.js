$package('finems.sysVehicles');
finems.sysVehicles = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#selectTypes").combobox({
							onSelect: function(record) {
								$("#carType").attr('value', record.value);
							}
						});
						$("#selectBelongs").combobox({
							onSelect: function(record) {
								$("#belong").attr('value', record.value);
							}
						});
						_box.handler.add(function(result) {
						});
					},
					edit: function() {
						$("#selectTypes").combobox({
							onSelect: function(record) {
								$("#carType").attr('value', record.value);
							}
						});
						$("#selectBelongs").combobox({
							onSelect: function(record) {
								$("#belong").attr('value', record.value);
							}
						});
						_box.handler.edit(function(result) {
							$("#selectTypes").combobox('select', result.data.carType);
							$("#carType").attr('value', result.data.carType);
							$("#selectBelongs").combobox('select', result.data.belong);
							$("#belong").attr('value', result.data.belong);
						});
					}
				},
				dataGrid: {
					title: '车辆管理列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'vehiclesNo', title: '车辆编号', width: 100, sortable: true},
					           {field: 'plateNum', title: '车牌号', width: 100, sortable: true},
					           {field: 'brand', title: '品牌', width: 100, sortable: true},
					           {field: 'carType', title: '车辆类型', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "大型货车";
									}
									if (value == 2) {
										return "小型货车";
									}
									if (value == 3) {
										return "小型汽车";
									}
									if (value == 4) {
										return "其他";
									}
								}},
							   {field: 'saleDate', title: '购买日期', width: 150, sortable: true},
					           {field: 'saleSum', title: '购买金额', width: 120, sortable: true},
					           {field: 'belong', title: '所属类型', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "自有";
									}
									if (value == 2) {
										return "外有";
									}
								}},
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
	finems.sysVehicles.init();
});