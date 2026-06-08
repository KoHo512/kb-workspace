CREATE DATABASE product_module;
USE product_module;

CREATE TABLE category
(
    category_id   INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50)  NOT NULL UNIQUE,
    description   VARCHAR(200) NULL
);

CREATE TABLE product
(
    product_id   INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category_id  INT          NOT NULL,
    price        INT          NOT NULL,
    stock        INT          NOT NULL,
    manufacturer VARCHAR(80)  NOT NULL,
    created_at   DATE         NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (category_id)
);

# ----------

CREATE TABLE product
(
    product_id   INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category_id  INT          NOT NULL,
    price        INT          NOT NULL,
    stock        INT          NOT NULL,
    manufacturer VARCHAR(80)  NOT NULL,
    created_at   DATE         NOT NULL,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category (category_id)
);

