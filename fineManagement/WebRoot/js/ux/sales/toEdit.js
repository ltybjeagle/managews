$package('finems.toEdit');
finems.toEdit = function() {
	var _box = null;
	var _this = {
			config: {
				btnUrl: urls['msPath'] + '/sysSign/list.shtml',
				event: {
					add: function() {
						_box.handler.add(function() {
							$("#distributionNos").val($("#distributionNo").val());
						});
					}
				},
				dataGrid: {
					title: '配送清单',
					url: 'getDistributionList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'nameOfDishes', title: '菜品名称', width: 180, sortable: true},
					           {field: 'typeOfDishes', title: '菜品类别', width: 180, sortable: true},
					           {field: 'number', title: '数量', width: 180, sortable: true},
					           {field: 'unit', title: '单位', width: 180, sortable: true}
					           ]],
					toolbar:[
							   {id: 'btnadd', text: '添加', btnType: 'add'},
							   {id: 'btnedit', text: '修改', btnType: 'edit'},
							   {id: 'btndelete', text: '删除', btnType: 'remove'}
							]
				}
			},
			init: function () {
				$("#distributionPIds").combobox({
					url: '../sysDriver/loadDriverList.do',
					valueField: 'id',
					textField: 'name',
					multiple: false,
					onSelect: function(record) {
						if (record.id == 0) {
							$("#distributionPId").val("");
						} else {
							$("#distributionPId").val(record.id);
						}
					}
				});
				$("#vehiclesIds").combobox({
					url: '../sysVehicles/loadVehiclesList.do',
					valueField: 'id',
					textField: 'vehiclesNo',
					multiple: false,
					onSelect: function(record) {
						if (record.id == 0) {
							$("#brand").val("");
							$("#plateNum").val("");
							$("#vehiclesId").val("");
						} else {
							finems.progress();
							var data = {};
							data['id'] = (record.id);
							finems.getById('../sysVehicles/getId.do', data, function(result) {
								finems.closeProgress();
								$("#brand").val(result.data.brand);
								$("#plateNum").val(result.data.plateNum);
								$("#vehiclesId").val(result.data.id);
							});
						}
					}
				});
				$("#distributionPIds").combobox('select', $("#distributionPId").val());
				$("#vehiclesIds").combobox('select', $("#vehiclesId").val());
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