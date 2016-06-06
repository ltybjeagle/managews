$package('finems.environmental');
finems.environmental = function() {
	var _box = null;
	  options = {
	            chart: {
	                   renderTo: 'container', //DIV容器ID
	                //   type: 'column'//报表类型
	                       },             
	              title:{
	                   text:''
	                      },  
	        subtitle: {
	                   text: ''
	                  },
	          loading:{
	        	       text:'加载中'
	          },
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
                         text: '',
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
                                text: '',
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
	var _this = {
			config: {
				event: {
					edit: function() {
						_box.handler.edit(function(result) {
							debugger;
							$("#MonitorNum").combobox('select', result.data.name);
						});
					}
				},
				dataGrid: {
					title: '环境监控',
					url: 'dataList.do',
					columns: [[         
					           {field: 'receivedTime', title: '时间', width: 100, sortable: true},
					           {field: 'airTemperature', title: '空气温度℃', width: 100, sortable: true},
					           {field: 'airHumidity', title: '空气湿度%', width: 100, sortable: true},
					           {field: 'photosyntheticRadiation', title: '光合有效辐射（umol/m^2*s）', width: 180, sortable: true},
					           {field: 'soilHumidity', title: '土壤湿度%', width: 120, sortable: true},
					           {field: 'soilEC', title: '土壤EC值（ms/cm）', width: 120, sortable: true},
					           {field: 'infraredTemperature', title: '叶片温度℃', width: 80, sortable: true},
					           ]]
				}
			},
			init: function () {
				$("#MonitorNum").combobox({
					url: '../sysMonitor/loadMonitorNumList.do',
					valueField: 'monitorNum',
					textField: 'name'
						});
				_box = new YDataGrid(_this.config);
				_box.init();
				 var chart = new Highcharts.Chart(options);
				 
				   $("[name = xz]:checkbox").bind("click", function () { 
						 var  datatemp=[];
						 var x=[];						
						 var rows = $("#data-list").datagrid("getRows");
						 for(var i=0;i<rows.length;i++)
				          {
				          //获取每一行的数据
				         x.push( rows[i].receivedTime);//假设有id这个字段					            			   
				          }	
						 options.xAxis.categories=x;
						   $("input[name='xz']:checked").each(function () {
					          var val=this.value ;
					         debugger;
					          var obj=new Object();	
					          var y=[];
					          for(var i=0;i<rows.length;i++)
					          {					        	
					          //获取每一行的数据						        	
					            y.push(Number(rows[i][val]));						           
					          }	
					          obj.name=this.nextSibling.nodeValue;
					          obj.data=y;
					          datatemp.push(obj);
					       });	
						   options.series=datatemp;
						   var chart = new Highcharts.Chart(options);
//						   var url =  "/sysMonitor/queryGraphData.do";	   
//						   $.getJSON(url,datatemp,function(data) {
//							   options.xAxis.categories=data[0].x;
//							     var datay=[];var tmp= data[0].y;
//							     for(var i=0,l=tmp.length;i<l;i++){
//							    	 var obj=new Object();
//							    	 obj.name=tmp[i].name;
//							    	 var vo= tmp[i].data;
//							    	 var st=[];
//							    	for(var j=0,h=vo.length; j<h;j++){
//							    		st.push(Number(vo[j]));
//							    	}
//							    	 obj.data=st;
//							    	 datay.push(obj);
//							     }
//							   options.series=datay;
//							   var chart = new Highcharts.Chart(options);
//						 });
					   });
			}
	}
	return _this;
}();


$(function(){
	finems.environmental.init();	
	 document.getElementById("ed").onfocus=function(){return new WdatePicker({skin:'whyGreen',dateFmt:'yyyy',minDate:'#F{$dp.$D(\'sd\')}'});}; 	
	 document.getElementById("sd").onfocus=function(){return new WdatePicker({onpicked:function(){ed.focus();},skin:'whyGreen',dateFmt:'yyyy'});}; 
	 $("#state").combobox({
		 onChange: function (n,o) {		
			 gradeChange(n);
		 }
		 });

});