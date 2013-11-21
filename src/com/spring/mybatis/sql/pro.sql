-- 简单的无参数返回字符串的存储过程
USE `testejb`;
DROP procedure IF EXISTS `ssd`;

DELIMITER $$
USE `testejb`$$
CREATE PROCEDURE `testejb`.`ssd` (out b varchar(100))
BEGIN
  set b = 'hello you!';
END$$

DELIMITER ;
--------------------------

-- 一个简单得输出值得存储过程
USE `testejb`;
DROP procedure IF EXISTS `ss`;

DELIMITER $$
USE `testejb`$$
CREATE PROCEDURE `testejb`.`ss` (a int,b int,out c int)
BEGIN
  set c =  a + b + 12;
END$$

DELIMITER ;

-------------------

-- 返回值的存储过程
USE `testejb`;
DROP procedure IF EXISTS `showdata`;

DELIMITER $$
USE `testejb`$$
CREATE PROCEDURE `testejb`.`showdata` (pages int)
BEGIN
  declare pageSize integer;
  set pageSize = 10;
  select * from testejb.tb_recod_copy limit pages,pageSize;
END $$

DELIMITER ;
