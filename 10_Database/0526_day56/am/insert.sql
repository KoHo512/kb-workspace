USE sqldb;

CREATE TABLE testTbl1(id INT, username CHAR(3), age INT);

INSERT INTO testTbl1 VALUES(1, '홍길동', 25);
INSERT INTO testTbl1(id, username) VALUES(2, '김길동');	-- 생략하면 NULL
INSERT INTO testTbl1(username, age, id) VALUES('최길동', 26, 3);
SELECT * FROM testTbl1;

--

CREATE TABLE testTbl2(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    username CHAR(3), 
    age INT
);

INSERT INTO testTbl2 VALUES (NULL, '홍길동', 25);
INSERT INTO testTbl2 VALUES (NULL, '김길동', 22);
INSERT INTO testTbl2 VALUES (NULL, '최길동', 21);
SELECT * FROM testTbl2;

INSERT INTO testTbl2 VALUES (4, '박길동', 21);	-- 규칙에 위배되지 않으면 지정 가능
INSERT INTO testTbl2 VALUES (NULL, '정길동', 21);
SELECT * FROM testTbl2;

INSERT INTO testTbl2 VALUES (7, '임길동', 21);
INSERT INTO testTbl2 VALUES (NULL, '유길동', 21);	-- id : 8
SELECT * FROM testTbl2;

DELETE FROM testTbl2;	-- 전체 데이터 삭제
INSERT INTO testTbl2 VALUES (NULL, '홍길동', 25);	-- id : 9
INSERT INTO testTbl2 VALUES (NULL, '김길동', 22);
INSERT INTO testTbl2 VALUES (NULL, '최길동', 21);
SELECT * FROM testTbl2;

--

CREATE TABLE testTbl4(id INT, Fname VARCHAR(50), Lname VARCHAR(50));

INSERT INTO testTbl4
SELECT emp_no, first_name, last_name
FROM employees.employees;
SELECT * FROM testTbl4;

UPDATE testTbl4
SET Lname = '없음'
WHERE Fname = 'Kyoichi';
SELECT * FROM testTbl4;