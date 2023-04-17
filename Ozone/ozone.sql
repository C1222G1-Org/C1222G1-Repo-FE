create database ozone;
use ozone;
create table account(
	id_account int auto_increment primary key, 
    username varchar(45), 
    password varchar(45), 
    isUser tinyint, 
    isAdmin tinyint
);
create table post(
id_post int auto_increment primary key,
title_post varchar(250),
content_post varchar(10000),
id_account int,
foreign key (id_account) references account(id_account)
);
create table comment(
id_comment int auto_increment primary key,
content_comment varchar(10000),
id_account int,
foreign key (id_account) references account(id_account)
);
insert into account(username, password, isUser, isAdmin)
	values ("totrinh", "123456", 0, 1),
		("doantri", "123456", 1, 0),
        ("viethoang", "123456", 1, 0);