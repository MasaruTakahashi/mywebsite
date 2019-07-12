USE fm_db;
CREATE TABLE item_state(
id SERIAL,
detail varchar(256)
);
INSERT INTO item_state(detail) VALUES('新品');
INSERT INTO item_state(detail) VALUES('未使用に近い');
INSERT INTO item_state(detail) VALUES('傷や汚れあり');
INSERT INTO item_state(detail) VALUES('状態が悪い');
