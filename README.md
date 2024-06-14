# Online Chat APP
## using java servlets

---
### Description
This application was a school project made for sharpening java skills, the objective was to create a web based chat app with servlets as backend running using Apache Tomcat, at the actual status the project is incomplete and not working but planning to finish it in the 2024 summer

---
### Requirements
- Java 19 or newer
- Apache Tomcat 9 or newer
- MySQL 5 or newer (if you want to use MySQL 8 pay attention to use the legacy user login system)

---
### Class diagram
![](diagram.png)

---
### Deployment procedure
create under tomcat application folder the following structure:
```
chat-app
    WEB-INF
        classes
```
1) under the ``WEB-INF`` directory paste the `` web.xml`` file and the ``web`` folder<br>
2) under the ``classes`` directory paste the following classes and packages:
- MessageAPI
- UserAPI
- Util
- Frontend
- UserAPI.java
- MessageAPI.java
- lib

---

On MySQL add the following database code, pay attention that MySQL need to be on the same server of Tomcat
```SQL
create schema messages;
use messages;
create table user (id int primary key auto_increment, name varchar(100), surname varchar(100), 
                   email varchar(100), pp_id int, password varchar(100), settings JSON);
create table session (id int primary key, last_login timestamp, user_id int, 
                      FOREIGN KEY (user_id) REFERENCES user(id));
create table message (id int primary key auto_increment, text text, s_time datetime, r_time datetime, 
                      send_user int, dest_user int, FOREIGN KEY (send_user) REFERENCES user(id), 
                      FOREIGN KEY (dest_user) REFERENCES user(id));
```
