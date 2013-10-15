<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../jsconfig.jsp"%>
<title>Insert title here</title>
</head>
<body>
<p>jquery study</p>
<p>开发JQuery插件标准结构</p>
<p>
　1，定义作用域：定义一个JQuery插件，首先要把这个插件的代码放在一个不受外界干扰的地方。如果用专业些的话来说就是要为这个插件定义私有作用域。外部的代码不能直接访问插件内部的代码。
  插件内部的代码不污染全局变量。在一定的作用上解耦了插件与运行环境的依赖
  //step01 定义JQuery的作用域
(function ($) {

})(jQuery);
#################################
　2，为JQuery扩展一个插件：当定义好了JQuery的作用域后，最核心也是最迫切的一步就是为这个JQuery的实例添加一个扩展方法。首先我们为这个Jqury插件命名一个方法，
  叫easySlider，当在调用这个插件的时候， 我们可以通过options来给这个插件传递一些参数。具体的定义方法看如下代码：
 //step01 定义JQuery的作用域
(function ($) {
    //step02 插件的扩展方法名称
    $.fn.easySlider = function (options) {
        
    }
})(jQuery);
################################
3，设置默认值：定义一个JQuery插件，就像定义一个.net控件。一个完美的插件，应该是有比较灵活的属性。
//step01 定义JQuery的作用域
(function ($) {
    //step03-a 插件的默认值属性
    var defaults = {
        prevId: 'prevBtn',
        prevText: 'Previous',
        nextId: 'nextBtn',
        nextText: 'Next'
        //……
    };
    //step02 插件的扩展方法名称
    $.fn.easySlider = function (options) {
        //step03-b 合并用户自定义属性，默认属性
        var options = $.extend(defaults, options); //表示 options 去覆盖了defaults的值，并把值赋给了options。在插件环境中，就表示用户设置的值，覆盖了插件的默认值；如果用户没有设置默认值的属性，还是保留插件的默认值
    }
})(jQuery);
#############################
完整
//step01 定义JQuery的作用域
(function ($) {
    //step03-a 插件的默认值属性
    var defaults = {
        prevId: 'prevBtn',
        prevText: 'Previous',
        nextId: 'nextBtn',
        nextText: 'Next'
        //……
    };
    //step06-a 在插件里定义方法
    var showLink = function (obj) {
        $(obj).append(function () { return "(" + $(obj).attr("href") + ")" });
    }

    //step02 插件的扩展方法名称
    $.fn.easySlider = function (options) {
        //step03-b 合并用户自定义属性，默认属性
        var options = $.extend(defaults, options);
        //step4 支持JQuery选择器
        //step5 支持链式调用
        return this.each(function () {
            //step06-b 在插件里定义方法
            showLink(this);
        });
    }
})(jQuery);
</p>
<button onclick="$.fun1();">test</button>
<button onclick="$(this).fun2();">test2</button>
<button onclick="t()">test3</button>
<button onclick="t2()">test4</button>
<p>
$.extend(object) 可以理解为JQuery 添加一个静态方法。
</p>
<p>
$.fn.extend(object) 可以理解为JQuery实例添加一个方法。
</p>
<hr />
<p id="mess">
$(document).ready(function(){}); 比window onload 好
</p>
<table class="dataintable">
<tbody><tr>
<th>语法</th>
<th>描述</th>
</tr>

<tr>
<td>$(this)</td>
<td>当前 HTML 元素</td>
</tr>

<tr>
<td>$("p")</td>
<td>所有 &lt;p&gt; 元素</td>
</tr>

<tr>
<td>$("p.intro")</td>
<td>所有 class="intro" 的 &lt;p&gt; 元素</td>
</tr>

<tr>
<td>$(".intro")</td>
<td>所有 class="intro" 的元素</td>
</tr>

<tr>
<td>$("#intro")</td>
<td>id="intro" 的元素</td>
</tr>

<tr>
<td>$("ul li:first")</td>
<td>每个 &lt;ul&gt; 的第一个 &lt;li&gt; 元素</td>
</tr>

<tr>
<td>$("[href$='.jpg']")</td>
<td>所有带有以 ".jpg" 结尾的属性值的 href 属性</td>
</tr>

<tr>
<td>$("div#intro .head")</td>
<td>id="intro" 的 &lt;div&gt; 元素中的所有 class="head" 的元素</td>
</tr>
</tbody></table>
<hr />
<p>jquery选择器</p>
<script language="JavaScript" type="text/javascript">
(function ($) {
	 
	 var ss = function tests(){
		 alert(123);
	 };
	 
	 $.extend({ fun1: function () { alert("执行方法一"); } });
	 $.fn.extend({ fun2: function () { alert("执行方法2"); } });
	
	 
})(jQuery);

function t(){
	$("#mess").html(new Date()+"t1");
}

function t2(){
	jQuery("#mess").html(new Date()+"t2");
}

</script>
</body>
</html>