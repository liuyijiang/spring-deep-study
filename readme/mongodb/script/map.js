var db = db.getSiblingDB("mapdb");
db.places.remove();
new Date();
var lon,lat,place;
for(var i=2;i<10000;i++){
   lon = 179 * Math.random();
   lat = 179 * Math.random();
   place = 'place'+i;
   p = { place: place ,loc : [ lon, lat ] };
   db.places.save(p);

   lon = -179 * Math.random();
   lat = 179 * Math.random();
   place = 'place'+i;
   p = { place: place ,loc : [ lon, lat ] };
   db.places.save(p);

   lon = 179 * Math.random();
   lat = -179 * Math.random();
   place = 'place'+i;
   p = { place: place ,loc : [ lon, lat ] };
   db.places.save(p);

   lon = -179 * Math.random();
   lat = -179 * Math.random();
   place = 'place'+i;
   p = { place: place ,loc : [ lon, lat ] };
   db.places.save(p);
}
new Date();
print("ok");