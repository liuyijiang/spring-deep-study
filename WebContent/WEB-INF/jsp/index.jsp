<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://www.waileecn.com/mxk/assets/js/jquery-1.7.2.js"></script>
<a id="a" href="https://192.168.2.150/springdeepstudy/ssllogin">login</a>
<body>
<script type="text/javascript">
     function login(){
        $.getJSON("https://192.168.2.150/springdeepstudy/SSLLoginSyncServlet?jsoncallback=?",
        {
    	   name: "111",
    	   psw: "sss"
        },
        function(data) {
         alert("收到返回数据  登陆状态："+data.isAuth+"  错误信息："+data.psw+" "+data.resetnum);
        });
   }
   
     function tt(){
    	 var j = {"type":22,"startTime":"2012-12-33","endTime":"2013-12-11"};
    	 //var j = {"request.type":22,"request.startTime":"2012-12-33","request.endTime":"2013-12-11"};
      	 $.ajax({
    	   		url : "http://192.168.2.200:8081/springdeepstudy/getDataParm",
    	   		type : "POST",
    	   		cache : false,
    	   		async : false,
    	   		dataType : "json",
    	   		contentType: "application/json;",   
    	   		data : JSON.stringify(j),
    	   		success : function(item) {
    	   		    alert(item.name);
    	   		}
    	 }); 
      }  
     
     
</script>
<form method="post" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/getDataParms">
   <input name="type"/>
   <input type="file">
   <input type="submit">
</form>

<button onclick="tt()">ttt</button>
  <input id="loginbtn" type="button" onclick="login()" value="ok" />
 <br /> <br /> <br />
<h1>spring 权限</h1>  
<a href="admin.jsp">进入admin页面</a>
<a href="other.jsp">进入其它页面</a>
</body>
</html>