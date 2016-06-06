$package('finems.sysPurchase');
finems.sysPurchase = function() {
	var _box = null;
	var _this = {
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
						_box.handler.add(function() {
							$("#productNos").combobox("select", 0);
							$("#pno").val("1");
						});
					},
					remove: function() {
						var record = _box.utils.getCheckedRows();
						for (var i = 0; i < record.length; i++) {
							if (record[i].taskkey != '00' && record[i].taskkey != '05') {
								finems.alert('警告', '只有【已录入】、【已退回】的数据才能删除.', 'warning'); 
								return;
							}
						}
						_box.handler.remove();
					},
					toAudit: function() {
						var record = _box.utils.getCheckedRows();
						for (var i = 0; i < record.length; i++) {
							if (record[i].taskkey != '00' && record[i].taskkey != '05') {
								finems.alert('警告', '只有【已录入】、【已退回】的数据才能送审.', 'warning'); 
								return;
							}
						}
						_box.handler.toAudit();
					}
				},
				dataGrid: {
					title: '采购计划列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'productNo', title: '商品编号', width: 80, sortable: true},
					           {field: 'inputName', title: '投入品名称', width: 100, sortable: true},
					           {field: 'classname', title: '分类', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 100, sortable: true},
					           {field: 'mfName', title: '生产厂家', width: 220, sortable: true},
					           {field: 'purchaseCount', title: '数量', width: 80, sortable: true},
					           {field: 'unitPrice', title: '单价(元)', width: 80, sortable: true},
					           {field: 'totalAmt', title: '总价(元)', width: 80, sortable: true},
					           {field: 'taskname', title: '状态', width: 80, sortable: true},
					           {field: 'taskkey', title: '状态编码', width: 80, sortable: true},
					           {field: 'auditName', title: '审核人', width: 80, sortable: true},
					           {field: 'createTime', title: '发布时间', width: 80, sortable: true},
							   {field: 'operate', title: '操作', width: 200, align: 'center', formatter: function(value, row, index) {
									var html = '<a class="query_cls" href="javascript:queryOne(\'' + row.id + '\');">查看</a>' +
											'<a class="edit_cls" href="javascript:editOne(\'' + row.id + '\',\'' + row.taskkey + '\');">编辑</a>' +
											'<a class="del_cls" href="javascript:removeOne(\'' + row.id + '\',\'' + row.taskkey + '\');">删除</a>' +
											'<a class="op_cls" href="javascript:showMyWindow(' + row.processInstanceId + ');">操作历史</a>';
									return html;
								}}
					           ]],
		            onLoadSuccess: function(data) {  
						$('.query_cls').linkbutton({text:'查看', plain:true}); 
						$('.edit_cls').linkbutton({text:'编辑', plain:true}); 
						$('.del_cls').linkbutton({text:'删除', plain:true});
						$('.op_cls').linkbutton({text:'操作历史', plain:true});
					},
					toolbar: [
					          {id: 'btnadd', text: '添加', btnType: 'add'},
					          {id: 'btndelete', text: '删除', btnType: 'remove'},
					          {id: 'btntoaudit', text: '送审', btnType: 'toaudit'}
					          ]
				}
			},
			init: function () {
				$("#classnames").combobox({
					url: '../sysClassify/loadClassifyList.do',
					valueField: 'classname',
					textField: 'classname',
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
	finems.sysPurchase.init();
});