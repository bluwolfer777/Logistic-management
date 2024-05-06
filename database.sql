create schema logistic;
use logistic;
create table user (id int primary key auto_increment, name varchar(100), surname varchar(100), email varchar(100), pp_id int, password varchar(100));
create table session (id int primary key, expires timestamp, last_login timestamp, user_id int);