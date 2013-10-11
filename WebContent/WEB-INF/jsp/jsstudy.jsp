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
<script type="text/javascript">
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
var ranges = new Range(2,4);
alert(ranges.showall());

</script>
<button onclick="s()">ss</button>
</body>
</html>