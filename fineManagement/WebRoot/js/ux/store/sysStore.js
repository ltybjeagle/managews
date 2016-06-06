$package('finems.sysStore');
finems.sysStore = function() {
	debugger;
	var _box = null;
	var _this = {
			config:{
				dataGrid: {
					title: '产品目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'productNo', title: '商品编号', width: 100, sortable: true},
					           {field: 'inputName', title: '投入品名称', width: 120, sortable: true},
					           {field: 'classname', title: '分类', width: 120, sortable: true},
					           {field: 'specifications', title: '规格', width: 60, sortable: true},
					           {field: 'unit', title: '单位', width: 60, sortable: true},
					           {field: 'purchaseCount', title: '数量', width: 100, sortable: true},
					           {field: 'brandName', title: '品牌', width: 120, sortable: true},
					           {field: 'syssign', title: '状态', width: 80, sortable: true, 
					        	   formatter: function(value, row, index) {
										if (value == 1) {
											return "入库";
										}
										if (value == -1) {
											return "出库";
										}
									}},
					           {field: 'mfName', title: '生产厂家', width: 220, sortable: true},
					           {field: 'whName', title: '仓库', width: 220, sortable: true},
					           ]]
				}
			},
		init: function () {
			_box = new YDataGrid(_this.config);
			_box.init();
		}
	};		
	return _this;
}();
$(function(){
	finems.sysStore.init();
});
