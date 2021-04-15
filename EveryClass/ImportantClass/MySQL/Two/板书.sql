-- SHOW DATABASES;

-- CREATE DATABASE IF NOT EXISTS java21_2021_04_13;
-- DROP DATABASE IF exists java21_2021_04_13;

-- USE test;

-- create table students (
--   sid INT,
--   name VARCHAR(45)
-- );

-- desc students;

-- show create table students;

-- drop table students;

-- 1. 一次插入一行数据 + 全字段插入
INSERT INTO goods VALUES (1, '电脑', 3000, "学习用品", "小米");

-- 1. 一次插入多行数据 + 全字段插入
INSERT INTO goods VALUES 
	(2, '手机', 2000, "通信用品", "OPPO"),
    (3, "手表", 1000, "办公用品", "杂牌"),
    (4, "耳机", 100, "办公用品", "杂牌");
    
-- 1. 一次插入一行 + 指定字段
INSERT INTO goods (name, gid, unit_price)
    VALUES ('桌子', 5, 1000);
    
-- 1. 支持一次多行 + 指定字段

-- 日期统统这么表示即可
INSERT INTO purcharses VALUES 
	(1, 1, 1, 10, '2021-04-15 17:18:19');


create table exam_result (
	id int,
    name varchar(45),
    eng int,
    chi int,
    mat int
);

INSERT INTO exam_result (id, name, chi, mat, eng) VALUES 
(1, '唐三藏', 67, 98, 56), 
(2, '孙悟空', 88, 78, 77), 
(3, '猪悟能', 88, 99, 90), 
(4, '曹孟德', 82, 84, 67), 
(5, '刘玄德', 55, 85, 45), 
(6, '孙权', 70, 73, 79), 
(7, '宋公明', 75, 65, 30);


SELECT * FROM exam_result;

SELECT name 姓名, chi + 100 as 语文 FROM exam_result;

SELECT VERSION();
SELECT DATABASE();

SELECT DISTINCT chi FROM exam_result;



















