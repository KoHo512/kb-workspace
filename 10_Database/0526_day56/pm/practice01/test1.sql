CREATE DATABASE doitsql;

USE doitsql;

CREATE TABLE doit_create_table(
	col1 INT,
    col2 VARCHAR(50),
    col3 DATETIME
);

INSERT INTO doit_create_table (col1, col2, col3) 
VALUES (1, '테스트1', '2026-05-26');
COMMIT;	-- 해야 반영됨
SELECT * FROM doit_create_table;

INSERT INTO doit_create_table (col2)
VALUES ('테스트1');

INSERT INTO doit_create_table
VALUES (2, '테스트2', '2026-05-27');

--

CREATE TABLE doit_notnull (
	col1 INT,
	col2 VARCHAR(50) NOT NULL
);

INSERT INTO doit_notnull (col1) VALUES (1);	-- 실패
INSERT INTO doit_notnull (col1, col2) VALUES (1, 'test');
SELECT * FROM doit_notnull;

--

CREATE TABLE doit_dml (
	col1 INT,
    col2 VARCHAR(50) NOT NULL
);

INSERT INTO doit_dml
VALUES (1, 'test1'), (2, 'test2'), (3, 'test3'), (4, 'test4');
COMMIT;
SELECT COUNT(*) FROM doit_dml;

UPDATE doit_dml SET col2 = '데이터 수정'
WHERE col1 = 4;
COMMIT;
SELECT * FROM doit_dml WHERE col1 = 4;

UPDATE doit_dml SET col1 = col1 + 10;	-- 조건을 주지 않으면 전체에 적용
SELECT * FROM doit_dml;

DELETE FROM doit_dml WHERE col1 = 14;
DELETE FROM doit_dml;
SELECT * FROM doit_dml;
COMMIT;
