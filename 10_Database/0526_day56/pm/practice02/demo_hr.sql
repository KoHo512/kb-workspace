/* root 계정으로 접속 - hr 데이터베이스 생성 - hr 계정 생성 */
CREATE DATABASE hr;
CREATE USER hr@localhost IDENTIFIED BY 'hr';
GRANT ALL PRIVILEGES ON hr.* TO hr@localhost WITH GRANT OPTION;
COMMIT;