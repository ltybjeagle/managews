$package('finems.sysMaterialInstore');

finems.sysMaterialInstore = function() {
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
					title: '物资目录入库列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 80, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 220, sortable: true},
					           {field: 'unit', title: '单位', width: 220, sortable: true},
					           {field: 'brandName', title: '品牌', width: 220, sortable: true},
					           {field: 'mfName', title: '厂家', width: 220, sortable: true},
					           ]],
					           toolbar: [
					                     	{id: 'btnadd', text: '入库', btnType: 'add',
					                     		handler:function(){
					                     			debugger;
					                     			var arrs = _box.utils.getCheckedRows();
					                     			if(arrs.length == 0){
					                     				finems.alert('警告', '请选择要入库的数据!', 'warning');
					                     				return;
					                     			}
					                     			if(arrs.length >1){
					                     				finems.alert('警告', '请选中一笔是数据编辑!', 'warning');
					                     				return;
					                     			}
					                     			var Win = { edit: $("#edit-win")};
					                     			var Form = {
					                     					edit: $("#editForm")};
					                     			Win.edit.dialog('open');
					                     			Form.edit.resetForm();
					                     			$("#materialno")[0].value = arrs[0].materialno;
					                     			$("#materialname")[0].value = arrs[0].materialname;
					                     			$("#syssign")[0].value = arrs[0].id;
					                     		}	  },
					                     		{id: 'btndetails',
													text: '入库详情',
													disabled: false,
													iconCls: 'icon-audit',
													handler: function() {
														window.location.href = '../sysMaterialInstoreDetail/list.do?';
													}
					                     		},
								          ]
					
				}
			},
			init: function () {
				$("#warehouseid").combobox({
					url: '../sysMaterialInstore/loadwarehouseidList.do',
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

$(function(){
	finems.sysMaterialInstore.init();
});