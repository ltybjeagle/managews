$package('finems.sysUser');
finems.sysUser = function() {
	var _box = null;
	var _this = {
		updatePwdAction: 'updatePwd.do',
		editPwdForm: function() {
			return $("#pwdForm");
		},
		editPwdWin: function() {
			return $("#edit-pwd-win");
		},
		savePwd: function() {
			finems.progress(); // 缓冲条
			if (_this.editPwdForm().form('validate')) {
				_this.editPwdForm().attr('action', _this.updatePwdAction);
				finems.saveForm(_this.editPwdForm(), function(data) {
					finems.closeProgress(); // 关闭缓冲条
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		config: {
			event: {
				add: function() {
					$("#edit-win").dialog({title: "添加"});
					_box.handler.add(function(result) {
					});
				},
				save: function() {
					// 判断是否被禁用帐号
					var state = $("input[name='state']", _box.form.edit).val();
					if (state != 0) {
						finems.confirm("提示", "禁用用户将会自动解除关联的角色授权,是否确定?", function(r) {
							if (r) {
								_box.handler.save(function(result){
									finems.alert('警告', result.msg, 'warning');
								});
							}
						});
					} else {
						_box.handler.save(function(result){
							finems.alert('警告', result.msg, 'warning');
						});
					}
				}
			},
  			dataGrid: {
  				title: '系统用户列表',
	   			url: 'dataList.do',
	   			columns:[[
						{field: 'id', checkbox: true},
						{field: 'code', title: '用户账号', width: 100, sortable: true},
						{field: 'nickName', title: '昵称', width: 120, sortable: true},
						{field: 'stateName', title: '状态', width: 60, sortable: true, styler: function(value, row, index) {
							if (value == '禁用') {
							  return 'color:red;';  
							}
						}},
						{field: 'createTime', title: '创建时间', width: 150, sortable: true},
						{field: 'updateTime', title: '更新时间', width: 150, sortable: true},
						{field: 'loginCount', title: '登陆次数', width: 80, sortable: true},
						{field: 'loginTime', title: '登陆时间', width: 150, sortable: true},
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
					{id: 'btnedit', text: '修改密码', btnType: 'editPwd', iconCls: 'icon-edit', handler: function() {
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)) {
								_this.editPwdForm().resetForm();
								_this.editPwdForm().find("input[name='id']").val(selected[0].id);
								_this.editPwdForm().find("input[name='code']").val(selected[0].code);
								_this.editPwdWin().window('open'); 
							}
						}},
					{id: 'btndelete', text: '删除', btnType: 'remove'}
				]
			}
		},
		init: function() {
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('#btn-pwd-close').click(function() {
				$.messager.confirm('确认', '你确认关闭窗口?', function(r) {  
				    if (r) {  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
			$('#btn-pwd-submit').click(function() {
				_this.savePwd()
			});
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
	finems.sysUser.init();
});		