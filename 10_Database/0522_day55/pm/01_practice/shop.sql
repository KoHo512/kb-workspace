CREATE DATABASE shop_db;
CREATE USER shopmaster@'%' IDENTIFIED BY 'shopmaster';
GRANT ALL ON shop_db.* TO shopmaster@'%' WITH GRANT OPTION;