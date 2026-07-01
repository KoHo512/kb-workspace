package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    // BoardMapper.xml에서 처리
//    @Select("SELECT * FROM tbl_board ORDER BY no DESC")
    List<BoardVO> getList();

    BoardVO get(Long no);

    void create(BoardVO board);

    int update(BoardVO board);

    int delete(Long no);

    void createAttachment(BoardAttachmentVO attach);

    List<BoardAttachmentVO> getAttachmentList(Long bno);

    BoardAttachmentVO getAttachment(Long no);

    int deleteAttachment(Long no);
}
