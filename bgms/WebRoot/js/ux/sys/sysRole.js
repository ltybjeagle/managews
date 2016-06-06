$package('finems.sysRole');
finems.sysRole = function() {
	var _box = null;
	var _this = {
		menu: $('#menu-tree'),
		buildTreeData: function(nodes) {
			$.each(nodes, function(i, note) {
				var id = note.attributes.id;
				var type = note.attributes.type;
				var $id = $("<input type='hidden' name='menuIds' class='c_menus'>");
				if (type == 0) {
					$id.attr('name','menuIds');
				}
				$id.val(id);
				_box.form.edit.append($id);
			});
		},
		setTreeValue: function (id) {
			var node = _this.menu.tree("find", id);
			if (node && node.target) {
				if ($(node.target).find(".tree-checkbox0")[0]) {
					_this.menu.tree('check', node.target);
				}
			}
		},
		save: function() {
			var checknodes = _this.menu.tree('getChecked');	
			var innodes = _this.menu.tree('getChecked','indeterminate');
			_this.buildTreeData(checknodes);
			_this.buildTreeData(innodes);
			_box.handler.save();
		},
		config: {
			event: {
				add: function() {
					$("#edit-win").dialog({title: "添加"});
					if ($('#menu-tree li')) {
						$('#menu-tree li').remove();
					}
					if ($('.c_menus')) {
						$('.c_menus').remove();
					}
					$("#sysIds").combobox({
						url: '../sysIdentifier/loadIdentifierList.do',
						valueField: 'sysid',
						textField: 'sysname',
						multiple: false,
						onSelect: function(record) {
							if (record.sysid != '') {
								_this.menu.tree({
									url: '../sysMenu/getMenuTree.do?sysid=' + record.sysid,
									checkbox: true
								});
							}
						}
					});
					_box.handler.add();
				},
				save: function() {
					// 判断是否被禁用帐号
					var state = $("input[name='state']", _box.form.edit).val();
					if (state != 0) {
						finems.confirm("提示", "禁用角色将会自动解除关联的用户授权,是否确定?", function(r) {
							if (r) {
								_this.save();
							}
						});
					} else {
						_this.save();
					}
				}
			},
  			dataGrid: {
  				title: '角色列表',
	   			url: 'dataList.do',
	   			columns:[[
						{field: 'id', checkbox: true},
						{field: 'sysname', title: '系统名称', width: 180, sortable: true},
						{field: 'code', title: '角色编码', width: 180, sortable: true},
						{field: 'roleName', title: '角色名称', width: 120, sortable: true},
						{field: 'state', title: '状态', width: 60, sortable: true, styler: function(value, row, index) {
								if (value == 1) {
								  return 'color:red;';  
								}
							},
							formatter: function(value, row, index) {
								if (value == 0) {
									return "可用";
								}
								if (value == 1) {
									return "禁用";
								}
							}},
						{field: 'createTime', title: '创建时间', width: 150, sortable: true},
						{field: 'updateTime', title: '修改时间', width: 150, sortable: true},
						{field: 'operate', title: '操作', width: 180, align: 'center', formatter: function(value, row, index) {
							var html = "<a class='query_cls' href='javascript:queryOne(" + row.id + ");'>查看</a>" +
									"<a class='edit_cls' href='javascript:editOne(" + row.id + ");'>编辑</a>" +
									"<a class='del_cls' href='javascript:removeOne(" + row.id + ");'>删除</a>";
							return html;
						}}
				]],
				onLoadSuccess: function(data) {  
					$('.query_cls').linkbutton({text:'查看', plain:true}); 
					$('.edit_cls').linkbutton({text:'编辑', plain:true}); 
					$('.del_cls').linkbutton({text:'删除', plain:true});
				},
				toolbar:[
							{id: 'btnadd', text: '添加', btnType: 'add'},
							{id: 'btndelete', text: '删除', btnType: 'remove'}
						]
			}
		},
		init: function() {
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('#btn-query-close').click(function() {
				$.messager.confirm('确认', '你确认关闭窗口?', function(r) {  
				    if (r) {  
				    	$('#query-win').dialog('close');
				    }  
				});
			});
		}
	}
	return _this;
}();

$(function(){
	finems.sysRole.init();
});		