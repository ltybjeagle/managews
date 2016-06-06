$package('finems.sysMaterialInstoreDetail');

finems.sysMaterialInstoreDetail = function() {
	var _box = null;
	var _this = {
			config: {
				dataGrid: {
					title: '物资目录入库详单',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 80, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 80, sortable: true},
					           {field: 'storecount', title: '库存', width: 80, sortable: true},
					           {field: 'unitPrice', title: '单价', width: 80, sortable: true},
					           {field: 'totalprice', title: '总价', width: 80, sortable: true},
					           {field: 'storecount', title: '入库数量', width: 80, sortable: true},
					           {field: 'instoretime', title: '入库时间', width: 80, sortable: true},
					           {field: 'principal', title: '负责人', width: 80, sortable: true},
					           {field: 'whName', title: '仓库', width: 80, sortable: true},
					           {field: 'mfName', title: '厂家', width: 200, sortable: true},
					           {field: 'xiangqing', title: '操作', width: 80, align: 'center', formatter: function(value, row, index) {
									var html = "<a href='#' onclick='showInstoreDetail(" + row.id + ");'>[详情]</a>";
									return html;
								}}
					           ]],
					toolbar: [       
					          {id: 'btndetails',
					        	  text: '返回',
					        	  disabled: false,
					        	  iconCls: 'icon-audit',
					        	  handler: function() {
					        		  window.location.href = '../sysMaterialInstore/list.shtml?';
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
function showInstoreDetail(storeId) {
	var data = {};
	data['id'] = (storeId);
	finems.getById('../sysMaterialInstoreDetail/getId.do', data, function(result) {
		$("#materialno").text(result.data.materialno);
		$("#materialname").text(result.data.materialname);
		$("#unit").text(result.data.unit);
		$("#specifications").text(result.data.specifications);
		$("#brandName").text(result.data.brandName);
		$("#mfName").text(result.data.mfName);
		$("#storecount").text(result.data.storecount);
		$("#instoretime").text(result.data.instoretime);
		$("#unitPrice").text(result.data.unitPrice);
		$("#whName").text(result.data.whName);
		$("#principal").text(result.data.principal);
		$("#remark").text(result.data.remark);
		$("#edit-pwd-win").dialog('open');
	});
}

$(function(){
	finems.sysMaterialInstoreDetail.init();
});