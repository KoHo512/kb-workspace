package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;

import java.util.Date;

/**
 * [학생용 TODO]
 * REST API 요청/응답에 사용하는 DTO입니다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    public static BoardDTO of(BoardVO vo) {
        // TODO 1
        // vo가 null이면 null을 반환하세요.
        if (vo == null) {
            return null;
        }

        // TODO 2
        // BoardVO의 값을 BoardDTO로 복사하세요.
        return BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .build();
    }

    public BoardVO toVo() {
        // TODO 3
        // BoardDTO의 값을 BoardVO로 복사하세요.
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
