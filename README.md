# Customer
JavaWeb实现客户管理系统

## 客户管理系统数据表结构：
字段名		说明		类型
id		编号		int
name		客户姓名	varchar(20)
gender		性别		varchar(10)
birthday	生日		date
cellphone	手机		varchar(20)
email		电子邮件	varchar(40)
preference	客户爱好	varchar(100)
type		客户类型	varchar(40)
description	备注		varchar(255)

## 使用MySql数据库，数据库创建语句：
CREATE TABLE customer (
	id int primary key auto_increment,
	name varchar(20),
	gender varchar(10),
	birthday date,
	cellphone varchar(20),
	email varchar(40),
	preference varchar(100),
	type varchar(40),
	description varchar(255)
);