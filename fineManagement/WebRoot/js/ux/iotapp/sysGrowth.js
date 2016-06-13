function createTable(greenhouse,variety,plantationMember,technician,startTime,obj){ 
     var div = document.getElementById("list_table"); 
     var table = document.createElement("table");//创建table
     table.id="table_id";
     table.style="border:1px solid #999999";
     var row = table.insertRow();//创建一行 
     var cell = row.insertCell();//创建一个单元 
     cell.width = "150";//更改cell的各种属性 
   //  cell.style.backgroundColor = "#999999"; 
     cell.innerHTML="<p><font size='5' face='arial'>"+greenhouse+"</font></p>"; 
     cell = row.insertCell();//创建一个单元 
     //cell.border="1px";
     cell.width = "150";//更改cell的各种属性 
     //cell.style.backgroundColor = "#999999"; 
     cell.innerHTML="<p><font size='5' face='arial'>种植品种："+variety+"</font></p>"+"<p><font size='5' face='arial'>种植员："+plantationMember+"</font></p>"+"<p><font size='5' face='arial'>种植时间："+startTime+"</font></p>"; 
     cell= row.insertCell();
     cell.innerHTML="<img src='../plug-in/login/images/video.png' width='80' height='50' />";
     cell.value=obj;
     cell.onclick=tr_click;
     table.onmouseover=cells_color;
     table.onmouseout=cells_color;
     div.appendChild(table); 
 } ;

 function tr_click(){
	 var data=this.value;
	var videoXML = "<?xml version='1.0'?>"
         + "<Parament>"
         + "<MatrixCode>"+data.MatrixCode+"</MatrixCode>"
         + "<MonitorID>"+data.MonitorID+"</MonitorID>"
         + "<CameraID>" + data.CameraID + "</CameraID>"
         + "<CameraName>蓝海-基地-" + data.CameraName + "</CameraName>"
         + "<DeviceIP>"+data.DeviceIP+"</DeviceIP>"
         + "<DevicePort>"+data.DevicePort+"</DevicePort>"
         + "<DeviceType>"+data.DeviceType+"</DeviceType>"
         + "<User>"+data.DeviceIP+"</User>"
         + "<Password>"+data.Password+"</Password>"
         + "<ChannelNum>" + data.ChannelNum + "</ChannelNum>"
         + "<ProtocolType>"+data.ProtocolType+"</ProtocolType>"
         + "<StreamType>"+data.StreamType+"</StreamType>"
         + "<Transmits>"
         + "<Transmit>"
         + "<SrvIp>"+data.SrvIp+"</SrvIp>"
         + "<Port>"+data.Port+"</Port>"
         + "</Transmit>"
         + "</Transmits>"
         + "<CascadeType>0</CascadeType>"
         + "<CameraIndexCode>"+data.CameraIndexCode+"</CameraIndexCode>"
         + "<CascadeServerIp>"+data.CascadeServerIp+"</CascadeServerIp>"
         + "<CascadeServerPort>"+data.CascadeServerPort+"</CascadeServerPort>"
         + "<CmsCascadeId>"+data.CmsCascadeId+"</CmsCascadeId>"
         + "<RegionIndexCode>"+data.RegionIndexCode+"</RegionIndexCode>"
         + "<PagIP>"+data.PagIP+"</PagIP>"
         + "<PagPort>"+data.PagPort+"</PagPort>"
         + "</Parament>"; 
		//videoXML="<?xml version='1.0'?><Parament><MatrixCode>0</MatrixCode><MonitorID>3</MonitorID><CameraID>16</CameraID><CameraName>原粮库采集点_IP通道1</CameraName><DeviceIP>218.59.191.14</DeviceIP><DevicePort>7402</DevicePort><DeviceType>60001</DeviceType><User>ehome</User><Password>224</Password><ChannelNum>0</ChannelNum><ProtocolType>0</ProtocolType><StreamType>0</StreamType><Transmits><Transmit><SrvIp>218.59.191.14:554/</SrvIp><Port>0</Port></Transmit></Transmits><CascadeType>0</CascadeType><CameraIndexCode>224</CameraIndexCode><CascadeServerIp>0.0.0.0</CascadeServerIp><CascadeServerPort>0</CascadeServerPort><CmsCascadeId>0</CmsCascadeId><RegionIndexCode>160225053679409890</RegionIndexCode><PagIP>218.59.191.14</PagIP><PagPort>7402</PagPort></Parament>";
		  var RealTimePlayOcx=document.getElementById("RealTimePlayOcx");
       RealTimePlayOcx.StartTask_Preview_InWnd(videoXML,0);//10.22.48.30是平台中云台管理服务器的IP地址
       RealTimePlayOcx.SetWndNum(1);
       RealTimePlayOcx.PtzSpeed(2);
	 }
 
 //鼠标移动高亮显示
 function cells_color() {
     var oColor, td = event.srcElement
     if (td.tagName != "TD")
         return;
     if (event.type == "mouseover")
         oColor = "#dedede"
     else oColor = "#ffffff"
     tr = td.parentElement
     tb = tr.parentElement
     for (var i = 0; i < tr.cells.length; i++)              //行高亮
         tr.cells[i].bgColor = oColor
     //for (var i = 0; i < tb.rows.length; i++)           //列高亮
     //    tb.rows[i].cells[td.cellIndex].bgColor = oColor
 }
	  
$(function(){
	//createTable("1#大棚","DFDF","dfdf","dfd","2015-45-3");
	var url="";
	$('#btn-search').bind('click',function(){	
	    var dec= $("#searchForm").serializeObject();
	    var url =  "../sysMonitor/queryVideoList.do";	  
	    var div = document.getElementById("list_table");
	    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
	    {
	        div.removeChild(div.firstChild);
	    }
	    $.getJSON(url,dec,function(data) {
	    	for(var i=0;i<data.length;i++){
	    		createTable(data[i].name,data[i].varietyName,data[i].plantationMember,data[i].technician,data[i].startTime,data[i]);
	    	};
	    });
	});
	
	   $("#baseid").combobox({
			url: '../sysBase/loadbaseList.do',
			valueField: 'id',
			textField: 'baseName',
			multiple: false
		});
		$("#greehouseids").combobox({
			url: '../sysGreenhouse/loadGreenhouseList.do',
			valueField: 'id',
			textField: 'name',
			multiple: false
		});
});