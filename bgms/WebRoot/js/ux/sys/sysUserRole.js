$package('finems.UserRole');
finems.UserRole = function() {
	var _box = null;
	var _this = {
		openAddRole: function(record) {
			$("#roleIds").combobox('clear'); // 清空选择框
			$(".selectId").attr('checked', false); // checkbox 取消选中
			_box.handler.edit(function(result) {
				$.each(result.data.roleIds, function(i, roleId) {
					$("#selectId_" + roleId).attr("checked", true);
				});
			});
		},
		config: {
			action: {
				save: 'addUserRole.do',
				getId: 'getUser.do'
			},
  			dataGrid: {
  				title: '系统用户授权',
	   			url: 'userList.do',
	   			columns:[[
						{field: 'id', checkbox: true},
						{field: 'code', title: '用户账号', width: 100, sortable: true},
						{field: 'nickName', title: '昵称', width: 120, sortable: true},
						{field: 'stateName', title: '状态', width: 60, sortable: true, styler: function(value, row, index) {
							if (value == 1) {
							  return 'color:red;';  
							}
						}},
						{field: 'createTime', title: '创建时间', width: 150, sortable: true},
						{field: 'loginCount', title: '登陆次数', width: 80, sortable: true},
						{field: 'loginTime', title: '登陆时间', width: 150, sortable: true},
						{field: 'roleStr', title: '授予角色', width: 400, sortable: true}
				]],
				toolbar:[
					{id: 'btnedit', iconCls: 'icon-edit', text: '授权', btnType: 'authRole', handler: function() {
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)) {
								_this.openAddRole(selected);
							}
						}
					}
				]
			}
		},
		init: function() {
			$("#roleIds").combobox({
				url: '../sysRole/loadRoleList.do',
				valueField: 'id',
				textField: 'roleName',
				multiple: true,
				formatter: function(row) {
				  var s = "<span><input type='checkbox' class='selectId' style='vertical-align: middle' id='selectId_" + row.id + "'>" + row.roleName + "<span>"
				  return s;  
				},
				onSelect: function(record) {
					$("#selectId_" + record.id).attr("checked", true);
				},
				onUnselect: function(record) {
					$("#selectId_" + record.id).attr("checked", false);
				}
			});
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	finems.UserRole.init();
});		