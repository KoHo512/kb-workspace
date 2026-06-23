DROP TABLE IF EXISTS tbl_board;

CREATE TABLE tbl_board (
    no BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    writer VARCHAR(100) NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO tbl_board(title, content, writer) VALUES
('REST API 첫 번째 게시글', 'GET /api/board/{no}로 상세 조회할 수 있습니다.', 'user00'),
('Swagger 테스트 게시글', 'Swagger UI에서 목록/상세/등록/수정/삭제를 테스트합니다.', 'user01'),
('MyBatis 게시글', 'Mapper Interface와 XML의 id를 일치시켜야 합니다.', 'user02');
