$package('finems.sysCattleSlaughter');
finems.sysCattleSlaughter = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + '/sysBreed/sysfowleryList.shtml';
			},
			config: {
				btnUrl: urls['msPath'] + '/sysBreed/sysfowleryList.shtml',
				dataGrid: {
					title: '出栏列表         (禽舍信息:' + $("#fowleryName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?fowleryid='+$("#fowleryid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'cattleTime', title: '出栏时间', width: 100, sortable: true},
					           {field: 'breedid', title: '产品名称', width: 100, sortable: true},
					           {field: 'cattleLevel', title: '等级', width: 120, sortable: true},
					           {field: 'unitPrice', title: '单价', width: 100, sortable: true},
					           {field: 'count', title: '数量', width: 100, sortable: true},
					           {field: 'charge', title: '负责人', width: 100, sortable: true},
					           {field: 'verification', title: '验证人', width: 100, sortable: true}
					           ]],
		             toolbar:[
							{id: 'btnadd', text: '添加', btnType: 'add'},
							{id: 'btnedit', text: '修改', btnType: 'edit'},
							{id: 'btndelete', text: '删除', btnType: 'remove'},
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
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysCattleSlaughter.init();
});