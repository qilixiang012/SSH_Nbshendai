create database spring;
use spring;
create table user (id int primary key auto_increment,username varchar(20),loginPassword varchar(20),mobile int,email varchar(30),money int default 0);
create table userDetail (id int primary key auto_increment,company varchar(30),contact varchar(20),area varchar(30),phone int,period varchar(30),industry varchar(30),remark varchar(50),amount int,userid int,time timestamp not null default current_timestamp);
create table loan(id int primary key auto_increment,name varchar(30),rate int,startTime Date,endTime Date,remainMoney int,finish bit,userdetailid int);
create table invest(id int primary key auto_increment,money int,loanid int,userid int,applyTime Date,rate int,foreign key (loanid) references loan (id),foreign key (userid) references user (id));




