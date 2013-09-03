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
   
</script>
  <input id="loginbtn" type="button" onclick="login()" value="ok" />
</body>
</html>