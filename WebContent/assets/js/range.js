function Range(a,b){
	this.a = a;
	this.b = b;
}

Range.prototype = {
   includes:function(x){
	   return this.a + x;
   },
   showall:function(){
	   return this.a + this.b;
   },
   toString:function(){
	   return "(+" + this.a + "--"+this.b+"+)";
   }
};