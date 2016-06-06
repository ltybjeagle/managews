$package('finems.sysSign');
finems.sysSign = function() {
	var _box = null;
	var _this = {
			toSign: function () {
				var records = _box.utils.getCheckedRows();
				if (_box.utils.checkSelect(records)) {
					$("#edit-win").dialog('open');
				}
			},
			config: {
				event: {
					add: function() {
						window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/toAdd.do';
					},
					edit: function() {
						var record = _box.utils.getCheckedRows();
						if (_box.utils.checkSelectOne(record)) {
							window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/toEdit.do?id=' + record[0].id;
						}
					},
					remove: function() {
						var records = _box.utils.getCheckedRows();
						if (_box.utils.checkSelect(records)) {
							$.messager.confirm('确认', '确认删除记录?', function(r) {  
								if (r) {
									finems.progress();
							    	var arr = []; // 主键名称
							    	$.each(records, function(i, record) {
							    		arr.push('id=' + record['id']);
							    	});
							    	var data = arr.join("&");
							    	finems.deleteForm('deleteSign.do', data, function(result) {
							    		finems.closeProgress();
							    		window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/list.shtml';
									});
							    }  
							});
						}
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							var records = _box.utils.getCheckedRows();
							var arr = []; // 主键名称
					    	$.each(records, function(i, record) {
					    		arr.push('id=' + record['id']);
					    	});
					    	var data = arr.join("&");
							data = data + "&signPerson=" + $("#signPerson").val();
							finems.ajaxJson('signOk.do', data, function() {
					    		window.location.href = urls['msPath'] + urls['msUrl'] + '/sysSign/list.shtml';
							});
						}
					}
				},
				dataGrid: {
					title: '签收管理列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'distributionNo', title: '配送编号', width: 180, sortable: true},
					           {field: 'releaseTime', title: '发布时间', width: 180, sortable: true},
					           {field: 'distributionPerson', title: '配送人', width: 180, sortable: true},
					           {field: 'receivingUnit', title: '收货单位', width: 180, sortable: true},
					           {field: 'distributionStatus', title: '配送状态', width: 180, sortable: true, 
					        	   formatter: function(value, row, index) {
									if (value == 1) {
										return "已配送";
									}
									if (value == 2) {
										return "未配送";
									}
								}},
								{field: 'management', title: '操作', width: 100, align: 'center', formatter: function(value, row, index) {
						        	   var html = "<a href='../sysSign/showDetails.do?id=" + row.id + "'>[详情]</a>";
									   return html;
									}}
					           ]],
		           toolbar:[
							{id: 'btnadd', text: '添加', btnType: 'add'},
							{id: 'btndelete', text: '删除', btnType: 'remove'},
							{
								id: 'btnSign',
								text: '签收',
								disabled: false,
								iconCls: 'icon-ok',
								handler: function() {
									_this.toSign();
								}
							}
						]
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
	finems.sysSign.init();
});