<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="../../jqueryeasyui.jsp"%>
</head>
<body onload="init()">

<!-- 使用html方式构建 -->
    <div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
    <div title="Tab1" style="padding:20px;display:none;">
    tab1
    </div>
    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
    tab2
    </div>
    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">
      
      <div id="p" class="easyui-panel" title="My Panel"
    style="width:500px;height:150px;padding:10px;background:#fafafa;"
    data-options="iconCls:'icon-save',closable:true,
    collapsible:true,minimizable:true,maximizable:true">
    <p>panel content.</p>
    <p>panel content.</p>
    </div>
      
    </div>
    </div>

<!-- 使用js方式构建 -->
<div id="ps" style="padding:10px;">
	<p>panel content.</p>
	<p><button onclick="move()">移动</button></p>
</div>

<script type="text/javascript">
    function init(){
    	$('#ps').panel({
  		  width:500,
  		  height:150,
  		  maximizable:true,//最大
  		  closable:true,//关闭按钮
  		  collapsible:true,//收缩
  		  title:'My Panel',
  		  tools:[{
  		       iconCls:'icon-add',
  		       handler:function(){alert('new');}
  		     },
  		     {
  		       iconCls:'icon-save',
  		       handler:function(){alert('save');}
  		     }]
  	 }); 
    }
  
    function move(){
    	alert(2);
    	$('#ps').panel('move',{
            left:1600,
            top:1600
        }); 
    }
    
</script>

</body>
</html>