$package('finems.sysOutinventory');
finems.sysOutinventory = function() {
	debugger;
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + urls['msUrl'] + '/sysOutputs/list.shtml';
			},
			config:{
				dataGrid: {
					title: '出库清单列表',
					url: 'dataList.do?syssign=-1',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'productNo', title: '商品编号', width: 100, sortable: true},
					           {field: 'inputName', title: '投入品名称', width: 180, sortable: true},
					           {field: 'classname', title: '分类', width: 120, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'unitPrice', title: '单价(元)', width: 80, sortable: true},
					           {field: 'totalprice', title: '总价(元)', width: 80, sortable: true},
					           {field: 'purchaseCount', title: '出库数量', width: 80, sortable: true},
					           {field: 'outuserName', title: '使用人', width: 80, sortable: true},
					           {field: 'outstoretime', title: '出库时间', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 100, sortable: true},
					           {field: 'mfName', title: '生产厂家', width: 220, sortable: true},
					           {field: 'whName', title: '仓库', width: 100, sortable: true},
					           {field: 'operate', title: '操作', width: 150, align: 'center', formatter: function(value, row, index) {
									var html = '<a class="query_cls" href="javascript:showOutinventory(' + row.id + ');">详情</a>';
									return html;
								}}
					           ]],
			           onLoadSuccess: function(data) {  
							$('.query_cls').linkbutton({text:'详情', plain:true}); 
						},
			           toolbar:[
								{
									id: 'btnback',
									text: 'back',
									disabled: false,
									iconCls: 'icon-back',
									handler: function() {
										_this.toBack();
									}
								}
							]
				}
			},
		init: function () {
			$("#classnames").combobox({
				url: '../sysClassify/loadClassifyList.do',
				valueField: 'classname',
				textField: 'classname',
				multiple: false
			});
			_box = new YDataGrid(_this.config);
			_box.init();
		}
	};		
	return _this;
}();
$(function(){
	finems.sysOutinventory.init();
});
