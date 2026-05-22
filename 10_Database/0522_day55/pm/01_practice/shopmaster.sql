USE shop_db;

CREATE TABLE member (
member_id CHAR(8) PRIMARY KEY NOT NULL,
member_name CHAR(5) NOT NULL,
member_address CHAR(20) NULL
);
DESC member;

CREATE TABLE product (
product_name CHAR(4) PRIMARY KEY NOT NULL,
cost INT NOT NULL,
make_date DATE NULL,
company CHAR(5) NULL,
amount INT NOT NULL
);
DESC product;

INSERT INTO member VALUES('TWC', '트와이스','서울');
INSERT INTO member VALUES('BLK', '블랙핑크','경남');
INSERT INTO member VALUES('WMN', '여자친구','경기');
INSERT INTO member VALUES('OMY', '오마이걸', '서울');
INSERT INTO member VALUES('GRL', '소녀시대','서울');
INSERT INTO member VALUES('ITZ', '잇지','경남');
INSERT INTO member VALUES('RED', '레드벨벳','경북');
INSERT INTO member VALUES('APN', '에이핑크','경기');
INSERT INTO member VALUES('IEU', '아이유', '서울');
INSERT INTO member VALUES('MMU', '마마무','전남');

INSERT INTO product VALUES('지갑', 30000, '2026-03-05','COS',100);

SELECT * FROM member;
SELECT * FROM product;

SELECT member_name, member_address FROM member;
SELECT * FROM member WHERE member_name = '아이유';