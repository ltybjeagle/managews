$package('finems.sysMaterial');

finems.sysMaterial = function() {
	var _box = null;
	var _this = {
			config: {
				event: {
					add: function() {
						$("#edit-win").dialog({title: "添加"});
						_box.handler.add(function(result) {});
					}
				},
				dataGrid: {
					title: '物资目录列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 80, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 100, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 200, sortable: true},
					           {field: 'brandName', title: '品牌', width: 180, sortable: true},
					           {field: 'mfName', title: '厂家', width: 200, sortable: true},
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
								           {id: 'btnadd', text: '添加', btnType: 'add',
								        	   handler:function(){
								        		  var data = {}; 
								        		  finems.ajaxJson('../sysMaterialmanage/getmaterialno.do', data, function(resp){
								        			  $("#materialno").val(resp.data.materialno);
								        		  });
								        		  var Win = { edit: $("#edit-win")};
									        	   var Form = {
									        				edit: $("#editForm")};
									        	   Win.edit.dialog('open');
									   			   Form.edit.resetForm();
								        	   }},
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
	finems.sysMaterial.init();
});