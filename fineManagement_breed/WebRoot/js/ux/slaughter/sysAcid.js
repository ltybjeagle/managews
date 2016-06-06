$package('finems.sysAcid');
finems.sysAcid = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#slaughterBatchIds").combobox({
							url: '../sysSlaughter/loadSlaughterList.do',
							valueField: 'id',
							textField: 'slaughterBatch',
							multiple: false,
							disabled: false,
							onSelect: function(record) {
								if (record.id == 0) {
									$("#slaughterQuantity").val("");
								} else {
									finems.progress();
									var data = {};
									data['id'] = (record.id);
									finems.getById('../sysSlaughter/getId.do', data, function(result) {
										finems.closeProgress();
										$("#slaughterQuantity").val(result.data.slaughterQuantity);
									});
								}
							}
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysAcid/getSerializId.do', data, function(result) {
								$("#acidBatch").val(result.data.acidBatch);
							});
						});
					},
					edit: function() {
						$("#slaughterBatchIds").combobox({
							url: '../sysSlaughter/loadSlaughterList.do',
							valueField: 'id',
							textField: 'slaughterBatch',
							multiple: false,
							disabled: true
						});
						_box.handler.edit(function(result) {
							$("#slaughterBatchIds").combobox('select', result.data.slaughterBatchId);
						});
					}
				},
				dataGrid: {
					title: '排酸管理列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'slaughterBatch', title: '屠宰批次', width: 180, sortable: true},
					           {field: 'acidBatch', title: '排酸批次', width: 180, sortable: true},
					           {field: 'startTime', title: '排酸开始时间', width: 180, sortable: true},
					           {field: 'endTime', title: '排酸结束时间', width: 180, sortable: true},
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
					toolbar: [
					          {id: 'btnadd', text: '添加', btnType: 'add'},
					          {id: 'btndelete', text: '删除', btnType: 'remove'}
					          ]
				}
			},
			init: function () {
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
	finems.sysAcid.init();
});