$package('finems.sysMaterialReturnDetail');

finems.sysMaterialReturnDetail = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '领用详情',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 80, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 80, sortable: true},
					           {field: 'unitPrice', title: '单价', width: 80, sortable: true},
					           {field: 'totalprice', title: '总价', width: 80, sortable: true},
					           {field: 'returncount', title: '归还数量', width: 80, sortable: true},
					           {field: 'returntime', title: '归还时间', width: 80, sortable: true},
					           {field: 'backuser', title: '归还人', width: 80, sortable: true},
					           {field: 'whName', title: '仓库', width: 80, sortable: true},
					           {field: 'baseName', title: '基地', width: 80, sortable: true},
					           {field: 'greenhousename', title: '禽舍', width: 80, sortable: true},
					           {field: 'mfName', title: '厂家', width: 220, sortable: true},
					           {field: 'xiangqing', title: '操作', width: 80, align: 'center', formatter: function(value, row, index) {
									var html = "<a href='#' onclick='showReturnDetail(" + row.id + ");'>[详情]</a>";
									return html;
								}}
					           ]],
				toolbar:[       
				         {id: 'btndetails',
				        	 text: '返回',
				        	 disabled: false,
				        	 iconCls: 'icon-audit',
				        	 handler: function() {
				        		 window.location.href = '../sysMaterialReturn/list.shtml?';
				        	 }
				         },
				         ]
								          
					
				}
			},
			editPwdWin: function() {
				return $("#edit-pwd-win");
			},
			initForm: function() {
				_this.editPwdWin().find("#btn-pwd-close").click(function() {	
					$.messager.confirm('Confirm', '是否关闭?', function(r) {  
					    if (r) {  
					     	_this.editPwdWin().dialog('close');
					    }  
					});
				});
			},
			init: function () {
				_box = new YDataGrid(_this.config);
				_box.init();
				_this.initForm();
			}
	}
	return _this;
}();
function showReturnDetail(storeId) {
	var data = {};
	data['id'] = (storeId);
	finems.getById('../sysMaterialReturnDetail/getId.do', data, function(result) {
		$("#materialno").text(result.data.materialno);
		$("#materialname").text(result.data.materialname);
		$("#unit").text(result.data.unit);
		$("#specifications").text(result.data.specifications);
		$("#brandName").text(result.data.brandName);
		$("#mfName").text(result.data.mfName);
		$("#returncount").text(result.data.returncount);
		$("#returntime").text(result.data.returntime);
		$("#unitPrice").text(result.data.unitPrice);
		$("#whName").text(result.data.whName);
		$("#principal").text(result.data.principal);
		$("#backuser").text(result.data.backuser);
		$("#remark").text(result.data.remark);
		$("#baseName").text(result.data.baseName);
		$("#greenhousename").text(result.data.greenhousename);
		$("#edit-pwd-win").dialog('open');
	});
}
$(function(){
	finems.sysMaterialReturnDetail.init();
});