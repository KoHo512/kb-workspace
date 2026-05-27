-- -- 데이터 형 변환
-- 데이터 형식 변환 함수 : CAST(), CONVERT()

-- 암시적 형 변환
SELECT '100' + '200';	-- 300
SELECT CONCAT('100', '200');	-- 100200
SELECT CONCAT(100, '200');	-- 100200

SELECT 1 > '2mega';	-- 0
SELECT 3 > '2MEGA';	-- 1	-- 2로 변환하여 비교
SELECT 0 = 'mega2';	-- 1	-- 숫자로 변환 못하는 값은 0으로 변환


-- -- 내장 함수
-- 제어 흐름 함수
SELECT IF (100 > 200, '참', '거짓');	-- 거짓	-- 일종의 3항 연산자

SELECT 1 * NULL;	-- NULL
SELECT 1 = NULL;	-- NULL
SELECT NULL = NULL;	-- NULL	-- NULL에 대한 연산 결과는 항상 NULL

SELECT IFNULL (NULL, '널');	-- 널

SELECT NULLIF (100, 100);	-- NULL	-- 수식1과 수식2가 같으면 NULL
SELECT NULLIF (100, 200);	-- 100	-- 다르면 수식1을 반환

SELECT CASE 10
	WHEN 1 THEN '일'
	WHEN 5 THEN '오'
	WHEN 10 THEN '십'
    END AS '기타';	-- 10

SELECT *
FROM buytbl
WHERE groupName IS NULL;

SELECT *
FROM buytbl
WHERE groupName IS NOT NULL;

-- 문자열 함수
SELECT
CONCAT(groupName, '::', prodName)
FROM buytbl;

SELECT
CONCAT_WS('::', IFNULL(groupName, '없음'), prodName)
FROM buytbl;

SELECT groupName, GROUP_CONCAT(prodName)
FROM buytbl
GROUP BY groupName;