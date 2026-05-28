USE bookstore;


-- SELECT 문

-- 질의 3-1. 모든 도서의 이름과 가격을 검색하시오.
SELECT bookname, price FROM book;

-- 질의 3-1 변형. 모든 도서의 이름과 가격을 검색하시오.
SELECT price, bookname FROM book;

-- 질의 3-2. 모든 도서의 도서 번호, 도서 이름, 출판사, 가격을 검색하시오.
SELECT bookid, bookname, publisher, price FROM book;

-- 질의 3-3. 도서 테이블에 있는 모든 출판사를 검색하시오.
SELECT publisher FROM book;

-- -- 중복을 제거하고 싶으면 DISTINCT 키워드 사용
SELECT DISTINCT publisher FROM book;


-- 조건 검색 : WHERE

-- 질의 3-4. 가격이 20,000원 미만인 도서를 검색하시오.
SELECT * FROM book
WHERE price < 20000;

-- 질의 3-5. 가격이 10,000원 이상 20,000원 이하인 도서를 검색하시오.
SELECT * FROM book
WHERE price BETWEEN 10000 AND 20000;

-- 질의 3-6. 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색하시오.
SELECT * FROM book
WHERE publisher IN ('굿스포츠', '대한미디어');

-- -- 출판사가 '굿스포츠' 혹은 '대한미디어'가 아닌 도서 검색
SELECT * FROM book
WHERE publisher NOT IN ('굿스포츠', '대한미디어');

-- 질의 3-7. '축구의 역사'를 출간한 출판사를 검색하시오.
SELECT bookname, publisher FROM book
WHERE bookname = '축구의 역사';

-- 질의 3-8. 도서 이름에 '축구'가 포함된 출판사를 검색하시오.
SELECT bookname, publisher FROM book
WHERE bookname LIKE '%축구%';

-- 질의 3-9. 도서 이름의 왼쪽 두 번째 위치에 '구'라는 문자열을 갖는 도서를 검색하시오.
SELECT * FROM book
WHERE bookname LIKE '_구%';

-- 질의 3-10. 축구에 관한 도서 중 가격이 20,000원 이상인 도서를 검색하시오.
SELECT * FROM book
WHERE bookname LIKE '%축구%' AND price >= 20000;

-- 질의 3-11. 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색하시오.
SELECT * FROM book
WHERE publisher IN ('굿스포츠', '대한미디어');


-- 검색 결과 정렬 : ORDER BY

-- 질의 3-12. 도서를 이름 순으로 검색하시오.
SELECT * FROM book
ORDER BY bookname;

-- 질의 3-13. 도서를 가격 순으로 검색하고, 가격이 같으면 이름 순으로 검색하시오.
SELECT * FROM book
ORDER BY price, bookname;

-- 질의 3-14. 도서를 가격의 내림차 순으로 검색하시오. 만약 가격이 같다면 출판사의 오름차 순으로 검색하시오.
SELECT * FROM book
ORDER BY price DESC, publisher;


-- 집계 함수
-- -- SUM(), AVG(), COUNT(), MAX(), MIN()

-- 질의 3-15. 고객이 주문한 도서의 총 판매액을 구하시오.
SELECT SUM(saleprice) FROM orders;

-- -- 의미 있는 열 이름을 출력하고 싶으면 속성 이름의 별칭을 지정하는 AS 키워드 사용
SELECT SUM(saleprice) AS '총 매출' FROM orders;

-- 질의 3-16. 2번 김연아 고객이 주문한 도서의 총 판매액을 구하시오.
SELECT SUM(saleprice) AS '총 매출' FROM orders
WHERE custid = 2; 

-- 질의 3-17. 고객이 주문한 도서의 총 판매액, 평균값, 최저가, 최고가를 구하시오.
SELECT SUM(saleprice) TOTAL, AVG(saleprice) AVERAGE, MIN(saleprice) MINIMUM, MAX(saleprice) MAXIMUM
FROM orders;

-- 질의 3-18. 서점의 도서 판매 건 수를 구하시오.
SELECT COUNT(*) FROM orders;


-- GROUP BY 검색

-- 질의 3-19. 고객 별로 주문한 도서의 총 수량과 총 판매액을 구하시오.
SELECT custid, COUNT(*) AS '도서 수량', SUM(saleprice) AS '총액'
FROM orders
GROUP BY custid;

-- 질의 3-20. 가격이 8,000원 이상인 도서를 구매한 고객에 대하여 고객 별 주문 도서의 총 수량을 구하시오. 단, 두 권 이상 구매한 고객만 구한다.
SELECT custid, COUNT(*) AS '도서 수량'
FROM orders
WHERE saleprice >= 8000
GROUP BY custid
HAVING COUNT(*) >= 2;


-- 조인

-- 질의 3-21. 고객과 고객의 주문에 관한 데이터를 모두 보이시오.
SELECT * FROM customer, orders
WHERE customer.custid = orders.custid;

-- 질의 3-22. 고객과 고객의 주문에 관한 데이터를 고객번호 순으로 정렬하여 보이시오.
SELECT * FROM customer, orders
WHERE customer.custid = orders.custid
ORDER BY customer.custid;

-- 질의 3-23. 고객의 이름과 고객이 주문한 도서의 판매 가격을 검색하시오.
SELECT c.name, o.saleprice
FROM customer c, orders o
WHERE c.custid = o.custid;

-- 질의 3-24. 고객 별로 주문한 모든 도서의 총 판매액을 구하고, 고객 별로 정렬하시오.
SELECT c.name, SUM(o.saleprice)
FROM customer c, orders o
WHERE c.custid = o.custid
GROUP BY c.custid
ORDER BY c.name;

-- 질의 3-25. 고객의 이름과 고객이 주문한 도서의 이름을 구하시오.
SELECT c.name, b.bookname
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND o.bookid = b.bookid;

-- 질의 3-26. 가격이 20,000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오.
SELECT c.name, b.bookname, b.price
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND o.bookid = b.bookid AND b.price = 20000;