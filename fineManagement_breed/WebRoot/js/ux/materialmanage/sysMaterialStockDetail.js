$package('finems.sysMaterialStockDetail');
finems.sysMaterialStockDetail = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '物资目录盘库详情列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 80, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 220, sortable: true},
					           {field: 'unit', title: '单位', width: 220, sortable: true},
					           {field: 'brandName', title: '品牌', width: 220, sortable: true},
					           {field: 'storecount', title: '帐目数', width: 220, sortable: true},
					           {field: 'firm', title: '实盘数', width: 220, sortable: true},
					           {field: 'differences', title: '差异数', width: 220, sortable: true},
					           {field: 'profitloss', title: '盈亏', width: 220, sortable: true},
					           {field: 'mfName', title: '厂家', width: 220, sortable: true},
					           ]],
					           toolbar: [       
								          {id: 'btnback',
								        	  text: '返回',
								        	  disabled: false,
								        	  iconCls: 'icon-back',
								        	  handler: function() {
								        		  window.location.href = '../SysStocktakingAction/list.shtml';
								        	  }
								          },
								          ]
				}
			},
			init: function () {
				_this.config.dataGrid.url = _this.config.dataGrid.url + '?stocktalingno=' + $("#stocktalingno").val();
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();
$(function(){
	finems.sysMaterialStockDetail.init();
});