<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>maven</title>
</head>
<style type="text/css">
body 
{
      margin:0px;
      padding:0px;
      background-color:#E7EAEB;
      font-family:"微软雅黑","黑体","宋体";
      font-size:12px;
      height:36px;
            
}  

</style>
<body>
<c:forEach items="${list }" var="opt">
   <xmp>
     <dependency>
      <groupId><c:out value="${opt.groupId }"></c:out></groupId>
      <artifactId><c:out value="${opt.artifactId }"></c:out></artifactId>
      <version><c:out value="${opt.version }"></c:out></version>
    </dependency>
   </xmp>
   <hr /> 
</c:forEach>
</body>
</html>