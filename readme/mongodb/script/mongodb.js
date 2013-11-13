var db = db.getSiblingDB("mapdb");//获得db
var data = {lng:"30.10132",lat:"103.31312",id:"2"};
db.baidumap.save(data);
print("save ok");
db.baidumap.find().forEach(printjson);//查询后遍历 用json的形式

//###################################################

var db = db.getSiblingDB("mapdb");
db.baidumap.find().forEach(printjson);
print("----------------ok----------------");
var data = {name:"liuyijiang",sex:"1",aga:24};
print(data);
print("-----------------------------------");
printjson(data); //打印出json


//#################################################
db.baidumap.find().forEach(printjson);
print("----------------ok----------------");
var data = {name:"liuyijiang",sex:"1",aga:24};
print(data);
print("-----------------------------------");
printjson(data);
print("---------------forEach--------------------");
db.baidumap.find().forEach(function (doc){
     print(doc);
});
print("---------------collection--------------------");
var cursor = db.baidumap.find()
if ( cursor.hasNext() ){
   print(cursor.next());
}
