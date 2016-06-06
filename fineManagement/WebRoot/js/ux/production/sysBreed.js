$package('finems.sysBreed');
finems.sysBreed = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + '/sysBreed/sysfowleryList.shtml';
			},
			config: {
				btnUrl: urls['msPath'] + '/sysBreed/sysfowleryList.shtml',
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							$("#breeders").combobox('select', result.data.breeder);
						});
						_box.handler.edit(function(result) {
							$("#breedTechnicians").combobox('select', result.data.breedTechnician);
						});
					}
				},
				dataGrid: {
					title: '养殖列表         (禽舍信息:' + $("#fowleryName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?fowleryid='+$("#fowleryid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'startTime', title: '饲养时间', width: 100, sortable: true},
					           {field: 'endTime', title: '预计结束时间', width: 100, sortable: true},
					           {field: 'variety', title: '养殖品种', width: 120, sortable: true},
					           {field: 'breedArea', title: '养殖面积', width: 100, sortable: true},
					           {field: 'breederName', title: '饲养员', width: 100, sortable: true},
					           {field: 'breedTechnicianName', title: '技术员', width: 100, sortable: true}
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
				$("#breeders").combobox({
					url: '../sysUser/queryBreederList.do',
					valueField: 'id',
					textField: 'nickName',
					multiple: false
				});
				$("#breedTechnicians").combobox({
					url: '../sysUser/queryBreedTechnicianList.do',
					valueField: 'id',
					textField: 'nickName',
					multiple: false
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.sysBreed.init();
});