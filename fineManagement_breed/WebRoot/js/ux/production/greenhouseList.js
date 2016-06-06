$package('finems.greenhouseList');
finems.greenhouseList = function() {
	var _box = null;
	var _this = {
			config: {
				istbar: false,
				dataGrid: {
					title: '大棚列表',
					url: 'greenhousedataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'name', title: '大棚名称', width: 180, sortable: true},
					           {field: 'ghArea', title: '大棚面积', width: 100, sortable: true},
					           {field: 'baseName', title: '所属基地', width: 120, sortable: true},
					           {field: 'greenhouseName', title: '大棚类型', width: 120, sortable: true},
					           {field: 'createTime', title: '建设时间', width: 150, sortable: true},
					           {field: 'management', title: '操作', width: 300, align: 'center', formatter: function(value, row, index) {
					        	   var html = "<a href='../sysPlant/list.do?greenhouseid=" + row.id + "'>[种植信息]</a>&nbsp;&nbsp;&nbsp" +
					        	   		"<a href='../sysTask/list.do?greenhouseid=" + row.id + "'>[任务管理]</a>&nbsp;&nbsp;&nbsp" +
					        	   		"<a href='../sysInputs/list.do?greenhouseid=" + row.id + "'>[投入品管理]</a>";
								   return html;
								}}
					           ]]
				}
			},
			init: function () {
				$("#baseId").combobox({
					url: '../sysBase/loadbaseList.do',
					valueField: 'id',
					textField: 'baseName',
					multiple: false
				});
				_box = new YDataGrid(_this.config);
				_box.init();
			}
	}
	return _this;
}();

$(function(){
	finems.greenhouseList.init();
});