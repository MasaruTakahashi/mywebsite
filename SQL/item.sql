USE fm_db;
CREATE TABLE item(
id SERIAL,
photo varchar(255) NOT NULL,
name varchar(255) NOT NULL,
price int NOT NULL,
item_state int NOT NULL,
delivery int NOT NULL,
detail text,
user_id int NOT NULL,
item_num int NOT NULL,
create_date date NOT NULL
);

