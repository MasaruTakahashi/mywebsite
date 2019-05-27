USE fm_db;
CREATE TABLE item_comment(
id SERIAL,
item_id int,
user_id int,
detail text,
create_date date
);
