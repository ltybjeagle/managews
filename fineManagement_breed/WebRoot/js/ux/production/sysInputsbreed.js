$package('finems.sysInputsbreed');
finems.sysInputsbreed = function() {
	var _box = null;
	var _this = {
			toBack: function () {
				window.location.href = urls['msPath'] + urls['msUrl'] + '/sysBreed/sysfowleryList.shtml';
			},
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#productNos").combobox({
							url: '../sysProduct/loadSysProductList.do',
							valueField: 'id',
							textField: 'productNo',
							multiple: false,
							onSelect: function(record) {
								if (record.id == 0) {
									$("#inputName").val("");
									$("#classname").val("");
									$("#unit").val("");
									$("#specifications").val("");
									$("#brandName").val("");
									$("#mfName").val("");
								} else {
									finems.progress();
									var data = {};
									data['id'] = (record.id);
									finems.getById('../sysProduct/getId.do', data, function(result) {
										finems.closeProgress();
										$("#inputName").val(result.data.inputName);
										$("#classname").val(result.data.classname);
										$("#unit").val(result.data.unit);
										$("#specifications").val(result.data.specifications);
										$("#brandName").val(result.data.brandName);
										$("#mfName").val(result.data.mfName);
									});
								}
							}
						});
						$("#breeders").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						$("#breedTechnicians").combobox({
							url: '../sysEmployees/loadEmployeeList.do',
							valueField: 'id',
							textField: 'employeeName',
							multiple: false
						});
						_box.handler.add(function() {
							$("#productNos").combobox("select", 0);
							$("#pno").val("1");
						});
					}
				},
				dataGrid: {
					title: '投入品列表         (禽舍信息:' + $("#fowleryName").val() + '              所属基地:' + $("#baseName").val() + ')',
					url: 'dataList.do?fowleryid='+$("#fowleryid").val(),
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'startTime', title: '使用时间', width: 80, sortable: true},
					           {field: 'inputName', title: '投入品名称', width: 100, sortable: true},
					           {field: 'classname', title: '分类', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 100, sortable: true},
					           {field: 'mfName', title: '生产厂家', width: 220, sortable: true},
					           {field: 'purchaseCount', title: '数量', width: 80, sortable: true},
					           {field: 'breederName', title: '使用人', width: 100, sortable: true},
					           {field: 'breedTechnicianName', title: '技术员', width: 100, sortable: true},
					           {field: 'remark', title: '备注', width: 100, sortable: true},
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
					          {id: 'btndelete', text: '删除', btnType: 'remove'},
					          {
									id: 'btnback',
									text: 'back',
									disabled: false,
									iconCls: 'icon-back',
									handler: function() {
										_this.toBack();
									}
								}
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
	finems.sysInputsbreed.init();
});