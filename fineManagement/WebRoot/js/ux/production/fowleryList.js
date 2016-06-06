$package('finems.fowleryList');
finems.fowleryList = function() {
	var _box = null;
	var _this = {
			config: {
				istbar: false,
				dataGrid: {
					title: '禽舍列表',
					url: 'sysfowlerydataList.do',
					columns: [[{field: 'id', checkbox: true},
							   {field: 'name', title: '禽舍名称', width: 180, sortable: true},
							   {field: 'breedArea', title: '禽舍面积', width: 100, sortable: true},
							   {field: 'baseName', title: '所属基地', width: 100, sortable: true},
							   {field: 'fowleryName', title: '禽舍类型', width: 100, sortable: true},
							   {field: 'createTime', title: '建设时间', width: 100, sortable: true},
							   {field: 'management', title: '操作', width: 300, align: 'center', formatter: function(value, row, index) {
					        	   var html = "<a href='../sysBreed/list.do?fowleryid=" + row.id + "'>[养殖信息]</a>&nbsp;&nbsp;&nbsp" +
					        	   		"<a href='../sysTaskBreed/list.do?fowleryid=" + row.id + "'>[任务管理]</a>&nbsp;&nbsp;&nbsp" +
					        	   		"<a href='../sysInputsBreed/list.do?fowleryid=" + row.id + "'>[投入品管理]</a>&nbsp;&nbsp;&nbsp" +
					        	   		"<a href='../sysCattleSlaughter/list.do?fowleryid=" + row.id + "'>[出栏管理]</a>";
								   return html;
								}}
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
	finems.fowleryList.init();
});