<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../jsconfig.jsp"%>
<title>Insert title here</title>
</head>
<body onload="pv_q('8a.amr', 100, 200)">
<p>js 客户端demo</p>
<p>windows</p>
<script language="JavaScript" type="text/javascript">
function pv_q(u, w, h){
var pv='';
pv += '<object width="'+w+'" height="'+h+'" classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B" codebase="http://www.apple.com/qtactivex/qtplugin.cab">';
pv += '<param name="src" value="'+u+'">';
pv += '<param name="controller" value="true">';
pv += '<param name="type" value="video/quicktime">';
pv += '<param name="autoplay" value="true">';
pv += '<param name="target" value="myself">';
pv += '<param name="bgcolor" value="black">';
pv += '<param name="pluginspage" value="http://www.apple.com/quicktime/download/index.html">';
pv += '<embed src="'+u+'" width="'+w+'" height="'+h+'" controller="true" align="middle" bgcolor="black" target="myself" type="video/quicktime" pluginspage="http://www.apple.com/quicktime/download/index.html"></embed>';
pv += '</object>';
document.write(pv);
}
</script>

</body>
</html>