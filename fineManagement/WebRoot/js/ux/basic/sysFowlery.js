$package('finems.sysFowlery');
finems.sysFowlery = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#baseIds").combobox('select', result.data.baseid);
							$("#ftypes").combobox('select', result.data.ftype);
						});
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
					           {field: 'remark', title: '备注', width: 120, sortable: true}
					           ]],
					toolbar: [
					          {id: 'btnadd', text: '添加', btnType: 'add'},
					          {id: 'btnedit', text: '修改', btnType: 'edit'},
					          {id: 'btndelete', text: '删除', btnType: 'remove'}
					          ]
				}
			},
			init: function () {
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
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysFowlery.init();
});