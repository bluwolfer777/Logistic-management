create schema logistic;
use logistic;
create table user (id int primary key auto_increment, name varchar(100), surname varchar(100), email varchar(100), pp_id int, password varchar(100));
create table session (id int primary key, expires timestamp, last_login timestamp, user_id int, FOREIGN KEY (user_id) REFERENCES user(id));
create table notification (id int primary key auto_increment, read_time timestamp, send_time timestamp, user_id int, FOREIGN KEY (user_id) REFERENCES user(id));
create table message (id int primary key auto_increment, text varchar(65000), s_time timestamp, r_time timestamp, send_user int, dest_user int, FOREIGN KEY (send_user) REFERENCES user(id), FOREIGN KEY (dest_user) REFERENCES user(id));