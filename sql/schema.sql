create database hotelmanagementsystem;
show databases;

use hotelmanagementsystem;

create table login(username varchar(25),password varchar(25));

insert into login values('admin','12345');

select * from login;

create table employee(name varchar(25), age varchar(10) , gender varchar(15) , job varchar(25),salary DECIMAL(10, 2),phone VARCHAR(10) NOT NULL, aadhar VARCHAR(12) NOT NULL, email VARCHAR(100) NOT NULL UNIQUE);
    
describe employee;

select * from employee;

create table room(roomnnumber varchar(10), availability varchar(20) , cleaning_status varchar(25), price int , bed_type varchar(20));

select * from room;

create table driver(name varchar(20), age varchar(25), gender varchar(25), company varchar(25));

select* from driver;

create table customer(document varchar(20), number varchar(30), name varchar(30) , gender varchar(20), country varchar(20), room varchar(15), checkintime varchar(80), deposit varchar(25));
insert into customer values('Aadhar card', 45625896541,'Samwell','Male','India',102,'Thu apr 07',1000);

select * from customer;

create table department(department varchar(30), budget varchar(30));

insert into department values('Front Office', '500000');
insert into department values('Housekeeping','40000');
insert into department values('Food and Beverage','23000');
insert into department values('Kitchen or Food Production','540000');
insert into department values('Security','320000');

select* from department;

SHOW DATABASES;
USE hotelmanagementsystem;
SHOW TABLES;
DESCRIBE login;

