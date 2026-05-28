-- 조인

-- 질의 3-22. 고객과 고객의 주문에 관한 데이터를 고객번호 순으로 정렬하여 보이시오.
SELECT * FROM customer c, orders o
WHERE c.custid = o.custid
ORDER BY c.custid;

-- 질의 3-23. 고객의 이름과 고객이 주문한 도서의 판매 가격을 검색하시오.
SELECT c.name, o.saleprice
FROM customer c, orders o
WHERE c.custid = o.custid;

-- 질의 3-24. 고객 별로 주문한 모든 도서의 총 판매액을 구하고, 고객 별로 정렬하시오.
SELECT c.name, SUM(o.saleprice)
FROM customer c, orders o
WHERE c.custid = o.custid
GROUP BY c.name
ORDER BY c.name;

-- 질의 3-25. 고객의 이름과 고객이 주문한 도서의 이름을 구하시오.
SELECT c.name, b.bookname
FROM customer c, orders o, book b
WHERE c.custid = o.custid AND o.bookid = b.bookid;

-- 질의 3-26. 가격이 20,000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오.
SELECT c.name, b.bookname
FROM customer c, orders o, book b
WHERE c.custid = o.custid AND o.bookid = b.bookid AND b.price = 20000;

-- 질의 3-27. 도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매 가격을 구하시오.
SELECT c.name, o.saleprice
FROM customer c
LEFT OUTER JOIN orders o
ON c.custid = o.custid;


-- 부속 질의 (Sub Query)

-- 질의 3-28. 가장 비싼 도서의 이름을 보이시오.
SELECT MAX(price) FROM book;	-- 35000
SELECT bookname FROM book
WHERE price = 35000;

SELECT bookname FROM book
WHERE price = (SELECT MAX(price) FROM book);

-- 질의 3-29. 도서를 구매한 적이 있는 고객의 이름을 검색하시오.
SELECT DISTINCT c.name
FROM customer c, orders o
WHERE c.custid = o.custid;

--

SELECT DISTINCT custid FROM orders;	-- 1, 2, 3, 4
--
SELECT name
FROM customer
WHERE custid in (1, 2, 3, 4);
-- 최종
SELECT name
FROM customer
WHERE custid IN (SELECT custid FROM orders);

-- 질의 3-30. 대한미디어에서 출판한 도서를 구매한 고객의 이름을 보이시오.
SELECT name
FROM customer
WHERE custid IN (
	SELECT custid 
    FROM orders 
    WHERE bookid IN (
		SELECT bookid 
        FROM book 
        WHERE publisher = '대한미디어'
	)
);

--

SELECT bookname, bookid
FROM book
WHERE publisher = '대한미디어';	-- 3, 4
--
SELECT custid
FROM orders
WHERE bookid IN (SELECT bookid
FROM book
WHERE publisher = '대한미디어');	-- 1
--
SELECT name
FROM customer
WHERE custid = 1;
-- 최종
SELECT name
FROM customer
WHERE custid IN (SELECT custid
FROM orders
WHERE bookid IN (SELECT bookid
FROM book
WHERE publisher = '대한미디어'));