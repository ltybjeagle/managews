$package('finems.sysMenu');
finems.sysMenu = function() {
	var _box = null;
	var _this = {
		toList: function(parentId) {
			_box.form.search.resetForm();
			if (parentId) {
				$('#search_parentId').val(parentId);
				$('#btnback').linkbutton('enable');
			} else {
				$('#btnback').linkbutton('disable');
				$('#btnback').linkbutton('disable');
			}
			_box.handler.refresh();
		},
		config: {
  			dataGrid: {
  				title: '菜单列表',
	   			url: 'dataList.do',
	   			columns:[[
					{field: 'id', checkbox: true},
					{field: 'sysname', title: '系统名称', width: 180, sortable: true},
					{field: 'name', title: '菜单名称', width: 120, sortable: true},
					{field: 'rank', title: '序号', align: 'right', width: 80, sortable: true},
					{field: 'url', title: 'URL', width: 220, sortable: true},
					{field: 'createTime', title: '创建时间', width: 180, sortable: true},
					{field: 'updateTime', title: '修改时间', width: 180, sortable: true},
					{field: 'childMenus', title: '子目录', width: 120, align: 'center', formatter: function(value, row, index) {
						var html = "";
						if (row.subCount > 0) {
							html = "<a href='#' onclick='finems.sysMenu.toList(" + row.id + ")'>子菜单管理(" + row.subCount + ")</a>";
						}
						return html;
					}}
				]],
				toolbar:[
					{
						id: 'btnback',
						text: 'back',
						disabled: true,
						iconCls: 'icon-back',
						handler: function() {
							_this.toList();
						}
					}
				]
			}
		},
		init: function() {
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	finems.sysMenu.init();
});		