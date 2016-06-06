$package('finems.toEdit');
finems.toEdit = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '配送清单',
					url: 'getDistributionList.do',
					columns: [[
					           {field: 'nameOfDishes', title: '菜品名称', width: 180, sortable: true},
					           {field: 'typeOfDishes', title: '菜品类别', width: 180, sortable: true},
					           {field: 'number', title: '数量', width: 180, sortable: true},
					           {field: 'unit', title: '单位', width: 180, sortable: true}
					           ]]
				}
			},
			init: function () {
				_this.config.dataGrid.url = _this.config.dataGrid.url + '?distributionNo=' + $("#distributionNo").val();
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.toEdit.init();
});