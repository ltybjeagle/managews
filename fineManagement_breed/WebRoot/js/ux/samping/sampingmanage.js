$package('finems.sampingmanage');
finems.sampingmanage = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#baseid").combobox({
							url: '../sysBase/loadbaseList.do',
							valueField: 'id',
							textField: 'baseName',
							multiple: false,
							onHidePanel: function(){
								$("#fowleryid").combobox("setValue", '');
								var baseid = $('#baseid').combobox('getValue');		
								$.ajax({
									type: "POST",
									url: "../sysFowlery/loadFowlerList.do?baseid="+baseid,
									cache: false,
									dataType : "json",
									success: function(data) {
										$("#fowleryid").combobox("loadData", data);
									}
								}); 	
							},
							onSelect: function(record) {
								$("#baseName").val(record.id);
							}
						});
						$("#fowleryid").combobox({
							valueField: 'id',
							textField: 'name',
							multiple: false,
							onHidePanel: function(){
								$("#sampname").combobox("setValue", '');
								var fowleryid = $('#fowleryid').combobox('getValue');		
								$.ajax({
									type: "POST",
									url: "../sysBreed/loadBreedList.do?fowleryid="+fowleryid,
									cache: false,
									dataType : "json",
									success: function(data) {
										$("#sampname").combobox("loadData", data);
									}
								}); 	
							},
							onSelect: function(record) {
								$("#greenhousename").val(record.id);
							}
						});
						$("#sampname").combobox({
							valueField: 'id',
							textField: 'variety',
							multiple: false
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysSamping/getSerializId.do', data, function(result) {
								$("#sampleno").val(result.data.sampleno);
							});
							$("#filecontrol").show();
						});
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							finems.progress();
							_box.form.edit.attr('action', '../sysSamping/save.do');
							_box.form.edit.submit();
						}
					}
				},
				dataGrid: {
					title: '样品列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'sampleno', title: '样品编号', width: 120, sortable: true},
					           {field: 'variety', title: '样品名称', width: 120, sortable: true},
					           {field: 'samplingcount', title: '抽样数量', width: 80, sortable: true},
					           {field: 'samplingpeople', title: '抽样人', width: 100, sortable: true},
					           {field: 'samplingtime', title: '抽样时间', width: 150, sortable: true},
					           {field: 'baseName', title: '基地', width: 120, sortable: true},
					           {field: 'greenhousename', title: '禽舍', width: 120, sortable: true},
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
				$("#baseids").combobox({
					url: '../sysBase/loadbaseList.do',
					valueField: 'id',
					textField: 'baseName',
					multiple: false
				});
				$("#fowleryids").combobox({
					url: '../sysFowlery/loadFowlerList.do',
					valueField: 'id',
					textField: 'name',
					multiple: false
				});
				$("#plantids").combobox({
					url: '../sysBreed/loadBreedList.do',
					valueField: 'id',
					textField: 'variety',
					multiple: false
				});
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
	finems.sampingmanage.init();
});