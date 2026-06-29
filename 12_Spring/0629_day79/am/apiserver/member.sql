DROP TABLE IF EXISTS tbl_member;

CREATE TABLE tbl_member
(
    username    VARCHAR(50) PRIMARY KEY,
    password    VARCHAR(128) NOT NULL,
    email       VARCHAR(50)  NOT NULL,
    reg_date    DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW()
);

DROP TABLE IF EXISTS tbl_member_auth;

CREATE TABLE tbl_member_auth
(
    username VARCHAR(50) NOT NULL,
    auth     VARCHAR(50) NOT NULL,
    PRIMARY KEY (username, auth),
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES tbl_member (username)
);

INSERT INTO tbl_member (username, password, email)
VALUES ('admin', '$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC', 'admin@galapgos.org'),
       ('user0', '$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC', 'user0@galapgos.org'),
       ('user1', '$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC', 'user1@galapgos.org'),
       ('user2', '$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC', 'user2@galapgos.org'),
       ('user3', '$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC', 'user3@galapgos.org'),
       ('user4', '$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC', 'user4@galapgos.org');

SELECT *
FROM tbl_member;

INSERT INTO tbl_member_auth (username, auth)
VALUES ('admin', 'ROLE_ADMIN'),
       ('admin', 'ROLE_MANAGER'),
       ('admin', 'ROLE_MEMBER'),
       ('user0', 'ROLE_MANAGER'),
       ('user0', 'ROLE_MEMBER'),
       ('user1', 'ROLE_MEMBER'),
       ('user2', 'ROLE_MEMBER'),
       ('user3', 'ROLE_MEMBER'),
       ('user4', 'ROLE_MEMBER');

SELECT *
FROM tbl_member_auth
ORDER BY auth;
