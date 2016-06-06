$package('finems.sysMaterialStocktaking');

finems.sysMaterialStocktaking = function() {
	var _box = null;
	var materialno = null;
	var datalist = null;
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							
						});
					}
				},
				dataGrid: {
					title: '物资盘库列表',
					url: 'dataList.do',
					columns: [[
					           {field: 'id', checkbox: true},
					           {field: 'materialno', title: '物资编号', width: 80, sortable: true},
					           {field: 'materialname', title: '物资名称', width: 80, sortable: true},
					           {field: 'specifications', title: '规格', width: 80, sortable: true},
					           {field: 'unit', title: '单位', width: 80, sortable: true},
					           {field: 'brandName', title: '品牌', width: 80, sortable: true},
					           {field: 'storecount', title: '帐目数', width: 110, sortable: true},
					           {field: 'firm', title: '实盘数', width: 110,sortable: true},
					           {field: 'differences', title: '差异数', width: 110, sortable: true},
					           {field: 'profitloss', title: '盈亏', width: 110, sortable: true},
					           {field: 'mfName', title: '厂家', width: 220, sortable: true},
					           {field: 'shanchu', title: '删除', width: 80, align: 'center', formatter: function(value, row, index) {
					        	   var html = "<a href='#' onclick='deletelist(" + index + ");'>[删除]</a>";
									return html;
								}}
					           ]],
					           toolbar: [       
								          {id: 'btndetails',
								        	  text: '添加明细',
								        	  disabled: false,
								        	  iconCls: 'icon-add',
								        	  handler: function() {
								        		  var Win = { edit: $("#add-win")};
					                     			var Form = {
					                     					edit: $("#editForm")};
					                     			Win.edit.dialog('open');
					                     			Form.edit.resetForm();
								        	  }
								          },
								          {id: 'btnsave',
								        	  text: '保存',
								        	  disabled: false,
								        	  iconCls: 'icon-save',
								        	  handler: function() {
								        		  debugger;
								        		  var rows = $('#data-list').datagrid('getRows');
								        		  if (rows.length > 0) {
								        				finems.progress();
								        				var data = {};
								        				data['stocktalingno'] = ($("#stocktalingno").val());
								        				data['warehouseid'] = ($("#warehouseid").val());
								        				data['principal'] = ($("#principal").val());
								        				data['remark'] = ($("#remark").val());
								        				
								        				finems.ajaxJson('../SysStocktakingAction/save.do?', data, function(resp) {
								        					if(resp.success){
								        						for(var i =0; i < rows.length;i++){
								        							rows[i]["stocktalingno"]=($("#stocktalingno").val());
								        							finems.ajaxJson('../sysMaterialStocktaking/save.do?', rows[i], function(resp) {
								        								if(resp.success){
								        									alert("保存成功!");
								        									window.location.href = '../sysMaterialStocktaking/list.shtml';
								        								}
								        							});
								        						}
								        					}
								        				});
								        			} else {
								        				finems.alert('警告', '未添加明细，不能保存', 'warning');
								        			}	
								        	  }
								          },
								          {id: 'btnback',
								        	  text: '返回',
								        	  disabled: false,
								        	  iconCls: 'icon-ok',
								        	  handler: function() {
								        		  window.location.href = '../SysStocktakingAction/list.shtml';
								        	  }
								          },
								          ]
					
				}
			},
			initForm: function() {
				$("#editaddbtn").find("#btn-pwd-close").click(function() {	
					$.messager.confirm('Confirm', '是否关闭?', function(r) {  
					    if (r) {  
					    	$("#add-win").dialog('close');
					    }  
					});
				});
				$("#editaddbtn").find("#btn-pwd-add").click(function() {
					debugger;
//					var data = {"materialno":materialno}; 
//		      		finems.ajaxJson('../sysMaterialStocktaking/getmaterial.do', data, function(resp){
					    var firm = $("#firm")[0].value;
					    if(firm==""){
					    	alert("请录入实盘数！");
					    	return;
					    }
						var data = datalist;
		      			$('#data-list').datagrid('insertRow',{
		      				row: {
		      					id:data.id,
		      					materialno: data.materialno,
		      					materialname: data.materialname,
		      					specifications: data.specifications,
		      					specifications: data.specifications,
		      					unit: data.unit,
		      					brandName: data.brandName,
		      					storecount:data.storecount,
		      					firm:firm,
		      					differences:data.differences,
		      					profitloss:data.profitloss,
		      					mfName:data.mfName
		      				}
		      			});
		      			  //重画列表
		      		 });
//				});
			},
			init: function () {
				$("#materialno").combobox({
					url: '../sysMaterialStocktaking/loadmaterialnoList.do',
					valueField: 'id',
					textField: 'materialno',
					multiple: false,
					onSelect: function(record){
						if (record.id == 0) {
							$("#materialname").val("");
							$("#storecount").val("");
							materialno = null;
							datalist = null;
						} else {
							$("#materialname").val(record.materialname);
							materialno = record.materialno;
							$("#storecount").val(record.storecount);
							datalist = record;
						}
					}
				});
				$("#warehouseid").combobox({
					url: '../sysMaterialStocktaking/loadwarehouseidList.do',
					valueField: 'id',
					textField: 'whName',
					multiple: false
				});
				var data = {}; 
      		  finems.ajaxJson('../sysMaterialStocktaking/getstocktalingno.do', data, function(resp){
      			  $("#stocktalingno").val(resp.data.stocktalingno);
      		  });
				_box = new YDataGrid(_this.config);
				_box.init();
				_this.initForm();
			}
	}
	return _this;
}();
function deletelist(index){
	$('#data-list').datagrid("deleteRow",index);
}
$(function(){
	finems.sysMaterialStocktaking.init();
});