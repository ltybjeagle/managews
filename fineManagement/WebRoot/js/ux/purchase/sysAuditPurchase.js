$package('finems.sysAuditPurchase');
finems.sysAuditPurchase = function() {
	var _box = null;
	var _this = {
			editPwdWin: function() {
				return $("#edit-win");
			},
			config: {
				dataGrid: {
					title: '采购审批列表',
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
					           {field: 'remark', title: '备注', width: 80, sortable: true},
					           {field: 'operate', title: '操作', width: 200, align: 'center', formatter: function(value, row, index) {
									var html = '<a class="query_cls" href="javascript:queryOne(\'' + row.id + '\');">查看</a>' +
											'<a class="op_cls" href="javascript:showMyWindow(' + row.processInstanceId + ');">操作历史</a>';
									return html;
								}}
					           ]],
		            onLoadSuccess: function(data) {  
						$('.query_cls').linkbutton({text:'查看', plain:true}); 
						$('.op_cls').linkbutton({text:'操作历史', plain:true});
					},
					toolbar: [
					          {id: 'btnaudit', text: '审核', btnType: 'audit'}
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
				$("#state").combobox({
					onSelect: function(record) {
						$("#stateid").attr('value', record.value);
					}
				});
				$("#btn-pwd-submit").click(function() {
					_box.handler.auditOp();
				});
				$("#btn-pwd-close").click(function() {
					$.messager.confirm('确定', '你确认关闭窗口?', function(r) {  
					    if (r) {  
					     	_this.editPwdWin().dialog('close');
					    }  
					});
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
	finems.sysAuditPurchase.init();
});