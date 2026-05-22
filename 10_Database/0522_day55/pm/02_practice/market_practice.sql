-- market_db를 선택하세요 
USE market_db;

-- 회원(member)테이블을 조회하세요
DESC member;

-- 회원(member)테이블에서 회원이름(mem_name)만 조회(출력)하세요
SELECT mem_name FROM member;

-- 회원(member)테이블에서 주소, 데뷔일자, 이름을 각 주소, 데뷔일자, 이름으로 별칭(alias)을 주어서 출력하세요
SELECT addr AS 주소, debut_date AS 데뷔일자, mem_name AS 이름 FROM member;

-- 회원(member)테이블에서 회원의 이름이 '블랙핑크'의 정보를 출력하세요
SELECT * FROM member WHERE mem_name = '블랙핑크';

-- 회원(member)테이블에서 인원수(mem_number)가 4명인 아이돌그룹의 정보를 출력하세요
SELECT * FROM member WHERE mem_number = 4;

-- 회원(member)테이블에서 평균키가 162이하인 회원을 검색하여 출력하세요
SELECT * FROM member WHERE height <= 162;

-- 회원(member)테이블에서 평균키가 165 이상이면서 인원이 6명 초과인 회원의 정보를 출력하세요
SELECT * FROM member WHERE height >= 165 and mem_number > 6;

-- 회원(member)테이블에서 평균키가 165 이상이거나 인원이 6명 초과인 회원의 정보를 출력하세요
SELECT * FROM member WHERE height >= 165 or mem_number > 6;

-- 회원(member)테이블에서 평균키가 163과 165 사이인 회원의 정보를 출력하세요
SELECT * FROM member WHERE height >= 163 and height <= 165;
SELECT * FROM member WHERE height BETWEEN 163 AND 165;

-- 회원(member)테이블에서 회원의 주소가 경기, 전남, 경남에 거주중인 회원의 정보를 출력하세요
SELECT * FROM member WHERE addr IN ('경기', '전남', '경남');

-- 회원(member)테이블에서 회원의 이름중 '우'로 시작하는 회원의 정보를 모두 출력하세요
SELECT * FROM member WHERE mem_name LIKE '우%';

-- 회원(member)테이블에서 이름이 '핑크'로 끝나는 회원의 정보를 출력하세요
SELECT * FROM member WHERE mem_name LIKE '%핑크';

-- 회원(member)테이블에서 이름이 '에이핑크'인 회원의 평균키가 보다 큰 회원의 정보를 출력하세요
SELECT * FROM member WHERE height > (SELECT height FROM member WHERE mem_name = '에이핑크');