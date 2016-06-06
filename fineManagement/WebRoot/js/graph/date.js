function gradeChange(checkValue){
	switch(checkValue)
	{
	case "year":
		getYear();
		break;
    case "month":
     	getMonth();
		break;
    case "date":
    	getDate();
	break;
		
	}
} 

function  getYear(){
	$("#ed").attr("value","");
	$("#sd").attr("value","");
	document.getElementById("ed").onfocus=function(){return new WdatePicker({skin:'whyGreen',dateFmt:'yyyy',minDate:'#F{$dp.$D(\'sd\')}'});}; 	
	document.getElementById("sd").onfocus=function(){return new WdatePicker({onpicked:function(){ed.focus();},skin:'whyGreen',dateFmt:'yyyy'});}; 
	
}
function  getMonth(){
	$("#ed").attr("value","");
	$("#sd").attr("value","");
	document.getElementById("ed").onfocus=function(){return new WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM',minDate:'#F{$dp.$D(\'sd\')}'});}; 
	document.getElementById("sd").onfocus=function(){return new WdatePicker({onpicked:function(){ed.focus();},skin:'whyGreen',dateFmt:'yyyy-MM'});}; 
}
function  getDate(){
	$("#ed").attr("value","");
	$("#sd").attr("value","");
	document.getElementById("ed").onfocus=function(){return new WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sd\')}'});}; 
	document.getElementById("sd").onfocus=function(){return new WdatePicker({onpicked:function(){ed.focus();},skin:'whyGreen',dateFmt:'yyyy-MM-dd'});}; 
}