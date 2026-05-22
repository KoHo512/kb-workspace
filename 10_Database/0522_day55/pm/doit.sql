-- JustDoIt 데이터베이스 생성
CREATE DATABASE JustDoIt;
DROP DATABASE JustDoIt;

USE JustDoIt;

-- doit_tabe 테이블 생성
CREATE TABLE doit_table (
	col_1 INT, col_2 VARCHAR(30), col_3 DATETIME
);

DESCRIBE doit_table;
DROP TABLE doit_table;

-- doit_dml 테이블 생성
CREATE TABLE doit_dml (
	col_1 INT, 
    col_2 VARCHAR(30), 
    col_3 DATETIME
);
DESC doit_dml;

-- doit_dml 테이블에 데이터 삽입
SELECT * FROM doit_dml;

INSERT INTO doit_dml(col_1) values (2);
INSERT INTO doit_dml(col_1, col_2, col_3) values (2, 'kb', '2026-05-22');
INSERT INTO doit_dml(col_2, col_1, col_3) values ('kb', 3, '2026-05-22');
INSERT INTO doit_dml values (4, 'kb', '2026-05-22');
-- 테이블에서 컬럼의 순서는 상관 없다 - 각 컬럼의 타입과 값의 타입이 일치하면 된다

INSERT INTO doit_dml(col_1, col_2, col_3)
VALUES (5, 'kb', '2026-05-22'), 
(6, 'kb', '2026-05-22'), 
(7, 'kb', '2026-05-22'), 
(8, 'kb', '2026-05-22'), (9, 'kb', '2026-05-22'), (10, 'kb', '2026-05-22');