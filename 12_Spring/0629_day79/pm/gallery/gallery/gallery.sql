CREATE DATABASE gallery;
CREATE USER gallery_admin@'%' IDENTIFIED BY 'gallery_admin';
GRANT ALL PRIVILEGES ON gallery.* TO gallery_admin@'%';

USE gallery;

CREATE TABLE items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    img_path VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    discount_per INT NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE members (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    login_id VARCHAR(50) NOT NULL UNIQUE,
    login_pw VARCHAR(100) NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE carts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL,
    item_id INT NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(500) NOT NULL,
    payment VARCHAR(10) NOT NULL,
    card_number VARCHAR(16) NULL,
    amount BIGINT NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE order_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    item_id INT NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO items (name, img_path, price, discount_per)
VALUES ('Starry', '/img/001.jpg', 10000000, 5),
       ('Seascape', '/img/002.jpg', 20000000, 10),
       ('Arles', '/img/003.jpg', 30000000, 15),
       ('Mountain', '/img/004.jpg', 40000000, 20),
       ('Provence', '/img/005.jpg', 50000000, 25),
       ('Houses', '/img/006.jpg', 60000000, 30);