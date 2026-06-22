package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * BoardVO
 * -----------------------------------------------------------------------------
 * tbl_board 테이블의 한 행을 표현하는 도메인 객체입니다.
 *
 * attaches 필드는 DB의 tbl_board_attachment와 1:N 관계를 표현합니다.
 * MyBatis resultMap의 <collection>과 연결됩니다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    private List<BoardAttachmentVO> attaches;
}
