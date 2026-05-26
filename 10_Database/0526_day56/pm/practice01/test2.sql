USE doitsql;

CREATE TABLE doit_increment(
	col1 INT AUTO_INCREMENT PRIMARY KEY,
    col2 VARCHAR(50),
    col3 INT
);

INSERT INTO doit_increment (col2, col3) VALUES ('1 자동 입력', 1);
INSERT INTO doit_increment (col1, col2, col3) VALUES (NULL, '2 자동 입력', 2);
SELECT * FROM doit_increment;

INSERT INTO doit_increment (col1, col2, col3) VALUES (3, '3 자동 입력', 3);
INSERT INTO doit_increment (col1, col2, col3) VALUES (5, '4 건너뛰고 5 입력', 5);
SELECT * FROM doit_increment;

SELECT LAST_INSERT_ID();	-- 2

ALTER TABLE doit_increment AUTO_INCREMENT=100;
INSERT INTO doit_increment (col2, col3) VALUES ('시작값 변경 확인', 0);	-- 100
INSERT INTO doit_increment (col2, col3) VALUES ('시작값 변경 확인', 0);	-- 101
SELECT * FROM doit_increment;

SET @@AUTO_INCREMENT_INCREMENT = 5;
INSERT INTO doit_increment (col2, col3) VALUES ('증가값 변경 확인', 0);	-- 106
INSERT INTO doit_increment (col2, col3) VALUES ('증가값 변경 확인', 0);	-- 111
SELECT * FROM doit_increment;

--

CREATE TABLE doit_insert_select_from (
	col1 INT,
    col2 VARCHAR(10)
);
INSERT INTO doit_insert_select_from VALUES (1, 'Do');
INSERT INTO doit_insert_select_from VALUES (2, 'It');
INSERT INTO doit_insert_select_from VALUES (3, 'MySQL');

CREATE TABLE doit_insert_select_to (
	col1 INT,
    col2 VARCHAR(10)
);
INSERT INTO doit_insert_select_to
SELECT * FROM doit_insert_select_from;
SELECT * FROM doit_insert_select_to;

CREATE TABLE doit_select_new AS (SELECT * FROM doit_insert_select_from);
SELECT * FROM doit_select_new;

--

CREATE TABLE doit_parent (
	col1 INT PRIMARY KEY,
    col2 DATE
);
CREATE TABLE doit_child (
	id INT AUTO_INCREMENT PRIMARY KEY,
	col1 INT,
    col2 DATE
);
DESC doit_parent;
DESC doit_child;

ALTER TABLE doit_child
ADD FOREIGN KEY (col1) REFERENCES doit_parent (col1);

INSERT INTO doit_child VALUES (NULL, 1, '2026-05-26');	-- Error Code: 1452

INSERT INTO doit_parent VALUES (1, '2026-05-26');
INSERT INTO doit_child VALUES (NULL, 1, '2026-05-26');
INSERT INTO doit_child VALUES (NULL, 1, '2026-05-27');

DELETE FROM doit_parent WHERE col1 = 1;	-- Error Code: 1451

DELETE FROM doit_child WHERE id = 6;
DELETE FROM doit_child WHERE id = 11;
DELETE FROM doit_parent WHERE col1 = 1;

DROP TABLE doit_parent;	-- Error Code: 3730

DROP TABLE doit_child;
DROP TABLE doit_parent;

--

CREATE TABLE doit_parent (col1 INT PRIMARY KEY);
CREATE TABLE doit_child (col1 INT);

SHOW CREATE TABLE doit_child;

ALTER TABLE doit_child
ADD CONSTRAINT fk_doit_child_parent FOREIGN KEY (col1) 
REFERENCES doit_parent (col1) ON DELETE CASCADE;

SELECT * FROM information_schema.KEY_COLUMN_USAGE
WHERE table_schema = DATABASE() AND table_name = 'doit_child';

DROP TABLE doit_parent;	-- Error Code: 3730

ALTER TABLE doit_child
DROP CONSTRAINT fk_doit_child_parent;
DROP TABLE doit_parent;