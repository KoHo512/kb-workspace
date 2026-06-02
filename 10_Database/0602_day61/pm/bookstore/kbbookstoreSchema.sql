CREATE DATABASE kbbookstore;

CREATE USER kbbookadmin@'%' IDENTIFIED BY '1234';
CREATE USER kbbookadmin@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON kbbookstore.* TO kbbookadmin@'%';
GRANT ALL PRIVILEGES ON kbbookstore.* TO kbbookadmin@'localhost';

FLUSH PRIVILEGES;