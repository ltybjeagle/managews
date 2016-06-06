$package('finems.sysTaskBreed');
finems.sysTaskBreed = function() {
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
						_box.handler.edit(function(result) {
							$("#taskids").combobox('select', result.data.taskid);
						});
					}
				},
				dataGrid: {
					title: '任务列表         (禽舍信息:' + $("#fowleryName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?fowleryid='+$("#fowleryid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'taskTime', title: '工作时间', width: 100, sortable: true},
					           {field: 'taskName', title: '任务类型', width: 100, sortable: true},
					           {field: 'taskContent', title: '工作内容', width: 120, sortable: true},
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
				$("#taskids").combobox({
					url: '../sysTask/loadTaskTypeList.do',
					valueField: 'id',
					textField: 'taskName',
					multiple: false
				});
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
	finems.sysTaskBreed.init();
});