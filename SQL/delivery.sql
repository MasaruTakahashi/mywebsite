USE fm_db;
CREATE TABLE delivery(
id SERIAL,
detail varchar(256)
);
INSERT INTO delivery(detail) VALUES('送料込み');
INSERT INTO delivery(detail) VALUES('着払い');