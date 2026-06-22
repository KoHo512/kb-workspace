DROP TABLE IF EXISTS tbl_board_attachment;
DROP TABLE IF EXISTS tbl_board;

CREATE TABLE tbl_board (
    no BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    writer VARCHAR(50) NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE tbl_board_attachment (
    no BIGINT AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(256) NOT NULL,
    path VARCHAR(512) NOT NULL,
    content_type VARCHAR(100),
    size BIGINT,
    bno BIGINT NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_board_attachment_board
        FOREIGN KEY(bno) REFERENCES tbl_board(no)
        ON DELETE CASCADE
);

INSERT INTO tbl_board(title, content, writer) VALUES
('파일 업로드 실습 안내', 'register.jsp에서 첨부파일을 함께 등록해보세요.', 'teacher'),
('다운로드 실습 안내', '게시글 상세 화면에서 첨부파일 링크를 클릭하면 다운로드됩니다.', 'teacher');
