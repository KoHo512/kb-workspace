DROP DATABASE IF EXISTS tabledb;
CREATE DATABASE tabledb;

USE tabledb;

DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr CHAR(2) NOT NULL,
    mobile1 CHAR(3) NULL,
    mobile2 CHAR(8) NULL,
    height SMALLINT NULL,
    mDATE DATE NULL
);

DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl (
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    userID CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL,
    groupName CHAR(4) NULL,
    price INT NOT NULL,
    amount SMALLINT NOT NULL,
    FOREIGN KEY (userID) REFERENCES usertbl (userID)
);

INSERT INTO usertbl VALUES ('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES ('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES ('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

INSERT INTO buytbl VALUES (NULL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES (NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES (NULL, 'JYP', '모니터', '전자', 200, 1);	-- Error Code: 1452	-- usertbl의 userID에 JYP 없음

DROP TABLE IF EXISTS usertbl2;
CREATE TABLE usertbl2 (
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    CONSTRAINT PRIMARY KEY PK_usertbl2_userID (userID)
);

DROP TABLE usertbl;	-- Error Code: 3730	-- 외래 키로 연결되어 있어 삭제 불가능
DROP TABLE buytbl;

CREATE VIEW v_userbuytbl
AS
SELECT u.userid, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2) AS 연락처
FROM usertbl u
INNER JOIN buytbl b
ON u.userID = b.userID;

SELECT * FROM v_userbuytbl WHERE name = '김범수';