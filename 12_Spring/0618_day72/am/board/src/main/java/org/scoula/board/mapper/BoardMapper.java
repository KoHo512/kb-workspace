package org.scoula.board.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    // BoardMapper.xml에서 처리
//    @Select("SELECT * FROM tbl_board ORDER BY no DESC")
    public List<BoardVO> getList();

    public BoardVO get(Long no);

    public void create(BoardVO board);

    public int update(BoardVO board);

    public int delete(Long no);
}
