-- 创建 数据库
CREATE SCHEMA `java32` DEFAULT CHARACTER SET utf8mb4 ;

-- 查看当前的所有数据库名称
SHOW DATABASES ;

-- 删除数据库
DROP DATABASE `java32_2021_04_14` ;

-- 查看建库语句
SHOW CREATE DATABASE `java32`;

-- 设置默认库
USE `java32` ;

-- 建表
CREATE TABLE `java32`.`students` (
    `sid` INT PRIMARY KEY,
    `name` VARCHAR(45),
    `birthday` DATETIME,
    `gender` CHAR(1)
);

CREATE TABLE `java32`.`goods` (
    `gid` INT NOT NULL,
    `gname` VARCHAR(45) NULL,
    `price` INT NULL COMMENT '单位是角',
    `category` VARCHAR(45) NULL COMMENT '类别',
    `provider` VARCHAR(45) NULL COMMENT '供应商',
    PRIMARY KEY (`gid`)
);
  
CREATE TABLE `java32`.`customers` (
    `cid` INT NOT NULL,
    `cname` VARCHAR(45) NULL,
    `address` VARCHAR(45) NULL,
    `phone` CHAR(11) NULL,
    `wechart` VARCHAR(45) NULL,
    PRIMARY KEY (`cid`)
)  COMMENT='顾客表';

CREATE TABLE `java32`.`indents` (
    `iid` INT NOT NULL,
    `cid` INT NOT NULL,
    `bought_at` DATETIME NOT NULL,
    `gid` INT NOT NULL,
    `price` INT NOT NULL COMMENT '单位是角',
    `number` INT NOT NULL,
    PRIMARY KEY (`iid`)
)  COMMENT='购买记录表
谁 何时 购买了 什么，一共多少件，当时的单价是单价';

-- 删除表
DROP TABLE indents;

-- 修改表
-- ALTER TABLE indents (....)

-- 查看当前库下有哪些表
SHOW TABLES;

-- 查看表的结构
DESC indents;
SHOW CREATE TABLE indents;
















-- 数据的插入
-- 单行 + 全列
INSERT INTO goods 
	VALUES (1, '手机', 1000, '家用电器', "华为");
    
-- 单行 + 指定列
INSERT INTO goods (gname, gid, price)
    VALUES ("手表", 2, 100);
    
-- 批量 + 全列
INSERT INTO goods VALUES
	(3, "饮料", 1000, "食品", "康师傅"),
    (4, "灯泡", 2000, "家用电器", "小米"),
    (5, "笔", 10, "办公用品", null);
    
INSERT INTO students VALUES
	(3, "张三", "1998-04-17", '女'),
    (4, "李四", '1999-12-18', '男');







    
-- 查询
SELECT 1;
SELECT 1 + 1;
SELECT VERSION();
SELECT DATABASE();

-- 全列查询，必须带着 FROM
SELECT 
    *
FROM
    students;
-- 一共多少行，有多少个 1
SELECT 
    1
FROM
    students;
-- 指定列查询
SELECT 
    name
FROM
    students;
SELECT 
    name, gender
FROM
    students;
-- 列可以参与表达式
SELECT 
    gid, price, gid > price
FROM
    goods;
SELECT 
    gid, price, gid - price
FROM
    goods;
-- 列可以参与函数的调用
SELECT 
    name
FROM
    students;
SELECT 
    CONCAT('@', name, '$')
FROM
    students;
-- 去掉重复的数值
SELECT 
    price
FROM
    goods;
SELECT DISTINCT
    price
FROM
    goods;
-- 为查询结果的列指定别名
SELECT 1 + 1 AS 结果;
SELECT 1 + 1 结果;
SELECT 
    name, (birthday < '1999-01-01') + 1 年级
FROM
    students;






SELECT NULL;
SELECT NULL + 1;

CREATE TABLE exam_result (
    id INT,
    name VARCHAR(45),
    chinese DECIMAL(3 , 1 ),
    math DECIMAL(3 , 1 ),
    english DECIMAL(3 , 1 )
);

INSERT INTO exam_result VALUES 
	(1, '唐三藏', 67.00, 98.00, 56.00), 
	(2, '孙悟空', 87.50, 78.00, 77.00), 
	(3, '猪悟能', 88.00, 98.50, 90.00), 
	(4, '曹孟德', 82.00, 84.00, 67.00), 
	(5, '刘玄德', 55.50, 85.00, 45.00), 
	(6, '孙权', 70.00, 73.00, 78.50), 
	(7, '宋公明', 75.00, 65.00, 30.00);
    























