function Ajaxcall(url,data){
	this.url = url;
	this.data = data;
}

Ajaxcall.prototype.callwithData = function() {
	$.ajax({
		url : url,
		type : "GET",
		cache : false,
		async : false,
		dataType : "json",
		data:data,
		contentType: "application/json;",   
		success : function(item) {
		    alert(item.name);
		}
	 }); 
},

Ajaxcall.prototype.callWithoutParm = function (){
	$("#cc").html("ssssss123344");//
	$.ajax({//无效
		url : url,
		type : "GET",
		cache : false,
		async : false,
		dataType : "json",
		contentType: "application/json;",   
		success : function(item) {
		    alert(item.name);
		}
	 }); 
};

Ajaxcall.prototype.shownumber = function (){
	//alert(1234567);
	//document.getElementById("cc").value = 1213;
	$("#cc").val(12345678);
	$.ajax({//无效
		url : url,
		type : "GET",
		cache : false,
		async : false,
		dataType : "json",
		contentType: "application/json;",   
		success : function(item) {
		    alert(item);
		}
	 }); 
};

//Ajaxcall.prototype.init = function (method) {
//	$("#ss").bind("click",function(){
//		alert(4);
//		method;
//	});
//};
//Ajaxcall.prototype = {
//   callWithoutParm:function(){
//	   alert(2);
//		$.ajax({
//			url : url,
//			type : "GET",
//			cache : false,
//			async : false,
//			dataType : "json",
//			contentType: "application/json;",   
//			success : function(item) {
//			    alert(item.name);
//			}
//		 }); 
//   }
//};