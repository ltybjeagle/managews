$package('finems.sysMaterialQuery');
finems.sysMaterialQuery = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '物资查询',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 100, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 100, sortable: true},
					           {field: 'type', title: '类型列', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 100, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 200, sortable: true},
					           {field: 'storecount', title: '库存', width: 120, sortable: true},
					           {field: 'mfName', title: '厂家', width: 200, sortable: true},
					           ]]
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
	finems.sysMaterialQuery.init();
});