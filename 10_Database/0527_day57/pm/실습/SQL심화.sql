-- sqldb 데이터베이스에서 다음 조건을 처리하세요.
-- - 사용자 별로 구매 이력 출력
-- - 모든 컬럼 출력
-- - 구매 이력이 없는 정보는 출력하지 않음
USE sqldb;
SELECT * FROM usertbl u
INNER JOIN buytbl b
ON u.userID = b.userID
ORDER BY u.name;

-- 앞의 결과에서 userID가 'JYP'인 데이터만 출력하세요.
USE sqldb;
SELECT * FROM usertbl u
INNER JOIN buytbl b
ON u.userID = b.userID
WHERE u.userID = 'JYP';


-- sqldb 데이터베이스에서 다음 조건을 처리하세요.
-- - 각 사용자 별로 구매 이력 출력
-- - 연결 컬럼은 userID
-- - 결과를 userID 기준으로 오름차 순으로 정렬
-- - 구매 이력이 없는 사용자도 출력
-- - userID, name, prodName, addr, 연락처를 다음과 같이 출력
SELECT u.userID, u.name, b.prodName, u.addr, CONCAT(u.mobile1, u.mobile2) AS 연락처
FROM usertbl u
LEFT OUTER JOIN buytbl b
ON u.userID = b.userID
ORDER BY u.userID;

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력하세요.
SELECT * FROM usertbl
WHERE mobile1 IS NOT NULL;

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람만 출력하세요.
SELECT * FROM usertbl
WHERE mobile1 IS NULL;