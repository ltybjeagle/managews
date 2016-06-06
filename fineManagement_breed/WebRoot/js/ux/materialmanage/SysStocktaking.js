$package('finems.SysStocktaking');

finems.SysStocktaking = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#warehouseid").combobox('select', result.data.warehouseid);
						});
					}
				},
				dataGrid: {
					title: '物资目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'stocktalingno', title: '盘库编号', width: 80, sortable: true},
					           {field: 'principal', title: '负责人', width: 80, sortable: true},
					           {field: 'stocktime', title: '盘库日期', width: 220, sortable: true},
					           {field: 'whName', title: '仓库', width: 220, sortable: true},
					           {field: 'remark', title: '备注', width: 220, sortable: true},
					           {field: 'xiangqing', title: '操作', width: 80, align: 'center', formatter: function(value, row, index) {
									var html = "<a href='#' onclick='showReturnDetail(" + row.id + ");'>[详情]</a>";
									return html;
								}}
					           ]],
					toolbar: [
					           {id: 'btndetails',
					        	text: '添加盘库',
					        	disabled: false,
					        	iconCls: 'icon-add',
					        	handler: function() {
					        		window.location.href = '../sysMaterialStocktaking/list.shtml';
					        	}
					           },
					          
							]
					
				}
			},
			init: function () {
				$("#warehouseid").combobox({
					url: '../SysStocktakingAction/loadwarehouseidList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();
function showReturnDetail(storeId) {
	var data = {};
	data['id'] = (storeId);
	finems.getById('../SysStocktakingAction/list.shtml', data, function(result) {
		$("#stocktalingno").text(result.data.stocktalingno);
		$("#whName").text(result.data.whName);
		$("#principal").text(result.data.principal);
		$("#remark").text(result.data.remark);
		
	});
}
$(function(){
	finems.SysStocktaking.init();
});