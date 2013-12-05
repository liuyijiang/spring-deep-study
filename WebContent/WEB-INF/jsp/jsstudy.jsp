<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../jsconfig.jsp"%>
<title>Insert title here</title>
</head>
<body>
js test Window对象
<button id="ss" >ss</button>
<script type="text/javascript">
Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	};

// var cal = {
//   operand1:1,
//   operand2:1,
//   add: function(){
// 	  this.result = this.operand1 + this.operand2;
//   },
//   up:function(a,b){
// 	  alert(a+b);
//   }
// };
// cal.add();
// alert(cal.result);
// alert(cal.up(1,3));
// alert(24);
// var dd = {
// 	m:function(arry){
		
// 	}	
// };
// var a1 = new Array();
// var a2 = "";
// dd.m(a1);
// dd.m(a2);

// function sq(x){
// 	return x*x;
// }
// var sp = function(f){
// 	alert(f);
// };
// var sd = sq;
// alert(sq(4));
// alert(sd(3));
// sp(45);

//匿名函数 可以防止代码被污染
// (function(){
// 	var ss = "ss";
// 	alert(ss);
// }());

//js面向对象
// var ranges = new Range(2,4);
// alert(ranges.showall());
// var url = "http://localhost:8081/springdeepstudy/bajaxget";
// var callserver = new Ajaxcall(url,{"startTime":"2012-12-11","endTime":"2012-12-21","type":1});
// callserver.callWithoutParm();


// function ss(){
// 	$.ajax({
// 		url : "http://localhost:8081/springdeepstudy/bajaxget",
// 		type : "GET",
// 		cache : false,
// 		async : false,
// 		dataType : "json",
// 		contentType: "application/json;",   
// 		success : function(item) {
// 		    alert(item.name);
// 		}
// 	 }); 
// }

//
(function tt($){ //$ jquery
// 	var url = "http://localhost:8081/springdeepstudy/bajaxget";
// 	var callserver = new Ajaxcall($,url,{"startTime":"2012-12-11","endTime":"2012-12-21","type":1});
// 	callserver.callWithoutParm();

// 	var show = function(event){
// 		alert(event.data.name);
// 	};
	
// 	var d = {name:"liuyijiang"};
	
// 	var callserver = new Ajaxcall("ss","ss");
	
// 	$("#ss").bind("click",d,callserver.shownumber);
	
})(jQuery);

// function t(){
// 	var url = "http://localhost:8081/springdeepstudy/bajaxget";
// 	var callserver = new Ajaxcall(url,{"startTime":"2012-12-11","endTime":"2012-12-21","type":1});
// 	callserver.callWithoutParm();
// }

</script>
<button id="ss2" onclick="t()">111ss</button>
<p><input id="cc" /></p>
</body>
</html>