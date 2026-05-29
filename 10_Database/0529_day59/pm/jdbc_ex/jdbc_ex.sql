USE jdbc_ex1;

CREATE TABLE users (
    id VARCHAR(12) NOT NULL PRIMARY KEY,
    password VARCHAR(12) NOT NULL,
    name VARCHAR(30) NOT NULL,
    role VARCHAR(6) NOT NULL
);

SELECT * FROM users;