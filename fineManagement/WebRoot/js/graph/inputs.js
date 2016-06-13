$(function () {	
	   options = {
	            chart: {
	                   renderTo: 'container', //DIV容器ID
	                //   type: 'column'//报表类型
	                       },             
	            title:{
	                   text:'商品编号:'+'投放品名称:'+'\n统计时间:'
	                      },  
	           subtitle: {
	                   text: ''
	                  },
	          loading:{
	        	       text:'加载中'
	          },
	          colors:['#1C86EE', '#B40404'],
	          lang: {
	                   downloadPNG: '下载JPEG 图片',
	                   downloadJPEG: '下载JPEG文档',
	                   downloadPDF: '下载PDF 文件',
	                   downloadSVG: '下载SVG 矢量图',
	                   contextButtonTitle: '下载图片'
	                       },
	            yAxis: [
                        {
                          labels: {
                        	  formatter: function() {
                                  return this.value ;
                              },
                              style: {
                                  color: '#1E1E1E'
                              }
                        	         },
                          min: 0,
                          title: {
                          text: '单位:元',
                          style: {
                              color: '#1E1E1E'             
                                  },
                          },
                        opposite: true
                         },{
                        labels: {
                              formatter: function() {
                                    return this.value ;
                                 },
                                  style: {
                                     color: '#1E1E1E'
                                 }
                             },
                             title: {
                                 text: '单位:袋',
                                 style: {
                                     color: '#1E1E1E'
                                 }
                             }
                           
                         }
	                    ],   
	                xAxis: {
	                     categories: []//x轴显示内容
	                            },          
	                   series: []//数据来源(多个对比的)
	                  };
	   var chart = new Highcharts.Chart(options);
   
	   $("#baseid").combobox({
			url: '../sysBase/loadbaseList.do',
			valueField: 'id',
			textField: 'baseName',
			multiple: false
		});
	   $("#inputid").combobox({
			url: '../sysProduct/loadSysProductList.do',
			valueField: 'id',
			textField: 'inputName',
			multiple: false
		});
	   
		$("#greehouseids").combobox({
			url: '../sysGreenhouse/loadGreenhouseList.do',
			valueField: 'id',
			textField: 'name',
			multiple: false
		});
		function onSelect(d) {
	        var issd = this.id == 'sd', sd = issd ? d : new Date($('#sd').datebox('getValue')), ed = issd ? new Date($('#ed').datebox('getValue')) : d;
	            if (ed < sd) {
	                alert('结束日期小于开始日期');
	                //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
	                $('#ed').datebox('setValue', '').datebox('showPanel');
	            }
	        };

   $('#data-list').datagrid({   
      //  url:'/statisticsInputs/inputtable.do',
	    fitColumns : true,
		fit: true,
		border: false,
		nowrap: true,
		autoRowHeight: false,
		striped: false,
		collapsible: false,
		remoteSort: false,
		pagination: true,
		rownumbers: true,
		method:  'post',
		loadMsg:  'Loading in ...',
	     columns:[[   
          {field:'startTime',title:'时间',width:100},
          {field:'baseid',title:'基地',width:100}, 
          {field:'inputName',title:'商品名称',width:100},
          {field:'greenhousename',title:'大棚',width:100},
	      {field:'purchaseCount',title:'使用数量',width:100},   
	      {field:'unitPrice',title:'平均单价（元）',width:100,align:'right'},   
	      {field:'totalprice',title:'总价（元）',width:100,align:'right'},  
	     ]]   
	  }); 
    
	 $('#data-list').datagrid({onLoadSuccess:compute});
	 document.getElementById("ed").onfocus=function(){return new WdatePicker({skin:'whyGreen',dateFmt:'yyyy',minDate:'#F{$dp.$D(\'sd\')}'});}; 	
	 document.getElementById("sd").onfocus=function(){return new WdatePicker({onpicked:function(){ed.focus();},skin:'whyGreen',dateFmt:'yyyy'});}; 
	 $("#state").combobox({
		 onChange: function (n,o) {		
			 gradeChange(n);
		 }
		 });
});

$('#btn-search').bind('click',function(){
	
    var dec= $("#searchForm").serializeObject();
	var te=new Object();
	var subtitle=new Object();
	te.text="商品编号:"+$('#productid').val()+"投放品名称:"+$('#inputid').combobox('getText')+"\n统计时间:"+$('#sd').val()+"至"+$('#ed').val();
	subtitle.text="使用基地："+$('#baseid').combobox('getText')+"  使用大棚："+$('#greehouseids').combobox('getText');
	options.title=te;
	options.subtitle=subtitle;
    var url =  "../statisticsInputs/inputtable.do";
    $.getJSON(url,dec,function(data) {
    	$('#data-list').datagrid('loadData',data);
           var i,len=data.rows.length;      
           var datatemp=[];
           var years=[];
           var strObj = new Object();
           var totalObj = new Object();
           strObj.name = "数量"; 
            totalObj.name="总价";
            var arrCount =[];
            var total=[];
          
            for( i=0;i<len;i++){
              //赋值 series
            	arrCount.push(Number(data.rows[i].purchaseCount));
            	total.push(data.rows[i].purchaseCount * data.rows[i].unitPrice );           	           	
            	years.push(data.rows[i].startTime);
               //对报表X轴显示名称赋值
          } 
            strObj.data = arrCount;
            strObj.yAxis=1;
            strObj.type='column';
            totalObj.data=total;
            totalObj.type='column';
            datatemp.push(strObj);
            datatemp.push(totalObj);
            options.series=datatemp;
            options.xAxis.categories=years;
            var chart = new Highcharts.Chart(options);
 });
    
   // $('#data-list').datagrid
	 var dec= $("#searchForm").serializeObject();
	 $("#data-list").datagrid("load",dec);
	    
	});	
  
function compute() {
    var rows = $('#data-list').datagrid('getRows')//获取当前的数据行
    var total = 0;
    for (var i = 0; i < rows.length; i++) {
    	rows[i]['totalprice'] = rows[i]['purchaseCount'] * rows[i]['unitPrice'];
    	$('#data-list').datagrid('refreshRow', i);
    }
}          
function onSelect(d) {
    var issd = this.id == 'sd', sd = issd ? d : new Date($('#sd').datebox('getValue')), ed = issd ? new Date($('#ed').datebox('getValue')) : d;
        if (ed < sd) {
            alert('结束日期小于开始日期');
            //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
            $('#ed').datebox('setValue', '').datebox('showPanel');
        }
    }

