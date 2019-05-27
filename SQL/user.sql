CREATE DATABASE fm_db DEFAULT CHARACTER SET utf8;
USE fm_db;
CREATE TABLE user(
id SERIAL,
 login_id varchar(255) UNIQUE NOT NULL,
 password varchar(255) NOT NULL,
 name varchar(255) NOT NULL,
 address varchar(255) NOT NULL,
 create_date date NOT NULL,
 point int,
 bad int,
 detail text
 );

