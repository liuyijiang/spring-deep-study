<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../baseconfig.jsp"%>
<title>Insert title here</title>
</head>
<body>
<h1>同步上传</h1>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">  
  <input name="imgFile" id="imgFile" type="file" /> 
  <input type="submit" /> 
</form> 
<br />
<hr />
<h1>ajax上传_ajaxfileupload.js</h1>
<form method="post" enctype="multipart/form-data">  
  <input name="imgFile" id="fileToUpload" type="file" /> 
</form> 
<input type="button" onclick="ajaxFileUpload()" value="上传"/> 
<script type="text/javascript"> 
   
   var path = '${pageContext.request.contextPath}';

   function validateImage() {
  	  return true;
   }
  
  
	function ajaxFileUpload()
	{   
		if(validateImage()){
			var datas = {"type":22,"startTime":"2012-年-33","endTime":"2013-12-11"};
			$.ajaxFileUpload
			(
				{
					url:path + "/uploadajax",
					secureuri:false,
					fileElementId:'fileToUpload',
					dataType: 'json',
					data:datas,
					success: function (data, status)
					{  
						alert(1);
					},
					error: function (data, status, e)
					{
						alert(2);
					}
				}
			);
		}
	}
	</script>
<hr />	
<h1>ajax上传_jquery.form.js</h1>
<a href="http://malsup.com/jquery/form/#getting-started" >教程</a>
<form id="fileform" action="${pageContext.request.contextPath}/uploadajaxfrom" method="post" enctype="multipart/form-data">  
  <input name="image"  type="file" /> 
  <input name="name" />
  <input name="sex" />
   <input type="submit" value="上传"/> 
</form> 
<!-- <input type="button" onclick="ajaxFileUpload()" value="上传"/>  -->

<script type="text/javascript">

$(document).ready(function() { 
    var options = { 
        target:        '#output2',   // target element(s) to be updated with server response 
        //beforeSubmit:  showRequest,  // pre-submit callback 
        success:       successRes , // post-submit callback 
 
        // other available options: 
        url:  path + "/uploadajaxfrom",      // override for form's 'action' attribute 
        //type:      type        // 'get' or 'post', override for form's 'method' attribute 
        dataType:'json'      // 'xml', 'script', or 'json' (expected server response type) 
        //clearForm: true        // clear all form fields after successful submit 
        //resetForm: true        // reset the form after successful submit 
 
        // $.ajax options can be used here too, for example: 
        //timeout:   3000 
    }; 
 
    // bind to the form's submit event 
    $('#fileform').submit(function() { 
    	 //e.preventDefault(); // 在事件处理最开始加上这句，以确保可以取消浏览器默认行为
        // inside event callbacks 'this' is the DOM element so we first 
        // wrap it in a jQuery object and then invoke ajaxSubmit 
        $(this).ajaxSubmit(options); 
 
        // !!! Important !!! 
        // always return false to prevent standard browser submit and page navigation 
        return false; 
    }); 
});
  
function successRes(jsonData){
	   alert(jsonData.message);
	}
</script>
</body>
</html>