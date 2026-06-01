# USE bookmarketdb;

INSERT INTO person(id, name) VALUES
(1, '김정민'),
(2, '이JOY'),
(3, '박경민');

INSERT INTO users(userid, username, userpassword, userage, useremail) VALUES
('user01', '홍길동', '1234', 20, 'hong@example.com'),
('user02', '신세계', '1234', 22, 'shin@example.com');

INSERT INTO boards(btitle, bcontent, bwriter, bdate, bfilename, bfiledata) VALUES
('첫 번째 게시글', 'JDBC 게시글 저장 실습입니다.', 'teacher', NOW(), NULL, NULL);
