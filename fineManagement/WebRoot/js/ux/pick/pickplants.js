$package('finems.pickplants');
finems.pickplants = function() {
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
							multiple: false
						});
						$("#greehouseid").combobox({
							url: '../sysGreenhouse/loadGreenhouseList.do',
							valueField: 'id',
							textField: 'name',
							multiple: false,
							onHidePanel: function(){
								$("#plantid").combobox("setValue", '');
								var greehouseid = $('#greehouseid').combobox('getValue');		
								$.ajax({
									type: "POST",
									url: "../sysPlant/loadPlantList.do?greenhouseid="+greehouseid,
									cache: false,
									dataType : "json",
									success: function(data) {
										$("#plantid").combobox("loadData", data);
									}
								}); 	
							}
						});
						$("#plantid").combobox({
							valueField: 'id',
							textField: 'variety',
							multiple: false
						});
						_box.handler.add(function() {
							$("#filecontrol").show();
						});
					},
					save: function() {
						if (_box.form.edit.form('validate')) {
							finems.progress();
							_box.form.edit.attr('action', '../sysPickplants/save.do');
							_box.form.edit.submit();
						}
					},
				},
				dataGrid: {
					title: '产品采收列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'harvesttime', title: '采收时间', width: 80, sortable: true},
					           {field: 'variety', title: '菜品名称', width: 100, sortable: true},
					           {field: 'baseName', title: '基地', width: 80, sortable: true},
					           {field: 'greenhousename', title: '大棚', width: 80, sortable: true},
					           {field: 'numberharvest', title: '采收数量', width: 80, sortable: true},
					           {field: 'grade', title: '等级', width: 80, sortable: true},
					           {field: 'unitprice', title: '单价(元)', width: 80, sortable: true},
					           {field: 'amt', title: '金额(元)', width: 80, sortable: true},
					           {field: 'harveststaff', title: '采收人员', width: 80, sortable: true},
					           {field: 'inspectionstaff', title: '验收人员', width: 80, sortable: true},
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
				$("#plantids").combobox({
					url: '../sysPlant/loadPlantList.do',
					valueField: 'id',
					textField: 'variety',
					multiple: false
				});
				$("#baseids").combobox({
					url: '../sysBase/loadbaseList.do',
					valueField: 'id',
					textField: 'baseName',
					multiple: false
				});
				$("#greehouseids").combobox({
					url: '../sysGreenhouse/loadGreenhouseList.do',
					valueField: 'id',
					textField: 'name',
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
	finems.pickplants.init();
});