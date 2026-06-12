CREATE DATABASE webdb;

CREATE USER webuser@'%' IDENTIFIED BY 'webuser';
GRANT ALL PRIVILEGES ON webdb.* TO webuser@'%';
FLUSH PRIVILEGES;

USE webdb;

CREATE TABLE todo
(
    tno      INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(100) NOT NULL,
    dueDate  DATE         NOT NULL,
    finished TINYINT DEFAULT 0
);

CREATE TABLE member
(
    mid     VARCHAR(100) NOT NULL PRIMARY KEY,
    mpw     VARCHAR(100) NOT NULL,
    mname   VARCHAR(50) NOT NULL
);

INSERT INTO member VALUES ("user", "1111", "홍길동");