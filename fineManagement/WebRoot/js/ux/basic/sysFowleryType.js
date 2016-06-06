$package('finems.sysFowleryType');
finems.sysFowleryType = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '禽舍类型列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'fowleryName', title: '禽舍类型名称', width: 180, sortable: true},
					           {field: 'fowleryCount', title: '禽舍数量', width: 100, sortable: true},
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
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysFowleryType.init();
});