$package('finems.sysMaterialConsum');
finems.sysMaterialConsum = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#warehouseid").combobox('select', result.data.warehouseid);
							$("#baseid").combobox('select', result.data.baseid);
							$("#greehouseid").combobox('select', result.data.greehouseid);
						});
					}
				},
				dataGrid: {
					title: '物资目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 100, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 100, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位(元)', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 180, sortable: true},
					           {field: 'mfName', title: '厂家', width: 200, sortable: true},
					           ]],
					           toolbar: [
					                     	{id: 'btnadd', text: '领用', btnType: 'add',
					                     		handler:function(){
					                     			var arrs = _box.utils.getCheckedRows();
					                     			if(arrs.length == 0){
					                     				finems.alert('警告', '请选择要领用的数据!', 'warning');
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
													text: '领用详情',
													disabled: false,
													iconCls: 'icon-audit',
													handler: function() {
														window.location.href = '../sysMaterialConsumDetail/list.do';
													}
					                     		},
								          ]
					
				}
			},
			init: function () {
				$("#warehouseid").combobox({
					url: '../sysMaterialConsum/loadwarehouseidList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false
				});
				$("#baseid").combobox({
					url: '../sysMaterialConsum/loadbaseidList.do',
					valueField: 'id',
					textField: 'baseName',
					multiple: false
				});
				$("#fowleryid").combobox({
					url: '../sysFowlery/loadFowlerList.do',
					valueField: 'id',
					textField: 'name',
					multiple: false
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysMaterialConsum.init();
});