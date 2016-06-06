<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/resource.jsp" %>
</head>
<body class="easyui-layout">
<!-- Search panel start -->
<div class="ui-search-panel" region="north" title="投入品信息" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="inputsForm">
	   <div class ="fitem" margin:auto>
	   		<div class="fitem">  
           		<label>商品编号:</label>  
           		<input class="easyui-validatebox" id="productNo" name="productNo" readonly="true" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>投入品名称:</label>  
           		<input class="easyui-validatebox" id="inputName" name="inputName" readonly="true" data-options="width:282"/>
       		</div>
       	</div>
       	<div class ="fitem" margin:auto>
			<div class="fitem">  
           		<label>分类:</label>  
           		<input class="easyui-validatebox" id="classname" name="classname"  readonly="true" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>规格:</label>  
           		<input class="easyui-validatebox" id="specifications" name="specifications"  readonly="true" data-options="width:282"/>
       		</div>  
       	</div>
       	<div class ="fitem" margin:auto>  
       		<div class="fitem">  
           		<label>单位:</label>  
           		<input class="easyui-validatebox" type="unit" name="unit" readonly="true" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>库存:</label>  
           		<input class="easyui-validatebox" type="purchaseCount" name="purchaseCount" readonly="true" data-options="width:282"/>
       		</div>
       	</div>
       	<div class ="fitem" margin:auto>  
       		<div class="fitem">  
            	<label>品牌:</label>  
             	<input class="easyui-validatebox" id="brandName" name="brandName" readonly="true" data-options="width:282"/>
         	</div>
         	<div class="fitem">  
            	<label>厂家:</label>  
             	<input class="easyui-validatebox" id="mfName" name="mfName" readonly="true" data-options="width:282"/>
         	</div>
         </div>
	</form>  
</div> 
<div class="ui-search-panel"  region='center' style="height:260px;width:600px" title="投入品入库记录" 
	data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
	<form id="instoreForm">
	   <div class ="fitem" margin:auto>
	   		<div class="fitem">  
           		<label>入库数量:</label>  
           		<input class="easyui-validatebox" id="purchaseCount" name="purchaseCount" readonly="true" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>入库时间:</label>  
           		<input class="easyui-validatebox" id="instoretime" name="instoretime" readonly="true" data-options="width:282"/>
       		</div>
       	</div>
       	<div class ="fitem" margin:auto>
			<div class="fitem">  
           		<label>单价:</label>  
           		<input class="easyui-validatebox" id="unitPrice" name="unitPrice"  readonly="true" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>仓库:</label>  
           		<input class="easyui-validatebox" id="warehouseid" name="warehouseid"  readonly="true" data-options="width:282"/>
       		</div>  
       	</div>
       	<div class ="fitem" margin:auto>  
       		<div class="fitem">  
           		<label>负责人:</label>  
           		<input class="easyui-validatebox" type="principal" name="principal" readonly="true" data-options="width:282"/>
       		</div>
       		<div class="fitem">  
           		<label>备注:</label>  
           		<input class="easyui-validatebox" type="remark" name="remark" readonly="true" data-options="width:282"/>
       		</div>
       	</div>
	</form>  
</div>
<script type="text/javascript" src="<%=basePath%>/js/ux/store/sysInstoreDetail.js"></script>
</body>
</html>