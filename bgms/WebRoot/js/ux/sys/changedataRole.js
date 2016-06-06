function editOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		$("#editForm").form('load', result.data);
		$("#state").combobox("select", result.data.state);
		$('#menu-tree li').remove();
		$('.c_menus').remove();
		$("#sysIds").combobox({
			url: '../sysIdentifier/loadIdentifierList.do?sysid=' + result.data.sysid,
			valueField: 'sysid',
			textField: 'sysname',
			multiple: false
		});
		$("#sysIds").combobox('select', result.data.sysid);
		$('#menu-tree').tree({
			url: '../sysMenu/getMenuTree.do?sysid=' + result.data.sysid,
			checkbox: true,
			onLoadSuccess: function () {
				var menuIds = result.data.menuIds;
				$.each(menuIds, function(i, id) {
					finems.sysRole.setTreeValue("menu_" + id);
				});
			}
		});
		$("#edit-win").dialog({title: "编辑"});
		$("#edit-win").dialog('open'); 
	});
}

function queryOne(reaordId) {
	finems.progress();
	var data = {};
	var idKey = 'id';
	data[idKey] = (reaordId);
	finems.getById('getId.do', data, function(result) {
		finems.closeProgress();
		var spanList = $("#query-win span");
		var spanListSize = spanList.length;
		for (var i = 0; i < spanListSize; i++) {
			var spanObj = spanList[i];
			var spanVal = spanObj["id"];
			if (spanVal == "") {
				continue;
			}
			eval("var resObj = result.data." + spanVal);
			$("#" + spanVal).text(resObj);
		}
		$('#menu-tree1 li').remove();
		$('#menu-tree1').tree({
			url: '../sysMenu/getMenuTree.do?sysid=' + result.data.sysid + '&roleId=' + result.data.id,
			checkbox: false
		});
		$("#query-win").dialog('open'); 
	});
}