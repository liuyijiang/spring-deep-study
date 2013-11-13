create table tb_ship(id int auto_increment primary key ,name varchar(20));
alter table book auto_increment = 5//创建表后修改自增初始值
//修改字段长度
alter table tb_ship modify column name varchar(50) ;
//增加字段：
ALTER TABLE tb_ship ADD createTime Date;