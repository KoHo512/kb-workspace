DROP DATABASE IF EXISTS bookmarketdb;
CREATE DATABASE bookmarketdb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bookmarketdb;

DROP TABLE IF EXISTS boards;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    userid VARCHAR(50) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    userpassword VARCHAR(100) NOT NULL,
    userage INT,
    useremail VARCHAR(100)
);

CREATE TABLE boards (
    bno INT AUTO_INCREMENT PRIMARY KEY,
    btitle VARCHAR(200) NOT NULL,
    bcontent TEXT,
    bwriter VARCHAR(50) NOT NULL,
    bdate DATETIME DEFAULT CURRENT_TIMESTAMP,
    bfilename VARCHAR(255),
    bfiledata LONGBLOB
);

SELECT * FROM person;
SELECT * FROM users;
SELECT * FROM boards;