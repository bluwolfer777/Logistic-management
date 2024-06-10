create schema messages;
use messages;
create table user (id int primary key auto_increment, name varchar(100), surname varchar(100), email varchar(100), pp_id int, password varchar(100), settings JSON);
create table session (id int primary key, last_login timestamp, user_id int, FOREIGN KEY (user_id) REFERENCES user(id));
-- create table notification (id int primary key auto_increment, read_time datetime, send_time datetime, user_id int, FOREIGN KEY (user_id) REFERENCES user(id));
create table message (id int primary key auto_increment, text text, s_time datetime, r_time datetime, send_user int, dest_user int, FOREIGN KEY (send_user) REFERENCES user(id), FOREIGN KEY (dest_user) REFERENCES user(id));