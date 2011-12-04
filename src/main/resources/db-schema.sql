create table if not exists Albums (
id varchar(250) unique, 
title varchar(250),
artist varchar(250),
label varchar(250),
year varchar(250),
image varchar(250),
comment varchar(250),
votes int, 
primary key(id) );
INSERT INTO Albums VALUES (
'1',
'Title1',
'Artist1',
'Label1',
'2001',
'Pictures/albuma.jpg',
'Comment1',
3);
INSERT INTO Albums VALUES (
'2',
'Title2',
'Artist2',
'Label3',
'2003',
'Pictures/albumb.jpg',
'Comment2',
3);
INSERT INTO Albums VALUES (
'3',
'Title3',
'Artist3',
'Label3',
'2006',
'Pictures/albumc.jpg',
'Comment3',
10);

create table if not exists Intros ( 
intro TEXT);
INSERT INTO Intros VALUES (
'<H1> Welcome to the XYZ Fan Club </H1> <P> This is the Blah BLab BLah section....................................!');





create table if not exists Members (
name varchar(30) unique not null, 
email varchar(20), 
address varchar(255), 
homepage varchar(50),
password varchar(10) NOT NULL,
authority varchar(15) default 'ROLE_MEMBER',
primary key(name));
INSERT INTO Members VALUES ('jane','jane@doe.ie','128 Here St Cityname','www.doe.ie','letmein', 'ROLE_MEMBER');
INSERT INTO Members VALUES ('caroline','','Curragh Woods Cork','','letmein', 'ROLE_MEMBER');



create table if not exists Reviews (
id varchar(250) unique, 
albumid varchar(250), 
review varchar(1000), 
name varchar(250),
primary key(id));
INSERT INTO Reviews VALUES ('1','1','Review1.....so on so on so on so on...','caroline');



create table if not exists News ( 
id varchar(250) unique, 
title varchar(50),
article varchar(1000),
date date,
primary key(id));
INSERT INTO News VALUES ('1','New Album','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','2011-12-11');
INSERT INTO News VALUES ('2','New Release','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','2011-12-19');
INSERT INTO News VALUES ('3','Award Win','BlahBlahBlahBlahBlahBlahBlahBlahBlahBlahBlah','2011-12-20');
