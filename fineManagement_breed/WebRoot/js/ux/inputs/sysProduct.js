$package('finems.sysProduct');
finems.sysProduct = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						$("#classifyIds").combobox({
							url: '../sysClassify/loadClassifyList.do',
							valueField: 'id',
							textField: 'classname',
							multiple: false
						});
						$("#brandIds").combobox({
							url: '../sysBrand/loadBrandList.do',
							valueField: 'id',
							textField: 'brandName',
							multiple: false
						});
						$("#mfids").combobox({
							url: '../sysManufacturer/loadManufacturerList.do',
							valueField: 'id',
							textField: 'mfName',
							multiple: false
						});
						_box.handler.add(function() {
							var data = {};
							finems.ajaxJson('../sysProduct/getSerializId.do', data, function(result) {
								$("#productNo").val(result.data.productNo);
							});
						});
					}
				},
				dataGrid: {
					title: '产品目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'productNo', title: '商品编号', width: 120, sortable: true},
					           {field: 'inputName', title: '投入品名称', width: 180, sortable: true},
					           {field: 'classname', title: '分类', width: 120, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 180, sortable: true},
					           {field: 'mfName', title: '生产厂家', width: 220, sortable: true},
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
				$("#classifyId").combobox({
					url: '../sysClassify/loadClassifyList.do',
					valueField: 'id',
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
	finems.sysProduct.init();
});