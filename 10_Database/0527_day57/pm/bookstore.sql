/**
* booksotre 데이터베이스 생성
* 
* bookstore 관리 계정 생성 : bookadmin (비밀번호 : 1234)
*
* bookstore 데이터베이스 안에 테이블 생성
* - customer 테이블
* - book 테이블
* - orders 테이블
*/

CREATE DATABASE bookstore;

CREATE USER bookadmin@localhost IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON bookstore.* TO bookadmin@localhost WITH GRANT OPTION;
