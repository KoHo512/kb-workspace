USE sqldb;

-- INNER JOIN
SELECT *
FROM buytbl
INNER JOIN usertbl
ON buytbl.userID = usertbl.userID;

-- OUTER JOIN
SELECT U.userId, U.name, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
LEFT OUTER JOIN buytbl B
ON U.userID = B.userID
ORDER BY U.userId; 

-- 3개의 테이블 조인
CREATE TABLE stdtbl (
	stdName VARCHAR(10) NOT NULL PRIMARY KEY,
	addr CHAR(4) NOT NULL
);
CREATE TABLE clubtbl (
	clubName VARCHAR(10) NOT NULL PRIMARY KEY,
	roomNo CHAR(4) NOT NULL
);
CREATE TABLE stdclubtbl (
	num int AUTO_INCREMENT NOT NULL PRIMARY KEY, 
	stdName VARCHAR(10) NOT NULL,
	clubName VARCHAR(10) NOT NULL,
	FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
	FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

INSERT INTO stdtbl VALUES ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'),('바비킴','서울');
INSERT INTO clubtbl VALUES ('수영','101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');
INSERT INTO stdclubtbl VALUES (NULL, '김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'), (NULL,'은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');

SELECT S.stdName, S.addr, SC.clubName, C.roomNo
FROM stdtbl S
INNER JOIN stdclubtbl SC
ON S.stdName = SC.stdName
INNER JOIN clubtbl C
ON SC.clubName = C.clubName
ORDER BY S.stdName;

SELECT C.clubName, C.roomNo, S.stdName, S.addr
FROM  stdtbl S
INNER JOIN stdclubtbl SC
ON SC.stdName = S.stdName
INNER JOIN clubtbl C
ON SC.clubName = C.clubName
ORDER BY C.clubName;

-- SELF JOIN
CREATE TABLE empTbl (emp CHAR(3), manager CHAR(3), empTel VARCHAR(8));
INSERT INTO empTbl VALUES('나사장',NULL,'0000');
INSERT INTO empTbl VALUES('김재무','나사장','2222');
INSERT INTO empTbl VALUES('김부장','김재무','2222-1');
INSERT INTO empTbl VALUES('이부장','김재무','2222-2');
INSERT INTO empTbl VALUES('우대리','이부장','2222-2-1');
INSERT INTO empTbl VALUES('지사원','이부장','2222-2-2');
INSERT INTO empTbl VALUES('이영업','나사장','1111');
INSERT INTO empTbl VALUES('한과장','이영업','1111-1');
INSERT INTO empTbl VALUES('최정보','나사장','3333');
INSERT INTO empTbl VALUES('윤차장','최정보','3333-1');
INSERT INTO empTbl VALUES('이주임','윤차장','3333-1-1');

SELECT A.emp AS '부하직원', B.emp AS '직속상관', B.empTel AS '직속상관 연락처'
FROM empTbl A
INNER JOIN empTbl B
ON A.manager = B.emp
WHERE A.emp = '우대리';