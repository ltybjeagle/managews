$(function () {
     options = {
    		 chart: {
                 renderTo: 'container', //DIV容器ID
              //   type: 'column'//报表类型
                     },
        title: {
            text: 'Monthly Average Temperature',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        xAxis: {
            categories: []
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
                 }
                
                ],
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: []
    };
   
   var chart = new Highcharts.Chart(options);
   
   $("[name = xz]:checkbox").bind("click", function () { 
	 var  datatemp={};
	   $("input[name='xz']:checked").each(function () {
          var val=this.value ;
          datatemp[val]=val;
       });	
	   var url =  "/sysMonitor/queryGraphData.do";	   
	   $.getJSON(url,datatemp,function(data) {
		   options.xAxis.categories=data[0].x;
		   var yaxis=data[0].y;
		   if(yaxis.length==1){
			   options.series=yaxis[0];
		   }else if(yaxis.length>1){
			   options.series=yaxis[0];
			    chart1 = new Highcharts.Chart(options);
			   for(var i=1;i<yaxis.length;i++){
				   AddSeriesData(yaxis[i],data[0].x);
			   }
		   }
		  
	 });
   });
	    
	   
 

   
});

//动态添加序列数据
function AddSeriesData(obj,categories) {
            //添加序列数据属于某个yAxis的时候最好提前判断是否已经有第二个Y轴 如果没有则不执行addSeries()操作
            var yAxisLength = options.yAxis.length;
            if (yAxisLength >=1) {
            	chart1.addAxis({ // Secondary yAxis
                    id : 'rainfall-axis',
                    title : {
                        text : 'Rainfall'
                    },
                    lineWidth : 2,
                    lineColor : '#08F',
                    opposite : true,//位于另一个Y周
                    categories:categories
                });
            	chart1.addSeries({
                    name: obj.name,
                    type: 'spline',
                    yAxis: 'rainfall-axis', //序列数据属于第几个Y轴
                    data: obj.data
                }, true, true);
            } else {
                alert("请天添加Y轴再执行序列数据的添加!");
            }
}
